# Lab#30 Circuit Breaker With Fallback

In the previous lab, we implemented the circuit breaker but it had no fallback mechanism, so a runtime exception was thrown. Throwing exceptions to the client is not a valid approach. We need a fallback mechanism to send a message to the client.
Step#1 In the gateway application we need to create a controller class to handle the fallback.

Step#2 Integrate the fallback into the circuitbreaker pattern by modifying the GatewayserverApplication class. Restart the gateway.

Step#3 Call the contact-info endpoint.

Now add the breakpoint again in the AccountController class

Call the end point again and you will see the fallback was called.
