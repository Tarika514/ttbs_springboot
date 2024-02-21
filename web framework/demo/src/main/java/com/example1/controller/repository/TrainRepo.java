package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Train;

@Repository
public interface TrainRepo extends JpaRepository<Train, Integer> {
}