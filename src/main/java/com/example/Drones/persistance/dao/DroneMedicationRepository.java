package com.example.Drones.persistance.dao;

import com.example.Drones.persistance.model.DroneMedication;
import com.example.Drones.persistance.model.DroneMedicationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneMedicationRepository extends JpaRepository<DroneMedication, DroneMedicationId> {
    List<DroneMedication> findByDroneSerialNumber(String serialNumber);
}