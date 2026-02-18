# 🚀 API de Pagamentos

API REST desenvolvida com **Spring Boot** para gerenciamento de pagamentos, utilizando PostgreSQL como banco de dados e Docker para containerização da aplicação.

---

## 🛠️ Tecnologias Utilizadas

* ☕ Java 21
* 🌱 Spring Boot
* 🗄️ PostgreSQL
* 🐳 Docker
* 📦 Maven
* 🔁 JPA / Hibernate

---

## 📂 Estrutura do Projeto

```
pg_api/
│
├── src/
├── target/
├── Dockerfile
├── pom.xml
└── README.md
```

---

## ⚙️ Configuração do Banco de Dados

Arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://host.docker.internal:5432/db_postgreSQL
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

---

## ▶️ Como Executar o Projeto

### 🔹 1. Gerar o JAR

```bash
.\mvnw.cmd clean package -DskipTests
```

---

### 🔹 2. Build da imagem Docker

```bash
docker build -t api-pagamento .
```

---

### 🔹 3. Executar o container

```bash
docker run -p 8080:8080 --name project-pagamentos api-pagamento
```

---

## 🌐 Acessar a API

Após subir o container:

```
http://localhost:8080
```

---

## 🐳 Executando com Docker Compose (Recomendado)

```yaml
version: '3.8'

services:
  api:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - postgres
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/db_postgreSQL
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: admin

  postgres:
    image: postgres:15
    environment:
      POSTGRES_DB: db_postgreSQL
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: admin
    ports:
      - "5432:5432"
```

Rodar:

```bash
docker compose up --build
```

---

## 📌 Funcionalidades

* ✅ Cadastro de pagamentos
* ✅ Atualização de registros
* ✅ Consulta de pagamentos
* ✅ Integração com banco PostgreSQL
* ✅ Containerização com Docker

---

## 🧑‍💻 Autor

Desenvolvido por **Claiton Dos Santos Silva**

📎 LinkedIn: (adicione seu link aqui)
📎 GitHub: (adicione seu perfil aqui)

---

## 📄 Licença

Este projeto está sob a licença MIT.
