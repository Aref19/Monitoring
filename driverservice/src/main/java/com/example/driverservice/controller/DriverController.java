package com.example.driverservice.controller;


import com.example.driverservice.dto.AssignDriverRequest;
import com.example.driverservice.dto.DriverResponse;
import com.example.driverservice.feignconfig.TracingFeign;
import com.example.driverservice.model.Driver;
import com.example.driverservice.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("driver")
public class DriverController {
    DriverService driverService;
    TracingFeign tracingFeign;

    public DriverController(DriverService driverService, TracingFeign tracingFeign) {
        this.driverService = driverService;
        this.tracingFeign = tracingFeign;
    }

    @GetMapping("/free/driver")
    public UUID freeDriver() throws Exception {
        return driverService.findFreeDriver();
    }

    @PostMapping("/assign")
    public void assignDriver(@RequestBody AssignDriverRequest assignDriverRequest) {
        driverService.assignDriver(assignDriverRequest);
    }

    @GetMapping("/getAllOrder")
    public List<DriverResponse> getAllOrder(@RequestParam String emai) {
        return driverService.getOrders(emai);
    }

    @PutMapping("/updateStatus")
        public void updateTracingId(@RequestParam UUID tracingId, @RequestParam String status) {
        tracingFeign.updateTracingId(tracingId, status);
    }

    @GetMapping("/getAllDriver")
    public List<Driver> updateTracingId() {
        return driverService.getAllDrivers();
    }
}
