# Dockerfile for Appointy API (Java 17)
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy the built JAR into the image
ARG JAR_FILE=target/Appointment-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Optional: allow tuning
ENV JAVA_OPTS=""

# Expose default port (Spring will use PORT env var)
EXPOSE 8080

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
