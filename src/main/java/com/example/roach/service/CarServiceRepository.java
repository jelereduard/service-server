package com.example.roach.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService, Long> {

    @Query("SELECT s FROM CarService s where s.name = ?1")
    Optional<CarService> findServiceByName(String name);
}
