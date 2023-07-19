package com.example.Drones.persistance.dao;

import com.example.Drones.persistance.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicationRepository extends JpaRepository<Medication, String> {
    Optional<Medication> findByCode(String code);
}