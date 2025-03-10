package com.example.hospitals.repositories;

import com.example.hospitals.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcineRepository extends JpaRepository<Medecin,Long> {
}
