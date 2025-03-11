package com.example.hospitals;

import com.example.hospitals.entities.*;
import com.example.hospitals.repositories.ConsultationRepository;
import com.example.hospitals.repositories.MedcineRepository;
import com.example.hospitals.repositories.RendezVousRepository;
import com.example.hospitals.service.Hospitalservice;
import com.example.hospitals.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.hospitals.repositories.PatientRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class HospitalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(Hospitalservice hospitalservice, UserService userService) {
        return args -> {

            // Ajouter des patients
            Patient patient1=new Patient();
            patient1.setNom("ayoub");
            patient1.setDate_naissance(Date.valueOf(LocalDate.of(2002, 1, 18)));
            patient1.setMalade(false);
            Patient patient2=new Patient();
            patient2.setNom("hicham");
            patient2.setDate_naissance(Date.valueOf(LocalDate.of(2006, 9, 27)));
            patient2.setMalade(true);

            hospitalservice.savePatient(patient1);
            hospitalservice.savePatient(patient2);

            Medecin medecin1 = new Medecin();
            medecin1.setNom("manal");
            medecin1.setEmail("manal@gmail.com");
            medecin1.setSpecialite("general");

            hospitalservice.saveMedecin(medecin1);

            Patient patient = hospitalservice.getPatientById(1L);
            Medecin medecin = hospitalservice.getMedecinByNom("manal");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(Date.valueOf(LocalDate.now()));
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.APPROVED);

            hospitalservice.saveRendezVous(rendezVous);


            Consultation consultation = new Consultation();
            consultation.setDateConsultation(Date.valueOf(LocalDate.now()));
            consultation.setRapport("rapport");
            consultation.setRendezVous(rendezVous);


            hospitalservice.saveConsultation(consultation);

            User user1=new User();
            user1.setUserName("ayoub");
            user1.setPassword("ayoub");

            User user2=new User();
            user2.setUserName("hicham");
            user2.setPassword("hicham");

            userService.addUser(user1);
            userService.addUser(user2);

            Role role1 = new Role();
            role1.setRoleName("admin");
            Role role2 = new Role();
            role2.setRoleName("tech");

            userService.addRole(role1);
            userService.addRole(role2);

            userService.addRoleToUser(role1, user1);


            try{
                User user = userService.authenticate("ayoub", "hicham");
                System.out.println(user.getId());
                System.out.println(user.getUserName());
                user.getRoles().forEach(System.out::println);

            }catch (RuntimeException e){
                e.printStackTrace();
            }
        };
    }
}
