package com.example.tracingservice.repo;

import com.example.tracingservice.modle.Tracing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface PackageTraceRepo extends CrudRepository<Tracing, UUID> {

    Tracing findTracingByTraceId(UUID traceId);

}
