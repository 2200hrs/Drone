package com.example.Drones.persistance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drone  {
    @Id
    @NotBlank(message = "serialNumber should not be null or empty")
    @Length(max = 100)
    private String serialNumber;

    @NotNull(message = "Valid model type is required")
    @Enumerated(EnumType.STRING)
    private Model model;


    @Max(value = 500, message = "Weight limit cannot exceed 500")
    private double weightLimit;

    @NotBlank(message = "battery capacity must not be empty")
    @Range(min = 0, max = 100, message = "Battery capacity cannot exceed 100")
    private double batteryCapacity;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL)
    private List<DroneMedication> medications;

}
