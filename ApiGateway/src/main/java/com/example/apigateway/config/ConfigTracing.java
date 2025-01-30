package com.example.apigateway.config;


import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Configuration
public class ConfigTracing implements GatewayFilter {

    private final Tracer tracer;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public ConfigTracing(Tracer tracer) {
        this.tracer = tracer;
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Exchange request path: " + exchange.getRequest().getPath());
        // Erzeuge einen Span und setze das Attribut `http.route`
        String routePath = exchange.getRequest().getPath().toString();
        Span span = tracer.spanBuilder("http.route")
                .setAttribute("http.route", routePath) // Setze das http.route-Attribut
                .startSpan();

        // Führe die Filterkette fort und schließe den Span am Ende ab
        Context context = Context.current().with(span);

        logger.info("Request path: " + routePath);  // Optional: Logge den Request-Pfad

        return chain.filter(exchange)
                .doFinally(signalType -> {
                    // Beende den Span, wenn die Anfrage abgeschlossen ist
                    span.end();
                });
    }

    @Bean
    public GatewayFilter openTelemetryTracingFilter(ConfigTracing openTelemetryTracingFilter) {
        return openTelemetryTracingFilter;
    }
}
