This Repo contains Spring Boot PRP:

## Day 1: Introduction to Spring and Spring Boot
Objective: Understand the fundamentals of Spring Framework and Spring Boot, and set up the development environment.
#### Topics Covered:
Introduction to the Spring Framework
Understanding Inversion of Control (IoC) and Dependency Injection (DI)
Overview of Spring Core, Spring MVC, and Spring Boot
Setting up the development environment (IntelliJ/Eclipse, Maven/Gradle)
Creating a simple Spring Boot application
Understanding  application.properties vs application.yaml
Introduction to Spring Boot Starters and Auto-Configuration
Dependency injection using @Component, @Service, @Repository
### Hands-On:
Create a Spring Boot application from scratch
Implement basic dependency injection with Spring beans


Day 2: Spring Boot RESTful APIs & Data Access
Objective: Learn how to develop RESTful APIs and interact with databases using Spring Data JPA.
 
### Topics Covered:
Building REST APIs with @RestController
Handling HTTP requests (GET, POST, PUT, DELETE)
Exception Handling with @ControllerAdvice
Introduction to Spring Data JPA
Configuring databases (H2, MySQL, PostgreSQL)
Writing repository interfaces (JpaRepository, CrudRepository)
Using @Entity, @Table, @Column, and @Id
Implementing Pagination and Sorting
Hands-On:
### Build a RESTful API with CRUD operations for a Product entity
Store data in an H2 database and switch to MySQL/PostgreSQL
 
 
--------------------------------------------------------------------------------------
 
## Day 3: Spring Security & Authentication
Objective: Implement security features, authentication, and authorization using Spring Security.
 
### Topics Covered:
Introduction to Spring Security
Configuring Basic Authentication & Role-based Authorization
Using JWT (JSON Web Tokens) for authentication
Implementing OAuth2 with Spring Security
Securing endpoints with @PreAuthorize and @PostAuthorize
### Hands-On:
Implement JWT-based authentication and authorization & Secure REST endpoints with 
role-based access control for the previous hands on.
 
-----------------------------------------------------------------------------------------
 
## Day 4: Microservices with Spring Boot & Spring Cloud
Objective: Understand microservices architecture and implement key Spring Cloud components.
 
### Topics Covered:
Introduction to Microservices Architecture
Service Discovery with Eureka
API Gateway with Spring Cloud Gateway
Inter-service communication using Feign Clients & RestTemplate
Distributed Configuration with Spring Cloud Config
Circuit Breaker Pattern with Resilience4j
Event-driven architecture using RabbitMQ
