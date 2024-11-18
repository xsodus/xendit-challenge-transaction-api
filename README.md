# Transaction Processor API

This repository contains the Transaction Processor API built with Spring Boot.

## Prerequisites

- Java 17
- Maven 3.9.9
- H2 Database (in-memory)

## Running the Application

1. **Clone the repository:**

    ```sh
    git clone git@github.com:xsodus/xendit-challenge-transaction-api.git
    cd xendit-challenge-transaction-api
    ```

2. **Build the project:**

    ```sh
    ./mvnw clean install
    ```

3. **Run the application:**

    ```sh
    ./mvnw spring-boot:run
    ```

    The application will start on [`http://localhost:8080`](http://localhost:8080).
    
    NOTES: Change the main command to `mvnw.cmd` if you run on Windows machine. 

## Opening the Project with IntelliJ

To open the project with IntelliJ IDEA, follow these steps:

1. **Open IntelliJ IDEA:**
    Launch IntelliJ IDEA on your machine.

2. **Import the project:**
    - Click on `File` > `New` > `Project from Existing Sources...`.
    - Navigate to the directory where you cloned the repository (`xendit-challenge-transaction-api`).
    - Select the `pom.xml` file and click `Open`.

3. **Import Maven dependencies:**
    IntelliJ IDEA will automatically detect the Maven project and import all the dependencies. If not, you can manually trigger the import by clicking on the `Maven` tool window and then clicking the `Refresh` button.

4. **Run the application:**
    - Open the `TransactionProcessorApiApplication` class.
    - Right-click on the class and select `Run 'TransactionProcessorApiApplication'`.

The application should start, and you can access it at [`http://localhost:8080`](http://localhost:8080).

## Accessing Swagger UI

Swagger UI is available to test the API endpoints.

1. **Open Swagger UI:**

    Navigate to [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html) in your web browser.

2. **Create an Account:**

    Before calling the `/api/payments` endpoint, you need to create an account using the `/accounts` endpoint.

    - **Method:** POST
    - **Endpoint:** `/accounts/{accountId}`

    Click on the "Try it out" button, enter the request body, and click "Execute" to create the account.

3. **Check Account Balance:**

    You can check the balance of an account using the `/accounts/{accountId}` endpoint.

    - **Method:** GET
    - **Endpoint:** `/accounts/{accountId}`

    Replace `{accountId}` with the actual account ID (e.g., 123).

4. **Check Transaction History:**

    You can check the transaction history of an account using the `/accounts/{accountId}/transactions` endpoint.

    - **Method:** GET
    - **Endpoint:** `/accounts/{accountId}/transactions`

    Replace `{accountId}` with the actual account ID (e.g., 123).

5. **Test the `/api/payments` endpoint:**

    - **Method:** POST
    - **Endpoint:** `/api/payments`
    - **Request Body:**

    ```json
    {
      "accountId": 123,
      "amount": 102.21,
      "currency": "USD",
      "creditCardDetail": {
        "number": "4111111111111111",
        "expirationMonth": "12",
        "expirationYear": "2031"
      },
      "billingDetail": {
        "firstName": "John",
        "lastName": "Doe",
        "address1": "1 Market St",
        "locality": "san francisco",
        "administrativeArea": "CA",
        "postalCode": "94105",
        "country": "US",
        "email": "test@cybs.com",
        "phoneNumber": "4158880000"
      }
    }
    ```

    Click on the "Try it out" button, enter the request body, and click "Execute" to test the endpoint.

## Authorizing and Capturing Payments with CyberSource SDK

### Authorizing a Payment

To authorize a payment, the `processPayment` method in the `PaymentController` is used. This method validates the payment details and calls the `authorizeTransaction` method in the `TransactionService`.

We implement payment authorization based on Simple Authorization (Internet) and call the `/pts/v2/payments` endpoint from the CyberSource SDK to authorize the payment.

### Capturing a Payment

To capture a payment, the `settleTransaction` method in the `TransactionService` is used. This method captures the authorized payment by calling the `/pts/v2/payments/{id}/captures` endpoint from the CyberSource SDK.

For more details on the CyberSource API, you can refer to the [CyberSource API Reference](https://developer.cybersource.com/api-reference-assets/index.html#payments).

## Running Tests

### Integration Tests for `PaymentController`

To implement integration tests for the `PaymentController` class:

1. **Setup the test environment:**
    - Use `@SpringBootTest` to load the full application context.
    - Use `RestAssured` to test the controller endpoints.

2. **Write test cases:**
    - Test the `/api/payments` endpoint with valid and invalid request bodies.
    - Verify the response status and content using `RestAssured`.

3. **Reason for using `RestAssured.given()`:**
    - The runtime exceptions are handled by `RestExceptionHandler`. If you use Mockito, the test will fail due to the runtime exceptions. Using `RestAssured.given()` allows you to test the actual HTTP requests and responses, ensuring that exceptions are properly handled.

4. **Example test case:**
    - Use `RestAssured.given()` to set up the request.
    - Use `when().post("/api/payments")` to send the request.
    - Use `then().statusCode(200)` to verify the response status.

### Unit Tests for `TransactionService`

To implement unit tests for the `TransactionService` class:

1. **Setup the test environment:**
    - Use `@InjectMocks` to inject the `TransactionService` instance.
    - Use `@Mock` to mock dependencies like `TransactionRepository`, `AccountRepository`, and CyberSource SDK clients.

2. **Write test cases:**
    - Test the `authorizeTransaction` method with various scenarios (e.g., successful authorization, API exceptions).
    - Test the `settleTransaction` method with different transaction statuses and retry logic.

3. **Verify interactions:**
    - Use `Mockito.verify` to ensure that the correct methods are called on the mocked dependencies.

To run the tests, execute the following command:

```sh
./mvnw test
```

This will run all the unit tests and integration tests in the project.

## Running Tests via IntelliJ IDEA

To run the test classes via IntelliJ IDEA, follow these steps:

1. **Open IntelliJ IDEA:**
    Launch IntelliJ IDEA on your machine and open the `xendit-challenge-transaction-api` project.

2. **Navigate to the test class:**
    In the Project tool window, navigate to the `src/test/java` directory and locate the test class you want to run (e.g., `PaymentControllerTest` or `TransactionServiceTest`).

3. **Run the test class:**
    - Right-click on the test class file.
    - Select `Run 'PaymentControllerTest'` or `Run 'TransactionServiceTest'` from the context menu.

4. **Run individual test methods:**
    - Open the test class file.
    - Locate the test method you want to run.
    - Right-click on the test method name.
    - Select `Run 'testMethodName'` from the context menu.

5. **View test results:**
    The test results will be displayed in the Run tool window at the bottom of the IntelliJ IDEA interface. You can view the status of each test, including any errors or failures.

By following these steps, you can easily run and debug your test classes and methods directly within IntelliJ IDEA.

## CyberSource SDK

The CyberSource SDK is used to interact with the CyberSource payment gateway. You can find the CyberSource SDK on GitHub:

- [CyberSource SDK for Java](https://github.com/CyberSource/cybersource-rest-client-java)

To include the CyberSource SDK in your project, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.cybersource</groupId>
    <artifactId>cybersource-rest-client-java</artifactId>
    <version>0.0.31</version>
</dependency>
```

## Additional Information

- **Configuration:** The application configuration is located in [`src/main/resources/application.yml`](src/main/resources/application.yml ).
- **Logging:** Logs are configured to be written to the console and can be adjusted in the [`src/main/resources/application.yml`](src/main/resources/application.yml ) file.

