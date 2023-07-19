package com.example.Drones.web.dto;

import com.example.Drones.persistance.model.Drone;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto{

        @Pattern(regexp = "[A-Z0-9_]+")
        @NotBlank(message="  allowed only upper case letters, underscore and numbers")
        private String code;

        @NotBlank(message = "Please enter a valid name")
        @Pattern(regexp = "[A-Za-z0-9_-]+")
        private String name;

        @Max(value = 500, message = "Please enter a valid weight less than 500")
        private double weight;

        private List<Drone> drone;



}
