# Accounts API

URL:

```java
http://localhost:8080/api/account
```

### Fetch

!!! note "GET ?mobileNumber=086-123456"
    Fetch the customer details by phone number

    **Response**: 200 OK
    ```json
    {
        "accountsDto": {
            "accountNumber": 1624831019,
            "accountType": "Savings",
            "branchAddress": "123 Main Street, New York"
        },
        "email": "joe@gmail.com",
        "mobileNumber": "086-123456",
        "name": "Joe Bloggs"
    }
    ```

    **Response**: 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/account",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Customer not found with the given input data mobileNumber : '086-123457'",
        "errortime": "2026-04-02T19:51:51.4683013"
    }
    ```

### Create

!!! success "POST"
    Create a new customer passing name, email, and mobileNumber
    
    **Request**:
    ```json
    {
        "name": "Joe Bloggs",
        "email": "joe@gmail.com",
        "mobileNumber": "086-123456"
    }
    ```
    **Response**: 201 (Account Created)
    ```json
    {
        "statusCode": "201",
        "statusMsg": "Account created successfully"
    }
    ```
    **Response**: 400 (Customer Exists)
    ```json
    {
        "apiPath": "uri=/api/account",
        "errorCode": "400 BAD_REQUEST",
        "errorMessage": "Customer already registerd with given mobile Number 086-123456",
        "errortime": "2026-04-02T19:02:29.2406524"
    }
    ```

### Update

!!! warning "PUT /account"
    Update the customer details

    **Request**:    
    ```json
    {
        "name": "Joe Bloggs",
        "email": "joe@gmail.com",
        "mobileNumber": "086-123456",
        "accountsDto": {
            "accountNumber": 1148418689,
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
        "apiPath": "uri=/api/account",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Account not found with the given input data AccountNumber : '179823808'",
        "errortime": "2026-04-02T20:42:36.6743506"
    }
    ```

### Delete

!!! danger "DELETE /account?mobileNumber=086-123456"
    Delete customer by mobileNumber

    **Response**: 200 OK
    ```json
    {
        "statusCode": "200",
        "statusMsg": "Request processed successfully"
    }
    ```    
    **Response** 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/account",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Customer not found with the given input data mobileNumber : '086-123457'",
        "errortime": "2026-04-02T20:59:58.8186726"
    }
    ```


### Input Validation

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

#### GET

!!! note "GET localhost:8080/api/account?mobileNumber=123456789"
    Fetch phone number with invalid length (must be 10 digits)

    **Response**: 500 Internal Server Error
    ```json
    {
        "apiPath": "uri=/api/account",
        "errorCode": "500 INTERNAL_SERVER_ERROR",
        "errorMessage": "fetchAccountDetails.mobileNumber: Mobile number must be 10 digits",
        "errortime": "2026-04-02T22:44:20.8069826"
    }
    ```