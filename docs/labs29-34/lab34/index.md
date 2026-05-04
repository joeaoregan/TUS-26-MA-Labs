# Lab#34 Redis rate limiter in the gateway and in accounts service.
Step#1 We will implement the redis rate limiter in the gateway. Add the dependency in the pom for the gateway.

Step#2 Then we need to add two beans to the GatewayserverApplication class. We create a KeyResolver base on the user in the request header and if no user found default to anonymous. The other beans creates a RedisRateLimiter witharguments defaultReplenishRate, defaultBurstCapacity and defaultRequestedTokens. With values 1,1,1 the user can make 1 request per second.

Step#3 Update the filters in the gateway for loans to add the redis rate limiter
 
Step#4 Start redis as a docker container.
 
Now gatewayserver needs the connection details for the redis server.
 
Restart the gateway server.
Step#5 See link on installing apache bench
https://dev.to/gabriellaamah/load-testing-for-api-with-apache-benchmark-on-windows-58oj
On windows download and unzip.

Step#6 Now update accounts microservice for the get java-version endpointwith a fallback.

And in the application.yml. This is one request for every 5 seconds. 

To avoid timeout in the circuit breaker I commented out the circuitbreaker in the gateway

Restart the accounts microservice and the gateway
