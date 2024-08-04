FROM openjdk:19-alpine3.16
EXPOSE 8081
COPY target/AuthorizationService-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]