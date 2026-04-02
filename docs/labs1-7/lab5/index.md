# RESTful API Lab 5

## Lab#5 Implementing a READ API that fetches the details based on mobile number.

---

In this lab we are going to fetch the customer and account details based on the customers mobile number. We will find the customer object base on the mobile number. Then we will find the account based on the customer id. The account data is returned as part of the CustomerDto object. The case where a customer does not exist is handled with exceptions.

### 1.	First we need to add a check to see if customer already exists. Add the method findByCustomerId in AccountsRepository interface.

![Check Customer Already Exists](1.png)

### 2.	Add a new ResourceNotFoundException the com.tus.accounts.exception package.

![Resource Not Found Exception](2.png)

### 3.	Update GlobalLogicExceptionHandler to handle the exception and return an appropriate ErrorResponseDto.

![Handle Exception Return Response](3.png)

### 4.	Update the CustomerDto to add a new field to keep the account information. We could create a new Dto for the combined Customer and Account information but will leave like this for now.

![Update CustomerDto](4.png)

### 5.	Add a new method to the controller class for the read API.

![Read API](5.png)
 
### 6.	Implement the fetchAccount method by adding to the Service Interface and the implementation class. This uses Lambda expressions to throw the exception.

![interface fetchAccount method](6.png)

![fetchAccount implementatoin](6b.png)

### 7.	Test the Application. Add a customer and then fetch the details as shown. Then use a different phone number and check that the 404 response with appropriate error message is found. 

![Test customer found](7.png)

![Test customer not found](7b.png)