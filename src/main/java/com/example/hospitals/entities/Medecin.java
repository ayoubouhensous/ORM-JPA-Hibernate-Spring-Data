package com.example.hospitals.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Medecin {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String email;

    private String specialite;

    @OneToMany(mappedBy = "medecin",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
