package com.example.user_service.openFeign;


import com.example.user_service.config.FeignClientConfig;
import com.example.user_service.dto.SendToDelivery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "DELIVERYSERVICE", configuration = FeignClientConfig.class)
public interface DeliveryFeign {

    @PostMapping("/delivery/api/delivery")
    UUID createDelivery(@RequestBody SendToDelivery sendToDelivery);
}
