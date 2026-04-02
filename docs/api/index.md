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
    Response:  
    ```json
    {
        "statusCode": "201",
        "statusMsg": "Account created successfully"
    }
    ```