package ma.enset.hospital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.repositories.ConsultationRepository;

@RestController
public class ConsultationRestController {
    @Autowired
    private ConsultationRepository consultationRepository;

    @GetMapping("/consultations")
    public List<Consultation> ConsultationsList(){
        return consultationRepository.findAll();
    }
}
