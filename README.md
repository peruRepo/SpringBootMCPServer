# Spring Boot MCP Memory Server

This project provides a simple Spring Boot implementation of an MCP (Model Context Protocol) server that stores conversation memories in PostgreSQL. The server exposes REST endpoints for creating and querying memory records.

## Building

Use Maven to build the project:

```bash
mvn clean package
```

## Running

Provide a PostgreSQL database and configure the connection properties in `src/main/resources/application.properties`.

Run the application with:

```bash
java -jar target/mcp-server-0.0.1-SNAPSHOT.jar
```

## API

- `POST /memories` – Store a memory record. Example body:
  ```json
  { "user": "alice", "content": "hello" }
  ```
- `GET /memories?user=alice` – List memories for a user.
- `GET /memories?search=hello` – Search memories by content.
