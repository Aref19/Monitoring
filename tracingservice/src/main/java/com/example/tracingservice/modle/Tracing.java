package com.example.tracingservice.modle;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;

@RedisHash("Tracing")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tracing {

    @Id
    private UUID id;
    @Indexed
    private UUID traceId;
    private String status;
}
