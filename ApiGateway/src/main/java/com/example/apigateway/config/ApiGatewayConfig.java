package com.example.apigateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class ApiGatewayConfig {

        @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                    .route("user_route", r -> r.path("/easydelivery/user/**")
                        .filters(f -> f
                                .preserveHostHeader()
                                .addRequestHeader("Content-Type", "application/json")
                                .rewritePath("/easydelivery/(?<remaining>.*)","/${remaining}")
                                .modifyRequestBody(String.class, String.class,
                                        (exchange, s) -> {
                                            if (exchange.getRequest().getHeaders().getContentLength() > 0) {
                                                return Mono.just(s);
                                            } else {
                                                return Mono.just("");
                                            }
                                        }
                                )
                        )
                        .uri("lb://USERSERVICE"))
                .route("driver_route", r -> r.path("/easydelivery/driver/**")
                        .filters(f -> f
                                .preserveHostHeader()
                                .addRequestHeader("Content-Type", "application/json")
                                .rewritePath("/easydelivery/(?<remaining>.*)","/${remaining}")

                        )
                        .uri("lb://DRIVERSERVICE"))
                .route("driver_route", r -> r.path("/easydelivery/delivery/**")
                        .filters(f -> f
                                .preserveHostHeader()
                                .addRequestHeader("Content-Type", "application/json")
                                .rewritePath("/easydelivery/(?<remaining>.*)","/${remaining}")

                        )
                        .uri("lb://DELIVERYSERVICE"))
                .route("driver_route", r -> r.path("/easydelivery/tracing/**")
                        .filters(f -> f
                                .preserveHostHeader()
                                .addRequestHeader("Content-Type", "application/json")
                                .rewritePath("/easydelivery/(?<remaining>.*)","/${remaining}")

                        )
                        .uri("lb://TRACINGSERVICE"))
                .build();
    }
}