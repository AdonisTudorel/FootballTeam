# README

This application allows managing football teams and players.

## Installation

```bash
# Install Java 19
sudo apt install openjdk-19-jdk

# Install PostgreSQL
sudo apt install postgresql postgresql-contrib

# Start PostgreSQL
sudo service postgresql start

# Create football_teams database
sudo -u postgres createdb football_teams

# Compile the project
mvn clean install

# Run the application
java -jar target/footballteam.jar
```

The application will start on [http://localhost:8080 ↗](http://localhost:8080)

## Usage

- Register a new user account
- Login as admin (user: test, pass: test)
- Add, edit and delete teams
- View team details and assign players

## Technologies

- Java 19
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven