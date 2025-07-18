# Accountant – Fee Calculation System

A sample backend application built with Spring Boot to demonstrate a solution for a fee calculation system. The logic is
triggered via REST API or RabbitMQ messaging. Designed for extensibility and easy integration of new fee algorithms.

## 💡 Features

- REST API for calculating transaction fees
- Message queue listener (RabbitMQ) for asynchronous fee processing
- Strategy pattern for fee calculation based on transaction type
- Simple API key security
- Docker Compose support for local development (PostgreSQL + RabbitMQ)
- Ready for further extension (e.g. audit logging, currency conversion, etc.)

## 🧱 Technologies

- Java 17
- Spring Boot
- Spring AMQP (RabbitMQ)
- PostgreSQL
- Docker & Docker Compose

---

## ▶️ Getting Started

### 1. Prerequisites

- Java 17
- Docker + Docker Compose

### 2. Run with Docker

```bash
docker-compose up
```

### 3. Build and Run Spring Boot app

```bash
./gradlew bootRun
```

---

## 📬 REST API Example

### Request

```http
POST http://localhost:8080/api/fees/calculate?key=secret123
Content-Type: application/json

{
  "transactionId": "abc123",
  "transactionType": "FIXED",
  "amount": 100.0
}
```

### Response

```json
{
  "transactionId": "abc123",
  "fee": 5.0
}
```

> Replace `secret123` with your API key (stored in env var `APP_KEY`).

---

## 📨 Messaging (RabbitMQ)

- Queue: `fees.calculate`
- Content-Type header **must be set** to `application/json`

### Message Body (JSON)

```json
{
  "transactionId": "abc123",
  "transactionType": "FIXED",
  "amount": 100.0
}
```

### Content-Type Header

```
content-type: application/json
```

You can publish a test message via the RabbitMQ UI at [http://localhost:15672](http://localhost:15672) with correct
headers.

---

## 🛠️ Configuration

Create `.env` file or set environment variables:

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:54327/database
SPRING_DATASOURCE_USERNAME=user
SPRING_DATASOURCE_PASSWORD=password
APP_KEY=secret123
```

---

## 📄 License

This project is for demonstration and interview purposes only.
