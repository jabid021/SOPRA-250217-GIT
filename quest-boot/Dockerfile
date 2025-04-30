FROM openjdk:25-jdk-bullseye

WORKDIR /app

COPY application.properties ./ 

# COPY target/quest-boot-0.0.1-SNAPSHOT.jar ./quest-boot.jar
COPY target/*.jar ./quest-boot.jar

ENTRYPOINT [ "java", "-jar", "quest-boot.jar", "--spring.config.location=application.properties" ]

EXPOSE 8080
