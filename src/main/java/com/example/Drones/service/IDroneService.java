package com.example.Drones.service;



import com.example.Drones.persistance.model.Drone;
import com.example.Drones.persistance.model.DroneMedication;
import com.example.Drones.persistance.model.Medication;
import com.example.Drones.web.dto.DroneDto;
import com.example.Drones.web.dto.MedicationDto;
import com.example.Drones.web.utils.RequirementNotMetException;
import com.example.Drones.web.utils.ResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IDroneService {


    Drone registerDrone(DroneDto drone);

    List<Drone> getAvailableDrones();

    Drone load(List<Medication> medications, String serialNumber) throws ChangeSetPersister.NotFoundException;

    List<DroneMedication> getLoadedMedications(String serialNumber);

    double getBatteryLevel(String serialNumber);
}
