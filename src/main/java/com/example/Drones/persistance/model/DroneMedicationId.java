package com.example.Drones.persistance.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroneMedicationId implements Serializable {
    private String droneSerialNumber;
    private String medicationCode;
}