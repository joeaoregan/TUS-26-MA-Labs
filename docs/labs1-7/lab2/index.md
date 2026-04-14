# RESTful API Lab 2

## Lab#2 Configuring H2 DB and YAML application.properties

In this lab we will continue from the previous lab and configure the application to use an in-memory H2 database.

### 1. Rename application.properties as application.yml  and update with following properties (file provided)
 
```yaml title="application.yml" linenums="1"
server:
  port: 8080
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: sa
    password: ''
  h2:
    console:
      enabled: true
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto:update
    show-sql: true
```

### 2. Create a file called scheme.sql (provided) in the resources folder with the following data.
 
```sql title="scheme.sql" linenums="1"
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `accounts` (
  `customer_id` int NOT NULL,
   `account_number` int AUTO_INCREMENT  PRIMARY KEY,
  `account_type` varchar(100) NOT NULL,
  `branch_address` varchar(200) NOT NULL,
  `created_at` date NOT NULL,
   `created_by` varchar(20) NOT NULL,
   `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);
```

### 3. Restart the server. It will start on port 8080 based on yml file.
### 4. Go to the h2-console in the browser. You should see the two tables have bee created.
 
![H2 Console](4.png)

Now we will write Spring Data JPA entities & repositories to interact with DB tables

### 4. Create a new package for the entity classes as show below.
 
![New package](4b.png)

### 5. Add the classes BaseEntity, Accounts and Customers (given) and examine the code.
 
![Add Classes](5.png)

### 6. Now Add the Repository interfaces
 
![Repository Interfacese](6.png)

```java title="CustomerRepository.java" linenums="1"
package com.tus.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tus.accounts.entity.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByMobileNumber(String mobileNumber);
}
```

```java title="AccountsRepository.java" linenums="1"
package com.tus.accounts.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.tus.accounts.entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

	Optional<Accounts> findByCustomerId(Long customerId);

	@Transactional
	@Modifying
	void deleteByCustomerId(Long customerId);
}
```
 
We will use the Data Transfer Object pattern to transfer data – not the entity classes themselves.

### 7. Create a new package with class AccountsDto and CustomerDto. These classes uses Lombok (You may need to turn on annotations in your IDE or install a Lombok jar)
 
![DTOs](7.png) 

```java title="AccountsDto.java" linenums="1"
package com.tus.accounts.dto;
import lombok.Data;

@Data
public class AccountsDto {
	private Long accountNumber;	
	private String accountType;	
	private String branchAddress;
}
```

```java title="CustomerDto.java" linenums="1"
package com.tus.accounts.dto;
import lombok.Data;

@Data
public class CustomerDto {
	private String name;
	private String email;
	private String mobileNumber;
}
```
 
### 8. Also add a ResponseDto and an ErrorResponseDto class

```java title="ResponseDto" linenums="1"
package com.tus.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
	private String statusCode;
	private String statusMsg;
}
```

```java title="ErrorResponseDto" linenums="1"
package com.tus.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
	private String apiPath;
	private HttpStatus errorCode;
	private String errorMessage;
	private LocalDateTime errortime;
}
```
