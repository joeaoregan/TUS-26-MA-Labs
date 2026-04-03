# Accounts API

URL:

```java
http://localhost:8080/api/accounts
```

### Health Check

!!! note "GET /sayHello"
    Test GET API request with Accounts Controller

    ```java
    http://localhost:8080/api/accounts/sayHello
    ```

### Create An Account

!!! success "POST"
    Create a new customer passing name, email, and mobileNumber
    
    **Request**:
    ```json
    {
        "name": "Joe Bloggs",
        "email": "joe@gmail.com",
        "mobileNumber": "1234567890"    
    }
    ```
    **Response**: 201  Created
    ```json
    {
        "statusCode": "201",
        "statusMsg": "Account created successfully"
    }
    ```
    Customer already exists with mobile number entered
    **Response**: 400 Bad Request
    ```json
    {
        "apiPath": "uri=/api/accounts",
        "errorCode": "400 BAD_REQUEST",
        "errorMessage": "Customer already registered with given mobile Number 1234567890",
        "errortime": "2026-04-03T04:49:02.273399"
    }
    ```

### Fetch Customer Account Details

!!! note "GET ?mobileNumber=1234567890"
    Fetch the customer details by phone number

    **Response**: 200 OK
    ```json
    {
        "accountsDto": {
            "accountNumber": 1571624916,
            "accountType": "Savings",
            "branchAddress": "123 Main Street, New York"
        },
        "email": "joe@gmail.com",
        "mobileNumber": "1234567890",
        "name": "Joe Bloggs"
    }
    ```

    **Response**: 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/accounts",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Customer not found with the given input data mobileNumber : '1234567895'",
        "errortime": "2026-04-03T04:50:42.5324041"
    }
    ```

### Update Account Details

!!! warning "PUT /account"
    Update the customer details, change address

    **Request**:    
    ```json
    {
        "name": "Joe Bloggs",
        "email": "joe@gmail.com",
        "mobileNumber": "1234567890",
        "accountsDto": {
            "accountNumber": 1571624916,
            "accountType": "Savings",
            "branchAddress": "123 Main Street, Athlone"
        }
    }
    ```

    **Response**: 200 OK
    ```json
    {
        "statusCode": "200",
        "statusMsg": "Request processed successfully"
    }
    ```    
    **Response**: 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/accounts",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Account not found with the given input data AccountNumber : '179823808'",
        "errortime": "2026-04-03T04:53:37.6310334"
    }
    ```

### Fetch Updated Accont Details

!!! note "GET ?mobileNumber=1234567890"
    Fetch the updated account details

    **Response**: 200 OK
    ```json
    {
        "accountsDto": {
            "accountNumber": 1571624916,
            "accountType": "Savings",
            "branchAddress": "123 Main Street, Athlone"
        },
        "email": "joe@gmail.com",
        "mobileNumber": "1234567890",
        "name": "Joe Bloggs"
    }
    ```

### Delete Account

!!! danger "DELETE /account?mobileNumber=1234567890"
    Delete customer by mobileNumber

    **Response**: 200 OK
    ```json
    {
        "statusCode": "200",
        "statusMsg": "Request processed successfully"
    }
    ```
    Account doesn't exist or already deleted

    **Response** 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/accounts",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Customer not found with the given input data mobileNumber : '1234567890'",
        "errortime": "2026-04-03T04:55:27.8700202"
    }
    ```


### Input Validation

#### AccountsDto

Input validation handled in AccountsDto

```java
@Data
public class AccountsDto {
	@NotEmpty(message = "AccountNumber cannot be null or empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
	private Long accountNumber;

	@NotEmpty(message = "AccountType cannot be null or empty")
	private String accountType;

	@NotEmpty(message = "BranchAddress cannot be null or empty")
	private String branchAddress;
}
```

#### GET

!!! note "GET localhost:8080/api/account?mobileNumber=123456789"
    Fetch phone number with invalid length (must be 10 digits)

    **Response**: 500 Internal Server Error
    ```json
    {
        "apiPath": "uri=/api/accounts",
        "errorCode": "500 INTERNAL_SERVER_ERROR",
        "errorMessage": "fetchAccountDetails.mobileNumber: Mobile number must be 10 digits",
        "errortime": "2026-04-03T04:57:45.7756952"
    }
    ```

!!! note "GET ?mobileNumber=0123456785"
    Fetch phone number, Customer Not Found  
    Mobile number does not exist in the database  

    **Response**: 404 Not Found  
    ```json
    {
        "apiPath": "uri=/api/accounts",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Customer not found with the given input data mobileNumber : '1234567895'",
        "errortime": "2026-04-03T04:58:26.3046525"
    }
    ```

#### PUT

!!! warning "PUT"
    Update input with invalid data

    **Request**:    
    ```json
    {
    "name": "Joe Bloggs",
    "email": "joe@gmail.com",
    "mobileNumber": "1234567890",
    "accountsDto": {
        "accountNumber": 102649817,
        "accountType": "",
        "branchAddress": ""
    }
}
    ```

    **Response**: 400 Bad Request
    ```json
    {
        "accountsDto.accountType": "AccountType cannot be null or empty",
        "accountsDto.branchAddress": "BranchAddress cannot be null or empty",
    }
    ```    
    
!!! warning "PUT"
    Update input phone number validation

    **Request**:    
    ```json
    {
        "name": "Joe Bloggs",
        "email": "joe@gmail.com",
        "mobileNumber": "12345678",
        "accountsDto": {
            "accountNumber": 1026498178,
            "accountType": "Savings",
            "branchAddress": "123 Main Street, New York"
        }
    }
    ```

    **Response**: 400 Bad Request
    ```json
    {
        "mobileNumber": "Mobile Number must be 10 digits"
    }
    ```

#### POST

!!! success "POST /account [400 Bad Request]"
    Create a new customer passing name, email, and mobileNumber that don't meet valiation requirements
    
    **Request**: (Bad Input)
    ```json
    {
        "name": "Joe",
        "email": "joegmail.com",
        "mobileNumber": "086-123456"    
    }
    ```
    **Response**: 400 Bad Request
    ```json
    {
        "mobileNumber": "Mobile number must be 10 digits",
        "name": "the length of the customer name should be between 5 and 30",
        "email": "Email adderess should be a valid value"
    }
    ```
    
#### Delete

!!! danger "DELETE ?mobileNumber=123456789"
    Delete account with invalid mobile number length

    **Response**: 500 Internal Server Error
    ```json
    {
        "apiPath": "uri=/api/accounts",
        "errorCode": "500 INTERNAL_SERVER_ERROR",
        "errorMessage": "deleteAccountDetails.mobileNumber: Mobile number must be 10 digits",
        "errortime": "2026-04-03T05:26:50.6977168"
    }
    ```

#### Delete

!!! danger "DELETE ?mobileNumber=1234567891"
    Delete account with mobile number not found

    **Response**: 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/accounts",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Customer not found with the given input data mobileNumber : '1234567891'",
        "errortime": "2026-04-03T05:27:31.5311777"
    }
    ```