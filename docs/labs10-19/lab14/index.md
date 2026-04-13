# Lab 14

## Lab#14 Activating Springboot Profiles
Springboot profiles are useful for different environments e.g dev, qa, prod. The profile can be selected at startup

Step# 1 To do this from IDE, Right-Click on AccountsApplication and select Run As > Run Configurations

`R.C > Run As > Run Configuration > Argurments Tab`

Add in the arguments tab `--spring.profiles.active=prod --build.version=1.1` and Run

![Run with Arguments](screenshot1.png)

    Figure 1. Pass arguments at run-time

Step #2 Test that the application has started with the production profile
 
```yaml title="application_prod.yml"
accounts:
  message: "Welcome to accounts related prod APIs"
  contactDetails:
    name: "John Bloggs - Prod Support"
    email: "john@tus.ie"
  onCallSupport:
    - (086) 555-1234
    - (087) 523-1345
```

![GET /contact-info](screenshot2.png)

    Figure 2. GET /contact-info

![Get /build-info](screenshot3.png)

    Figure 3. GET /build-info
 

Or using environment variables from IDE
 
**Note**: First clear the Arguments > Program arguments - these override Environment Variables

![Environment Variables](screenshot4.png)

    Figure 4. Environment Variables

![GET /build-info](screenshot5.png)

    Figure 5. GET /build-info

Now implement similar changes in the loans and cards microservice

 
 
