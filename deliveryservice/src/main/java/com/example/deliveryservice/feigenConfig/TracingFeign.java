package com.example.deliveryservice.feigenConfig;


import com.example.deliveryservice.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@FeignClient(value = "TRACINGSERVICE", configuration = FeignClientConfig.class)
public interface TracingFeign {

    @GetMapping("/tracing/tracingId")
    UUID getTracingId();

}
