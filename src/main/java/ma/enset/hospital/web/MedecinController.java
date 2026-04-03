package ma.enset.hospital.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medecin")
@PreAuthorize("hasRole('MEDECIN')")
public class MedecinController {
    
    @GetMapping("/dashboard")
    public String medecinDashboard() {
        return "medecin-dashboard";
    }
}
