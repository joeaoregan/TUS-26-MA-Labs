# Lab#28 Cross cutting concerns – tracing and logging

In this lab we will add custom filters in the gateway to generate a correlation id
Step#1 Create a new package with classes as shown (code given).

Step#2 Update the .yml file for the gateway with the logging information to allow all logger statements of type DEBUG to be logged.

Step#3 We need to make changes inside the individual microservices (accounts, loans, cards) because the gateway is going to send a new request header with the correlationid value which the services need to receive the request header that the gateway is going to forward with the request. We can use the customercontroller (fetchCustomerDetails) to show this since it in turn invokes the cards and loans.

Step#4 enable logging in the accounts, loans and cards

Restart all the services followed by restarting the gateway.

Clear the console for cars, accounts and loans as well as the gateway.

Invoke the fetchCustomerDetails request from the Gateway.
