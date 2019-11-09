# Accounts Service

## Local development

1. Install Java 11 through SDKMAN: `sdk install java 11.0.5.hs-adpt`
1. Install Lombok plugin and enable annotation processors in IntelliJ IDEA.
1. Use Java 11 through SDKMAN: `sdk use java 11.0.5.hs-adpt`


## Docker Compose usage

- PostgreSQL 11 is used for the relational database.

### Startup

```bash
docker-compose up 
```

### Shutdown

```bash
docker-compose down 
```

### Cleanup

The following command will remove the database files from the PostgreSQL Docker container, rendering the PostgreSQL in pristine state. From there you can migrate the database, using gradle and Liquibase, to recreate it.

```bash
docker-compose down --volumes
```

## Liquibase migrations

### Apply migrations

```bash
gradle update
```


## Design

### Spring Security and Auth0 

- [Auth0](https://auth0.com/) provides identity management services.
- Spring Security is used within the Spring Boot application to integrate identity management services provided by Auth0. 
- OAuth2 is used to validate the bearer tokens (JWT format) with Auth0. Clients will supply the bearer tokens in the `Authorization` header for HTTP requests.


### GraphQL

- [GraphQL Java](https://www.graphql-java.com/) is used for the GraphQL engine within Spring Boot.

### JPA