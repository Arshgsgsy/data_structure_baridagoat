# Course Registration System

A console-based university course registration system written in Java.

## Features

- **Admin login** — create, edit, and delete courses; view course details and registered students.
- **Student login** — register for courses, withdraw, and view enrolled courses.
- Courses are loaded from `MyUniversityCourses.csv` on first run.
- Application state (courses and students) is persisted between runs via Java serialization (`courses.ser`, `students.ser`).

## Run

```bash
javac *.java
java Main
```
