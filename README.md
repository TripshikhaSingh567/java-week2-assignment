# Java Internship - Week 2 Tasks

This repository contains the projects completed during **Week 2 of the Java Internship Program**. The objective of these projects was to gain hands-on experience with Java programming concepts, file handling, JDBC, and database connectivity.

---

# Task 1: Student Management System

## Task Overview

The Student Management System is a console-based Java application that helps manage student records. It allows users to add, view, search, update, and delete student information. Student records are stored using Java Serialization, which allows data to be saved in a file and loaded again when the application starts.

This project helped me understand how data can be managed and stored without using a database.

---

## Features

* Add Student Record
* Display All Students
* Search Student by ID
* Search Student by Name
* Update Student Grade
* Update Student Subjects
* Delete Student Record
* Calculate Average Grade
* Save Records to File
* Load Records from File Automatically

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList Collection
* File Handling
* Serialization

---

## Project Structure

```text
Student Management System
│
├── model
│   └── Student.java
│
├── service
│   └── StudentManager.java
│
├── util
│   └── FileHandler.java
│
└── Main.java
```

---

# Task 2: Employee Management System

## Task Overview

The Employee Management System is a console-based Java application developed using JDBC and MySQL. It allows users to perform CRUD (Create, Read, Update, Delete) operations on employee records stored in a database.

This project helped me learn how Java applications communicate with databases and how real-world data management systems work.

---

## Features

* Add Employee
* View Employee Records
* Update Employee Salary
* Delete Employee Record
* Automatic Table Creation
* MySQL Database Integration
* JDBC Connectivity
* Menu-Driven Interface

---

## Technologies Used

* Java
* JDBC
* MySQL
* Maven
* SQL
* DAO Pattern

---

## Project Structure

```text
Employee Management System
│
├── model
│   └── Employee.java
│
├── dao
│   └── EmployeeDAO.java
│
├── util
│   └── DatabaseConnection.java
│
└── Main.java
```

---

## Database Setup

### Create Database

```sql
CREATE DATABASE IF NOT EXISTS employee_db;
```

### Create Table

```sql
USE employee_db;

CREATE TABLE IF NOT EXISTS employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE
);
```

---

# How to Run the Projects

## Student Management System

1. Open the project in IntelliJ IDEA.
2. Run the `Main.java` file.
3. Use the menu options to manage student records.
4. Student data will be stored in the `students.dat` file.

## Employee Management System

1. Make sure MySQL Server is installed and running.
2. Create the database using the SQL commands provided above.
3. Update the database username and password in `DatabaseConnection.java`.
4. Open the project in IntelliJ IDEA.
5. Run the `Main.java` file.
6. Use the menu options to manage employee records.

---

# Sample Menus

## Student Management System

```text
1. Add Student
2. Display All Students
3. Search Student
4. Update Student
5. Delete Student
6. Calculate Average Grade
7. Save Records
8. Exit
```

## Employee Management System

```text
1. Add Employee
2. View Employees
3. Update Employee Salary
4. Delete Employee
5. Exit
```

---

# Concepts Practiced

Through these projects, I practiced and improved my understanding of:

* Object-Oriented Programming (OOP)
* Classes and Objects
* Encapsulation
* Java Collections Framework
* File Handling
* Serialization
* JDBC Connectivity
* SQL Queries
* CRUD Operations
* MySQL Database Management
* DAO Design Pattern
* Exception Handling
* Maven Project Management

---

# Learning Outcome

These projects helped me understand two different approaches for storing and managing data.

In the Student Management System, data is stored in a file using Serialization. In the Employee Management System, data is stored in a MySQL database using JDBC.

Working on these projects improved my Java programming skills and gave me practical experience in building real-world applications.
