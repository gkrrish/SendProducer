# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/SendProducer-0.0.1-SNAPSHOT.jar /app/SendProducer-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8181

# Command to run your application
CMD ["java", "-jar", "SendProducer-0.0.1-SNAPSHOT.jar"]
