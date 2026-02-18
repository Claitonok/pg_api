# Antes de criar a imagem docker!!

# RODAR ESSE COMANDO NA RAIS DO SEU PROJETO 
# No powershell

# .\mvnw.cmd package -DskipTests
# Esse comando cria a Arquivo jar do seu projeto ou atualiza!!

# http://localhost:8080/swagger-ui/index.html


# Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY /target/*.jar application.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","application.jar"]






