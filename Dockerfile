# ---------------------------------------
# 1. Etapa de construcción (Build Stage)
# ---------------------------------------
FROM maven:3.9.5-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar pom.xml y descargar dependencias
COPY pom.xml .
RUN mvn -q -e -B dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Empaquetar la aplicación
RUN mvn -q -e -B package -DskipTests


# ---------------------------------------
# 2. Etapa de ejecución (Runtime Stage)
# ---------------------------------------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiar el .jar generado en la etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Ejecutar el jar
ENTRYPOINT ["java", "-jar", "app.jar"]
