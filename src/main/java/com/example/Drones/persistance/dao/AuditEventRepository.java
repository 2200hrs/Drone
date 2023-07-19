package com.example.Drones.persistance.dao;


import com.example.Drones.persistance.model.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditEventRepository extends JpaRepository<AuditEvent,Long> {
}
