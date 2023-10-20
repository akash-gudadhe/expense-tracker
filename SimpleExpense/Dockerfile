# Use an official Java 8 runtime as the base image
FROM openjdk:8-jre-alpine

# Set the working directory in the container
ARG JAR_FILE=target/*.jar

# Copy your Java application JAR file into the container at /app
COPY ./target/simpleexpense-0.0.1-SNAPSHOT.jar app.jar 

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]

# docker images
# docker build -p dockerPort:localPort expense-tracker (from dir where Dockerfile resides)
# docker run -p 8090:8081 expense-tracker