package com.example.deliveryservice.feigenConfig;


import com.example.deliveryservice.config.FeignClientConfig;
import com.example.deliveryservice.dto.SenderAndReceiver;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(value = "USERSERVICE", configuration = FeignClientConfig.class)
public interface UserFeign {

    @GetMapping("/user/getUser")
    SenderAndReceiver user(@RequestParam UUID userID);
}
