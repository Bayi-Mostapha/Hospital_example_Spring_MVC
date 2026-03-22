package ma.enset.hospital.service;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.entities.Consultation;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
