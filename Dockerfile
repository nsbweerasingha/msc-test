# ====== Build Stage ======
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and build application
COPY src ./src
RUN mvn clean package -DskipTests

# ====== Runtime Stage ======
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy built JAR from builder stage
COPY --from=build /app/target/gscomp285-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 8086

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
