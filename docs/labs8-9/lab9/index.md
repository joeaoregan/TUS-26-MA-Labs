# RESTful API Lab 9

## Lab#9 Cards MicroService

---

In this lab we will create a cards microservice, similar to the loans service.

![Project Layout](1.png)  
**Figure 1: Project Layout**  

Schema.sql, CardsConstants, ICardsService and CardsServiceImpl and CardsMapper files are given. Use port 9000 in the .yml file.


### Creating a Card

Now a mobile number create a card. The mobile number supplied must be 10 digits long. A card cannot already exist for the customer with given mobile number.

![Create a card - Success](2.png)  
**Fig. 2 Create a card - Success**  

![Create a card -  Card already exists for mobile no.](3.png)  
**Fig. 3 Create a card -  Card already exists for mobile no.**  

![Create a card- mobile number too short](4.png)  
**Fig. 4 Create a card- mobile number too short.**  

![Creating a card – code in CardsServiceImpl](5.png)  
**Fig. 5 Creating a card – code in CardsServiceImpl**  

The card is created using default values as shown and the number is generated as shown


### Fetch card details

![Fetching card details - success](6.png)  
**Fig. 6 Fetching card details - success**  

![Fetching card details - mobile number not 10 digits](7.png)  
**Fig. 7 Fetching card details - mobile number not 10 digits**  

![Fetching card – no card for given mobile number](8.png)  
**Fig. 8 Fetching card – no card for given mobile number**  


### Update Card details

![Updating card – card details updated successfully](9.png)  
**Fig. 9 Updating card – card details updated successfully**  

![Fetch updated values – card details updated](10.png)  
**Fig. 10 Fetch updated values – card details updated**  

![Updating loan – validation errors in data](11.png)  
**Fig. 11 Updating loan – validation errors in data**  

See CardsDto for error example

![Handling errors in CardsDto](12.png)  
**Fig. 12 Handling errors in CardsDto**  

![Update card](13.png)  
**Fig. 13 Update card - Mobile number not 10 digits**  

![Update card](14.png)  
**Fig. 14 Update card – Card number not found**  


### DELETE Mapping

![Deleting a card](15.png)  
**Fig. 15 Deleting a card**  

![Deleting a loan](16.png)  
**Fig. 16 Deleting a loan – mobile number too short**  

![Deleting a card](17.png)  
**Fig. 17 Deleting a card – card with mobile number not found**  