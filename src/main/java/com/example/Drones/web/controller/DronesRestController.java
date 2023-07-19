package com.example.Drones.web.controller;

import com.example.Drones.persistance.model.Drone;
import com.example.Drones.persistance.model.DroneMedication;
import com.example.Drones.persistance.model.Medication;
import com.example.Drones.service.IDroneService;
import com.example.Drones.web.dto.DroneDto;
import com.example.Drones.web.dto.MedicationDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/drones")
public class DronesRestController {
    @Autowired
    private IDroneService droneService;

    @PostMapping()
    public ResponseEntity<Drone> registerDrone(@Valid @RequestBody DroneDto drone) {
//        return ResponseEntity<>(droneService.registerDrone(drone)),HttpStatus.CREATED);


        ResponseEntity<Drone> ResponseEntity = new ResponseEntity<>(droneService.registerDrone(drone), HttpStatus.CREATED);
        return ResponseEntity;
    }

    @PutMapping("/{serialNumber}/load")
    public void loadMedications(@PathVariable String serialNumber, @RequestBody List<Medication> medications) throws ChangeSetPersister.NotFoundException {
        droneService.load( medications,serialNumber);
    }

    @GetMapping("/{serialNumber}/medications")
    public ResponseEntity<List<DroneMedication>> getLoadedMedications(@PathVariable String serialNumber) {
        return ResponseEntity.ok(droneService.getLoadedMedications(serialNumber));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Drone>> getAvailableDrones() {

        return ResponseEntity.ok(droneService.getAvailableDrones());
    }

    @GetMapping("/{serialNumber}/battery")
    public double getBatteryLevel(@PathVariable String serialNumber) {
        return droneService.getBatteryLevel(serialNumber);
    }
}