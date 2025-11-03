# ---------- build stage ----------
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /build

# copy everything (but dockerignore will exclude target, .git etc)
COPY . /build

# Build the project (skip tests for faster build)
RUN mvn -B clean package -DskipTests

# ---------- runtime stage ----------
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# copy the built jar from build stage (adjust name if different)
ARG JAR_FILE=/build/target/Appointment-0.0.1-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} /app/app.jar

ENV JAVA_OPTS=""

# use platform port (Render sets $PORT at runtime)
ENV SERVER_PORT=${PORT:-8080}
EXPOSE 8080

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
