package com.example.transactionprocessor.controller;
import com.example.transactionprocessor.runtime.util.FileReader;
import com.example.transactionprocessor.service.AccountService;

import io.restassured.RestAssured;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;


import static io.restassured.RestAssured.given;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;


// This controller test class should be a spring boot test with io.restassured
// Because the input error handling is done by RestExceptionHandler so the API can return a 400 response correctly
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class PaymentControllerTest {
    
    @Autowired
    private AccountService accountService;


    @Autowired
    private FileReader fileReader;

    private static final String PATH_PREFIX = "/api/payments";

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @Test
    public void testProcessPaymentSuccess()  {
        // Load request body from file
        var payload = fileReader.getRequest("Post_Process_Payment_Success_200_ok.json");
        var expectedResponse = fileReader.getResponse("Post_Process_Payment_Success_200_ok.json");

        accountService.createAccountById(123L);

        var response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(payload)
                .when()
                .post(PATH_PREFIX).then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract().asString();

        assertThatJson(response).isEqualTo(expectedResponse);
    }

    @Test
    public void testProcessPaymentInvalidCreditCardNumber() throws Exception {
        var payload = fileReader.getRequest("Post_Process_Payment_Invalid_CreditCardNumber.json");


        var response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(payload)
                .when()
                .post(PATH_PREFIX).then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .extract().asString();

        assertThatJson(response).node("message").isEqualTo("Invalid credit card number");
    }

    @Test
    public void testProcessPaymentInvalidExpirationMonth() throws Exception {
        var payload = fileReader.getRequest("Post_Process_Payment_Invalid_ExpirationMonth.json");


        var response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(payload)
                .when()
                .post(PATH_PREFIX).then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .extract().asString();

        assertThatJson(response).node("message").isEqualTo("Invalid expiration month");
    }

    @Test
    public void testProcessPaymentInvalidExpirationYear() throws Exception {
        var payload = fileReader.getRequest("Post_Process_Payment_Invalid_ExpirationYear.json");


        var response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(payload)
                .when()
                .post(PATH_PREFIX).then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .extract().asString();

        assertThatJson(response).node("message").isEqualTo("Invalid expiration year");
    }

    @Test
    public void testProcessPaymentInvalidEmail() throws Exception {
        var payload = fileReader.getRequest("Post_Process_Payment_Invalid_Email.json");

        var response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(payload)
                .when()
                .post(PATH_PREFIX).then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .extract().asString();

        assertThatJson(response).node("message").isEqualTo("Invalid email address");
    }

    @Test
    public void testProcessPaymentInvalidPostalCode() throws Exception {
        var payload = fileReader.getRequest("Post_Process_Payment_Invalid_PostalCode.json");

        var response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(payload)
                .when()
                .post(PATH_PREFIX).then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .extract().asString();

        assertThatJson(response).node("message").isEqualTo("Invalid postal code");
    }

    @Test
    public void testProcessPaymentAccountNotFound() throws Exception {
        var payload = fileReader.getRequest("Post_Process_Payment_AccountNotFound.json");

        var response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(payload)
                .when()
                .post(PATH_PREFIX).then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .extract().asString();

        assertThatJson(response).node("message").isEqualTo("Account not found");
    }
}