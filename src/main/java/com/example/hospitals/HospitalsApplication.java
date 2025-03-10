package com.example.hospitals;

import com.example.hospitals.entities.Patient;
import com.example.hospitals.repositories.MedcineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.hospitals.repositories.PatientRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HospitalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedcineRepository medcineRepository) {
        return args -> {

            // Ajouter des patients
            Patient patient1=new Patient();
            patient1.setNom("ayoub");
            patient1.setDate_naissance(new Date(2002,01,18));
            patient1.setMalade(false);
            Patient patient2=new Patient();
            patient1.setNom("hicham");
            patient1.setDate_naissance(new Date(2006,9,27));
            patient1.setMalade(false);

            patientRepository.save(patient1);
            patientRepository.save(patient2);







        };
    }
}
