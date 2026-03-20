package ma.enset.hospital;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.entities.StatusRDV;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
		return args -> {
			java.util.stream.Stream.of("Hassan", "Yassine", "Adnane").forEach(name -> {
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new java.sql.Date(System.currentTimeMillis()));
				patient.setMalade(false);
				patientRepository.save(patient);
			});
			java.util.stream.Stream.of("Aymane", "Haytham", "Mostapha").forEach(name -> {
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name + "@gmail.com");
				medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
				medecinRepository.save(medecin);
			});
			Patient patient1 = patientRepository.findByNom("Hassan");
			Medecin medecin = medecinRepository.findByNom("Aymane");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new java.sql.Date(System.currentTimeMillis()));
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient1);
			rendezVousRepository.save(rendezVous);

			RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new java.sql.Date(System.currentTimeMillis()));
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation");
			consultationRepository.save(consultation);
		};
	};
}
