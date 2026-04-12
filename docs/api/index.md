# API Endpoints

## Health Check

!!! note "GET /sayHello"
    Test GET API request with Account Controller

    ```java
    http://localhost:8081/api/accounts/sayHello
        
    http://localhost:8090/api/loans/sayHello
    
    http://localhost:9000/api/cards/sayHello
    ```

## Accounts URL

**Note**: Moved `api/accounts` to top level path, so required for health check, build-info, etc.

```java
http://localhost:8081/api/accounts
```

```java title="Use @Value annotation to display Build Information from application.yml (Lab 10)"
http://localhost:8081/api/accounts/build-info
```

## Loans URL

```java
http://localhost:8090/api/loans
```

## Cards URL

```java
http://localhost:9000/api/cards
```