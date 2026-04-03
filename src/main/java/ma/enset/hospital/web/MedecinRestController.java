package ma.enset.hospital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.repositories.MedecinRepository;

@RestController
public class MedecinRestController {
    @Autowired
    private MedecinRepository medecinRepository;

    @GetMapping("/medecins")
    public List<Medecin> MedecinsList(){
        return medecinRepository.findAll();
    }
}
