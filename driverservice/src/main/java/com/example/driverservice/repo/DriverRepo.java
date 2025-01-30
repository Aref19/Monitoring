package com.example.driverservice.repo;

import com.example.driverservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DriverRepo extends JpaRepository<Driver, UUID> {
    List<Driver> findByStatus(Boolean status);

    Driver findByEmail(String email);
}
