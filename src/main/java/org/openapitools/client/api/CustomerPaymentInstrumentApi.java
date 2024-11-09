package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetCustomer410Response;
import org.openapitools.client.model.PatchCustomer412Response;
import org.openapitools.client.model.PaymentInstrumentList;
import org.openapitools.client.model.PaymentInstrumentListEmbeddedPaymentInstrumentsInner;
import org.openapitools.client.model.PostCustomer400Response;
import org.openapitools.client.model.PostCustomer403Response;
import org.openapitools.client.model.PostCustomer409Response;
import org.openapitools.client.model.PostCustomer424Response;
import org.openapitools.client.model.PostCustomer500Response;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

//@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-11-09T19:17:21.826843+07:00[Asia/Bangkok]", comments = "Generator version: 7.9.0")
public class CustomerPaymentInstrumentApi {
    private ApiClient apiClient;

    public CustomerPaymentInstrumentApi() {
        this(new ApiClient());
    }

    @Autowired
    public CustomerPaymentInstrumentApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customers Payment Instrument**&lt;br&gt;Your system can use this API to delete an existing Payment Instrument for a Customer.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments.&lt;br&gt;If a customer has more than one Payment Instrument then the default Payment Instrument cannot be deleted without first selecting a [new default Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument_samplerequests-dropdown_make-customer-payment-instrument-the-default_liveconsole-tab-request-body). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteCustomerPaymentInstrumentRequestCreation(String customerId, String paymentInstrumentId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling deleteCustomerPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'paymentInstrumentId' is set
        if (paymentInstrumentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'paymentInstrumentId' when calling deleteCustomerPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);
        pathParams.put("paymentInstrumentId", paymentInstrumentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();


        if (profileId != null)
        headerParams.add("profile-id", apiClient.parameterToString(profileId));
        final String[] localVarAccepts = { 
            "application/json;charset=utf-8", "Invalid Customer request body", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/payment-instruments/{paymentInstrumentId}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customers Payment Instrument**&lt;br&gt;Your system can use this API to delete an existing Payment Instrument for a Customer.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments.&lt;br&gt;If a customer has more than one Payment Instrument then the default Payment Instrument cannot be deleted without first selecting a [new default Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument_samplerequests-dropdown_make-customer-payment-instrument-the-default_liveconsole-tab-request-body). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteCustomerPaymentInstrument(String customerId, String paymentInstrumentId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteCustomerPaymentInstrumentRequestCreation(customerId, paymentInstrumentId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customers Payment Instrument**&lt;br&gt;Your system can use this API to delete an existing Payment Instrument for a Customer.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments.&lt;br&gt;If a customer has more than one Payment Instrument then the default Payment Instrument cannot be deleted without first selecting a [new default Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument_samplerequests-dropdown_make-customer-payment-instrument-the-default_liveconsole-tab-request-body). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteCustomerPaymentInstrumentWithHttpInfo(String customerId, String paymentInstrumentId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteCustomerPaymentInstrumentRequestCreation(customerId, paymentInstrumentId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customers Payment Instrument**&lt;br&gt;Your system can use this API to delete an existing Payment Instrument for a Customer.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments.&lt;br&gt;If a customer has more than one Payment Instrument then the default Payment Instrument cannot be deleted without first selecting a [new default Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument_samplerequests-dropdown_make-customer-payment-instrument-the-default_liveconsole-tab-request-body). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteCustomerPaymentInstrumentWithResponseSpec(String customerId, String paymentInstrumentId, String profileId) throws WebClientResponseException {
        return deleteCustomerPaymentInstrumentRequestCreation(customerId, paymentInstrumentId, profileId);
    }
    /**
     * Retrieve a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Customer Payment Instrument**&lt;br&gt;Your system can use this API to retrieve an existing Payment Instrument for a Customer.&lt;br&gt;To perform a payment with a particular Payment Instrument simply specify the [Payment Instrument Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCustomerPaymentInstrumentRequestCreation(String customerId, String paymentInstrumentId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling getCustomerPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'paymentInstrumentId' is set
        if (paymentInstrumentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'paymentInstrumentId' when calling getCustomerPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);
        pathParams.put("paymentInstrumentId", paymentInstrumentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();


        if (profileId != null)
        headerParams.add("profile-id", apiClient.parameterToString(profileId));
        final String[] localVarAccepts = { 
            "application/json;charset=utf-8", "Invalid Customer request body", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/payment-instruments/{paymentInstrumentId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Customer Payment Instrument**&lt;br&gt;Your system can use this API to retrieve an existing Payment Instrument for a Customer.&lt;br&gt;To perform a payment with a particular Payment Instrument simply specify the [Payment Instrument Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> getCustomerPaymentInstrument(String customerId, String paymentInstrumentId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return getCustomerPaymentInstrumentRequestCreation(customerId, paymentInstrumentId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Customer Payment Instrument**&lt;br&gt;Your system can use this API to retrieve an existing Payment Instrument for a Customer.&lt;br&gt;To perform a payment with a particular Payment Instrument simply specify the [Payment Instrument Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;PaymentInstrumentListEmbeddedPaymentInstrumentsInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>> getCustomerPaymentInstrumentWithHttpInfo(String customerId, String paymentInstrumentId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return getCustomerPaymentInstrumentRequestCreation(customerId, paymentInstrumentId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Retrieve a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Customer Payment Instrument**&lt;br&gt;Your system can use this API to retrieve an existing Payment Instrument for a Customer.&lt;br&gt;To perform a payment with a particular Payment Instrument simply specify the [Payment Instrument Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getCustomerPaymentInstrumentWithResponseSpec(String customerId, String paymentInstrumentId, String profileId) throws WebClientResponseException {
        return getCustomerPaymentInstrumentRequestCreation(customerId, paymentInstrumentId, profileId);
    }
    /**
     * List Payment Instruments for a Customer
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Customer Payment Instruments**&lt;br&gt;Your system can use this API to retrieve all existing Payment Instruments for a Customer. 
     * <p><b>200</b> - Returns all existing Payment Instruments associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array. Default is 0.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset. Default is 20, maximum is 100.
     * @return PaymentInstrumentList
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCustomerPaymentInstrumentsListRequestCreation(String customerId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling getCustomerPaymentInstrumentsList", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        

        if (profileId != null)
        headerParams.add("profile-id", apiClient.parameterToString(profileId));
        final String[] localVarAccepts = { 
            "application/json;charset=utf-8", "Invalid Customer request body", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PaymentInstrumentList> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentList>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/payment-instruments", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Payment Instruments for a Customer
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Customer Payment Instruments**&lt;br&gt;Your system can use this API to retrieve all existing Payment Instruments for a Customer. 
     * <p><b>200</b> - Returns all existing Payment Instruments associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array. Default is 0.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset. Default is 20, maximum is 100.
     * @return PaymentInstrumentList
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstrumentList> getCustomerPaymentInstrumentsList(String customerId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentList> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentList>() {};
        return getCustomerPaymentInstrumentsListRequestCreation(customerId, profileId, offset, limit).bodyToMono(localVarReturnType);
    }

    /**
     * List Payment Instruments for a Customer
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Customer Payment Instruments**&lt;br&gt;Your system can use this API to retrieve all existing Payment Instruments for a Customer. 
     * <p><b>200</b> - Returns all existing Payment Instruments associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array. Default is 0.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset. Default is 20, maximum is 100.
     * @return ResponseEntity&lt;PaymentInstrumentList&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PaymentInstrumentList>> getCustomerPaymentInstrumentsListWithHttpInfo(String customerId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentList> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentList>() {};
        return getCustomerPaymentInstrumentsListRequestCreation(customerId, profileId, offset, limit).toEntity(localVarReturnType);
    }

    /**
     * List Payment Instruments for a Customer
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Customer Payment Instruments**&lt;br&gt;Your system can use this API to retrieve all existing Payment Instruments for a Customer. 
     * <p><b>200</b> - Returns all existing Payment Instruments associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array. Default is 0.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset. Default is 20, maximum is 100.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getCustomerPaymentInstrumentsListWithResponseSpec(String customerId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        return getCustomerPaymentInstrumentsListRequestCreation(customerId, profileId, offset, limit);
    }
    /**
     * Update a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customers Payment Instrument**&lt;br&gt;Your system can use this API to update an existing Payment Instrument for a Customer, including selecting a [default Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument_samplerequests-dropdown_make-customer-payment-instrument-the-default_liveconsole-tab-request-body) for use in payments. 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param patchCustomerPaymentInstrumentRequest The patchCustomerPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec patchCustomersPaymentInstrumentRequestCreation(String customerId, String paymentInstrumentId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner patchCustomerPaymentInstrumentRequest, String profileId, String ifMatch) throws WebClientResponseException {
        Object postBody = patchCustomerPaymentInstrumentRequest;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling patchCustomersPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'paymentInstrumentId' is set
        if (paymentInstrumentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'paymentInstrumentId' when calling patchCustomersPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'patchCustomerPaymentInstrumentRequest' is set
        if (patchCustomerPaymentInstrumentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'patchCustomerPaymentInstrumentRequest' when calling patchCustomersPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);
        pathParams.put("paymentInstrumentId", paymentInstrumentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();


        if (profileId != null)
        headerParams.add("profile-id", apiClient.parameterToString(profileId));
        if (ifMatch != null)
        headerParams.add("if-match", apiClient.parameterToString(ifMatch));
        final String[] localVarAccepts = { 
            "application/json;charset=utf-8", "Invalid Customer request body", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/payment-instruments/{paymentInstrumentId}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customers Payment Instrument**&lt;br&gt;Your system can use this API to update an existing Payment Instrument for a Customer, including selecting a [default Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument_samplerequests-dropdown_make-customer-payment-instrument-the-default_liveconsole-tab-request-body) for use in payments. 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param patchCustomerPaymentInstrumentRequest The patchCustomerPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> patchCustomersPaymentInstrument(String customerId, String paymentInstrumentId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner patchCustomerPaymentInstrumentRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return patchCustomersPaymentInstrumentRequestCreation(customerId, paymentInstrumentId, patchCustomerPaymentInstrumentRequest, profileId, ifMatch).bodyToMono(localVarReturnType);
    }

    /**
     * Update a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customers Payment Instrument**&lt;br&gt;Your system can use this API to update an existing Payment Instrument for a Customer, including selecting a [default Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument_samplerequests-dropdown_make-customer-payment-instrument-the-default_liveconsole-tab-request-body) for use in payments. 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param patchCustomerPaymentInstrumentRequest The patchCustomerPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseEntity&lt;PaymentInstrumentListEmbeddedPaymentInstrumentsInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>> patchCustomersPaymentInstrumentWithHttpInfo(String customerId, String paymentInstrumentId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner patchCustomerPaymentInstrumentRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return patchCustomersPaymentInstrumentRequestCreation(customerId, paymentInstrumentId, patchCustomerPaymentInstrumentRequest, profileId, ifMatch).toEntity(localVarReturnType);
    }

    /**
     * Update a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customers Payment Instrument**&lt;br&gt;Your system can use this API to update an existing Payment Instrument for a Customer, including selecting a [default Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument_samplerequests-dropdown_make-customer-payment-instrument-the-default_liveconsole-tab-request-body) for use in payments. 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param patchCustomerPaymentInstrumentRequest The patchCustomerPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec patchCustomersPaymentInstrumentWithResponseSpec(String customerId, String paymentInstrumentId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner patchCustomerPaymentInstrumentRequest, String profileId, String ifMatch) throws WebClientResponseException {
        return patchCustomersPaymentInstrumentRequestCreation(customerId, paymentInstrumentId, patchCustomerPaymentInstrumentRequest, profileId, ifMatch);
    }
    /**
     * Create a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;&lt;br&gt;**Creating a Customer Payment Instrument**&lt;br&gt;It is recommended you [create a Customer Payment Instrument via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers Payment Instrument**&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address specify the [Payment Instrument in the payment request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Payment Instrument has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param postCustomerPaymentInstrumentRequest The postCustomerPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postCustomerPaymentInstrumentRequestCreation(String customerId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner postCustomerPaymentInstrumentRequest, String profileId) throws WebClientResponseException {
        Object postBody = postCustomerPaymentInstrumentRequest;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling postCustomerPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'postCustomerPaymentInstrumentRequest' is set
        if (postCustomerPaymentInstrumentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'postCustomerPaymentInstrumentRequest' when calling postCustomerPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();


        if (profileId != null)
        headerParams.add("profile-id", apiClient.parameterToString(profileId));
        final String[] localVarAccepts = { 
            "application/json;charset=utf-8", "Invalid Customer request body", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/payment-instruments", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;&lt;br&gt;**Creating a Customer Payment Instrument**&lt;br&gt;It is recommended you [create a Customer Payment Instrument via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers Payment Instrument**&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address specify the [Payment Instrument in the payment request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Payment Instrument has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param postCustomerPaymentInstrumentRequest The postCustomerPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> postCustomerPaymentInstrument(String customerId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner postCustomerPaymentInstrumentRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return postCustomerPaymentInstrumentRequestCreation(customerId, postCustomerPaymentInstrumentRequest, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;&lt;br&gt;**Creating a Customer Payment Instrument**&lt;br&gt;It is recommended you [create a Customer Payment Instrument via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers Payment Instrument**&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address specify the [Payment Instrument in the payment request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Payment Instrument has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param postCustomerPaymentInstrumentRequest The postCustomerPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;PaymentInstrumentListEmbeddedPaymentInstrumentsInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>> postCustomerPaymentInstrumentWithHttpInfo(String customerId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner postCustomerPaymentInstrumentRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return postCustomerPaymentInstrumentRequestCreation(customerId, postCustomerPaymentInstrumentRequest, profileId).toEntity(localVarReturnType);
    }

    /**
     * Create a Customer Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Customer Payment Instrument**&lt;br&gt;A Customer Payment Instrument represents tokenized customer payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Payment Instruments](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument), with one allocated as the Customers default for use in payments.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;&lt;br&gt;**Creating a Customer Payment Instrument**&lt;br&gt;It is recommended you [create a Customer Payment Instrument via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers Payment Instrument**&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address specify the [Payment Instrument in the payment request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Payment Instrument has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param postCustomerPaymentInstrumentRequest The postCustomerPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postCustomerPaymentInstrumentWithResponseSpec(String customerId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner postCustomerPaymentInstrumentRequest, String profileId) throws WebClientResponseException {
        return postCustomerPaymentInstrumentRequestCreation(customerId, postCustomerPaymentInstrumentRequest, profileId);
    }
}
