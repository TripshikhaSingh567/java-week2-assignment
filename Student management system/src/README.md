# Student Management System

## Project Overview

The Student Management System is a console-based Java application developed to manage student records efficiently. The project demonstrates the use of Object-Oriented Programming (OOP), Collections Framework, File Handling, and user input management in Java.

The application allows users to perform various operations such as adding, searching, updating, deleting, and viewing student records. Student data is stored using serialization, ensuring that records remain available even after the application is closed and reopened.

---

## Features

* Add new student records
* Display all student records in a formatted table
* Search students by ID
* Search students by name
* Update student grades
* Update student subjects
* Delete student records with confirmation
* Calculate and display class average grade
* Prevent duplicate student IDs
* Save student records to a file using serialization
* Automatically load saved records when the application starts

---

## Technologies Used

* Java 11+
* Object-Oriented Programming (OOP)
* Collections Framework (`ArrayList`)
* File Handling
* Serialization (`ObjectInputStream`, `ObjectOutputStream`)
* Exception Handling
* IntelliJ IDEA / Eclipse

---

## Project Structure

```text
src
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

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Make sure JDK 11 or higher is configured.
3. Locate `Main.java`.
4. Run the `main()` method.
5. Use the console menu to interact with the application.

### Using Command Prompt

Compile:

```bash
javac Main.java
```

Run:

```bash
java Main
```

---

## Sample Menu

```text
===== STUDENT MANAGEMENT SYSTEM =====

1. Add Student
2. Display All Students
3. Search Student
4. Update Student
5. Delete Student
6. Calculate Average Grade
7. Save Records
8. Exit

Enter your choice:
```

---

## Sample Student Record

```text
ID: 101
Name: Riya
Age: 20
Grade: 85.50
Subjects: [JAVA, DSA, DBMS]
```

---

## Key Concepts Demonstrated

* Encapsulation
* Object-Oriented Design
* Collections Framework
* CRUD Operations
* File Persistence
* Exception Handling
* Java Serialization
* Menu-Driven Console Applications

---

## Future Enhancements

* Input validation using custom methods
* Sorting students by grade
* Display top-performing student
* Database integration using JDBC and MySQL
* Graphical User Interface (GUI) using JavaFX or Swing

---

