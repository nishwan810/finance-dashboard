# FinanceHub – Finance Dashboard Backend

FinanceHub is a **Spring Boot** backend application that manages financial records, users, roles, dashboard analytics, and secure API access.  
This project demonstrates:

- REST API development  
- Spring Security  
- JPA & MySQL integration  
- Input validation and error handling  
- Backend architecture  

---

## Tech Stack

- Java 21  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- MySQL  
- Lombok  
- Maven  
- Postman  
- Render (Deployment)  

---

## Project Objective

The project fulfills the following requirements:

- User and Role Management  
- Financial Records CRUD  
- Record Filtering (by date, category, type)  
- Dashboard Summary APIs  
- Role-Based Access Control  
- Input Validation and Error Handling  
- Data Persistence using MySQL  
- API Testing using Postman  
- Deployment on Render  

---

## Features

### 1. User and Role Management
Create and manage users with roles:

**Supported Roles:**  
- ADMIN  
- ANALYST  
- VIEWER  

**Capabilities:**  
- Create user  
- Get all users  
- Get user by ID  
- Delete user  

---

### 2. Financial Records CRUD
Manage financial data with fields:  

- amount  
- category  
- description  
- type (INCOME / EXPENSE)  
- date  

**Operations:**  
- Create finance record  
- Get all records  
- Get record by ID  
- Update record  
- Delete record  

---

### 3. Record Filtering
Finance records can be filtered by:

- Type  
- Category  
- Date Range  

**Example filters:**  
- `GET /finance/filter?type=INCOME`  
- `GET /finance/filter?category=Salary`  
- `GET /finance/filter?startDate=2024-01-01&endDate=2024-02-01`  
- `GET /finance/filter?type=EXPENSE&category=Food`  

---

### 4. Dashboard APIs
Provides summary and analytics:

- Total Income  
- Total Expense  
- Net Balance  
- Category-wise summary  
- Monthly summary  
- Recent transactions  

---

### 5. Role-Based Access Control
**Access rules:**  

| Role    | Access                |
|---------|----------------------|
| ADMIN   | Full access          |
| ANALYST | Finance + Dashboard  |
| VIEWER  | Dashboard only       |

**Authentication:**  
- Basic Auth  
- Example credentials:  
  - username: `admin@gmail.com`  
  - password: `12345`  

---

### 6. Input Validation
Validation annotations used:

- `@NotBlank`  
- `@NotNull`  
- `@Positive`  

**Example:**  
- amount must be positive  
- category cannot be empty  
- date required  

---

### 7. Exception Handling
**Global Exception Handler** handles:  

- Resource not found  
- Invalid input  
- Validation errors  
- Bad requests  

**Example response:**  
```json
{
  "message": "Finance record not found",
  "status": 404
}
```



**Database
MySQL database used
Tables: users, finance
Hibernate automatically creates tables
Configuration in application.properties
```
FinanceHub
│
├── controller
│   ├── FinanceController
│   ├── UserController
│   └── DashboardController
│
├── service
│   ├── FinanceService
│   ├── UserService
│   └── DashboardService
│
├── repo
│   ├── FinanceRepo
│   └── UserRepo
│
├── model
│   ├── Finance
│   ├── User
│   ├── Role
│   └── RecordType
│
├── config
│   └── SecurityConfig
│
├── dto
│   ├── FinanceDTO
│   └── UserDTO
│
├── exception
│   └── GlobalExceptionHandler
│
└── FinanceHubApplication


```
--------------------------------------
API Endpoints
User APIs

-Create User: POST /users
Request:
```json
{
  "name": "Admin",
  "email": "admin@gmail.com",
  "password": "12345",
  "role": "ADMIN"
}
```
```
-Get All Users: GET /users
-Get User By ID: GET /users/{id}
-Delete User: DELETE /users/{id}
```
--------------------------------------
-Finance APIs
-Create Finance Record: POST /finance
Request:
```json
{
  "amount": 5000,
  "category": "Salary",
  "description": "Monthly salary",
  "type": "INCOME",
  "date": "2024-04-01"
}
```
```
-Get All Finance Records: GET /finance
-Get Finance By ID: GET /finance/{id}
-Update Finance: PUT /finance/{id}
-Delete Finance: DELETE /finance/{id}
```
--------------------------------------
-Filtering API
-GET /finance/filter
Examples:
```
/finance/filter?type=INCOME
/finance/filter?category=Food
/finance/filter?startDate=2024-01-01&endDate=2024-03-01
/finance/filter?type=EXPENSE&category=Food
```
---------------------------------------
Dashboard APIs
```
Summary: GET /dashboard/summary
Category Summary: GET /dashboard/category
Monthly Summary: GET /dashboard/monthly
Recent Transactions: GET /dashboard/recent

```

How to Run Project
1.Clone Repository
```Bash
git clone https://github.com/nishwan810/finance-dashboard.git
cd FinanceHub
```
2.Create Database
```SQL
CREATE DATABASE finance_db;
```
3.Update application.properties
```</>Properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```
4.Run Project
```Bash
mvn spring-boot:run
```
Or run from IDE.
--------------------------------------------
-Postman Testing
-Open Postman
-Create collection
-Add APIs
-Use Basic Auth
-Test endpoints
<br>
Postman collection included in repository
<br>
<h1>Deployment</h1>
-Backend deployed on Render

```
Base URL: https://finance-dashboard.onrender.com
Example: https://finance-dashboard.onrender.com/finance
```
Sample Credentials
-------------------
username: admin@gmail.com
password: 12345
-------------------

Validation Example

Invalid request:
```JSON
{
  "amount": -100
}
```

Response:
amount must be positive

Security

-Spring Security implemented
-Uses:
-Basic Authentication
-Password Encoder
-Role-based authorization
-Protected APIs
<br>

