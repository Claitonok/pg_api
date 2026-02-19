# 💳 Pagamento API - Spring Boot + Mercado Pago + PIX

API de pagamentos desenvolvida com **Spring Boot**, integrada ao **Mercado Pago**, com suporte a **PIX**, persistência em **PostgreSQL**, Dockerizada e preparada para ambiente de produção.

---

## 🚀 Tecnologias Utilizadas

* ☕ Java 17
* 🌱 Spring Boot
* 💳 Integração com Mercado Pago
* 🐘 PostgreSQL
* 🐳 Docker & Docker Compose
* 📦 Maven
* 🔐 Webhook com validação de assinatura

---

## 📌 Funcionalidades

✔ Criar pagamento via PIX
✔ Gerar QR Code (texto e base64)
✔ Persistência de pagamentos no banco
✔ Atualização automática via Webhook
✔ Estrutura pronta para produção
✔ Suporte a variáveis de ambiente
✔ Containerização com Docker

---

## 🏗️ Arquitetura do Projeto

```
src/main/java/com/seuprojeto
│
├── config        # Configurações do Mercado Pago
├── controller    # Endpoints da API
├── service       # Regras de negócio
├── entity        # Entidades JPA
├── repository    # Acesso ao banco
```

---

## ⚙️ Configuração

### 1️⃣ Variáveis de Ambiente

Crie as seguintes variáveis:

```
MERCADOPAGO_ACCESS_TOKEN=SEU_TOKEN
MERCADOPAGO_WEBHOOK_SECRET=SEU_SECRET
```

---

## 🐳 Executando com Docker

### Build da aplicação

```bash
mvn clean package
```

### Subir containers

```bash
docker-compose up --build
```

A API estará disponível em:

```
http://localhost:8080
```

---

## 💳 Criar Pagamento PIX

### Endpoint

```
POST /pagamentos/pix
```

### Exemplo

```
POST http://localhost:8080/pagamentos/pix?valor=100&email=cliente@email.com
```

### Resposta

```json
{
  "qr_code": "000201...",
  "qr_code_base64": "iVBORw0KGgoAAAANS..."
}
```

---

## 🔔 Webhook

Endpoint responsável por receber notificações automáticas de pagamento.

```
POST /webhook
```

⚠️ Em produção:

* Validar assinatura HMAC SHA256
* Consultar pagamento na API do Mercado Pago antes de atualizar status
* Nunca confiar apenas no payload recebido

---

## 🗄️ Banco de Dados

Banco: PostgreSQL
Tabela: pagamento

Campos principais:

* id
* payment_id
* email
* valor
* status
* tipo (PIX)

---

## 🔐 Segurança

* Tokens protegidos por variáveis de ambiente
* Não versionar credenciais
* Webhook validado por assinatura
* Pronto para integração com Spring Security + JWT

---

## 🔄 Fluxo de Pagamento

Cliente → API → Mercado Pago → Cliente paga via PIX
→ Mercado Pago envia Webhook → API valida assinatura
→ API consulta pagamento → Atualiza banco

---

## 📈 Melhorias Futuras

* Pagamento com cartão
* Assinaturas recorrentes
* Split de pagamento
* Dashboard administrativo
* Autenticação JWT
* Deploy AWS / Render
* CI/CD com GitHub Actions

---

## 👨‍💻 Autor

Claiton Dos Santos Silva
Desenvolvedor Backend Java

---

## 📄 Licença

Este projeto é apenas para fins educacionais e demonstração técnica.
