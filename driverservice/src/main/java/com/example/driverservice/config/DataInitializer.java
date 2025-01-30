package com.example.driverservice.config;

import com.example.driverservice.model.Driver;
import com.example.driverservice.repo.DriverRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    DriverRepo driverRepo;

    public DataInitializer(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Driver driver = new Driver();
        driver.setDriverId(UUID.randomUUID());
        driver.setStatus(true);
        driver.setEmail("Max@gmail.com");
        Driver driver1 = new Driver();
        driver1.setDriverId(UUID.randomUUID());
        driver1.setStatus(true);
        driver1.setEmail("Adnan@gmail.com");
        Driver driver2 = new Driver();
        driver2.setDriverId(UUID.randomUUID());
        driver2.setStatus(true);
        driver2.setEmail("Alex@gmail.com");
        Driver driver3 = new Driver();
        driver3.setDriverId(UUID.randomUUID());
        driver3.setStatus(true);
        driver3.setEmail("Niko@gmail.com");
        driverRepo.saveAll(List.of(driver, driver1, driver2, driver3));


    }
}
