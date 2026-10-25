# Online Flat Rental Backend

A robust Spring Boot backend application for managing online flat rental operations, including user management, property listings, tenant handling, and booking workflows.

## Overview

This project provides a backend service for a flat rental platform where:

- landlords can manage their properties
- tenants can be created and validated
- flats can be listed, updated, and removed
- availability can be tracked
- bookings can be created and managed

The application follows a layered architecture using controllers, services, repositories, and JPA entities.

## Tech Stack

- Java 17
- Spring Boot 2.7.4
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- REST API architecture

## Project Structure

```bash
online-flate-rental-backend-java/
├── Backend/
│   └── online-flat-rental/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/com/cg/onlineflatrental/
│       │   │   │   ├── controller/
│       │   │   │   ├── entity/
│       │   │   │   ├── exception/
│       │   │   │   ├── repository/
│       │   │   │   ├── service/
│       │   │   │   └── OnlineFlatRentalApplication.java
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       │       └── java/com/cg/onlineflatrental/
│       ├── pom.xml
│       ├── mvnw
│       ├── mvnw.cmd
│       └── .gitignore
└── README.md
```

## Features

- User registration and validation
- Landlord management
- Tenant management
- Flat listing and availability handling
- Booking creation and management
- Business logic validation and custom exceptions
- Database persistence using JPA and PostgreSQL

## Architecture

The backend follows a modular layered architecture:

- Controller layer: exposes REST endpoints
- Service layer: contains business logic
- Repository layer: handles persistence operations
- Entity layer: represents database models
- Exception layer: centralizes error handling

## Prerequisites

Before running this project, ensure the following are installed:

- JDK 17 or newer
- Maven 3.6+
- PostgreSQL 12 or later
- Git

## Database Configuration

The application is configured to use PostgreSQL.

Edit the following file:

`Backend/online-flat-rental/src/main/resources/application.properties`

Example configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/onlineflaterental
spring.datasource.username=postgres
spring.datasource.password=qwerty2234
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

Create the database before starting the app:

```bash
createdb onlineflaterental
```

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/arifmdkhan/online-flate-rental-backend-java.git
cd online-flate-rental-backend-java
```

### 2. Navigate to the backend project

```bash
cd Backend/online-flat-rental
```

### 3. Run the project

Using Maven wrapper:

```bash
./mvnw clean spring-boot:run
```

On Windows:

```bash
mvnw.cmd clean spring-boot:run
```

The backend server will run on:

```text
http://localhost:8080
```

## API Endpoints

### User Module

- `POST /user` - Create a user
- `GET /user/{id}` - Fetch a user by ID
- `GET /users` - Fetch all users
- `PUT /user/{id}` - Update a user
- `DELETE /user/{id}` - Delete a user
- `PATCH /user/{newpass}` - Update password
- `PATCH /user/{username}/{password}` - Validate user credentials

### Landlord Module

- `POST /landlord` - Add landlord
- `GET /landlord/{id}` - Fetch landlord by ID
- `GET /landlords` - Fetch all landlords
- `PUT /landlord/{id}` - Update landlord
- `DELETE /landlord/{id}` - Delete landlord

### Tenant Module

- `POST /tenant` - Add tenant
- `GET /tenant/{tenantId}` - Fetch tenant by ID
- `GET /tenants` - Fetch all tenants
- `PUT /tenant/{tenantId}` - Update tenant
- `DELETE /tenant/{tenantId}` - Delete tenant
- `PATCH /tenant/{tenantId}` - Validate tenant

### Flat Module

- `POST /flat` - Add a flat
- `GET /flat/{flatId}` - Fetch flat by ID
- `GET /flats` - Fetch all flats
- `PUT /flat/{id}` - Update flat
- `DELETE /flat/{flatId}` - Delete flat
- `GET /flat/{cost}/{availability}` - Search by cost and availability

### Flat Booking Module

- `POST /flatbooking` - Create a booking
- `GET /flatbooking/{id}` - Fetch booking by ID
- `GET /flatbookings` - Fetch all bookings
- `PUT /flatbooking/{id}` - Update booking
- `DELETE /flatbooking/{id}` - Delete booking

## Example Request Body

### Add User

```json
{
  "userName": "john",
  "password": "securePass123",
  "userType": "Tenant"
}
```

### Add Flat

```json
{
  "cost": 25000,
  "availability": "Available",
  "flatAddress": {
    "houseNo": 101,
    "street": "Main Street",
    "city": "Pune",
    "state": "Maharashtra",
    "pincode": 411001
  }
}
```

## Notes

- This is a backend-only project focused on REST API development and database integration.
- The application is designed to be easy to understand for learning Spring Boot and JPA concepts.
- It follows a clean structure suitable for CRUD-based projects.

## License

This repository does not currently include a license file. Please review repository usage and licensing requirements before using it in a commercial or public project.

## Contributing

Contributions are welcome. You can:

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Open a pull request

## Contact

For questions or collaboration, please reach out through the repository owner on GitHub.

---

Built with Java, Spring Boot, and PostgreSQL for online flat rental management.
