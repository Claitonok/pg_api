# Antes de criar a imagem docker!!

# RODAR ESSE COMANDO NA RAIS DO SEU PROJETO 
# No powershell

# .\mvnw.cmd package -DskipTests
# Esse comando cria a Arquivo jar do seu projeto ou atualiza!!

# http://localhost:8080/swagger-ui/index.html


# Runtime
# FROM eclipse-temurin:21-jre-alpine

# WORKDIR /app

# COPY /target/*.jar application.jar
# EXPOSE 8080

# ENTRYPOINT ["java","-jar","application.jar"]



# DEPLOY - Back4App
# ==============================
# Stage 1 - Build da aplicação
# ==============================
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copia todo o projeto
COPY . .

# Gera o jar
RUN mvn clean package -DskipTests

# ==============================
# Stage 2 - Runtime
# ==============================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia qualquer jar gerado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]





