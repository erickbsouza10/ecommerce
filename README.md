# E-commerce Auth API

Backend authentication system built with Java and Spring Boot, featuring secure user registration and login using JWT authentication.

## 🚀 Technologies

- Java 21
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## 🔐 Features

- User registration
- Secure login with BCrypt password encryption
- JWT token generation
- Public and private route protection
- Stateless authentication
- PostgreSQL integration

## 📁 Project Structure

src/main/java/com/ecommerce/ecommerce

- config
- security
- domain/user
- dto

## ⚙️ Installation

Clone the repository:

```bash
git clone https://github.com/your-user/your-repo.git

Enter the project folder:
cd ecommerce
Configure application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommercespring.datasource.username=postgresspring.datasource.password=yourpassword
Run the project:
./mvnw spring-boot:run
📌 API Endpoints
Public Routes


POST /auth/register


POST /auth/login


Protected Routes
Require Bearer Token.
🧪 Swagger
Access:
http://localhost:8080/swagger-ui/index.html
📜 Example Login Response
{  "token": "your-jwt-token"}
👨‍💻 Author
Erick Souza
