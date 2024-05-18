# JAVA_PROJECT

# Client Management System

This project is a simple Client Management System built with Java, JSP, Servlets, and MySQL. It allows you to add, update, delete, and view clients.

## Features

- Add new clients
- Update existing client information
- Delete clients
- View client details

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Tomcat server 9.0 or higher
- MySQL 5.7 or higher
- A MySQL client (e.g., MySQL Workbench)

## Setup Instructions

### Database Setup

1. **Create the Database:**

```sql
CREATE DATABASE client_management;
```

2. **Create the Table:**

```sql
USE client_management;

CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15) NOT NULL
);
```

### Project Structure

The project consists of the following files:

- `add_client.jsp`: The page to add a new client.
- `update_client.jsp`: The page to update an existing client.
- `delete_client.jsp`: The page to delete a client.
- `view_clients.jsp`: The page to view all clients.
- `Client.java`: The Java Bean representing the client entity.
- `ClientDAO.java`: The Data Access Object (DAO) for performing database operations.
- `AddClientServlet.java`: The servlet handling client addition.
- `UpdateClientServlet.java`: The servlet handling client updates.
- `DeleteClientServlet.java`: The servlet handling client deletion.
- `ViewClientsServlet.java`: The servlet handling client retrieval for viewing.

### Step-by-Step Guide

1. **Clone the Repository:**

```sh
git clone https://github.com/yourusername/client-management-system.git
```

2. **Import the Project into Your IDE:**

- Open your IDE (e.g., Eclipse, IntelliJ IDEA).
- Import the project as a Maven project.

3. **Configure Database Connection:**

- Open `ClientDAO.java`.
- Update the constants with your database details


4. **Build and Deploy the Project:**

- Build the project using your IDE or run `mvn clean install` if using Maven.
- Deploy the generated WAR file to your Apache Tomcat server.

5. **Access the Application:**

- Start your Apache Tomcat server.
- Open your web browser and navigate to `http://localhost:8080/client-management-system/`.

### File Descriptions

#### JSP Files

- **add_client.jsp**: Form to add a new client.
- **update_client.jsp**: Form to update an existing client.
- **delete_client.jsp**: Form to delete a client.
- **view_clients.jsp**: Displays a list of all clients.

#### Java Beans

- **Client.java**: Represents the client entity with fields for ID, name, email, and phone number.

#### DAO

- **ClientDAO.java**: Contains methods for database operations (add, update, delete, retrieve clients).


#### Servlets

- **AddClientServlet.java**: Handles adding new clients.
- **UpdateClientServlet.java**: Handles updating existing clients.
- **DeleteClientServlet.java**: Handles deleting clients.
- **ViewClientsServlet.java**: Handles retrieving clients for viewing.

## Usage

1. **Add Client:**

- Go to the `Add Client` page from the home page.
- Fill in the form and submit to add a new client.

2. **Update Client:**

- Go to the `Update Client` page from the home page.
- Enter the client ID, update the information, and submit to update the client details.

3. **Delete Client:**

- Go to the `Delete Client` page from the home page.
- Enter the client ID and submit to delete the client.

4. **View Clients:**

- Go to the `View Clients` page from the home page to see a list of all clients.


 
