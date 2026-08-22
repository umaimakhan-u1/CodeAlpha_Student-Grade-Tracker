# Student Grade Tracker

## Overview

Student Grade Tracker is a Java Swing desktop application designed to make basic student grade management simple and organized. The application provides a clean graphical interface where users can add student names and grades, view records, remove individual students, clear all records, and instantly see grade statistics.

## Features

* Add student names and grades
* Validate grades between 0 and 100
* Display student records in a structured table
* Delete a selected student
* Clear all student records
* Automatically calculate:

  * Average grade
  * Highest grade
  * Lowest grade
* User-friendly error and confirmation messages
* Modern and responsive desktop interface

## Technologies Used

* **Java**
* **Java Swing**
* **JTable & DefaultTableModel**
* **ArrayList**
* **Object-Oriented Programming**
* **Event Handling**
* **Input Validation**

## Project Structure

```text
StudentGradeTracker
└── src
    └── studentgradetracker
        ├── Student.java
        └── StudentGradeTrackerGUI.java
```

`Student.java` represents individual student records and stores the student's name and grade.

`StudentGradeTrackerGUI.java` contains the main application window, user interface, table management, validation, and grade calculations.

## How It Works

The user enters a student's name and grade and clicks **Add Student**. The application validates the input before adding the record to the table. Once students are added, the summary section automatically updates the average, highest, and lowest grades.

Users can select a record and remove it with **Delete Selected**, or remove all records using **Clear All**. Confirmation and error dialogs help prevent accidental actions and invalid input.

## Purpose

This project was created as a practical Java GUI project to demonstrate how programming concepts can be combined to build a functional desktop application. It focuses on clean design, simple data management, validation, and real-time calculations.

## Future Improvements

Possible future enhancements include saving student records to a file or database, editing existing records, adding grade letters, generating reports, and adding search or sorting functionality.

Umaima Khan

Developed as a Java learning project focused on GUI development, object-oriented programming, and practical application design.
