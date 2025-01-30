package com.example.driverservice.feignconfig;


import com.example.driverservice.config.FeignClientConfig;
import com.example.driverservice.dto.DriverResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "DELIVERYSERVICE", configuration = {FeignClientConfig.class})
public interface DeliveryFeign {

    @GetMapping("/delivery/getOrders")
    List<DriverResponse> getOrders(@RequestParam UUID driverId);

}
