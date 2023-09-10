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
- Login as admin (user: admin, pass: admin) or user (user: user, pass: user)
- Add, edit and delete teams
- View team details and assign players

## Technologies

- Java 19
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven



# Documentatie

## Enunt problema

Aplicatia permite inregistrarea si gestionarea echipelor de fotbal. Utilizatorii se pot inregistra si conecta, iar administratorii pot adauga, edita si sterge echipe. Fiecare echipa are nume, liga, stadion, data infiintarii, detalii si lista de jucatori.


## Observatii rezolvare

- Structura initiala continea doar functionalitatile de baza pentru utilizatori si echipe
- Am adaugat campuri relevante pentru echipe: liga, stadion, data infiintarii, detalii
- Utilizatorii pot vedea detaliile unei echipe si o pot modifica daca au drepturi de admin
- Detaliile echipei permit adaugarea de informatii extinse (palmares, galerie, etc)

## Entitatea Team

- are campuri pentru nume, liga, stadion, data infiintarii, detalii
- detaliile echipei stocheaza informatii extinse despre echipa
- poate avea o lista de jucatori alocati

## Entitatea Player

- are rol de utilizator sau admin

## Entitatea Jucator

- se poate aloca unei echipe

## Alte observatii

- Autentificarea se bazeaza pe username si parola criptata
- Rolurile utilizatorilor sunt gestionate cu ajutorul enumului PlayerRole
- Echipele pot fi cautate dupa nume folosind query parameters