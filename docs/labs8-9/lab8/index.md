# RESTful API Lab 7

## Lab#8 Loans MicroService

---

In this lab we will create a loans microservice, similar to the accounts service.

![Project Layout](1.png)  
**Figure 1: Project Layout**  

Schema.sql, LoansConstants, ILoansService and LoansServiceImpl and LoansMapper files are given. Use port 8090 in the .yml file.

---

### Creating a Loan
First create a customer as before using the accounts microservice.

![Create a customer](2.png)   
**Fig. 2 Create a customer**  

Now using the same mobile number create a loan. The mobile number supplied must be 10 digits long. A loan cannot already exist for the customer with given mobile number.
 
![Create a loan - Mobile number too short](3.png)  
**Fig. 3 Create a loan - Mobile number too short**
 
![Create a loan -  Loan already exists for customer](4.png)  
**Fig. 4 Create a loan -  Loan already exists for customer**

![Loan created success](5.png)  
**Fig. 5 Loan created success.**

![Creating a loan – code in LoansServiceImpl](6.png)  
**Fig. 6 Creating a loan – code in LoansServiceImpl**

The loan is create using default values as shown and the number is generated as shown

---

### Fetch loan details

![Fetching loan details - success](7.png)  
**Fig. 7 Fetching loan details - success**

![Fetching loan - mobile number not 10 digits](8.png)  
**Fig. 8 Fetching loan - mobile number not 10 digits**

![Fetching loan – no loan for given mobile number](9.png)  
**Fig. 9 Fetching loan – no loan for given mobile number**

---

### Update Loan details

![Updating loan –loan details updated successfully](10.png)  
**Fig. 10 Updating loan –loan details updated successfully**

![Fetch updated values –loan details updated](11.png)  
**Fig. 11 Fetch updated values –loan details updated**

![Updating loan –validation errors in data](12.png)  
**Fig. 12 Updating loan –validation errors in data**

See LoansDto for error example

![Handling errors in LoansDto](13.png)  
**Fig. 13 Handling errors in LoansDto**

![Update loan - Mobile number not 10 digits](14.png)  
**Fig. 14 Update loan - Mobile number not 10 digits**

---

### DELETE Mapping

![Deleting a loan](15.png)  
**Fig. 15 Deleting a loan**

![Deleting a loan – mobile number too short](16.png)  
**Fig. 16 Deleting a loan – mobile number too short**

![Deleting a loan – loan with mobile number not found](17.png)  
**Fig. 17 Deleting a loan – loan with mobile number not found**