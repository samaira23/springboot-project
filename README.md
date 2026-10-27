# 🛍️ MiniStore – E-Commerce Website

MiniStore is a web-based e-commerce application developed using Java and Spring Boot. It provides a foundation for an online shopping experience, with a web interface for interacting with products and managing store data.

The application uses Spring Boot for backend development, Thymeleaf for server-side rendering, Spring Data JPA and Hibernate for database operations, and H2 Database for local data storage.

## ✨ Features

- **E-Commerce Interface:** A web-based interface for interacting with the online store.
- **Product Management:** Manage product information supported by the application.
- **Dynamic Web Pages:** Render dynamic content using Thymeleaf.
- **Database Integration:** Store application data using H2 Database.
- **ORM Support:** Use Spring Data JPA and Hibernate for database operations.
- **Automatic Schema Management:** Configure Hibernate to update the database schema.
- **Local Development:** Run the application locally without requiring a separately installed database server.

> Note: The exact features available depend on the controllers, services, and templates implemented in the project.

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming language |
| Spring Boot | Application framework |
| Spring Web MVC | Handle web requests and responses |
| Thymeleaf | Render dynamic HTML pages |
| Spring Data JPA | Database access and persistence |
| Hibernate | Object-relational mapping (ORM) |
| H2 Database | Local database storage |
| HTML | Structure of web pages |
| CSS | Styling and layout |
| JavaScript | Client-side interactions, where implemented |
| Maven | Dependency and build management |
| Git & GitHub | Version control and source code hosting |

## 🏗️ Application Architecture

MiniStore follows a Spring Boot web application architecture.

```text
              User
                |
                v
          Web Browser
                |
                v
       Thymeleaf Web Interface
                |
                v
       Spring Boot / MVC Layer
                |
                v
       Spring Data JPA
                |
                v
          Hibernate ORM
                |
                v
          H2 Database
```

### How It Works

1. The user interacts with the website through a browser.
2. Spring MVC handles incoming web requests.
3. The application processes requests using its Java components.
4. Spring Data JPA and Hibernate handle database operations.
5. The application returns the appropriate web page to the browser.

## 📂 Project Structure

The project follows the standard Maven and Spring Boot directory structure.

```text
springboot-project/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/
│       │       └── ...
│       │
│       └── resources/
│           ├── static/
│           │   ├── css/
│           │   ├── js/
│           │   └── images/
│           │
│           ├── templates/
│           │   └── ...
│           │
│           └── application.properties
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

*Note: The directory tree above illustrates the typical Spring Boot structure. Actual package and resource names may differ in the repository.*

## ⚙️ Prerequisites

Before running the application, install:

- Java Development Kit (JDK) 21
- Git
- A web browser
- An internet connection to download Maven dependencies

The project includes the Maven Wrapper, so installing Maven separately is not necessary.

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/samaira23/springboot-project.git
```

### 2. Navigate to the Project

```bash
cd springboot-project
```

### 3. Verify Java Installation

```bash
java -version
```

Ensure that JDK 21 is installed and available.

### 4. Run the Application

**Windows PowerShell:**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS / Linux:**

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

Wait for Spring Boot to finish starting the application.

### 5. Open the Website

Open your browser and visit:

http://localhost:8080

The MiniStore website should load.

Keep the terminal running while using the application. Press `Ctrl + C` to stop the server.

## 🗄️ Database Configuration

MiniStore uses the H2 database in file-based mode.

The database configuration is defined in:

`src/main/resources/application.properties`

Current configuration:

```properties
spring.application.name=ministore

server.port=8080

spring.datasource.url=jdbc:h2:file:./data/ministoredb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.thymeleaf.cache=false
```

### H2 Database Console

When the application is running, the H2 console is available at:

http://localhost:8080/h2-console

Use the following connection details:

| Setting | Value |
|---|---|
| JDBC URL | `jdbc:h2:file:./data/ministoredb` |
| User Name | `sa` |
| Password | Leave empty |

The database is stored locally. Hibernate is configured to update the schema automatically.

### Will the Application Work After Cloning?

Yes. The database file does not need to be committed to GitHub.

When someone clones the repository and runs the application, H2 can create the local database and Hibernate can create or update the required tables.

The new user will have a separate local database rather than your existing database records.

## 🔧 Development

You can use any Java-compatible IDE, such as:

- Visual Studio Code
- IntelliJ IDEA
- Eclipse

For development in Visual Studio Code, install the Java extensions and open the cloned project folder.

To rebuild the project on Windows:

```powershell
.\mvnw.cmd clean package
```

To run the application again:

```powershell
.\mvnw.cmd spring-boot:run
```

## 🔮 Future Enhancements

Potential enhancements for the application include:

- User registration and authentication
- Product search and category filtering
- Shopping cart and checkout functionality
- Order management and order history
- Payment gateway integration
- Product image uploads
- Administrative dashboard
- Deployment to a cloud hosting platform

These are possible future improvements, not claims about existing functionality.

## 👩‍💻 Author

**Samaira Mittal**

GitHub: [@samaira23](https://github.com/samaira23)

## 📄 License

No license is specified here. If you want others to reuse or distribute this project, consider adding an appropriate open-source license to the repository.
