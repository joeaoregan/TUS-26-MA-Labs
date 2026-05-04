# Lab#29 Circuit Breaker Pattern

In this lab we will implement the circuit breaker pattern in the gateway and in the accounts microservice.

Step#1 In the pom of the gateway server add the following dependency
 
Step#2 Now in the Main class of the gateway server and we can use the inbuilt circuit breaker filter. It accepts some lambda configurations. Update the application.yml to include some configuration for the crcuit breaker.

Step#3 Now start the config server, the eureka server, and accounts microservice, followed by the gateway server. Check the eureka dashboard.

Step#4 Open the actuator endpoint for the gateway to see all the endpoints.

Open the “circuitbreaker” url and you will see that circuitBreakers is empty. circuitBreaker imformation will be populated here when testing the accounts microservice.

Step#5 To test the circuitbreaker we will use the info endpoint already implemented in the accounts microservice.
 After calling the “contact-info” API, refresh the “circuitbreaker” endpoint in the gateway. You will see that the circuit breaker information has been populated.

We can also look at the circuit breaker events.
 
If you call the contact-info end-point another two times you will see that the circuit breaker events are updated with the new events.

Step#6 To activate the circuitbreaker pattern, add a breakpoint in the AccountController so that the response will not be returned to the gateway.
 
Call the contact-info endpoint and you will get a timeout.

Circuit breaker is still CLOSED because only one of four calls has failed.

Refresh the “contact-info” multiple times. At some point you will see the status change from 504 to 503.

Now check the circuit breaker information and you will see that the status is open.

And the event data shows that the failure rate was exceeded.

Then we have a state transition from ‘CLOSED_TO_OPEN’ and further requests are not permitted which means that the gateway will not send the requests.

Step#7 After at least 10 seconds, invoke the “contact-info” end point again. The error code has changed to 504 again and there is a transition ‘OPEN_TO_HALF_OPEN’
 
 
Step#8 Remove the breakpoint in the code. Invoke the endpoint.
 
 
You should also get a “HALF_OPEN_TO_CLOSED” transition and state of circuit breaker will be closed.
 
