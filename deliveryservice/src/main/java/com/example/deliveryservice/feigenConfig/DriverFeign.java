package com.example.deliveryservice.feigenConfig;


import com.example.deliveryservice.config.FeignClientConfig;
import com.example.deliveryservice.dto.AssignDriverRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "DRIVERSERVICE", configuration = FeignClientConfig.class)
public interface DriverFeign {

    @GetMapping("/driver/free/driver")
    UUID findFree();

    @PostMapping("/driver/assign")
    void assignDriver(@RequestBody AssignDriverRequest request);

}
