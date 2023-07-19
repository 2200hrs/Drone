package com.example.Drones.web.controller;

import com.example.Drones.persistance.model.Drone;
import com.example.Drones.persistance.model.ImageModel;
import com.example.Drones.persistance.model.Medication;
import com.example.Drones.service.IMedicationService;
import com.example.Drones.service.ImageService;
import com.example.Drones.web.dto.MedicationDto;
import com.example.Drones.web.utils.ResourceNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@RestController
public class MedicationRestController {

    @Autowired
    private IMedicationService medicationService;
    @Autowired
    private ImageService imageService;

    @PostMapping("/addNewMedication")
    public ResponseEntity<Medication> register(@NotNull @Valid @RequestBody MedicationDto dto) throws IllegalArgumentException {

        Medication saveMedication = this.medicationService.saveMedication(dto);
        return ResponseEntity.ok(saveMedication);
    }

    @PostMapping(value = "upload/{id}", consumes = { "multipart/form-data" })
    public ResponseEntity<Medication> imageUpload(@PathVariable String id,
                                                  @RequestParam("image") Optional<MultipartFile> imageFile)
            throws ResourceNotFoundException, IOException {

        byte[] imageData = this.imageService.processImage(imageFile.get());

        return ResponseEntity.ok(this.medicationService.imageUpdate(id, imageData));
    }

    public ImageModel uploadImage(MultipartFile multipartFile) throws IOException {
        ImageModel imageModel =new ImageModel(
        multipartFile.getOriginalFilename(),
        multipartFile.getContentType(),
        multipartFile.getBytes());

        return imageModel;
    }
    @GetMapping("/medications")
    public List<Medication> getMedications(){

        return medicationService.getMedications();
    }



    @GetMapping("/medication/{id}")
    public ResponseEntity<Medication> findById(@PathVariable String id)
            throws ResourceNotFoundException, IOException, DataFormatException {
        Medication med = this.medicationService.findById(id);
        if (med.getImage() != null) {
            byte[] imageData = this.imageService.decompress(med.getImage());
            med.setImage(imageData);
        }
        return ResponseEntity.ok(med);
    }


}
