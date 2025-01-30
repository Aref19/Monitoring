package com.example.tracingservice.controller;


import com.example.tracingservice.services.TracingService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("tracing")
public class TracingController {

    TracingService tracingService;

    public TracingController(TracingService tracingService) {
        this.tracingService = tracingService;
    }

        @GetMapping("/tracingId")
    public UUID getTracingId() {
        return tracingService.getTraceId();
    }

    @PutMapping("/update")
    public void updateTracingId(@RequestParam UUID tracingId, @RequestParam String status) {
        tracingService.updateStatus(tracingId, status);
    }

    @GetMapping("/getStatus")
    public String getStatus(@RequestParam UUID tracingId) {
        return tracingService.getStatus(tracingId);
    }
}
