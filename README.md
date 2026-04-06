-----------------------------------------------
<h1>FinanceHub – Finance Dashboard Backend</h1>


FinanceHub is a Spring Boot based backend application that manages financial records, users, roles, dashboard analytics, and secure API access.
This project demonstrates REST API development, Spring Security, JPA, MySQL integration, validation, and backend architecture.

-------------------------------------------------------------------
<h1>Tech Stack</h1>

Java 21<br>
Spring Boot<br>
Spring Web<br>
Spring Data JPA<br>
Spring Security<br>
MySQL<br>
Lombok<br>
Maven<br>
Postman<br>
Render (Deployment)<br>
Project Objective<br>
<br>
------------------------------------------------
The project fulfills the following requirements:

-------------------------------------------------
<br>
User and Role Management<br>
Financial Records CRUD<br>
Record Filtering (date, category, type)<br>
Dashboard Summary APIs<br>
Role Based Access Control<br>
Input Validation and Error Handling<br>
Data Persistence using MySQL<br>
API Testing using Postman<br>
Deployment on Render<br>
Features<br>
1. User and Role Management<br>
<br>
Create and manage users with roles.<br>
<br>
Supported roles:<br>
<br>
ADMIN<br>
ANALYST<br>
VIEWER<br>
<br>
Capabilities:<br>
<br>
Create user
Get all users
Get user by ID
Delete user
2. Financial Records CRUD

Users can manage financial data.

Fields:

amount
category
description
type (INCOME / EXPENSE)
date

Operations:

Create finance record
Get all records
Get record by ID
Update record
Delete record
3. Record Filtering

Finance records can be filtered by:

Type
Category
Date Range

Example filters:

GET /finance/filter?type=INCOME
GET /finance/filter?category=Salary
GET /finance/filter?startDate=2024-01-01&endDate=2024-02-01
GET /finance/filter?type=EXPENSE&category=Food
4. Dashboard APIs

Provides summary and analytics.

Includes:

Total Income
Total Expense
Net Balance
Category-wise summary
Monthly summary
Recent transactions
5. Role Based Access Control

Security is implemented using Spring Security.

Access rules:

Role	Access
ADMIN	Full access
ANALYST	Finance + Dashboard
VIEWER	Dashboard only

Authentication:

Basic Auth

Example:

username: admin@gmail.com
password: 12345
6. Input Validation

Validation annotations used:

@NotBlank
@NotNull
@Positive

Example:

amount must be positive
category cannot be empty
date required
7. Exception Handling

Global Exception Handler is implemented.

Handles:

Resource not found
Invalid input
Validation errors
Bad requests

Returns structured JSON response.

Example:

{
  "message": "Finance record not found",
  "status": 404
}
Database

MySQL database used.

Tables:

users
finance

Hibernate automatically creates tables.

Configuration in:

application.properties
Project Structure
FinanceHub
│
├── controller
│      FinanceController
│      UserController
│      DashboardController
│
├── service
│      FinanceService
│      UserService
│      DashboardService
│
├── repo
│      FinanceRepo
│      UserRepo
│
├── model
│      Finance
│      User
│      Role
│      RecordType
│
├── config
│      SecurityConfig
│
├── dto
│      FinanceDTO
│      UserDTO
│
├── exception
│      GlobalExceptionHandler
│
└── FinanceHubApplication
API Endpoints
User APIs
Create User
POST /users

Request:

{
  "name": "Admin",
  "email": "admin@gmail.com",
  "password": "12345",
  "role": "ADMIN"
}
Get All Users
GET /users
Get User By ID
GET /users/{id}
Delete User
DELETE /users/{id}
Finance APIs
Create Finance Record
POST /finance

Request:

{
  "amount": 5000,
  "category": "Salary",
  "description": "Monthly salary",
  "type": "INCOME",
  "date": "2024-04-01"
}
Get All Finance Records
GET /finance
Get Finance By ID
GET /finance/{id}
Update Finance
PUT /finance/{id}
Delete Finance
DELETE /finance/{id}
Filtering API
GET /finance/filter

Examples:

/finance/filter?type=INCOME
/finance/filter?category=Food
/finance/filter?startDate=2024-01-01&endDate=2024-03-01
/finance/filter?type=EXPENSE&category=Food
Dashboard APIs
Summary
GET /dashboard/summary

Returns:

total income
total expense
net balance
Category Summary
GET /dashboard/category
Monthly Summary
GET /dashboard/monthly
Recent Transactions
GET /dashboard/recent
How to Run Project
Clone Repository
git clone https://github.com/nishwan810/finance-dashboard.git
cd FinanceHub
Create Database
CREATE DATABASE finance_db;
Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
Run Project
mvn spring-boot:run

or run from IDE.

Postman Testing

All APIs tested using Postman.

Steps:

Open Postman
Create collection
Add APIs
Use Basic Auth
Test endpoints

Postman collection included in repository.

Deployment

Backend deployed on Render.

Base URL:

https://finance-dashboard.onrender.com

Example:

https://finance-dashboard.onrender.com/finance
Sample Credentials
admin@gmail.com
12345
Validation Example

Invalid request:

amount = -100

Response:

amount must be positive
Security

Spring Security implemented.

Uses:

Basic Authentication
Password Encoder
Role-based authorization
Protected APIs
Deployment Checklist
GitHub repository uploaded
README added
Postman collection added
APIs tested
Security implemented
MySQL configured
Render deployed
Author

Nishwan
Java Full Stack Developer

GitHub:

https://github.com/nishwan810
