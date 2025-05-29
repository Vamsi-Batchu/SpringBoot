
# Day 1: Introduction to Spring and Spring Boot

## Objective
Understand the fundamentals of the Spring Framework and Spring Boot, and set up a basic Spring Boot application demonstrating Dependency Injection, REST controller, and Swagger UI documentation.

---

## Topics Covered

### 1. What is the Spring Framework?
Spring is a powerful, feature-rich framework for building enterprise-level Java applications. It focuses on **dependency injection**, **aspect-oriented programming**, and **modular architecture**.

---

### 2. Inversion of Control (IoC) & Dependency Injection (DI)

#### Inversion of Control (IoC)
IoC is a design principle where the control of object creation and dependency management is shifted from the program to the framework.

#### Dependency Injection (DI)
DI is the process of **providing dependent objects** to a class rather than letting it create them. Spring handles this automatically.

**Example Used:**  
`GreetingService` is injected into `GreetingController` using constructor injection.

```java
@Autowired
public GreetingController(GreetingService greetingService) {
    this.greetingService = greetingService;
}
```

---

### 3. Spring Modules Overview

- **Spring Core** – Foundation for DI and bean management.
- **Spring MVC** – Framework for building RESTful web applications.
- **Spring Boot** – Simplifies Spring configuration with auto-configuration and starter dependencies.

---

### 4. Development Environment Setup

- **IDE**: IntelliJ IDEA or Eclipse
- **Build Tool**: Maven
- **Java Version**: 17+

---

### 5. Creating a Simple Spring Boot App

Files created:
- `DemoApplication.java` – Entry point annotated with `@SpringBootApplication`
- `GreetingService.java` – A simple service class
- `GreetingController.java` – A REST controller

---

### 6. application.properties vs application.yaml

Both are used to define configuration in Spring Boot.

**application.properties** (used in this project):
```properties
server.port=8080
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

**application.yaml** (optional alternative):
```yaml
server:
  port: 8080
springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
```

---

### 7. Spring Boot Starters and Auto-Configuration

**Starters**: Pre-packaged dependency descriptors (`spring-boot-starter-web`)
**Auto-Configuration**: Spring Boot configures defaults based on the classpath and dependencies.

---

### 8. Annotations: @Component, @Service, @Repository

| Annotation     | Purpose               | Layer           |
|----------------|------------------------|------------------|
| `@Component`   | Generic Spring bean     | Utility/Helper   |
| `@Service`     | Business logic class    | Service Layer    |
| `@Repository`  | DAO, data access class  | Persistence Layer |

All three register the class as a **Spring Bean** so it can be injected using `@Autowired`.



## Common Purpose: Bean Registration for DI

All three annotations mark a class as a Spring Bean, allowing Spring to manage it and inject it wherever needed using Inversion of Control (IoC).


### 1. `@Component` – The Generic Bean
#### Purpose:
Marks a class as a Spring-managed component. This is the most general-purpose annotation.

Usage Example:

```java
import org.springframework.stereotype.Component;

@Component
public class EmailValidator {
    public boolean isValid(String email) {
        return email.contains("@");
    }
}
```

```java
@Autowired
private EmailValidator emailValidator;
```

  __Note__: Use this when your class doesn't clearly fall into service or repository categories.


### 2. `@Service` – The Business Logic Bean
#### Purpose:
Marks a class that contains business logic or service layer code.

Internally, it's a specialization of `@Component`.

Usage Example:

```java
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserInfo() {
        return "User info from service";
    }
}
```

Injection:

```java
@Autowired
private UserService userService;
```

  __Note__: Use this when the class performs core business logic, transformations, or coordinations.


### 3. `@Repository` – The Data Access Bean (DAO Layer)
#### Purpose:
Marks a class as a Data Access Object (DAO) — used for database operations.

Also a specialization of `@Component`, but comes with extra behaviors:

Automatic exception translation (e.g., converts `SQLException` to `DataAccessException`)
Usage Example:

```java
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public String fetchUserFromDb() {
        return "User from DB";
    }
}
```

Injection:

```java
@Autowired
private UserRepository userRepository;
```

  __Note__: Use this for any class that interacts with the database (JPA, JDBC, etc.).

| Annotation    | Layer             | Special Behavior              | Use Case Example                     |
| ------------- | ----------------- | ----------------------------- | ------------------------------------ |
| `@Component`  | Generic           | Basic Spring Bean             | Utility classes, validators          |
| `@Service`    | Business Layer    | Semantic clarity for services | Business logic (e.g., `UserService`) |
| `@Repository` | Persistence Layer | Exception translation         | Data access (e.g., `UserRepository`) |



##   Hands-On Done

###   Create Spring Boot App
- Used Maven and Spring Boot
- Set up main class with `@SpringBootApplication`

###   Implement DI with Spring Beans
- `GreetingService` marked as `@Service`
- Injected into `GreetingController` using `@Autowired`

###   Enable Swagger UI
- Added `springdoc-openapi-starter-webmvc-ui` dependency
- Configured Swagger paths in `application.properties`

###   Endpoint Created
```http
GET /hello-service
```
Shows message from `GreetingService`


## 📦 Project Structure

```
src/
└── main/
    ├── java/
    │   └── com/example/demo/
    │       ├── DemoApplication.java
    │       ├── GreetingService.java
    │       └── GreetingController.java
    └── resources/
        └── application.properties
```

