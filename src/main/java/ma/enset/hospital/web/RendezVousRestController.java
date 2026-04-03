package ma.enset.hospital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.repositories.RendezVousRepository;

@RestController
public class RendezVousRestController {
    @Autowired
    private RendezVousRepository rendezVousRepository;

    @GetMapping("/rendezVous")
    public List<RendezVous> RendezVousList(){
        return rendezVousRepository.findAll();
    }
}
