package com.example.Drones.service.impl;


import com.example.Drones.persistance.dao.DroneMedicationRepository;
import com.example.Drones.persistance.dao.DroneRepository;
import com.example.Drones.persistance.dao.MedicationRepository;
import com.example.Drones.persistance.model.Drone;
import com.example.Drones.persistance.model.DroneMedication;
import com.example.Drones.persistance.model.Medication;
import com.example.Drones.persistance.model.State;
import com.example.Drones.service.IDroneService;
import com.example.Drones.web.dto.DroneDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DroneService  implements IDroneService {

    @Autowired
    private DroneRepository droneRepository;
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private DroneMedicationRepository droneMedicationRepository;
    @Autowired
    private ModelMapper mapper;



    @Override
    public Drone registerDrone(DroneDto drone) {

        Optional<Drone> drones = droneRepository.findById(drone.getSerialNumber());

        if(drones.isPresent()) {
            throw new RuntimeException("Drone already exit");
        }
        Drone droneCreated =Drone.builder().
                serialNumber(drone.getSerialNumber())
                .state(State.IDLE)
                .batteryCapacity(drone.getBatteryCapacity())
                .weightLimit(drone.getWeightLimit())
                .build();



        return droneRepository.save(droneCreated);
    }

    @Override
    public List<Drone> getAvailableDrones() {
        return droneRepository.findByState(State.IDLE);
    }

    @Override
    public Drone load(List<Medication> medications, String serialNumber) throws ChangeSetPersister.NotFoundException {
        // Get the drone object from the repository
        Drone drone = droneRepository.findById(serialNumber)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        Double totalMedicationWeight = medications.stream().map(Medication::getWeight).reduce(0.0, Double::sum);
        boolean isAvailable = drone.getWeightLimit() < totalMedicationWeight;

        List<DroneMedication> droneMedications = new ArrayList<>();
        if (isAvailable && drone.getBatteryCapacity() >= 25) {
            drone.setState(State.LOADING);

            drone.setWeightLimit(drone.getWeightLimit() - totalMedicationWeight);

            for (Medication medication : medications) {
                // Create a new DroneMedication object and set the medication, drone, and quantity
                DroneMedication droneMedication = new DroneMedication(medication, drone);
                droneMedication.setQuantity(0); // Set the default quantity to zero
                droneMedications.add(droneMedication);
            }
        }

        drone.setState(State.LOADED);
        drone.setMedications(droneMedications);

        // Save the updated drone object to the repository
        return droneRepository.save(drone);
    }

    @Override
    public List<DroneMedication> getLoadedMedications(String serialNumber) {
        Drone drone = this.getDrone(serialNumber);
        if (drone.getState().equals(State.LOADED)) {
            throw new IllegalStateException("Drone is already being loaded");
        }
        return droneMedicationRepository.findByDroneSerialNumber(serialNumber);
    }

    @Override
    public double getBatteryLevel(String serialNumber) {
        Drone drone = this.getDrone(serialNumber);
        return drone.getBatteryCapacity();
    }

    private Drone getDrone(String serialNumber) {
        return droneRepository.findById(serialNumber)
                .orElseThrow(() -> new IllegalArgumentException("Invalid droneserial number"));
    }













}
