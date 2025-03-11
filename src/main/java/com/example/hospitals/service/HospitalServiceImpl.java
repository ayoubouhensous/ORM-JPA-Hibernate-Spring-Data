package com.example.hospitals.service;

import com.example.hospitals.entities.Consultation;
import com.example.hospitals.entities.Medecin;
import com.example.hospitals.entities.Patient;
import com.example.hospitals.entities.RendezVous;
import com.example.hospitals.repositories.ConsultationRepository;
import com.example.hospitals.repositories.MedcineRepository;
import com.example.hospitals.repositories.PatientRepository;
import com.example.hospitals.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements Hospitalservice{
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private MedcineRepository medcineRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medcineRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient getPatientById(long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin getMedecinById(long id) {
        return medcineRepository.findById(id).orElse(null);
    }

    @Override
    public RendezVous getRendezVous(long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public Consultation getConsultationById(long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public Patient findPatientByNom(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public Medecin getMedecinByNom(String nom) {
        return medcineRepository.findByNom(nom);
    }
}
