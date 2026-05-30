# Library Management System

## Overview

The Library Management System is a Java-based console application that allows librarians to manage books, patrons, and lending operations through an interactive menu-driven interface.

The system follows a layered architecture and demonstrates the application of Object-Oriented Programming (OOP), SOLID principles, and Design Patterns.

All data is currently stored in memory using Java Collections Framework and managed dynamically through user input.

---

# Features

## Book Management

The system allows users to:

* Add new books
* View all books
* Update existing book details
* Remove books using ISBN
* Search books by:

  * Title
  * Author
  * ISBN

### Book Attributes

Each book contains:

* Title
* Author
* ISBN (Unique Identifier)
* Publication Year
* Availability Status

### Validation

* Duplicate ISBNs are not allowed.
* ISBN is used as the primary identifier for book operations.

---

## Patron Management

The system allows users to:

* Register new patrons
* Update patron information
* View patron borrowed books
* View patron borrowing history

### Patron Attributes

Each patron contains:

* Patron ID
* Name
* Borrowed Books
* Borrowing History

### Validation

* Duplicate Patron IDs are not allowed.

---

## Lending Management

The system supports:

* Book checkout
* Book return
* Loan tracking
* Inventory updates

### Checkout Process

When a book is checked out:

* Book availability is changed to Borrowed
* Patron borrowed-books list is updated
* Patron borrowing history is updated
* Loan record is created

### Return Process

When a book is returned:

* Book availability is changed to Available
* Patron borrowed-books list is updated
* Loan return date is recorded

---

## Inventory Management

The system automatically maintains inventory status and supports:

* View all books
* View available books
* View borrowed books

Book availability is automatically updated during checkout and return operations.

---

# Console Menu

```text
===== LIBRARY MANAGEMENT SYSTEM =====

1. Add Book
2. View All Books
3. Update Books
4. Remove Book

5. Search Book By Title
6. Search Book By Author
7. Search Book By ISBN

8. Add Patron
9. Update Patron

10. Checkout Book
11. Return Book

12. View Patron Borrowed Books
13. View Borrowing History

14. View Available Books
15. View Borrowed Books

16. Exit
```

---

# Application Flow

```text
User Input
    ↓
Main.java
    ↓
Service Layer
    ↓
Repository Layer
    ↓
Java Collections (ArrayList)
```

---

# Search Functionality (Strategy Pattern)

The application uses the Strategy Design Pattern to perform different types of book searches.

## Search Strategies Implemented

* SearchByTitle
* SearchByAuthor
* SearchByISBN

### Search Flow

```text
User Search Request
        ↓
BookService
        ↓
Selected Search Strategy
        ↓
Matching Books Returned
```

This design allows new search strategies to be added without modifying existing business logic.

---

# Table-Based Output

Books are displayed in a formatted table using the TablePrinter utility.

Example:

```text
TITLE                          AUTHOR                    ISBN            YEAR     STATUS
------------------------------------------------------------------------------------------
Clean Code                     Robert C. Martin          ISBN101         2008     Available
Effective Java                 Joshua Bloch             ISBN102         2018     Borrowed
```

This improves readability and provides a consistent console experience.

---

# Architecture

## Model Layer

Contains domain objects:

* Book
* Patron
* Loan

### Responsibilities

Book

* Stores book information
* Maintains availability status

Patron

* Stores patron information
* Tracks borrowed books
* Maintains borrowing history

Loan

* Stores lending transactions
* Tracks issue and return dates

---

## Repository Layer

Responsible for managing in-memory data storage.

### Components

* BookRepository
* PatronRepository
* LoanRepository

### Responsibilities

BookRepository

* Add books
* Remove books
* Update books
* Find books by ISBN

PatronRepository

* Add patrons
* Find patrons by ID
* Update patron information

LoanRepository

* Store loan records
* Retrieve lending information

---

## Service Layer

Contains business logic.

### Components

* BookService
* PatronService
* LendingService

### Responsibilities

* Validation
* Search coordination
* Checkout operations
* Return operations
* Borrowing history management
* Inventory management

---

# Design Patterns Used

## Strategy Pattern

Used for dynamic search functionality.

### Implementations

* SearchByTitle
* SearchByAuthor
* SearchByISBN

### Benefits

* Open for extension
* Reduces conditional logic
* Easy to add future search algorithms

---

## Repository Pattern

Used to separate data access logic from business logic.

### Benefits

* Better separation of concerns
* Easier maintenance
* Future database integration becomes simpler

---

## Service Layer Pattern

Used to encapsulate business rules and business operations.

### Benefits

* Cleaner architecture
* Improved scalability
* Better code organization

---

# OOP Concepts Applied

## Encapsulation

Class fields are private and accessed through getters and setters.

## Abstraction

Business logic is hidden behind service classes.

## Polymorphism

Search strategies implement a common SearchStrategy interface.

## Inheritance

The system design allows future extension through inheritance when specialized entities are required.

---

# SOLID Principles Applied

## Single Responsibility Principle (SRP)

Each class has one responsibility.

## Open/Closed Principle (OCP)

New search strategies can be added without modifying existing code.

## Liskov Substitution Principle (LSP)

All search implementations can replace SearchStrategy.

## Interface Segregation Principle (ISP)

Search functionality is exposed through a focused interface.

## Dependency Inversion Principle (DIP)

Business logic depends on abstractions rather than implementation details.

---

# Project Structure

```text
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
│   │   ├── LoggerUtil.java
│   │   └── TablePrinter.java
│   │
│   └── Main.java
│
├── README.md
└── .gitignore
```

---

# Compilation

```powershell
javac -d out src/Main.java src/model/*.java src/repository/*.java src/service/*.java src/strategy/*.java src/util/*.java
```

---

# Execution

```powershell
java -cp out Main
```
---

# Author

Sathya Devi P

---

# License

This project is intended for educational and learning purposes.
