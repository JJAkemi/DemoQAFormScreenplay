# Automated Testing Project

This project contains automated tests using Cucumber, Selenium, and Serenity BDD with the Java programming language.

## Requirements:

- Java JDK 17 or higher
- Maven
- IntelliJ IDE installed

## Execution Instructions:

1. Clone the repository to your local machine.

2. Open a terminal or command prompt and navigate to the project directory.

3. Run the following command to compile and execute the tests:
   mvn clean verify

4. After the tests are completed, a report will be generated in the folder `target/site/serenity`.

5.  Open the file `target/site/serenity/index.html` in your browser to view the Serenity report.

## Run all project features with Chrome:
```
mvn clean verify -Denvironment=chrome
```

## Run all project features with Firefox:
```
mvn clean verify -Denvironment=firefox
```

## Run all project features with Edge:
```
mvn clean verify -Denvironment=edge
```

### Validate Scenarios:
``````
mvn serenity:check-gherki
``````

### Run by specific Tag "@":
``````
mvn clean verify -Denvironment=chrome -Dcucumber.filter.tags=@OrdenarNombreZA
``````

### Run all features:
``````
mvn clean verify -Denvironment=chrome  -Dcucumber.features=src/test/resources/features/
``````

### Run specific Tag "@" from a Feature:

``````
mvn clean verify -Denvironment=chrome -Dcucumber.features=src/test/resources/features/ -Dcucumber.filter.tags=@Tags
``````  
