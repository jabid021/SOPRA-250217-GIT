FROM openjdk:25-jdk-bullseye

ENV ENV_DB_URL=mysql://quest-mysql:3306/quest_boot
ENV ENV_DB_USER=root
ENV ENV_DB_PASSWORD=root

WORKDIR /app

# COPY application.properties ./ 

# COPY target/quest-boot-0.0.1-SNAPSHOT.jar ./quest-boot.jar
COPY target/*.jar ./quest-boot.jar

# ENTRYPOINT [ "java", "-jar", "quest-boot.jar", "--spring.config.location=application.properties" ]
ENTRYPOINT [ "java", "-jar", "quest-boot.jar" ]

EXPOSE 8080
