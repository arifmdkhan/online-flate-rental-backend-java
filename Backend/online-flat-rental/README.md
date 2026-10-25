# Online Flat Rental Backend

This is the backend service for an online flat rental platform built with Java and Spring Boot.

## Overview

The application exposes REST APIs for managing users, landlords, tenants, flat listings, and booking records. It uses Spring Data JPA to interact with a PostgreSQL database.

## Technologies Used

- Java 17
- Spring Boot 2.7.4
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

## Project Structure

```bash
src/
├── main/
│   ├── java/com/cg/onlineflatrental/
│   │   ├── controller/
│   │   ├── entity/
│   │   ├── exception/
│   │   ├── repository/
│   │   ├── service/
│   │   └── OnlineFlatRentalApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/cg/onlineflatrental/
```

## Features

- Manage users
- Manage landlords
- Manage tenants
- Manage flat records and availability
- Book flats for tenants
- Handle validation and exception responses

## Prerequisites

- Java 17+
- Maven 3.6+
- PostgreSQL installed and running

## Configuration

Update `src/main/resources/application.properties` for your local PostgreSQL configuration.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/onlineflaterental
spring.datasource.username=postgres
spring.datasource.password=qwerty2234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Run the Application

```bash
./mvnw clean spring-boot:run
```

The API will run at:

```text
http://localhost:8080
```

## Main API Endpoints

### User Endpoints

- `POST /user`
- `GET /user/{id}`
- `GET /users`
- `PUT /user/{id}`
- `DELETE /user/{id}`

### Landlord Endpoints

- `POST /landlord`
- `GET /landlord/{id}`
- `GET /landlords`
- `PUT /landlord/{id}`
- `DELETE /landlord/{id}`

### Tenant Endpoints

- `POST /tenant`
- `GET /tenant/{tenantId}`
- `GET /tenants`
- `PUT /tenant/{tenantId}`
- `DELETE /tenant/{tenantId}`

### Flat Endpoints

- `POST /flat`
- `GET /flat/{flatId}`
- `GET /flats`
- `PUT /flat/{id}`
- `DELETE /flat/{flatId}`

### Flat Booking Endpoints

- `POST /flatbooking`
- `GET /flatbooking/{id}`
- `GET /flatbookings`
- `PUT /flatbooking/{id}`
- `DELETE /flatbooking/{id}`

## Notes

This is a backend-only project focused on REST APIs and JPA persistence. It is suitable for learning Spring Boot application structure, layered architecture, and database integration.

## License

This repository does not include a license file. Please review repository ownership and usage terms before commercial use.
