# API Endpoints

!!! note "GET /sayHello"
    Test GET API request with Account Controller

!!! success "POST /account"
    Create a new customer
    
    Request:
    ```json
    {
        "name": "Joe Bloggs",
        "email": "joe@gmail.com",
        "mobileNumber": "086-123456"
    }
    ```
    Response 201 (Account Created):
    ```json
    {
        "statusCode": "201",
        "statusMsg": "Account created successfully"
    }
    ```
    Response 400 (Customer Exists):
    ```json
    {
        "apiPath": "uri=/api/account",
        "errorCode": "400 BAD_REQUEST",
        "errorMessage": "Customer already registerd with given mobile Number 086-123456",
        "errortime": "2026-04-02T19:02:29.2406524"
    }
    ```

!!! note "GET /account?mobileNumber"
    Fetch the customer details by phone number

    Response 200 OK:
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

    Response 404 Not Found:
    ```json
    {
        "apiPath": "uri=/api/account",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Customer not found with the given input data mobileNumber : '086-123457'",
        "errortime": "2026-04-02T19:51:51.4683013"
    }
    ```

!!! warning "PUT /account"
    Update the customer details

    Request:    
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

    Response 200 OK:
    ```json
    {
        "statusCode": "200",
        "statusMsg": "Request processed successfully"
    }
    ```    
    Response 404 Not Found:
    ```json
    {
        "apiPath": "uri=/api/account",
        "errorCode": "404 NOT_FOUND",
        "errorMessage": "Account not found with the given input data AccountNumber : '179823808'",
        "errortime": "2026-04-02T20:42:36.6743506"
    }
    ```
