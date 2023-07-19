package com.example.Drones.persistance.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroneMedication {
    @EmbeddedId
    private DroneMedicationId id;
    @ManyToOne
    @MapsId("droneSerialNumber")
    private Drone drone;
    @ManyToOne
    @MapsId("medicationCode")
    private Medication medication;
    private int quantity;

    public DroneMedication(Medication medication, Drone drone){
        this.medication = medication;
        this.drone = drone;
    }
}