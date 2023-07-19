package com.example.Drones.web.dto;


import com.example.Drones.persistance.model.DroneMedication;
import com.example.Drones.persistance.model.Medication;
import com.example.Drones.persistance.model.Model;
import com.example.Drones.persistance.model.State;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneDto {


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

    private State state;

    private List<DroneMedication> medications;
}
