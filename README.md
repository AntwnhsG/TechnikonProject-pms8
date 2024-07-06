# Project for Harokopio University MSc.

This is a backend application, created using Spring Boot, Java, Maven, to be used for a project of Harokopio University MSc program.
This application provides the means to handle/ service functionality to a frontend application (UI) regarding a website that is used for property management.
This backend application provides CRUD operations and database connection and queries, to store user/ property information. 

# Frameworks - Tools used for implementation

The source code is written in Java using Spring Boot for Dependency Injection, API end point configuration and connection to Database.
Also, there is a websocket implementation but currently it is not functional.
The design pattern is a typical web application architecture that contains controllers, services, repositories, resource classes (DTOs) etc.

# Requirements

To use this backend Java 17 must be installed in your system.
Also PostgreSQL needs to be install or used from docker container in order to connect to a database.
## Note that without a database connection this application will not run and the server will not be initialized.
There is an application.propertie.yml file which you can configure to much your PostgreSQL configuration and connection parameters.
Last, in the application properties file, for testing and development purposes the database is set to be re-created every time the server is run.
This was done in order to gain important time from avoiding to clear the database tables each time a mistake was made or some new functionality was intoduced.

# Setup

Clone the repository from here: https://github.com/AntwnhsG/TechnikonProject-pms8.git

The only thing needed to run this application is a connection to a PostgreSQL database and Java version 17. 
## Note in classes WebConfiguration you must change the CORS origin to much your frontend's URL. Also in PropertyController class you must change the mailhog host to much yours.

# Swagger

Swagger end point documentation can be found here: 

# Note!

Master branch source code is configured to run specificly for the puproses of this project. You need to configure the files mentions above including the application.properties.yml to much yours if you need to make changes.
