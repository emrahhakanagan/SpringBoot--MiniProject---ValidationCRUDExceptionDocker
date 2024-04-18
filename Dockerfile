FROM openjdk:17
EXPOSE 8080
COPY /build/libs/springBoot-ValidationCRUDExceptionDocker-0.0.1-SNAPSHOT.jar application.jar
CMD ["java", "-jar", "application.jar"]