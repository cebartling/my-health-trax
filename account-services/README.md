# Accounts Service

## Local development

1. Install Java 11 through SDKMAN: `sdk install java 11.0.5.hs-adpt`
1. Install Lombok plugin and enable annotation processors in IntelliJ IDEA.
1. Use Java 11 through SDKMAN: `sdk use java 11.0.5.hs-adpt`


## Docker Compose usage

PostgreSQL 11 is used for the database.

### Startup

```bash
docker-compose up 
```

### Shutdown

```bash
docker-compose down 
```

### Cleanup

```bash
docker-compose down --volumes
```

## Liquibase migrations

### Apply migrations

```bash
gradle update
```
