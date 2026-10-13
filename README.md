

\# Student Task Manager



A simple full-stack web application built using Java and Spring Boot that helps students organize, track, and manage their daily academic tasks.



The application provides a web interface to create tasks, view task details, mark tasks as completed, and delete tasks. It uses Spring Boot REST APIs for backend operations and an H2 database for persistent local storage.



\## Features



\- \*\*Add Tasks:\*\* Create tasks with a title and description.

\- \*\*View Tasks:\*\* Display all saved tasks in the web interface.

\- \*\*Mark as Completed:\*\* Update a task's completion status.

\- \*\*Delete Tasks:\*\* Remove tasks that are no longer needed.

\- \*\*Task Counter:\*\* View the task count displayed by the interface.

\- \*\*REST API:\*\* Perform CRUD operations through REST endpoints.

\- \*\*Persistent Storage:\*\* Store tasks in a local H2 database file.

\- \*\*Automatic Table Creation:\*\* Use Hibernate to create and update the database schema.

\- \*\*Simple User Interface:\*\* Interact with the application through a browser without installing a separate frontend framework.



\## Technology Stack



| Technology | Purpose |

|---|---|

| Java 21 | Backend programming language |

| Spring Boot | Application framework |

| Spring Web | REST API and web server |

| Spring Data JPA | Database operations |

| Hibernate | Object-relational mapping |

| H2 Database | Local database storage |

| HTML | Web page structure |

| CSS | User interface styling |

| JavaScript | Frontend interactions and API requests |

| Maven | Dependency and build management |

| Git and GitHub | Version control and source code hosting |



\## Project Structure



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

├── .gitignore

├── mvnw

├── mvnw.cmd

├── pom.xml

└── README.md

```



\## Prerequisites



Before running the project, install:



\- \[JDK 21](https://adoptium.net/)

\- \[Git](https://git-scm.com/)

\- A web browser



Maven is included through the Maven Wrapper, so a separate Maven installation is not required. An internet connection is needed initially to download project dependencies.



\## Getting Started



\### 1. Clone the Repository



Replace `YOUR\_USERNAME` with the GitHub account that hosts this repository.



```bash

git clone https://github.com/YOUR\_USERNAME/student-task-manager.git

```



\### 2. Open the Project Directory



```bash

cd student-task-manager

```



\### 3. Verify Java



```bash

java -version

```



Make sure Java 21 is active.



\### 4. Run the Application



\*\*Windows PowerShell:\*\*



```powershell

.\\mvnw.cmd spring-boot:run

```



\*\*macOS/Linux:\*\*



```bash

chmod +x mvnw

./mvnw spring-boot:run

```



Wait until Spring Boot reports that Tomcat has started on port 8080.



\### 5. Open the Application



Visit:



\*\*http://localhost:8080\*\*



The Student Task Manager interface should appear in your browser.



Keep the terminal running while using the application. Press `Ctrl + C` in the terminal to stop the server.



\## How the Application Works



1\. A user interacts with the web interface.

2\. JavaScript sends HTTP requests to the Spring Boot REST API.

3\. The controller receives the requests and uses the repository to access task data.

4\. Spring Data JPA and Hibernate perform the database operations.

5\. The API returns the results, and JavaScript updates the interface.



\## REST API Endpoints



The following endpoints are implemented by the application.



| Method | Endpoint | Description |

|---|---|---|

| GET | `/api/tasks` | Retrieve all tasks |

| POST | `/api/tasks` | Create a new task |

| PUT | `/api/tasks/{id}` | Update an existing task |

| DELETE | `/api/tasks/{id}` | Delete a task |



\### Example: Create a Task



\*\*Request\*\*



```http

POST /api/tasks

Content-Type: application/json

```



\*\*Request body\*\*



```json

{

&#x20; "title": "Complete Java Assignment",

&#x20; "description": "Finish the programming exercises",

&#x20; "completed": false

}

```



\### Example: Retrieve All Tasks



```http

GET /api/tasks

```



The API returns task data in JSON format.



\## Database Configuration



The application uses the H2 database in file-based mode.



The relevant settings are in `src/main/resources/application.properties`:



```properties

spring.datasource.url=jdbc:h2:file:./data/taskdb

spring.datasource.driver-class-name=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=



spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true



spring.h2.console.enabled=true

spring.h2.console.path=/h2-console

```



\### Does a New User Need Your Database File?



No. The database file is intentionally excluded from GitHub.



When a user runs the application for the first time, H2 creates a local database and Hibernate creates the required table. The new user starts with an empty task list.



Tasks created by one user are not shared with other users because each local installation maintains its own database.



\### H2 Database Console



While the application is running, visit:



http://localhost:8080/h2-console



Use these connection settings:



\- \*\*JDBC URL:\*\* `jdbc:h2:file:./data/taskdb`

\- \*\*User Name:\*\* `sa`

\- \*\*Password:\*\* Leave blank



The console is intended for local development. Do not expose it publicly without appropriate security controls.



\## Build and Test



To compile the project and run its available tests:



\*\*Windows PowerShell:\*\*



```powershell

.\\mvnw.cmd clean verify

```



\*\*macOS/Linux:\*\*



```bash

./mvnw clean verify

```



\## Troubleshooting



\### Java Version Error



If you see `UnsupportedClassVersionError`, verify that Java 21 is being used by both Java and Maven:



```powershell

java -version

.\\mvnw.cmd -version

```



Both should report Java 21.



\### Port 8080 Is Already in Use



Stop the other application using port 8080, or configure Spring Boot to use another available port.



\### Database File Access Error



If Git reports a permission error for `data/taskdb.mv.db`, stop the running application and verify that the database directory is excluded in `.gitignore`.



\### Maven Dependency Download Failure



Check your internet connection and run the Maven Wrapper again.



\## Future Improvements



Potential enhancements include:



\- Edit task details from the interface.

\- Add due dates and task priorities.

\- Filter tasks by completion status.

\- Search tasks by title.

\- Add student authentication and individual task lists.

\- Deploy the application to a cloud platform.



\## Learning Outcomes



This project demonstrates practical use of:



\- Java and object-oriented programming.

\- Spring Boot application development.

\- REST API design and HTTP methods.

\- Spring Data JPA and Hibernate.

\- Relational database persistence.

\- Frontend-to-backend communication using JavaScript `fetch()`.

\- Maven-based project management.

\- Git-based version control.



\## Author



\*\*YOUR NAME\*\*



Developed as a learning project to practice Java, Spring Boot, REST APIs, database integration, and frontend development.



\---



If you find this project useful, feel free to fork the repository and build on it.



