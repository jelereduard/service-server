package com.example.roach.serviceLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<ServiceLog, Long> {

    @Query("SELECT l FROM ServiceLog l WHERE l.carId = ?1")
    Optional<ServiceLog> findLogByCarId(Long id);
}
