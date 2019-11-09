# Accounts Service

## Local development

1. Ensure you have [SDKMAN](https://sdkman.io/) installed. If not, go [here](https://sdkman.io/install).
1. Install Java 11 through SDKMAN: `sdk install java 11.0.5.hs-adpt`
1. Install [Lombok plugin](https://plugins.jetbrains.com/plugin/6317-lombok) and [enable annotation processors in IntelliJ IDEA](https://www.jetbrains.com/help/idea/compiler-annotation-processors.html).
1. Use Java 11 through SDKMAN: `sdk use java 11.0.5.hs-adpt`

### Running the Spring Boot app locally, outside of Docker Compose

1. Set the following environment variable: `JDBC_URL=jdbc:postgresql://localhost:5432/accounts`
1. Run the Spring Boot app after starting the PostgreSQL server through `docker-compose`.

### Obtaining Bearer tokens from Auth0 for GraphQL testing

```bash
curl --request POST --url https://XXX.auth0.com/oauth/token --header 'content-type: application/json' --data '{"client_id":"ZZZ","client_secret":"YYY","audience":"https://XXX.auth0.com/api/v2/","grant_type":"client_credentials"}'
```

- Replace XXX with your own Auth0 *domain*.
- Replace YYY with your own Auth0 *client_secret*.
- Replace ZZZ with your own Auth0 *client_id*.

## Docker Compose usage

- PostgreSQL 11 is used for the relational database.

## Build Docker image for account services

`./gradlew build docker`


### Startup

- The `account-services-db` in the [docker-compose.yml](https://github.com/cebartling/my-health-trax/blob/master/account-services/docker-compose.yml) file uses an initialization volume shell script to install the UUID type PostgreSQL extension and set up some roles and permissions. See [init.sh](https://github.com/cebartling/my-health-trax/blob/master/account-services/database/init.sh) file for more details. 

```bash
docker-compose up 
```

### Shutdown

```bash
docker-compose down 
```

### Cleanup

- The following command will remove the database files from the PostgreSQL Docker container, rendering the PostgreSQL in pristine state. From there you can migrate the database, using gradle and Liquibase, to recreate it.

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
- See [SecurityConfiguration.java](https://github.com/cebartling/my-health-trax/blob/master/account-services/src/main/java/org/myhealthtrax/accountservices/security/SecurityConfiguration.java) and [AudienceValidator.java](https://github.com/cebartling/my-health-trax/blob/master/account-services/src/main/java/org/myhealthtrax/accountservices/security/AudienceValidator.java) for the nitty gritty details of how this Auth0 integration works.

### GraphQL

- [GraphQL Java](https://www.graphql-java.com/) is used for the GraphQL engine within Spring Boot.

### JPA