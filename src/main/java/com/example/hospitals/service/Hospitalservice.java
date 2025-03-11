package com.example.hospitals.service;

import com.example.hospitals.entities.Consultation;
import com.example.hospitals.entities.Medecin;
import com.example.hospitals.entities.Patient;
import com.example.hospitals.entities.RendezVous;

public interface Hospitalservice {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
    Patient getPatientById(long id);
    Medecin getMedecinById(long id);
    RendezVous getRendezVous(long id);
    Consultation getConsultationById(long id);
    Patient findPatientByNom(String nom);
    Medecin getMedecinByNom(String nom);

}
