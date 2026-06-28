FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8092
ENTRYPOINT ["bash", "-lc", "until </dev/tcp/db/3306; do echo 'Waiting for MySQL at db:3306...'; sleep 2; done; until </dev/tcp/servidor-eureka/8761; do echo 'Waiting for Eureka at servidor-eureka:8761...'; sleep 2; done; exec java -jar app.jar"]
