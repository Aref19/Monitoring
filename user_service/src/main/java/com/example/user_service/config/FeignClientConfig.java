package com.example.user_service.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapSetter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor tracingInterceptor(OpenTelemetry openTelemetry) {
        return requestTemplate -> {
            Context context = Context.current();
            TextMapSetter<RequestTemplate> setter = (carrier, key, value) ->
                    carrier.header(key, value);

            openTelemetry.getPropagators()
                    .getTextMapPropagator()
                    .inject(context, requestTemplate, setter);
        };
    }

}