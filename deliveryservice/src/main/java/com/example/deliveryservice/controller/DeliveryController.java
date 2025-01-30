package com.example.deliveryservice.controller;

import com.example.deliveryservice.dto.DataFromUser;
import com.example.deliveryservice.dto.DriverResponse;
import com.example.deliveryservice.model.DeliveryDetails;
import com.example.deliveryservice.services.DeliveryService;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("delivery")
public class DeliveryController {

    DeliveryService deliveryService;
    Logger logger = Logger.getLogger(DeliveryController.class.getName());

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/api/delivery")
    public UUID handleDelivery(@RequestBody DataFromUser dataFromUser) throws Exception {
        Span span = Span.current();
        SpanContext spanContext = Span.current().getSpanContext();
        logger.info("span: " + span.toString());
        //throw  new Exception("No connection to database 'userDatabase'. Shutting down service.");
        logger.info("span id: " + spanContext.getSpanId());
        UUID tracing = deliveryService.saveDelivery(dataFromUser);
        System.out.println("Received Delivery Request: " + tracing);

        return tracing;

    }

        @GetMapping("/getOrders")
    public List<DriverResponse> getOrders(@RequestParam UUID driverId) {
        return deliveryService.getAllDriverOrders(driverId);
    }

    @GetMapping("/getDeliveryDetails")
    public List<DeliveryDetails> getDeliveryDetails() {
        return deliveryService.getDeliveryDetails();
    }
}
