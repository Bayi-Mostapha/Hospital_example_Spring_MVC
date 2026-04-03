package ma.enset.hospital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repositories.PatientRepository;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> PatientsList(){
        return patientRepository.findAll();
    }
}
