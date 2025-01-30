package com.example.tracingservice.services;


import com.example.tracingservice.modle.Tracing;
import com.example.tracingservice.repo.PackageTraceRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TracingService {

    PackageTraceRepo packageTraceRepo;

    public TracingService(PackageTraceRepo packageTraceRepo) {
        this.packageTraceRepo = packageTraceRepo;
    }


    public UUID getTraceId() {
        UUID traceId = UUID.randomUUID();
        UUID uuid = UUID.randomUUID();
        packageTraceRepo.save(new Tracing(uuid, traceId, "in Bearbeitung"));
        return traceId;
    }

    public String getStatus(UUID tracingId) {
        return packageTraceRepo.findTracingByTraceId(tracingId).getStatus();
    }

    public void updateStatus(UUID tracingId, String status) {
        Tracing tracing = packageTraceRepo.findTracingByTraceId(tracingId);
        tracing.setStatus(status);
        packageTraceRepo.save(tracing);
    }
}
