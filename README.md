# Restaurant Management System

This is a **Restaurant Management System** built using **Java Spring Boot** with **MySQL** hosted on Azure as the database. This application provides RESTful APIs to manage restaurants, including functionalities for restaurant creation, restaurant search, and review management. Exception handling, validation, and DTO classes are also implemented to maintain clean and efficient code.

## Features

1. **Restaurant Management**:
   - **Add New Restaurant**: Create a new restaurant entry with relevant details (name, location, cuisine, etc.).
   - **Search Restaurant**: Search for restaurants based on criteria such as name, location, or cuisine.
   
2. **Review Management**:
   - **Add Review**: Allows users to add reviews for restaurants.
   - **Fetch Reviews**: Fetch reviews for a specific restaurant.

## Technologies Used

- **Backend**: Java, Spring Boot
- **Database**: MySQL (hosted on Azure)
- **Data Access**: JDBC
- **Additional Features**: DTOs, Validation, Exception Handling

## Project Structure

- `Controller` - Handles incoming requests and routes them to the appropriate service.
- `Service` - Contains business logic for handling restaurant and review operations.
- `Repository` - Interacts with the database using JDBC for data persistence.
- `DTOs` - Data Transfer Objects for transferring data between layers.
- `Validators` - Custom validations to ensure data integrity.
- `Exception Handling` - Global and custom exception handling for improved error management.

## API Endpoints

### Restaurant Endpoints

- **POST** `/api/restaurants` - Create a new restaurant.
- **GET** `/api/restaurants/{id}` - Get details of a specific restaurant by ID.
- **GET** `/api/restaurants/search` - Search for restaurants with specific criteria (query parameters).

### Review Endpoints

- **POST** `/api/reviews` - Add a review for a restaurant.
- **GET** `/api/reviews/{restaurantId}` - Get all reviews for a specific restaurant.

## Getting Started

### Prerequisites

- **Java** - Ensure Java is installed on your machine.
- **Maven** - Use Maven for dependency management.
- **MySQL Database** - Set up the MySQL database on Azure.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/restaurant-management-system.git

## Project Structure

```plaintext
restaurant-management-system
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.example.restaurant
│   │   │   │   ├── controllers        # REST controllers for handling requests
│   │   │   │   ├── dtos               # Data Transfer Objects (DTOs)
│   │   │   │   ├── models             # Entity models for MySQL
│   │   │   │   ├── repositories       # JPA repositories for database operations
│   │   │   │   ├── services           # Business logic layer
│   │   │   │   ├── validators         # Custom validation classes
│   │   │   │   ├── exceptions         # Custom exception handling classes
│   │   │   │   └── RestaurantManagementSystemApplication.java
│   │   └── resources
│   │       └── application.properties # Configuration file for database and other settings
└── pom.xml                             # Maven dependencies
