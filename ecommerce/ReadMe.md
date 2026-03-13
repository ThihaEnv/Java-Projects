# 🏀 Sport Equipment E-Commerce System

A robust backend system built with **Java Spring Boot** for managing a sports equipment retail shop. This application features a dual-interface approach, allowing users to interact via a **Terminal-based Console UI** or through **RESTful API endpoints**.

---

## ✨ Core Features

* **Product Management**: Browse a catalog of sports gear with real-time price and ID tracking.
* **Customer Lifecycle**: Register new customers and automatically generate a dedicated shopping cart for each.
* **Smart Shopping Cart**: Add multiple products to a single cart without creating duplicate cart instances.
* **Transactional Checkout**: Calculate the total price of all items in the cart and process cash payments.
* **Data Persistence**: Uses Spring Data JPA with an H2 Database for reliable data handling.

---

## 🛠 Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x
* **Database:** H2 (In-Memory) / MySQL Support
* **ORM:** Spring Data JPA (Hibernate)
* **Build Tool:** Maven

---

## 🚀 Getting Started

### Prerequisites

* JDK 17 or higher
* Maven 3.6+
* IntelliJ IDEA (Recommended)

### Installation & Execution

1. **Clone the Repository:**
```bash
git clone https://github.com/ThihaEnv/Java-Projects.git

```


2. **Open in IDE:**
   Import the project as a Maven project in IntelliJ.
3. **Run the Application:**
   Locate `EcommerceApplication.java` and click **Run**.
4. **Usage:**
   The Terminal will display a menu. Follow the prompts to register, add items, and checkout.

---

## 📖 API Documentation

The system exposes the following REST endpoints for integration with frontend or mobile apps:

### 🛍 Products

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/v1/products` | Retrieve all available equipment |
| `POST` | `/api/v1/products` | Add a new sports product |

### 👤 Customers & Carts

| Method | Endpoint | Description |
| --- | --- | --- |
| `POST` | `/api/v1/customers/register` | Create user and assign a Cart ID |
| `POST` | `/api/v1/carts/add/{pId}/{cId}` | Add specific product to a specific cart |

### 💳 Orders

| Method | Endpoint | Description |
| --- | --- | --- |
| `POST` | `/api/v1/orders/pay/{cartId}` | Process checkout and sum totals |

---

## 📂 Project Structure

src/main/java/com/thiha/ecommerce/
├── controller/    # REST API Controllers
├── model/         # JPA Entities (Product, Customer, Cart, Order)
├── repository/    # Data Access Layers
├── service/       # Business Logic & Payment Processing
└── EcommerceApplication.java # Application Entry Point & Console UI

```

---

## 👤 Author

* **Thiha** - Backend Developer
* GitHub: [@ThihaEnv](https://www.google.com/search?q=https://github.com/ThihaEnv)