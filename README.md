# MongoDB Test

Projeto Java 21 com Spring Boot 3, Spring Web, Spring Data MongoDB, Lombok, Docker e Docker Compose.

## Executar

```bash
docker compose up -d
mvn spring-boot:run
```

Por padrao, a aplicacao usa:

- MongoDB: `localhost:27017`
- Database: `people_db`
- Usuario: `admin`
- Senha: `admin123`

Esses valores podem ser alterados por variaveis de ambiente:

```bash
MONGO_USERNAME=myuser MONGO_PASSWORD=mypass MONGO_DATABASE=mydb docker compose up -d
MONGO_USERNAME=myuser MONGO_PASSWORD=mypass MONGO_DATABASE=mydb mvn spring-boot:run
```

## cURL

Criar pessoa:

```bash
curl -X POST http://localhost:8080/api/people \
  -H "Content-Type: application/json" \
  -d '{"name":"Ada Lovelace","email":"ada@example.com"}'
```

Listar pessoas:

```bash
curl http://localhost:8080/api/people
```
