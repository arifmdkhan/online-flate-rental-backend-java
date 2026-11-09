# Online Flat Rental Backend

<div align="center">

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-336791?style=for-the-badge&logo=postgresql&logoColor=white)
![REST API](https://img.shields.io/badge/API-REST-FF6B6B?style=for-the-badge&logo=fastapi&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-CA4245?style=for-the-badge&logo=apachemaven&logoColor=white)

</div>

A Java Spring Boot backend designed for a digital flat rental platform, focused on managing users, landlords, tenants, property listings, and booking workflows through a clean REST API architecture.

## Project Overview

This application demonstrates a production-style backend for an online rental ecosystem where:

- landlords can manage rental properties
- tenants can be created and validated
- flat listings can be searched and updated
- booking operations can be tracked and managed
- database interactions are handled through JPA and PostgreSQL

The project follows a layered architecture built around controllers, services, repositories, entities, and exception handling to keep the business logic modular and maintainable.

## Why This Project

This repository was built to showcase backend engineering skills in:

- Java enterprise application development
- Spring Boot application structure
- REST API design and implementation
- JPA persistence and relational modeling
- Clean service-oriented architecture
- Real-world booking and rental domain logic

## Key Features

- User registration, authentication validation, and password updates
- Landlord management and profile operations
- Tenant management and verification workflows
- Flat listing, filtering, update, and deletion support
- Booking creation and lifecycle management
- Role-based data handling and business validation
- Custom exception handling for meaningful API responses
- PostgreSQL-backed persistence with Spring Data JPA

## Tech Stack

- Java 17
- Spring Boot 2.7.4
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- RESTful API design

## Architecture

The backend follows a layered MVC-style architecture:

- Controller layer: exposes REST endpoints
- Service layer: handles business logic
- Repository layer: manages database access
- Entity layer: represents domain models
- Exception layer: centralizes error handling

```text
Client -> Controller -> Service -> Repository -> PostgreSQL
                 \-> Custom Exceptions
```

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
├── README.md
└── LICENSE (if added later)
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

### 3. Configure PostgreSQL

Update the datasource settings in:

`Backend/online-flat-rental/src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/onlineflaterental
spring.datasource.username=postgres
spring.datasource.password=qwerty2234
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

Create the database before starting the application:

```bash
createdb onlineflaterental
```

### 4. Run the application

Using Maven wrapper:

```bash
./mvnw clean spring-boot:run
```

On Windows:

```bash
mvnw.cmd clean spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## API Modules

### User Module

- `POST /user` — create a user
- `GET /user/{id}` — fetch a user by ID
- `GET /users` — fetch all users
- `PUT /user/{id}` — update a user
- `DELETE /user/{id}` — delete a user
- `PATCH /user/{newpass}` — update password
- `PATCH /user/{username}/{password}` — validate credentials

### Landlord Module

- `POST /landlord` — add landlord
- `GET /landlord/{id}` — fetch landlord by ID
- `GET /landlords` — fetch all landlords
- `PUT /landlord/{id}` — update landlord
- `DELETE /landlord/{id}` — delete landlord

### Tenant Module

- `POST /tenant` — add tenant
- `GET /tenant/{tenantId}` — fetch tenant by ID
- `GET /tenants` — fetch all tenants
- `PUT /tenant/{tenantId}` — update tenant
- `DELETE /tenant/{tenantId}` — delete tenant
- `PATCH /tenant/{tenantId}` — validate tenant

### Flat Module

- `POST /flat` — add flat
- `GET /flat/{flatId}` — fetch flat by ID
- `GET /flats` — fetch all flats
- `PUT /flat/{id}` — update flat
- `DELETE /flat/{flatId}` — delete flat
- `GET /flat/{cost}/{availability}` — search by cost and availability

### Booking Module

- `POST /flatbooking` — create booking
- `GET /flatbooking/{id}` — fetch booking by ID
- `GET /flatbookings` — fetch all bookings
- `PUT /flatbooking/{id}` — update booking
- `DELETE /flatbooking/{id}` — delete booking

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

## Project Status

Status: In active development / backend learning project

This project is a solid example of a practical Spring Boot CRUD application with domain-driven modeling and database persistence.

## License

This repository does not currently include a license file. Please review repository usage and licensing requirements before using it in a commercial or public project.

## Contributing

Contributions are welcome. To contribute:

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Open a pull request

## Contact

For collaboration or questions, connect through the repository owner on GitHub.

---

Built with Java, Spring Boot, and PostgreSQL for a modern rental platform backend.
