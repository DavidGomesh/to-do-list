# Technnical test

Development of a secure RESTful To-Do List API using Java 21, Spring Boot 3, MySQL, and Docker, with user authentication, task management, and business rules enforcement

## Used technologies
- Java 21 with Spring Boot 3
- Dependencies:
    - Spring Web
    - Spring Data
    - Spring Validation
    - Lombok
    - MySQL Connector
    - Spring Security and OAuth2 Resource Server
    - Map Struct
    - Springdoc OpenAPI
- Docker
- Git and GitHub

## Prerequisites
- Docker Engine installed

## Step-by-step
- Clone the repository
- Open a terminal in the directory containing the `docker-compose.yml` file
- Execute the following command to start:
```
docker-compose up -d
```
- Access the API routes via:
```
http://localhost:8080/
```

## Class Diagram
| ![Class Diagram](./docs/diagrams/class/Class%20Diagram.jpg? "Class Diagram") |
|-|
| *Class Diagram* |

## Routes

All application's routes are started by path `api`.

### Authentication

| Method | Need authentication | Route | Description |
|-|-|-|-|
| POST | No | `/api/auth/login` | User login |

### Users
| Method | Need authentication | Route | Description |
|-|-|-|-|
| POST | No | `/api/v1/users` | Creates a new user |
| GET | No | `/api/v1/users` | Retrieves all users |
| GET | No | `/api/v1/users/{id}` | Retrieves a user by ID |

### Tasks
| Method | Need authentication | Route | Description |
|-|-|-|-|
| POST | Yes | `/api/v1/task` | Creates a new task |
| GET | Yes | `/api/v1/task` | Retrieves all tasks of the logged user |
| GET | Yes | `/api/v1/task/{id}` | Retrieves a task by ID |
| PATCH | Yes | `/api/v1/task/{id}/status/{status}` | Updates the status of a task |
| DELETE | Yes | `/api/v1/task/{id}` | Deletes a task by ID |

## Bussiness logic
- A new task is automatically associate to the logged user
- The user just can view and manipulate its own tasks
- A task that contains incomplete subtasks can't be marked as completed

