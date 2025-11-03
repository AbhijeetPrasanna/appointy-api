# build stage
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /build
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw -v
COPY src src
RUN ./mvnw -B clean package -DskipTests

# runtime stage
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
ARG JAR_FILE=/build/target/Appointment-0.0.1-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} app.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
