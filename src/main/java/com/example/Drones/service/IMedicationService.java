package com.example.Drones.service;


import com.example.Drones.persistance.model.Medication;
import com.example.Drones.web.dto.MedicationDto;
import com.example.Drones.web.utils.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

public interface IMedicationService {


    Medication saveMedication(MedicationDto medication);

    Medication updateMedication(MedicationDto medicationDto);

    Medication imageUpdate(String code, byte[] imageData);

    List<Medication> getMedications();

    Optional<Medication> getMedicationByMedicationId(int medicationId);

    Medication findById(String id);
}
