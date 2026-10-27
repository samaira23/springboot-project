# Student Task Manager

A simple full-stack web application built using **Java 21 and Spring Boot** that helps students organize, manage, and track their academic tasks.

## 📌 About the Project

The Student Task Manager provides a simple interface for students to maintain their daily academic activities. Users can create tasks, view saved tasks, mark tasks as completed, and delete tasks when they are no longer needed.

The application uses Spring Boot REST APIs for backend operations and an H2 database for local data persistence.

## ✨ Features

- **Add Tasks:** Create tasks with a title and description.
- **View Tasks:** Display all saved tasks.
- **Mark as Completed:** Update a task's completion status.
- **Delete Tasks:** Remove tasks that are no longer required.
- **Task Counter:** View the total number of tasks.
- **REST API Integration:** Perform CRUD operations through HTTP endpoints.
- **Database Persistence:** Store tasks in a local H2 database.
- **Simple User Interface:** Interact with tasks through a web browser.

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming |
| Spring Boot | Application framework |
| Spring Web | REST API development |
| Spring Data JPA | Database interaction |
| Hibernate | Object-relational mapping |
| H2 Database | Local data storage |
| HTML | Web page structure |
| CSS | Styling and responsive layout |
| JavaScript | Frontend interactions and API requests |
| Maven | Dependency and build management |
| Git and GitHub | Version control |

## 📂 Project Structure

```text
student-task-manager/
├── .mvn/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/studenttaskmanager/
│       │       ├── model/
│       │       │   └── Task.java
│       │       ├── repository/
│       │       │   └── TaskRepository.java
│       │       ├── controller/
│       │       │   └── TaskController.java
│       │       └── StudentTaskManagerApplication.java
│       └── resources/
│           ├── static/
│           │   └── index.html
│           └── application.properties
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## ⚙️ Prerequisites

Before running the project, make sure you have:

- Java Development Kit (JDK) 21
- Git
- A modern web browser
- An internet connection for the initial dependency download

Maven is provided through the Maven Wrapper, so a separate Maven installation is not required.

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/samaira23/springboot-project.git
```

### 2. Open the project directory

```bash
cd springboot-project
```

### 3. Verify your Java installation

```bash
java -version
```

Make sure Java 21 is installed and configured.

### 4. Run the application

**Windows PowerShell:**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux:**

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

Wait until Spring Boot starts successfully.

### 5. Open the application

Open your browser and visit:

**http://localhost:8080**

Keep the terminal running while using the application.

## 🔗 REST API Endpoints

The application provides the following endpoints for task management.

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Retrieve all tasks |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}` | Update an existing task |
| DELETE | `/api/tasks/{id}` | Delete a task |

### Example: Create a Task

**Request:**

```http
POST /api/tasks
Content-Type: application/json
```

**Request body:**

```json
{
  "title": "Complete Java Assignment",
  "description": "Finish the programming exercises",
  "completed": false
}
```

### Example: Retrieve Tasks

```http
GET /api/tasks
```

The API returns task information in JSON format.

## 🗄️ Database Configuration

The application uses the H2 database in file-based mode to store task information locally.

The database configuration is maintained in:

```text
src/main/resources/application.properties
```

The application uses Spring Data JPA and Hibernate to manage database operations and the database schema.

### H2 Database Console

When the application is running, visit:

**http://localhost:8080/h2-console**

Use the following connection details:

- **JDBC URL:** `jdbc:h2:file:./data/taskdb`
- **Username:** `sa`
- **Password:** Leave blank

The database is created locally when the application starts and is not shared automatically between different installations.

## 🔄 How the Application Works

1. The user interacts with the web interface.
2. JavaScript sends HTTP requests to the Spring Boot REST API.
3. The controller receives requests and processes task operations.
4. Spring Data JPA and Hibernate handle database interactions.
5. The H2 database stores task information.
6. The API returns the response, and JavaScript updates the interface.

## 🧪 Build and Test

To build the project and run its available tests:

**Windows:**

```powershell
.\mvnw.cmd clean verify
```

**macOS/Linux:**

```bash
./mvnw clean verify
```

## 🚀 Future Enhancements

- Add task due dates and priority levels.
- Implement task search and filtering.
- Add student authentication and individual task lists.
- Improve task editing functionality.
- Deploy the application to a cloud platform.
- Add automated tests for REST API endpoints.

## 🎓 Learning Outcomes

This project demonstrates practical implementation of:

- Java and object-oriented programming.
- Spring Boot application development.
- RESTful API design and HTTP methods.
- Spring Data JPA and Hibernate.
- Relational database integration.
- Frontend and backend communication using JavaScript.
- Maven-based dependency management.
- Git and GitHub version control.

## 👨‍💻 Author

**Samaira23**

GitHub Repository: https://github.com/samaira23/springboot-project

---

*Developed as a learning project to practice Java, Spring Boot, REST APIs, database integration, and frontend development.*
