FROM openjdk:17-jdk-slim

LABEL maintainer="ma823285807@gmail.com"

COPY target/galaxy-0.0.1-SNAPSHOT.jar /app/galaxy-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/galaxy-0.0.1-SNAPSHOT.jar"]