# Banking System API

A RESTful Banking System API built with **Java**, **Spring Boot**, **Spring Data JPA**, and **MySQL**. The application allows users to create bank accounts, manage balances, and perform banking operations through RESTful endpoints.

## Features

* Create a new bank account
* Retrieve account details
* Deposit money
* Withdraw money
* Transfer funds between accounts
* Update account information
* Delete bank accounts
* Input validation
* Global exception handling
* RESTful API design

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Git
* GitHub
* Postman

## Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
├── config
└── resources
```

## API Endpoints

| Method | Endpoint                               | Description                   |
| ------ | -------------------------------------- | ----------------------------- |
| POST   | /api/accounts                          | Create a bank account         |
| GET    | /api/accounts                          | Get all accounts              |
| GET    | /api/accounts/{accountNumber}          | Get account by account number |
| PUT    | /api/accounts/{accountNumber}          | Update account                |
| DELETE | /api/accounts/{accountNumber}          | Delete account                |
| POST   | /api/accounts/{accountNumber}/deposit  | Deposit money                 |
| POST   | /api/accounts/{accountNumber}/withdraw | Withdraw money                |
| POST   | /api/accounts/transfer                 | Transfer funds                |

## Database

The application uses **MySQL** for persistent data storage with **Spring Data JPA** and **Hibernate**.

##  Running the Project

### Clone the repository

```bash
git clone https://github.com/your-username/banking-system-api.git
```

### Navigate into the project

```bash
cd banking-system-api
```

### Configure the database

Update the database configuration in `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Run the application

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

## Testing

API endpoints can be tested using **Postman**.

##  Concepts Demonstrated

* Layered Architecture
* Dependency Injection
* REST API Development
* DTO Pattern
* Exception Handling
* Validation
* JPA Entity Relationships
* Repository Pattern
* Service Layer Business Logic
* CRUD Operations

## Future Improvements

* JWT Authentication
* Role-Based Authorization
* Swagger / OpenAPI Documentation
* Docker Support
* Unit & Integration Testing
* Email Notifications
* Transaction History
* Account Statements

## Author

**Francis (Ekabot Dev)**

Backend Developer focused on Java, Spring Boot, and building scalable backend applications.
