# Project for Harokopio University MSc. 
This Frontend application functions as the UI for a website that allows customers to manage their properties and register/ handle repairs or renovations regarding the said properties.

# Requirements

This application can function independently but will not show any UI because of Keycloak. In order to be functional, the application needs to connect with Keycloak (correctly configured as described below) and the Backend application found in the below URL. Also Kong is needed as an application gateway in oreder to hit the backend endpoints.

Backend URL: https://github.com/AntwnhsG/TechnikonProject-pms8

# Tools and Framework requirements

1) To run the application NODE JS must be installed. Version of NODE JS: 20.15.0
2) Keycloak needs to be installed or used from docker container.
3) Kong needs to be installed or userd from docker container.
   
# Setup

1) To setup this application, clone the repository from: https://github.com/AntwnhsG/Technikon_project_pms_frontEnd.git

2) Keycloak is needed as decribed above. A realm need to be created, from the Admin UI of keycloak, named FrontEndRealm. Then a client needs to be created named front-end-app.
   Create users and assign them roles. Important: the application expects 2 roles, one for user and one for admin. Any other role is not considered valid.

3) In Kong, CORS plugin needs to be created to accept this applications URL. Also the correct Kong service and routes need to be created as well. For service you can use your own host IP. But for routes if no changes are made to much yours, the ones that must be defined are:
   a) /
   b) /users
   b) /property
   d) /propertyRepair

5) From VScode (recommended), or any other IDE of your preference, in terminal run:
  a) command: npm i (to install any required packages/ libraries).
  b) command: npm start (to start the application).

# Note! 
Master repository is now configured to run with IPs used for this project. To use you own you must configure files Api.jsx (for Kong) and Keycloak.jsx
