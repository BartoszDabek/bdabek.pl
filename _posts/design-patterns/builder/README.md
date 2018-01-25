
# MyCalories


## Prerequisites

  - [Node.js](https://nodejs.org/en/download/)
  - [Angular CLI](https://cli.angular.io/)
  - Database (By default it using PostgreSQL)
  - Maven

## Configurations

Before you run application you need to configure database and liquibase properties. Properties are located in 
`./src/main/resources/application.properties` 
`./src/main/resources/liquibase/liquibase.properties`
<br>
> Default settings
```
driver=org.postgresql.Driver
url=jdbc:postgresql://localhost:5432/MyCalories
username=postgres
password=admin
```

## Build and Run
You have two options:
1. Run only server
run with your IDE: `CalorieeCApplication.java` located in `.src/main/java/pl/mycalories`
2. Run server with TextGUI
run with your IDE: `Main.java` located in `.text_interface/src/pl/mycalories`
or run with maven: `mvn spring-boot:run`

> By default server will be running on port 8080.

## Development
- Go to `./frontend` folder  
1. `npm install`
2. `npm start` or `ng serve` to start front-end server for development.
> By default server will be running on port 4200.

