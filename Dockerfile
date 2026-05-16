# Multi-stage build con Gradle y Java 17
FROM gradle:8.5-jdk17-alpine AS build
WORKDIR /app

# Copiar archivos de configuración de Gradle
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# Copiar el código fuente
COPY src ./src

# Compilar el jar de Spring Boot saltando las pruebas
RUN gradle bootJar -x test

# Runtime stage ligero
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# En Gradle, el compilado se guarda en build/libs/ en lugar de target/
COPY --from=build /app/build/libs/ms-ventas-*.jar app.jar

EXPOSE 8080
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]