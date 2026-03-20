package ma.enset.hospital;

import org.apache.el.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository) {
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
		};
	};
}
