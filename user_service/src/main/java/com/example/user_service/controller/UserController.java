package com.example.user_service.controller;


import com.example.user_service.dto.ResponseToUser;
import com.example.user_service.dto.SenderAndReceiver;
import com.example.user_service.dto.UserPackageDto;
import com.example.user_service.exception.BadRequestError;
import com.example.user_service.openFeign.TracingFeign;
import com.example.user_service.service.UserService;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("user")
public class UserController {

    @Value("${spring.application.name}")
    String applicationName;

    final UserService userService;
    TracingFeign tracingFeign;
    Logger logger = Logger.getLogger(UserController.class.getName());

    public UserController(UserService userService, TracingFeign tracingFeign) {
        this.userService = userService;
        this.tracingFeign = tracingFeign;

    }

    @PostMapping("/send")
    public ResponseEntity<ResponseToUser> saveData(@RequestBody UserPackageDto userPackageDto) throws Exception {
        Span span = Span.current();
        SpanContext spanContext = Span.current().getSpanContext();

        logger.info("hallo :" + span.toString());
        // throw  new Exception("No connection to database 'userDatabase'. Shutting down service.");
        return userService.saveUserDetails(userPackageDto);
    }

    public void fallbackMethod(Throwable t) {
        // Fallback-Logik oder Service Deaktivierung
        System.out.println("Service wird aufgrund eines Fehlers deaktiviert: " + t.getMessage());
    }

    @GetMapping("/getUser")
    public SenderAndReceiver user(@RequestParam UUID userID) {
        if (userID == null) {
            throw new BadRequestError("userID is null please give user Id");
        }
        logger.info("hallo :" + applicationName);

        return userService.getUserInfo(userID);
    }

    @GetMapping("/getStatus")
    public String getStatus(@RequestParam UUID userID) {
        return tracingFeign.getStatus(userID);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    /*@GetMapping("/getAllUser")
    public SenderAndReciver getAllUser() {

        logger.info("hallo :" + applicationName);

        return userService.getUserInfo(userID);
    }*/


}
