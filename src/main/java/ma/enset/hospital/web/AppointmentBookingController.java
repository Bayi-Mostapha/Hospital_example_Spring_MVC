package ma.enset.hospital.web;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.entities.StatusRDV;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;

@RestController
public class AppointmentBookingController {
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private MedecinRepository medecinRepository;
    
    @Autowired
    private RendezVousRepository rendezVousRepository;
    
    @PostMapping("/api/book-appointment")
    public AppointmentResponse bookAppointment(
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestParam String appointmentDate) {
        
        try {
            Patient patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new Exception("Patient not found"));
            
            Medecin medecin = medecinRepository.findById(doctorId)
                    .orElseThrow(() -> new Exception("Doctor not found"));
            
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(Date.valueOf(appointmentDate));
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            
            RendezVous saved = rendezVousRepository.save(rendezVous);
            
            return new AppointmentResponse(true, "Appointment booked successfully", saved.getId());
        } catch (Exception e) {
            return new AppointmentResponse(false, "Error: " + e.getMessage(), null);
        }
    }
    
    public static class AppointmentResponse {
        public boolean success;
        public String message;
        public Long appointmentId;
        
        public AppointmentResponse(boolean success, String message, Long appointmentId) {
            this.success = success;
            this.message = message;
            this.appointmentId = appointmentId;
        }
    }
}
