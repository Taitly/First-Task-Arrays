# Array Processing

A Java 17 application for validating, parsing, and processing integer arrays from a text file.

## Features
- Input validation and parsing
- Min, max, sum, and average calculations
- Bubble sort and selection sort
- Console and file logging with Log4j2
- Unit tests with JUnit 5

## Requirements
- JDK 17 or newer
- Maven 3.9 or newer

## Run
Run these commands from the project root:

```bash
mvn clean test
mvn compile exec:java
```

Input data is read from `data/arrays.txt`. Invalid lines are skipped. Logs are written to the console and `logs/application.log`.
