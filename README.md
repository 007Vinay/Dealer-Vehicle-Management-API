# Dealer & Vehicle Management API

A Spring Boot application to manage dealers and their vehicles. Supports full CRUD operations, filtering, and querying vehicles of PREMIUM dealers.

---

## Table of Contents

- [Features]
- [Tech Stack]
- [Getting Started]
- [API Endpoints]
- [Sample Test Data]
- [Swagger / Postman]
- [Notes]

---

## Features

- Manage **Dealers**: Create, Read, Update, Delete
- Manage **Vehicles**: Create, Read, Update, Delete
- Fetch all vehicles belonging to **PREMIUM** dealers
- Filter vehicles by dealer subscription type
- PostgreSQL integration using Spring Data JPA
- Validation for input data
- Swagger UI for API documentation
- Postman tested endpoints for CRUD operations and filtering

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Swagger/OpenAPI (springdoc)
- Maven
- Lombok (optional)

---

## Getting Started

1. **Clone the repository**  

2. **Configure PostgreSQL** in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dealer_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update

3. **Run the application**
mvn clean install
mvn spring-boot:run

4. Swagger UI: http://localhost:8080/swagger-ui.html

5. Postman: Import a collection to test all endpoints quickly.

## API Endpoints
- Vehicle Controller
| Method | Endpoint                                                | Description                                            |
| ------ | ------------------------------------------------------- | ------------------------------------------------------ |
| GET    | /api/vehicles/{id}                                      | Get a vehicle by ID                                    |
| PUT    | /api/vehicles/{id}                                      | Update a vehicle by ID                                 |
| DELETE | /api/vehicles/{id}                                      | Delete a vehicle by ID                                 |
| GET    | /api/vehicles/dealer/{dealerId}                         | List all vehicles of a specific dealer                 |
| POST   | /api/vehicles/dealer/{dealerId}                         | Create a vehicle for a specific dealer                 |
| GET    | /api/vehicles                                           | List all vehicles                                      |
| GET    | /api/vehicles/premium-dealers                           | List all vehicles belonging to PREMIUM dealers         |
| GET    | /api/vehicles/by-dealer-subscription/{subscriptionType} | List all vehicles filtered by dealer subscription type |

- Dealer Controller
| Method | Endpoint                         | Description                                                |
| ------ | -------------------------------- | ---------------------------------------------------------- |
| GET    | /api/dealers/{id}                | Get a dealer by ID                                         |
| PUT    | /api/dealers/{id}                | Update a dealer by ID                                      |
| DELETE | /api/dealers/{id}                | Delete a dealer by ID                                      |
| GET    | /api/dealers                     | List all dealers                                           |
| POST   | /api/dealers                     | Create a new dealer                                        |
| GET    | /api/dealers/subscription/{type} | List dealers filtered by subscription type (BASIC/PREMIUM) |


- Sample Test Data
| ID | Name          | Email                                           | Subscription Type |
| -- | ------------- | ----------------------------------------------- | ----------------- |
| 1  | ACME Motors   | [acme@example.com](mailto:acme@example.com)     | PREMIUM           |
| 2  | Budget Cars   | [budget@example.com](mailto:budget@example.com) | BASIC             |
| 3  | Luxury Wheels | [luxury@example.com](mailto:luxury@example.com) | PREMIUM           |



Vehicles
| ID | Dealer ID | Model          | Price | Status    |
| -- | --------- | -------------- | ----- | --------- |
| 1  | 1         | Toyota Corolla | 15000 | AVAILABLE |
| 2  | 1         | Honda Civic    | 18000 | AVAILABLE |
| 3  | 2         | Ford Fiesta    | 9000  | SOLD      |
| 4  | 2         | Hyundai i20    | 10000 | AVAILABLE |
| 5  | 3         | BMW X5         | 60000 | AVAILABLE |
| 6  | 3         | Audi Q7        | 65000 | AVAILABLE |


**Swagger / Postman**

Swagger UI: /swagger-ui.html – interactive documentation

Postman: Import a collection to quickly test all CRUD operations, filtering by subscription type, and vehicles of PREMIUM dealers.

Postman was used to verify:

- Creating, reading, updating, deleting dealers

- Creating, reading, updating, deleting vehicles

- Fetching vehicles by dealer or subscription type

- Fetching vehicles of PREMIUM dealers


## Notes

- Dealer email is unique; validations prevent duplicates.

- Vehicles must belong to an existing dealer.

- PREMIUM dealer vehicles can be queried specifically.

- For production, consider adding global exception handling with @ControllerAdvice.








