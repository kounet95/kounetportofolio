FROM openjdk:21-jdk-slim
RUN apt-get update && apt-get install -y curl
VOLUME /tmp
COPY target/*.jar  app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
