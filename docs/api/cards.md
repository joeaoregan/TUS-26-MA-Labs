# Cards API

URL:

```java
http://localhost:9000/api/cards
```

### Health Check

!!! note "GET /sayHello"
    Test GET API request with Cards Controller

    ```java
    http://localhost:9000/api/cards/sayHello
    ```

### Create A Card

!!! success "POST ?mobileNumber=0123456789"
    Create a new card passing a mobileNumber
    
    Response: 201 Created:
    ```json
    {
        "statusCode": "201",
        "statusMsg": "Card created successfully"
    }
    ```
    Card already exists:  

    **Response**: 400 Bad Request  
    ```json
    {
        "apiPath": "uri=/api/cards",
        "errorCode": "BAD_REQUEST",
        "errorMessage": "Card already registered with given mobileNumber 0123456789",
        "errortime": "2026-04-03T04:12:44.7246787"
    }
    ```

### Fetch Card Details

!!! note "GET ?mobileNumber=0123456789"
    Fetch the card details by phone number

    **Response**: 200 OK
    ```json
    {
        "mobileNumber": "0123456789",
        "cardNumber": "100673938652",
        "cardType": "Credit Card",
        "totalLimit": 100000,
        "amountUsed": 0,
        "availableAmount": 100000
    }
    ```

    Mobile number does not exist in the the database:  

    **Response**: 404 Not Found  
    ```json
   {
        "apiPath": "uri=/api/cards",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Card not found with the given input data mobileNumber : '0123456784'",
        "errortime": "2026-04-03T04:15:00.0569723"
    }
    ```

### Update Card Details

!!! warning "PUT"
    Update the customer details

    Request:    
    ```json
    {
        "mobileNumber": "0123456789",
        "cardNumber": "100701198058",
        "cardType": "Debit Card",
        "totalLimit": 100000,
        "amountUsed": 20000,
        "availableAmount": 80000
    }
    ```

    **Response**: 200 OK
    ```json
    {
        "statusCode": "200",
        "statusMsg": "Request processed successfully"
    }
    ```    
    Card number does not exist in the the database:  

    **Response**: 404 Not Found  
    ```json
    {
        "apiPath": "uri=/api/cards",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Card not found with the given input data CardNumber : '100701198051'",
        "errortime": "2026-04-03T04:21:48.0029487"
    }
    ```

### Fetch Updated Card Details

!!! note "GET ?mobileNumber=0123456789"
    Fetch the updated card details

    **Response**: 200 OK
    ```json
    {
        "mobileNumber": "0123456789",
        "cardNumber": "100701198058",
        "cardType": "Debit Card",
        "totalLimit": 100000,
        "amountUsed": 20000,
        "availableAmount": 80000
    }
    ```

### Delete Card

!!! danger "DELETE ?mobileNumber=0123456789"
    Delete card by mobileNumber

    **Response**: 200 OK
    ```json
    {
        "statusCode": "200",
        "statusMsg": "Request processed successfully"
    }
    ```
    Card doesn't exist or already deleted

    **Response** 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/cards",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Card not found with the given input data mobileNumber : '0123456789'",
        "errortime": "2026-04-03T04:28:22.1951599"
    }
    ```
    
### Input Validation

#### CardsDto

Input validation handled in CardsDto

```java
@Data
public class CardsDto {
	@NotEmpty(message = "MobileNumber cannot be null or empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
	private String mobileNumber;

	@NotEmpty(message = "Card Number cannot be null or empty")
	@Pattern(regexp = "(^$|[0-9]{12})", message = "CardNumber must be 12 digits")
	private String cardNumber;

	@NotEmpty(message = "Card Type cannot be null or empty")
	private String cardType;

	@Positive(message = "Total card limit amount should be greater than zero")
	private Integer totalLimit;

	@PositiveOrZero(message = "Total card amount used should be equal or greater than zero")
	private Integer amountUsed;

	@PositiveOrZero(message = "Total available amount should be equal or greater than zero")
	private Integer availableAmount;
}

```

#### GET

!!! note "GET ?mobileNumber=123456789"
    Fetch phone number with invalid length (must be 10 digits)

    Response: 500 Internal Server Error
    ```json
    {
        "apiPath": "uri=/api/cards",
        "errorCode": "INTERNAL_SERVER_ERROR",
        "errorMessage": "fetchAccountDetails.mobileNumber: Mobile number must be 10 digits",
        "errortime": "2026-04-03T04:17:31.9604032"
    }
    ```

!!! note "GET ?mobileNumber=0123456785"
    Fetch phone number, Card Not Found  
    Mobile number does not exist in the database  

    **Response**: 404 Not Found  
    ```json
    {
        "apiPath": "uri=/api/cards",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Card not found with the given input data mobileNumber : '0123456785'",
        "errortime": "2026-04-03T04:18:27.0718691"
    }
    ```

#### PUT

!!! warning "PUT"
    Update input negative amount validation

    **Request**:    
    ```json
    {
        "mobileNumber": "0123456789",
        "cardNumber": "10070119805",
        "cardType": "Debit Card",
        "totalLimit": -100000,
        "amountUsed": -20000,
        "availableAmount": -80000
    }
    ```

    **Response**: 400 Bad Request
    ```json
    {
        "totalLimit": "Total card limit amount should be greater than zero",
        "availableAmount": "Total available amount should be equal or greater than zero",
        "amountUsed": "Total card amount used should be equal or greater than zero",
        "cardNumber": "CardNumber must be 12 digits"
    }
    ```    
    
!!! warning "PUT"
    Update input phone number validation

    **Request**:    
    ```json
    {
        "mobileNumber": "012345678",
        "cardNumber": "100701198051",
        "cardType": "Debit Card",
        "totalLimit": 100000,
        "amountUsed": 20000,
        "availableAmount": 80000
    }
    ```

    **Response**: 400 Bad Request
    ```json
    {
        "mobileNumber": "Mobile Number must be 10 digits"
    }
    ```

#### Delete

!!! danger "DELETE ?mobileNumber=012345678"
    Delete card with invalid mobile number length

    **Response**: 500 Internal Server Error
    ```json
    {
        "apiPath": "uri=/api/cards",
        "errorCode": "INTERNAL_SERVER_ERROR",
        "errorMessage": "deleteAccountDetails.mobileNumber: Mobile number must be 10 digits",
        "errortime": "2026-04-03T04:28:49.5241082"
    }
    ```

#### Delete

!!! danger "DELETE ?mobileNumber=0123456781"
    Delete card with mobile number not found

    **Response**: 404 Not Found
    ```json
    {
        "apiPath": "uri=/api/cards",
        "errorCode": "NOT_FOUND",
        "errorMessage": "Card not found with the given input data mobileNumber : '0123456781'",
        "errortime": "2026-04-03T04:29:21.9620379"
    }
    ```