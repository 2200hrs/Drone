package com.example.Drones.service.impl;


import com.example.Drones.persistance.dao.AuditEventRepository;
import com.example.Drones.persistance.dao.DroneRepository;
import com.example.Drones.persistance.model.AuditEvent;
import com.example.Drones.persistance.model.Drone;
import com.example.Drones.service.IAuditEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditEventService implements IAuditEventService {


    private final AuditEventRepository auditEventRepository;

    private final DroneRepository droneRepository;


//    Introduce a periodic task to check drones battery levels and create history/audit event log for this.

    @Override
    @Scheduled(fixedRate = 60000) // 5 minutes in milliseconds
    public void checkDroneCapacity() {


        List<Drone> droneList = droneRepository.findAll();

        List<AuditEvent> auditEvents = droneList
                .stream()
                .map(AuditEvent::new)
                .collect(Collectors.toList());


        if(!auditEvents.isEmpty()){
         auditEventRepository.saveAll(auditEvents);
        }

    }
}
