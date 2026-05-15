# Lab#26 Building a Gateway with Spring Cloud.

In this lab we will create a Gateway Server.

Step#1 Use Spring Initializer to create a project with dependencies as shown

![Spring Initialiser](pic1.png)

    Figure 1. Spring Initialiser

![gatewayserver in package explorer](pic2.png)

    Figure 2. Gateway Server in Package Explorer

Step#2 Update the application.yml (from application.properties)

![application.yml](pic3.png)

    Figure 3. application.yml

Step#3 Start the services in the following order: config, eureka, accounts/loans/cards and finally the gateway. Check Eureka.

![Eureka dasboard](pic4.png)

    Figure 4. Eureka dashboard

Step#4 Check the endpoints using actuator and routes

![Check Endpoints with Actuator and routes](pic5.png)

    Figure 5. Check endpoints with Actuator and routes

![Gateway Routes](pic6.png)

    Figure 6. Gateway Routes

Step#5 Send request to the accounts application via the Gateway. Note the service name is in uppercase letters. Even though the name is lowercase in the application.yml. 

![Service name in Uppercase Letters](pic7.png)

    Figure 7. Service name in Uppercase Letters

![service name lowercase in application.yml](pic8.png)

    Figure 8. Service name lowercase in application.yml

![POST Account](pic9.png)

    Figure 9. POST Account

![GET Account](pic10.png)

    Figure 10. GET Account

![GET Loan](pic11.png)

    Figure 11. GET Loan