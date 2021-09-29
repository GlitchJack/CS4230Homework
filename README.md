# CS4230Homework

Instructions for running project:

Install Eclipse IDE for Enterprise Java and Web Developers

Import this project

Use "Servers" tab to create a new Tomcat version 10 server
(You must have a Tomcat directory which you may need to set as your Tomcat Installation Directory during setup)

Add this new server (make sure under modules of the server you have '/' as the path)

Create Local MySQL Database

Set Environment variables on your tomcat server to match your database using the names found in DatabaseConnection.java

Run command: mvn clean install

Start Tomcat server from "Servers" tab

Open browser window and go to "localhost:{Tomcat Port #, likely 8080}"
(if you are unsure of which port, open Tomcat Server from "Servers" tab and look under Ports section)

