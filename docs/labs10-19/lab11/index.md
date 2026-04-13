# Lab 11

## Lab#11 Configuration with Environment interface
----

In this lab we will read configurations with Environment interface in the accounts microservice e.g. JAVA_HOME

Step #1 Add an Environment variable to AccountController class

```java title="AccountController.java"  linenums="21"
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
@Validated
public class AccountController {


	private IAccountsService iAccountsService;
	
	@Value("${build.version}")
	private String buildVersion;

    @Autowired
    private Environment environment;

    @Value
	public AccountController(IAccountsService iAccountsService) {
		this.iAccountsService = iAccountsService;
	}
```

Step #2 Build a REST API to read the property and return to user. In the AccountController

```java title="getJavaVersion()"
	@GetMapping("/java-version")
	public ResponseEntity<String> getJavaVersion() {
		return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("JAVA_HOME"));
	}
```

Step #2 Test using Postman

![Postman](screenshot.png)