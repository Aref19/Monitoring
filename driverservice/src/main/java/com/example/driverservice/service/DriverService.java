package com.example.driverservice.service;

import com.example.driverservice.dto.AssignDriverRequest;
import com.example.driverservice.dto.DriverResponse;
import com.example.driverservice.feignconfig.DeliveryFeign;
import com.example.driverservice.model.Driver;
import com.example.driverservice.model.Order;
import com.example.driverservice.repo.DriverRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class DriverService {

    DriverRepo driverRepo;
    UUID freeDriverId;
    DeliveryFeign deliveryFeign;

    Logger logger = Logger.getLogger(DriverService.class.getName());

    public DriverService(DriverRepo driverRepo, DeliveryFeign deliveryFeign) {
        this.driverRepo = driverRepo;
        this.deliveryFeign = deliveryFeign;
    }

    public UUID findFreeDriver() {
        List<Driver> freeDrivers = driverRepo.findByStatus(true);

        freeDrivers.get(0).setStatus(false);
        driverRepo.save(freeDrivers.get(0));
        freeDriverId = freeDrivers.get(0).getDriverId();

        return freeDriverId;
    }

    public void assignDriver(AssignDriverRequest assignDriverRequest) {
        logger.warning(assignDriverRequest.getDriverID().toString());
        Driver driver = driverRepo.findById(assignDriverRequest.getDriverID()).get();
        Order order = new Order(UUID.randomUUID(), assignDriverRequest.getDriverID());
        order.setDriver(driver);
        driver.getOrders().add(order);
        driverRepo.save(driver);
    }

    public List<DriverResponse> getOrders(String email) {
        logger.warning(email);
        Driver driver = driverRepo.findByEmail(email);
        List<DriverResponse> driverResponses = deliveryFeign.getOrders(driver.getDriverId());
        return driverResponses;
    }

    public List<Driver> getAllDrivers() {
        return driverRepo.findAll();
    }
}
