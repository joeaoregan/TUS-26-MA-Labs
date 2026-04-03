# Loans API

URL:

```java
http://localhost:8090/api/loans
```

### Create A Loan

!!! success "POST ?mobileNumber=1234567890"
    Create a new loan passing name, email, and mobileNumber
    
    Request:
    ```json
    {
        "name": "Joe Bloggs",
        "email": "joe@gmail.com",
        "mobileNumber": "1234567890"    
    }
    ```
    Response: 201 Created:
    ```json
    {
        "statusCode": "201",
        "statusMsg": "Loan created successfully"
    }
    ```
    Loan already exists:  

    **Response**: 400 Bad Request  
    ```json
    {
        "apiPath": "uri=/api/loans",
        "errorCode": "BAD_REQUEST",
        "errorMessage": "Loan already registered with given mobileNumber 1234567890",
        "errortime": "2026-04-03T01:33:44.4108084"
    }
    ```

### Fetch Loan Details

!!! note "GET ?mobileNumber=1234567890"
    Fetch the loan details by phone number

    **Response**: 200 OK
    ```json
    {
        "mobileNumber": "1234567890",
        "loanNumber": "100347363839",
        "loanType": "Home Loan",
        "totalLoan": 100000,
        "amountPaid": 0,
        "outstandingAmount": 100000
    }
    ```

    Mobile number does not exist in the the database:  

    **Response**: 404 Not Found  
    ```json
    {
        "apiPath": "uri=/api/loans",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Loan not found with the given input data mobileNumber : '1234567899'",
        "errortime": "2026-04-03T01:32:08.959885"
    }
    ```

### Update Loan Details

!!! warning "PUT"
    Update the customer details

    Request:    
    ```json
    {
        "mobileNumber": "1234567890",
        "loanNumber": "100347363839",
        "loanType": "Car Loan",
        "totalLoan": 100000,
        "amountPaid": 2000,
        "outstandingAmount": 98000
    }
    ```

    **Response**: 200 OK
    ```json
    {
        "statusCode": "200",
        "statusMsg": "Request processed successfully"
    }
    ```    
    Loan number does not exist in the the database:  

    **Response**: 404 Not Found  
    ```json
    {
        "apiPath": "uri=/api/loans",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Loan not found with the given input data LoanNumber : '100008437212'",
        "errortime": "2026-04-03T02:27:31.6457924"
    }
    ```

### Fetch Updated Loan Details

!!! note "GET ?mobileNumber=1234567890"
    Fetch the updated loan details

    **Response**: 200 OK
    ```json
    {
        "mobileNumber": "1234567890",
        "loanNumber": "100347363839",
        "loanType": "Car Loan",
        "totalLoan": 100000,
        "amountPaid": 2000,
        "outstandingAmount": 98000
    }
    ```

### Delete Loan

!!! danger "DELETE ?mobileNumber=1234567890"
    Delete loan by mobileNumber

    **Response**: 200 OK
    ```json
    {
        "statusCode": "200",
        "statusMsg": "Request processed successfully"
    }
    ```
    Loan doesn't exist or already deleted
    **Response** 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/loans",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Loan not found with the given input data mobileNumber : '1234567890'",
        "errortime": "2026-04-03T02:41:46.0353513"
    }
    ```

### Input Validation

#### LoansDto

Input validation handled in LoansDto

```java
public class LoansDto {
	@NotEmpty(message = "MobileNumber cannot be null or empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
	private String mobileNumber;
	
	@NotEmpty(message = "LoanNumber cannot be null or empty")
	@Pattern(regexp = "(^$|[0-9]{12})", message = "LoanNumber must be 12 digits")
	private String loanNumber;

	@NotEmpty(message = "LaonType cannot be null or empty")
	private String loanType;

	@Positive(message = "Total loan amount should be greater than zero")
	private Integer totalLoan;

	@PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
	private Integer amountPaid;

	@PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
	private Integer outstandingAmount;
}
```

#### GET

!!! note "GET ?mobileNumber=123456789"
    Fetch phone number with invalid length (must be 10 digits)

    Response: 500 Internal Server Error
    ```json
    {
        "apiPath": "uri=/api/loans",
        "errorCode": "INTERNAL_SERVER_ERROR",
        "errorMessage": "fetchAccountDetails.mobileNumber: Mobile number must be 10 digits",
        "errortime": "2026-04-03T01:48:31.3337033"
    }
    ```

!!! note "GET ?mobileNumber=1234567895"
    Fetch phone number, Loan Not Found  
    Mobile number does not exist in the database  

    **Response**: 404 Not Found  
    ```json
    {
        "apiPath": "uri=/api/loans",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Loan not found with the given input data mobileNumber : '1234567895'",
        "errortime": "2026-04-03T01:50:32.548013"
    }
    ```

#### PUT

!!! warning "PUT"
    Update input negative amount validation

    **Request**:    
    ```json
    {
        "mobileNumber": "1234567890",
        "loanNumber": "10000843722",
        "loanType": "Home Loan",
        "totalLoan": -100000,
        "amountPaid": -2000,
        "outstandingAmount": -98000
    }
    ```

    **Response**: 200 OK
    ```json
    {
        "amountPaid": "Total loan amount paid should be equal or greater than zero",
        "outstandingAmount": "Total outstanding amount should be equal or greater than zero",
        "totalLoan": "Total loan amount should be greater than zero",
        "loanNumber": "LoanNumber must be 12 digits"
    }
    ```    
    
!!! warning "PUT"
    Update input phone number validation

    **Request**:    
    ```json
    {
        "mobileNumber": "123456790",
        "loanNumber": "100008437221",
        "loanType": "Home Loan",
        "totalLoan": 100000,
        "amountPaid": 2000,
        "outstandingAmount": 98000
    }
    ```

    **Response**: 200 OK
    ```json
    {
        "mobileNumber": "Mobile Number must be 10 digits"
    }
    ```

#### Delete

!!! danger "DELETE ?mobileNumber=12345678"
    Delete loan with invalid mobile number length

    **Response**: 500 Internal Server Error
    ```json
    {
        "apiPath": "uri=/api/loans",
        "errorCode": "INTERNAL_SERVER_ERROR",
        "errorMessage": "deleteAccountDetails.mobileNumber: Mobile number must be 10 digits",
        "errortime": "2026-04-03T02:43:04.2164548"
    }
    ```

#### Delete

!!! danger "DELETE ?mobileNumber=12345678"
    Delete loan with mobile number not found

    **Response**: 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/loans",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Loan not found with the given input data mobileNumber : '9876543210'",
        "errortime": "2026-04-03T02:46:17.1251248"
    }
    ```