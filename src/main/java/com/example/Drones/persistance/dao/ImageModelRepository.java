package com.example.Drones.persistance.dao;

import com.example.Drones.persistance.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageModelRepository extends JpaRepository<ImageModel, Long> {
}