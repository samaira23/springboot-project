
# MiniStore - E-Commerce Website

MiniStore is a web-based e-commerce application developed using Java and Spring Boot. It provides a simple online shopping experience where users can browse products, search by name, filter by category, manage a shopping cart, and complete a demo checkout.

The application uses Spring Boot MVC and Thymeleaf to render dynamic web pages. Product information is predefined in Java code, while shopping cart contents are maintained in the user's HTTP session.

## Features

- **Product Catalog:** Browse 16 predefined products across Electronics, Fashion, Accessories, and Home categories.
- **Product Search:** Search for products by name.
- **Category Filtering:** Filter products by category.
- **Shopping Cart:** Add products to the cart and view selected items.
- **Quantity Management:** Increase or decrease product quantities.
- **Remove Items:** Remove individual products from the cart.
- **Price Calculation:** Automatically calculate item totals, subtotal, and cart total.
- **Demo Checkout:** Simulate placing an order, display the order total, and clear the cart.
- **Responsive Interface:** Access the shopping interface on desktop and mobile screen sizes.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming |
| Spring Boot 4.1.1 | Application framework |
| Spring Web MVC | Handle HTTP requests and responses |
| Thymeleaf | Server-side HTML rendering |
| HTML5 | Web page structure |
| CSS3 | Styling and responsive layout |
| Spring Data JPA | Database integration dependency |
| Hibernate | ORM integration through JPA |
| H2 Database | Configured local database |
| Maven | Dependency management and build automation |
| Git and GitHub | Version control and source code hosting |

## Project Structure

The repository contains the following application files:

```text
springboot-project/
|
|-- .mvn/
|   |-- wrapper/
|       |-- maven-wrapper.properties
|
|-- src/
|   |-- main/
|       |-- java/
|       |   |-- com/
|       |       |-- example/
|       |           |-- ecommerce/
|       |               |-- EcommerceApplication.java
|       |               |-- Product.java
|       |               |-- StoreController.java
|       |
|       |-- resources/
|           |-- templates/
|           |   |-- index.html
|           |
|           |-- application.properties
|
|-- .gitattributes
|-- .gitignore
|-- mvnw
|-- mvnw.cmd
|-- pom.xml
|-- README.md
```

### Main Application Files

- **EcommerceApplication.java:** Entry point that starts the Spring Boot application.
- **Product.java:** Defines the product model, including ID, name, price, description, category, and emoji-based product illustration.
- **StoreController.java:** Handles product search, category filtering, cart operations, quantity updates, item removal, and demo checkout.
- **index.html:** Contains the Thymeleaf-based storefront, product catalog, search controls, category filters, shopping cart, and checkout interface.
- **application.properties:** Contains the application name, server port, H2 database settings, JPA configuration, and Thymeleaf settings.
- **pom.xml:** Defines project dependencies, Java version, and Maven build configuration.

## Application Architecture

```text
          User
            |
            v
       Web Browser
            |
            v
    Thymeleaf HTML Page
        index.html
            |
            v
    Spring MVC Controller
     StoreController.java
            |
       +----+----+
       |         |
       v         v
   Product     HTTP Session
   Catalog     Shopping Cart
       |
       v
  Rendered Storefront
```

The application follows a Spring MVC architecture. The controller processes browser requests, manages the in-memory product catalog and session-based cart, and supplies data to Thymeleaf for rendering the storefront.

## Prerequisites

Before running the project, ensure that you have:

- Java Development Kit (JDK) 21
- Git
- A web browser
- An internet connection for downloading Maven dependencies on the first run

The repository includes the Maven Wrapper, so a separate Maven installation is not required.

## Installation and Setup

### 1. Clone the Repository

```bash
git clone https://github.com/samaira23/springboot-project.git
```

### 2. Navigate to the Project Directory

```bash
cd springboot-project
```

### 3. Verify Java Installation

```bash
java -version
```

Ensure that Java 21 is installed and available in your system's PATH.

### 4. Run the Application

**Windows PowerShell:**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS or Linux:**

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

Maven will download the required dependencies and start the Spring Boot application.

### 5. Open the Website

Once the application has started, open:

http://localhost:8080

You can now browse products, search and filter the catalog, manage your shopping cart, and try the demo checkout.

To stop the application, press `Ctrl + C` in the terminal.

## Database Configuration

The project includes H2 Database and Spring Data JPA dependencies. The database is configured in `src/main/resources/application.properties` using the following settings:

```properties
spring.datasource.url=jdbc:h2:file:./data/ministoredb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### Important Implementation Details

The current storefront does not persist products, cart contents, or orders in H2.

- Products are predefined in `StoreController.java`.
- Shopping cart contents are stored in the user's HTTP session.
- The checkout operation displays a confirmation message and clears the cart.
- No real payment is collected, and no order record is saved.

The H2 database configuration is present, but database persistence has not been implemented for these shopping features.

### H2 Console

When the application is running, the configured H2 console URL is:

http://localhost:8080/h2-console

Connection settings:

| Setting | Value |
|---|---|
| JDBC URL | `jdbc:h2:file:./data/ministoredb` |
| Username | `sa` |
| Password | Leave empty |

The console is intended for local development and database inspection.

## Current Limitations

- Product information is hardcoded rather than loaded from a database.
- Cart contents are session-based and are not permanently stored.
- Checkout is a demonstration and does not process payments.
- Orders are not persisted or available as order history.
- User registration and authentication are not implemented.
- There is no administrative product management interface.

## Future Enhancements

Potential improvements include:

- Persist products using JPA entities and repositories.
- Implement a database-backed shopping cart.
- Add user registration and authentication.
- Store orders and provide order history.
- Integrate a secure payment gateway.
- Add product image uploads and product management.
- Introduce an administrative dashboard.
- Deploy the application to a cloud hosting platform.

## Author

**Samaira Mittal**

GitHub: [@samaira23](https://github.com/samaira23)

## License

No license has been specified for this project. Add a suitable license file if you intend to distribute the project under an open-source license.
