package com.example.Drones.service.impl;


import com.example.Drones.persistance.dao.ImageModelRepository;
import com.example.Drones.persistance.dao.MedicationRepository;
import com.example.Drones.persistance.model.Medication;
import com.example.Drones.service.IMedicationService;
import com.example.Drones.web.dto.MedicationDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MedicationService implements IMedicationService {


    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private ImageModelRepository imageModelRepository;


    @Autowired
    private ModelMapper mapper;


    @Override
    public Medication saveMedication(MedicationDto medication) {
        Optional<Medication> existingMedication = medicationRepository.findByCode(medication.getCode());

        if (existingMedication.isEmpty()) {

            Medication newMedication = new Medication();
            mapper.map(medication, newMedication);

            return medicationRepository.save(newMedication);
        } else {
            throw new RuntimeException("Medication already exit : " + medication);

    }}


    @Override
    public Medication updateMedication(MedicationDto medicationDto) {

        Optional<Medication> existingMedication = medicationRepository.findByCode(medicationDto.getCode());

        if (existingMedication.isEmpty()) {

            throw new RuntimeException("No Medication found  with code: " + medicationDto.getCode());

        }

        Medication newMedication = new Medication();
        mapper.map(medicationDto, newMedication);
        return medicationRepository.save(newMedication);
    }


    @Override
    public Medication imageUpdate(String code, byte[] imageData) {

        Optional<Medication> existingMedication = medicationRepository.findByCode(code);


        if (existingMedication.isEmpty()) {

            throw new RuntimeException("No Medication found  with code: " + code);

        }

        Medication existingMedicationMedication = existingMedication.get();
        existingMedicationMedication.setImage(imageData);
        medicationRepository.save(existingMedicationMedication);
        return existingMedicationMedication;
    }


    @Override
    public List<Medication> getMedications() {
        return medicationRepository.findAll();
    }

    @Override
    public Optional<Medication> getMedicationByMedicationId(int medicationId) {


        Optional<Medication> medication = medicationRepository.findById(String.valueOf(medicationId));

        if(medication.isEmpty()) {
            throw new IllegalArgumentException("A drone with the given serial number does not exists.");

        }
        return Optional.of(medication.get());
    }

    @Override
    public Medication findById(String id) {
        Optional<Medication> medication = medicationRepository.findById(id);

        if(medication.isEmpty()) {
            throw new IllegalArgumentException("A drone with the given serial number does not exists.");

        }
        return medication.get();
    }

}
