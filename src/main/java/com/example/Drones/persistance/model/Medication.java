package com.example.Drones.persistance.model;

import com.example.Drones.web.dto.MedicationDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
    @Id
    @Pattern(regexp = "[A-Z0-9_]+")
    @NotBlank(message="  allowed only upper case letters, underscore and numbers")
    private String code;

    @NotBlank(message = "Please enter a valid name")
    @Pattern(regexp = "[A-Za-z0-9_-]+")
    private String name;

    @Max(value = 500, message = "Please enter a valid weight less than 500")
    private double weight;


    @Column(name = "image", columnDefinition = "BLOB")
    @Lob
    private byte[] image;


//    private String image ;
    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    private List<DroneMedication> drones;


}