FROM maven:3.9.9-amazoncorretto-21-debian-bookworm

# RUN apt update
# RUN apt install maven -y

ENV ENV_DB_URL=mysql://quest-mysql:3306/quest_boot
ENV ENV_DB_USER=root
ENV ENV_DB_PASSWORD=root

WORKDIR /app

COPY . .

RUN mvn package

RUN cp target/*.jar ./quest-boot.jar 

ENTRYPOINT [ "java", "-jar", "quest-boot.jar" ]

EXPOSE 8080
