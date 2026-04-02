# RESTful API Lab 7

## Lab#7 Exceptions , Data Validations and Audit Columns

--- 

In this lab we will complete the RESTful API CRUD actions by adding the Update and Delete parts. 

### Part 1 GlobalExceptionHandler

Currently we are only handling two exceptions here. We add a new method that handles all types of exceptions. (e,g runtime expections). To test this exception, delete the @AllArgsConstructor from the AccountController class.With only the default constructor,autowiring will not happen and the the AccountsService will be null.

![Global Exception Handler](1_1.png)

![Remove @AllArgsConstructor Annotation to Test](1_2.png)

Test using the exception.

![Test Exception in Postman](1_3.png)

Put the @AllArgsConstructor back in.

### Part#2 Validating the input data

1.	We need to validate the data we are receiving from the user. Make sure the relevant dependency is in the pom.xml .

![Validate Data](2_1.png)

2.	Now go to the Dto classes – Customer Dto and add validations

![Customer DTO add validations](2_2.png)

3.	Similarly add validations in the AccountsDto

![Accounts DTO add Validations](2_3.png)

This data is received in the AccountController class. Add the @Validated annotation.

![@Validated Annotation](2_4.png)

Add the @Valid annotation for the PST and PUT mappings

![@Validated Annotation for POST](2_5.png)

![@Validated Annotation for PUT](2_6.png)

For the GET mapping we can validation the mobilenumber using the @Pattern
@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
And the same for the DELETE method

![GET @Pattern](2_7.png)

![DELETE @Pattern](2_8.png)

Now in the GlobalExceptionHandler we need to update the class so that is extends the ResponseEntityExceptionHandler and add a method handleMethodArgumentNotValid so that it knows how to return the error to the client.

![GlobalExceptionHandler extends ResponseEntityExceptionHandler](2_9.png)

Add the method handleMethodArgumentNotValid method. This will give process all validations. The map will hold all the validation errors that occurred in the input data.

![Import](2_10.png)

![handleMethodArgumentNotValid](2_11.png)

To test, go to Postman, remove @ from email, put mobile number as 9 or less digits and make name one character.

![Test email](2_12.png)

![Test ok](2_13.png)

Test the validation on the GET mapping

![Test mobile number](2_14.png)

### Part#3 Completing the audit metadata.

These metadata columns can be updated automatically by Spring Data JPA
The metadata columns are defined in the BaseEntity class. Add the annotations shown.

![BaseEntity Metadata](3_1.png)

To add the logic about the user, add a new package and class

![AudiAwareImpl](3_2.png)

![AudiAwareImpl](3_3.png)

Now in the BaseEntity, make sure the two annotations are there

![MappedSuperClass EntityListeners annotations](3_4.png)

Also in the main class AccountsApplication add the annotation to enable JpaAuditing.

![Enable JPA Auditing](3_5.png)

Now delete the code where we were manually creating the fields.

![Delete manually created fields](3_6.png)

![createNewAccount](3_7.png)

![Delete manually created fields](3_8.png)

![createAccount](3_9.png)

Go to Postman and test

![Test Postman](3_10.png)

![H2 Console](3_11.png)

![H2 Console](3_12.png)

Check the update mapping

First fetch the data

![Fetch account](3_13.png)

Now update a field e.g. Address

![PUT udpate address](3_14.png)
 
![Check in table](3_15.png)