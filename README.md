# Library Management System

A Java console application for managing books, users, and lending activity. The project uses object-oriented design and Java collections to keep track of records during runtime.

## Features

- Add books with an ID, title, and author
- Register library users
- Issue books to registered users
- Return issued books
- View books, users, and issued-book records
- Manage in-memory data with `ArrayList` and `HashMap`

## Requirements

- Java Development Kit (JDK)

## Build and Run

If the source file is named `LibraryManagementSystem.java`:

```bash
javac LibraryManagementSystem.java
java LibraryManagementSystem
```

The application is a runtime-only console system; the current implementation does not provide persistent storage.

## Project Structure

```text
LibraryManagementSystem.java   # Main Java source
README.md                       # Project documentation
LICENSE                         # License information
```

## Concepts Demonstrated

- Classes and objects
- Encapsulation
- Java collections
- Console input with `Scanner`
- Menu-driven application design