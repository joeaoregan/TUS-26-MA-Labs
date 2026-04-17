# Lab 22

## Steps and Files

1. [Eureka Server](#1-eureka-server)
2. [@EnableEurekaServer annotation](#2-enableeurekaserver-annotation)
    - EurekaserverApplication.java
3. [application.yml](#3-applicationyml)
    - application.yml
4. [eurekaserver.yml](#4-eurekaserveryml)
    - eurekaserver.yml
5. [Start Configserver and Eureka Server](#5-start-configserver-and-eureka-server)
6. [Eureka Dashboard](#6-eureka-dashboard)
7. [Register Microservices with Eureka](#7-register-microservices-with-eureka)
    - pom.xml
8. [Accounts application.yml](#8-accounts-applicationyml)
    - application.yml
9. [Eureka Dashboard, Accounts](#9-eureka-dashboard-accounts)
10. [Accounts Acuator/info endpoint](#10-accounts-acuatorinfo-endpoint)
11. [Eureka Dashboard, Loans and Cards](#11-eureka-dashboard-loans-and-cards)

---

## Lab#22 Service discovery with Eureka

Spring Cloud Netflix’s Eureka service which will act as a service discovery agent
In this lab we will setup a Eureka server and register the microservices with Eureka.

### Server Side

#### 1. Eureka Server

Step#1 Create a new project using spring initializer. The dependencies that we need are the Eureka Server, the Config Client and the Spring Boot Actuator

![Eureka Server Spring Initializer](screenshot1.png)

    Figure 1. Eureka Server Spring Initializer

#### 2. @EnableEurekaServer annotation

Step#2 Open the EurekaserverApplication class and add the @EnableEurekaServer annotation.

```java title="EurekaserverApplication.java EnableEurekaServer Annotation" linenums="1"
package com.tus.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
	}
}
```

#### 3. application.yml

Step#3 Rename the application.properties to application.yml and update as follows:

```yaml title="application.yml" linenums="1"
spring:
  application:
    name: "eurekaserver"
  config:
    import: "optional:configserver:http://localhost:8071" # Lab 22
management:
  endpoints:
    web:
      exposure:
        include: "*" # Lab 19
  health:
    readinessState:
      enabled: true # Lab 22
    livenessState:
      enabled: true # Lab 22
  endpoint:
    health:
      probes:
        enabled: true # Lab 22
```

#### 4. eurekaserver.yml

Step#4 In the bitbucket/github repo add a eurekaserver.yml file. The eureka server only needs one profile.

```yaml title="eurekaserver.yml" linenums="1"
server:
  port: 8070

eureka:
  instance:
    hostname: localhost
  client:
    fetch-registry: false
    registerWithEureka: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

#### 5. Start Configserver and Eureka Server
 
Step#5 Start the configserver first, followed by the eureka server. Check that the properties are read correctly.

```bash title="Start Configserver and Eureka Server and test Accounts prod properties"
localhost:8071/accounts/prod
```

![Read accounts/prod properties](screenshot2.png)

    Figure 2. Read accounts/prod properties

```bash title="Start Configserver and Eureka Server and test Eureka Server default properties"
localhost:8071/eurekaserver/default
```

![Read eurekaserver/default properties](screenshot3.png)

    Figure 3. Read eurekaserver/default properties
 
#### 6. Eureka Dashboard
 
Step#6 Go to the eureka dashboard. No services currently registered with eureka

![Eureka Dashboard](screenshot4.png)

    Figure 4. Eureka Dashboard

---

### Client Side

#### 7. Register Microservices with Eureka
 
Step#7 Now we will update the microservices to register themselves with eureka. First of all we have to add a dependency to the pom files for the accounts microservice.

```xml title="Accounts pom.xml Eureka Client Dependency" linenums="40"
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
```

#### 8. Accounts application.yml

Step#8 Make the following changes to the application.yml for the accounts microservice.

```yaml title="application.yml" linenums="22"
  config:
   import: "configserver:http://localhost:8071/" # config server port 8071
  cloud:
    compatibility-verifier:
      enabled: false # disable version check
management:
  endpoints:
    web:
      exposure:
        # include: "*" # Lab 19
        include: info, shutdown # lab 22
  endpoint:
    shutdown:
      enabled: true
    info:
      env:
        enabled: true
        
eureka:
  instance:
    preferIpAddress: true
  client:
    fetchRegistry: true
    registerWithEureka: true
    serviceUrl:
      defaultZone: http://localhost:8070/eureka
      
info:
  app:
    name: "accounts"
    description: "Bank Accounts Application"
    version: "1.0.0"
```

#### 9. Eureka Dashboard, Accounts
 
Step#9 Restart the accounts microservice and check in the eureka dashboard that one instance of the accounts microservice has registered.

![Eureka Dashboard, Accounts Registered](screenshot5.png)

    Figure 5. Eureka Dashboard, Accounts Registered

#### 10. Accounts Acuator/info endpoint

Step#10 check on the accounts instance and the actuator/info endpoint should show the data for the microservice.

```bash title="Access Accounts Port with Eureka Address and /actuator/info endpoint" linenums="1"
192.168.56.1:8081/actuator/info
```

![actuator/info endpoint](screenshot6.png)

    Figure 6. actuator/info endpoint

#### 11. Eureka Dashboard, Loans and Cards

Step#11 Make similar changes in the loans and cards microservices. Restart them and check eureka dashboard.
 
![Eureka Dashboard, Loans and Cards Registered](screenshot7.png)

    Figure 7. Eureka Dashboard, Loans and Cards Registered