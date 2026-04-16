# RESTful API Lab 1


## Steps and Files

1. [Spring.io New Project](#1-springio-new-project)  
2. [Import Project](#2-import-project)  
3. [Rest Controller](#3-rest-controller)  
    - controller/AccountController.java  
4. [Test the application](#4-test-the-application)  

---

## Lab#1 Getting started with Springboot – Helloworld Example

### 1.	Spring.io New Project

Create a new project from Spring.io. Add the dependencies shown. Java 17 is required for Springboot 3.
 
![Spring Initializer](screenshot1.png)

    Figure 1. Spring Initializer

### 2.	Import Project

Generate and Import the Maven Project into your IDE.

### 3.	Rest Controller

Now Add a Restcontroller class to your project as shown below.

```java title="AccountController.java" linenums="1"
package com.tus.accounts.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AccountController {
    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello World";
    }
}
```

### 4.	Test the application.

`localhost:8080/sayHello`

![Test the application](screenshot2.png)