# Lab#31 Circuit Breaker With Feign client
In this lab we implement the circuit breaker inside the accounts microservice. The accounts microservice uses Feign client to invoke cards and loans microservice.
If Spring Cloud CircuitBreaker is on the classpath and spring.cloud.openfeign.circuitbreaker.enabled=true, Feign will wrap all the methods with a circuit breaker.
Step#1 In the pom in the accounts microservice, add the dependency and change the version of spring-cloud.

Note: Changed in all services for compatibility reasons

And in application.yml

Add in the parameters for the circuit breaker in the application.yml for the accounts service.

Step#2 Implementing the fallbacks. Create a new class called LoansFallback in the accounts microservice

Step#3 Create a similar class called CardsFallback

Update the LoansFeignClient interface and the CardsFeignClient interface.

Add the if statements in the CustomersServiceImpl class.

Step#3 Start all the services, config, eureka, accounts, cards and loans followed by gateway.

Open the actuator of accounts microservice. First make sure that the actuator endpoints are enabled by checking the application.yml

Check the circuit breakers link. Right now there are no circuit breakers because we did not send any request yet.

Call the fetch customer details endpoint. Note: account, loan and card previously created for this mobile number.

Now refresh the actuator end point

And look at the circuit breaker events.

Step#4 To look at the negative situation, first stop the loans microservice from the springboot dashboard

Call the fetch customer details endpoint again

Try calling the endpoint a number of times and the circuit breaker will move to the open state.
