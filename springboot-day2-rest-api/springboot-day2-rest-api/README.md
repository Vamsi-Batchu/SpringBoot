# Day 2: Spring Boot RESTful APIs & Data Access

## Objective

Learn how to build RESTful APIs and interact with databases using Spring Data JPA in a Spring Boot application.

---

## Topics Covered

### 1. Building REST APIs with `@RestController`

* `@RestController` is a specialized version of `@Controller` used to build REST APIs.
* It combines `@Controller` and `@ResponseBody`, eliminating the need to annotate every method with `@ResponseBody`.

**Example:**

```java
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }
}
```

---

### 2. Handling HTTP requests (GET, POST, PUT, DELETE)

Spring MVC supports RESTful endpoints with annotations:

* `@GetMapping`: retrieve data
* `@PostMapping`: create a resource
* `@PutMapping`: update a resource
* `@DeleteMapping`: delete a resource

**Example:**

```java
@PostMapping
public Product createProduct(@RequestBody Product product) {
    return productService.save(product);
}
```

---

### 3. Exception Handling with `@ControllerAdvice`

* `@ControllerAdvice` is used for global exception handling.
* It separates error handling from regular controller logic.

**Example:**

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
```

---

### 4. Introduction to Spring Data JPA

* A part of Spring Data that simplifies database access with JPA.
* Eliminates boilerplate code like SQL statements and implementation of DAO classes.

**Benefits:**

* Automatically implements basic CRUD operations
* Integrates with multiple databases (MySQL, PostgreSQL, etc.)

---

### 5. Configuring Databases (H2, MySQL, PostgreSQL)

* **H2**: In-memory database used for testing
* **MySQL/PostgreSQL**: Production-grade databases

**H2 Configuration Example (`application.properties`)**

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

---

### 6. Writing Repository Interfaces (`JpaRepository`, `CrudRepository`)

* Spring Data provides interfaces like `JpaRepository` and `CrudRepository`.
* No need to write implementation code.

**Example:**

```java
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
```

---

### 7. Using `@Entity`, `@Table`, `@Column`, and `@Id`

Annotations for ORM mapping with JPA:

* `@Entity`: marks a class as a database entity
* `@Table`: maps to a specific table name
* `@Column`: customizes column properties
* `@Id`: marks the primary key field

**Example:**

```java
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private double price;
}
```

---

### 8. Implementing Pagination and Sorting

* Provided by `PagingAndSortingRepository` or `JpaRepository`

**Example:**

```java
@GetMapping("/paged")
public Page<Product> getPagedProducts(Pageable pageable) {
    return productRepository.findAll(pageable);
}
```

Usage:

```
GET /api/products/paged?page=0&size=5&sort=price,desc
```

---

## 📋 Hands-On Task

### Build REST API with CRUD for Product Entity

* **Create**: `POST /api/products`
* **Read**: `GET /api/products`, `GET /api/products/{id}`
* **Update**: `PUT /api/products/{id}`
* **Delete**: `DELETE /api/products/{id}`

### Store Data in H2, Then Switch to MySQL/PostgreSQL

* Start with H2 for local development
* Change database config in `application.properties` to switch to MySQL/PostgreSQL

---
