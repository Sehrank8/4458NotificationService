FROM eclipse-temurin:17
WORKDIR /app
COPY target/notification-service-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
