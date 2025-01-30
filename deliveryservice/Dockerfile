FROM openjdk:22-jdk-slim

WORKDIR /app

COPY target/deliveryservice-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 9098


ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]