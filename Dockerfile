FROM openjdk:23-ea-8-jdk-slim
WORKDIR /app
COPY target/SendProducer-0.0.1-SNAPSHOT.jar /app/SendProducer-0.0.1-SNAPSHOT.jar
EXPOSE 8283
CMD ["java", "-jar", "SendProducer-0.0.1-SNAPSHOT.jar"]