package com.example.driverservice.feignconfig;


import com.example.driverservice.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(value = "TRACINGSERVICE", configuration = {FeignClientConfig.class})
public interface TracingFeign {

    @PutMapping("/tracing/update")
    void updateTracingId(@RequestParam UUID tracingId, @RequestParam String status);

}
