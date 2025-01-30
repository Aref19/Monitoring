# Use the official Jaeger All-in-One image from Docker Hub
FROM jaegertracing/all-in-one:latest

# Set environment variables for Jaeger
ENV COLLECTOR_ZIPKIN_HTTP_PORT=9411
ENV JAEGER_AGENT_HTTP_PORT=4317
ENV JAEGER_AGENT_HTTP_TCP_PORT=5775
ENV JAEGER_UI_HTTP_PORT=16686

# Expose necessary ports for Jaeger
EXPOSE 5775 5778 6831 6832 5777 16686 4317 4318 9411

# Run Jaeger in the container
CMD [ "--query.port", "16686", "--agent.http-port", "4317"]



