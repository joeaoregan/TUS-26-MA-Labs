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