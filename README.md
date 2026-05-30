# Library Management System

## Overview

The Library Management System is a Java-based console application that allows librarians to manage books, patrons, and lending operations through an interactive menu-driven interface.

The application follows a layered architecture consisting of:

* Model Layer
* Repository Layer
* Service Layer
* Strategy Pattern for Search Operations

All data is stored in memory using Java Collections Framework and managed dynamically through user input.

---

# Implemented Features

## Book Management

Users can perform the following operations:

* Add new books
* View all books
* Remove books using ISBN
* Search books by:

  * Title
  * Author
  * ISBN

### Book Attributes

Each book contains:

* Title
* Author
* ISBN
* Publication Year
* Availability Status

---

## Patron Management

Users can:

* Register new patrons
* View patron information
* Track borrowed books
* Maintain borrowing history

### Patron Attributes

Each patron contains:

* Patron ID
* Name
* Borrowed Books
* Borrowing History

---

## Lending Management

The system supports:

* Book checkout
* Book return
* Loan tracking
* Inventory updates

When a book is checked out:

* Book availability is set to false
* Loan record is created
* Patron borrowing history is updated

When a book is returned:

* Book availability is restored
* Loan return date is updated

---

# Dynamic Console Menu

The application provides an interactive menu:

===== LIBRARY MANAGEMENT SYSTEM =====

1. Add Book
2. View All Books
3. Search Book By Title
4. Search Book By Author
5. Search Book By ISBN
6. Remove Book
7. Add Patron
8. Checkout Book
9. Return Book
10. View Patron Borrowed Books
11. Exit

All operations are performed through user input using Scanner.

---

# Application Flow

User Input
    ↓
Main.java
    ↓
Service Layer
    ↓
Repository Layer
    ↓
Java Collections (ArrayList)

---

# Search Functionality (Strategy Pattern)

The system uses the Strategy Design Pattern to support different search mechanisms.

### Search Strategies

* SearchByTitle
* SearchByAuthor
* SearchByISBN

### Flow

User Search Request
        ↓
BookService
        ↓
Selected Search Strategy
        ↓
Matching Books Returned

This allows new search strategies to be added without modifying existing code.

---

# Architecture

## Model Layer

Contains domain objects:

* Book
* Patron
* Loan

---

## Repository Layer

Responsible for managing in-memory data storage.

* BookRepository
* PatronRepository
* LoanRepository

Repositories use Java Collections such as ArrayList.

---

## Service Layer

Contains business logic.

* BookService
* PatronService
* LendingService

Responsibilities include:

* Validation
* Checkout operations
* Return operations
* Search coordination
* Inventory management

---

# Design Patterns Used

## Strategy Pattern

Used for dynamic search functionality.

Implementations:

* SearchByTitle
* SearchByAuthor
* SearchByISBN

Benefits:

* Open for extension
* Easy to add new search algorithms
* Reduces conditional logic

---

## Repository Pattern

Used to separate data access logic from business logic.

Benefits:

* Improved maintainability
* Better separation of concerns
* Easier future database integration

---

## Service Layer Pattern

Used to encapsulate business logic.

Benefits:

* Cleaner architecture
* Better scalability
* Improved code organization

---

# OOP Principles Applied

## Encapsulation

Private fields with controlled access through getters and setters.

## Abstraction

Services hide implementation details from the user interface.

## Polymorphism

Search strategies implement a common interface.

## Inheritance

Can be extended in future versions for specialized book or patron types.

---

# SOLID Principles Applied

### Single Responsibility Principle

Each class has a single responsibility.

### Open/Closed Principle

Search strategies can be extended without modifying existing code.

### Liskov Substitution Principle

All search implementations can replace SearchStrategy.

### Interface Segregation Principle

Search functionality is exposed through a focused interface.

### Dependency Inversion Principle

Services depend on abstractions rather than concrete implementations.

---

# Current Project Structure

LibraryManagementSystem/
│
├── src/
│   ├── model/
│   │   ├── Book.java
│   │   ├── Patron.java
│   │   └── Loan.java
│   │
│   ├── repository/
│   │   ├── BookRepository.java
│   │   ├── PatronRepository.java
│   │   └── LoanRepository.java
│   │
│   ├── service/
│   │   ├── BookService.java
│   │   ├── PatronService.java
│   │   └── LendingService.java
│   │
│   ├── strategy/
│   │   ├── SearchStrategy.java
│   │   ├── SearchByTitle.java
│   │   ├── SearchByAuthor.java
│   │   └── SearchByISBN.java
│   │
│   ├── util/
│   │   └── LoggerUtil.java
│   │
│   └── Main.java
│
├── README.md
└── .gitignore

---

# How to Compile

Windows PowerShell:

```powershell
javac -d out src/Main.java src/model/*.java src/repository/*.java src/service/*.java src/strategy/*.java src/util/*.java
```

---

# How to Run

```powershell
java -cp out Main
```

---

# Future Enhancements

* Update Book Details
* Reservation System
* Multi-Branch Support
* Recommendation Engine
* Persistent Storage (Database/File System)
* Graphical User Interface (JavaFX/Swing)
* REST API Integration

---

# Author

Sathya Devi P

---

# License

This project is intended for educational purposes.
