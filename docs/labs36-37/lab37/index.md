# Lab#37 Authorization Code grant type flow

Step#1 Create a new client in KeyCloak

![Keycloak New Client](pic1.png)

    Figure 1. Keycloak New Client

![Create Client 2 Capability Config](pic2.png)

    Figure 2. Create Client 2 Capability Config

![Create Client 3 Login Settings](pic3.png)

    Figure 3. Create Client 3 Login Settings

![Credentials](pic4.png)

    Figure 4. Credentials

![Users](pic5.png)

    Figure 5. Users

![Create User](pic6.png)

    Figure 6. Create User

![Details](pic7.png)

    Figure 7. Details

![Credentials](pic8.png)

    Figure 8. Credentials.png

![Set Password](pic9.png)

    Figure 9. Set Password

![Users](pic10.png)

    Figure 10. Users

![Configure New Token](pic11.png)

    Figure 11. Configure New Token

![Configure New Token](pic12.png)

    Figure 12. Configure New Token
 
Close KeyCloak browser session or change your default browser to bing temporarily if you have issues. 

![Get New Access Token](pic13.png)

    Figure 13. Get New Access Token

Generate a new access token in Postman. You will be re-directed to KeyCloak to login. Enter the login details for the user that you created (not your Keycloak login).

![Keycloak Login](pic14.png)

    Figure 14. Keycloak Login

You will be re-directed back to Postman

![Postman Re-direct](pic15.png)

    Figure 15. Postman Re-direct

![Get New Access Token](pic16.png)

    Figure 16. Get New Access Token

![Use Token](pic17.png)

    Figure 17. Use Token

POST <localhost:8072/tusbank/accounts/api/accounts>

![Create New Account](pic18.png)

    Figure 18. Create New Account

![Status 201](pic19.png)

    Figure 19. Status 201 Account Created Successfully