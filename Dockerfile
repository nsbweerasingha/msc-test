# Step 1: Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory inside container
WORKDIR /app

# Step 3: Copy the jar file into container
COPY target/gscomp285-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port (default Spring Boot runs on 8080)
EXPOSE 8086

# Step 5: Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
