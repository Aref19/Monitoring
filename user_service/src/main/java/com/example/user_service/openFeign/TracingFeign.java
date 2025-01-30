package com.example.user_service.openFeign;


import com.example.user_service.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(value = "TRACINGSERVICE", configuration = FeignClientConfig.class)
public interface TracingFeign {

    @GetMapping("/tracing/getStatus")
    String getStatus(@RequestParam UUID tracingId);


}
