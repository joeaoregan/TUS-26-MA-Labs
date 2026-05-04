# Lab#26 Building a Gateway with Spring Cloud.

In this lab we will create a Gateway Server.

Step#1 Use Spring Initializer to create a project with dependencies as shown

Step#2 Update the application.yml (from application.properties)

Step#3 Start the services in the following order: config, eureka, accounts/loans/cards and finally the gateway. Check Eureka.  

Step#4 Check the endpoints using actuator and routes

Step#5 Send request to the accounts application via the Gateway. Note the service name is in uppercase letters. Even though the name is lowercase in the application.yml. 
