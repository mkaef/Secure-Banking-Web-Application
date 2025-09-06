
# Secure Online Banking Web Application

A full-featured, secure **Online Banking Web Application** built with **Java**, **Spring MVC**, and **Hibernate**, deployed on **AWS**. The application supports role-based access for **Customers**, **Bank Staff**, and **Admins** to manage various banking operations.

## Features

The application supports multi-role access and a wide range of banking functionalities, including secure login, transaction management, and administrative operations.

# Customer Features

Secure login and logout

View personal account details

View account balances

View transaction history

Transfer funds between accounts

Update basic profile information

Access transaction receipts and confirmation

# Bank Staff Features

View and manage customer information

Approve, review, or reject transactions

Open and close customer accounts

Reset customer passwords securely

Access transaction reports and customer summaries

# Admin Features

Manage user accounts (staff, customers, other admins)

Create and manage bank branches

Assign roles to new or existing users

Audit all system operations and user activities

Control system settings and configuration 

# Security Features

Role-based access control (RBAC)

Spring Security-based authentication and authorization

Secure password hashing with BCrypt

Custom validators for input validation

Protection against unauthorized access and CSRF (optional)

Form validation for all user inputs

# System & Deployment Features

Deployed on AWS (EC2 for app hosting, RDS for DB)

Scalable and modular architecture using Spring MVC

ORM with Hibernate for easy DB interaction

Separation of concerns across layers (Controller, Service, Repository)

Custom error handling and exception management

### Customers:

- Login securely
- View account balances and transaction history
- Perform money transfers and other banking operations

### Bank Staff:

- Manage customer profiles
- Approve or reject transactions
- View reports and logs

### Admins:

- Manage branches and system users
- Assign roles and permissions
- Oversee all system-wide banking operations

## Technologies Used

| Layer             | Technology                     |
|------------------|--------------------------------|
| Backend           | Java, Spring MVC, Spring Security |
| ORM & DB Access   | Hibernate, JPA                 |
| Database          | MySQL / PostgreSQL             |
| Validation        | Hibernate Validator (JSR-380)  |
| Frontend (View)   | JSP, HTML, CSS (optional JS)   |
| Deployment        | AWS EC2, RDS, S3 (optional), Elastic Beanstalk |
| Build Tool        | Maven                          |

## Project Structure

src/main/java/com/yourbank
├── config/
│   ├── AppConfig.java
│   └── SecurityConfig.java
│
├── controllers/
│   ├── BankTransactionController.java
│   ├── BranchController.java
│   ├── CustomerController.java
│   ├── LoginController.java
│   ├── RoleController.java
│   └── UserController.java
│
├── domains/
│   ├── Account.java
│   ├── AccountType.java
│   ├── Address.java
│   ├── BankTransaction.java
│   ├── Branch.java
│   ├── Customer.java
│   ├── Gender.java
│   ├── Role.java
│   ├── TransactionType.java
│   └── User.java
│
├── repositories/
│   ├── BankTransactionRepository.java
│   ├── BranchRepository.java
│   ├── CustomerRepository.java
│   ├── RoleRepository.java
│   └── UserRepository.java
│
├── services/
│   ├── bank/
│   │   ├── BankTransactionService.java
│   │   └── BankTransactionImpl.java
│   ├── branch/
│   │   ├── BranchService.java
│   │   └── BranchImpl.java
│   ├── customer/
│   │   ├── CustomerService.java
│   │   └── CustomerImpl.java
│   ├── role/
│   │   ├── RoleService.java
│   │   └── RoleImpl.java
│   └── user/
│       ├── UserService.java
│       ├── UserImpl.java
│       └── UserDetailsImpl.java
│
├── validators/
│   ├── BankTransactionValidator.java
│   ├── BranchValidator.java
│   ├── CustomerValidator.java
│   └── UserValidator.java

## Security

Spring Security for authentication and role-based authorization

Passwords are hashed (e.g., using BCrypt)

Access control:

ROLE_CUSTOMER for end-users

ROLE_STAFF for internal employees

ROLE_ADMIN for system administrators

## Key Modules

1. Controllers
Handle HTTP requests and route to appropriate services

2. Services
Business logic layer

Interfaces and implementations are separated for better testing and maintainability

3. Repositories
Use Spring Data JPA for seamless database interactions

4. Validations
Custom validation logic for domain-specific constraints

5. Domains Entities
JPA entities representing real-world banking concepts

## Deployment on AWS

1. Backend Deployment:
Package app as a WAR or JAR
Deploy to AWS EC2 or Elastic Beanstalk

2. Database:
Host on Amazon RDS (MySQL/PostgreSQL)
Configure connection properties in application.properties

3. Static Content
Store assets like documents or images in AWS S3

## Configuration - application.properties

spring.datasource.url=jdbc:mysql://<your-db-endpoint>:3306/yourdb
spring.datasource.username=youruser
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

# Security settings
spring.security.user.name=admin
spring.security.user.password=adminpass

## Testing and Validation

Unit testing with JUnit and Mockito

Custom form validators for user and transaction input

## Licence
This project is licensed under the MIT License

## Author

@mkaef
