package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetCustomer410Response;
import org.openapitools.client.model.PatchCustomer412Response;
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
public class PaymentInstrumentApi {
    private ApiClient apiClient;

    public PaymentInstrumentApi() {
        this(new ApiClient());
    }

    @Autowired
    public PaymentInstrumentApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Payment Instrument**&lt;br&gt;Your system can use this API to delete an existing Payment Instrument.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments. 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deletePaymentInstrumentRequestCreation(String paymentInstrumentId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'paymentInstrumentId' is set
        if (paymentInstrumentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'paymentInstrumentId' when calling deletePaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("paymentInstrumentId", paymentInstrumentId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();


        if (profileId != null)
        headerParams.add("profile-id", apiClient.parameterToString(profileId));
        final String[] localVarAccepts = { 
            "application/json;charset=utf-8", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/tms/v1/paymentinstruments/{paymentInstrumentId}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Payment Instrument**&lt;br&gt;Your system can use this API to delete an existing Payment Instrument.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments. 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deletePaymentInstrument(String paymentInstrumentId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deletePaymentInstrumentRequestCreation(paymentInstrumentId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Payment Instrument**&lt;br&gt;Your system can use this API to delete an existing Payment Instrument.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments. 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deletePaymentInstrumentWithHttpInfo(String paymentInstrumentId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deletePaymentInstrumentRequestCreation(paymentInstrumentId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Payment Instrument**&lt;br&gt;Your system can use this API to delete an existing Payment Instrument.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments. 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deletePaymentInstrumentWithResponseSpec(String paymentInstrumentId, String profileId) throws WebClientResponseException {
        return deletePaymentInstrumentRequestCreation(paymentInstrumentId, profileId);
    }
    /**
     * Retrieve a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Payment Instrument**&lt;br&gt;Your system can use this API to retrieve an existing Payment Instrument.&lt;br&gt;To perform a payment with a particular Payment Instrument simply specify the [Payment Instrument Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getPaymentInstrumentRequestCreation(String paymentInstrumentId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'paymentInstrumentId' is set
        if (paymentInstrumentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'paymentInstrumentId' when calling getPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

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
        return apiClient.invokeAPI("/tms/v1/paymentinstruments/{paymentInstrumentId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Payment Instrument**&lt;br&gt;Your system can use this API to retrieve an existing Payment Instrument.&lt;br&gt;To perform a payment with a particular Payment Instrument simply specify the [Payment Instrument Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> getPaymentInstrument(String paymentInstrumentId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return getPaymentInstrumentRequestCreation(paymentInstrumentId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Payment Instrument**&lt;br&gt;Your system can use this API to retrieve an existing Payment Instrument.&lt;br&gt;To perform a payment with a particular Payment Instrument simply specify the [Payment Instrument Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;PaymentInstrumentListEmbeddedPaymentInstrumentsInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>> getPaymentInstrumentWithHttpInfo(String paymentInstrumentId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return getPaymentInstrumentRequestCreation(paymentInstrumentId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Retrieve a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Payment Instrument**&lt;br&gt;Your system can use this API to retrieve an existing Payment Instrument.&lt;br&gt;To perform a payment with a particular Payment Instrument simply specify the [Payment Instrument Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getPaymentInstrumentWithResponseSpec(String paymentInstrumentId, String profileId) throws WebClientResponseException {
        return getPaymentInstrumentRequestCreation(paymentInstrumentId, profileId);
    }
    /**
     * Update a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Payment Instrument**&lt;br&gt;Your system can use this API to update an existing Payment Instrument. 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param patchPaymentInstrumentRequest The patchPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec patchPaymentInstrumentRequestCreation(String paymentInstrumentId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner patchPaymentInstrumentRequest, String profileId, String ifMatch) throws WebClientResponseException {
        Object postBody = patchPaymentInstrumentRequest;
        // verify the required parameter 'paymentInstrumentId' is set
        if (paymentInstrumentId == null) {
            throw new WebClientResponseException("Missing the required parameter 'paymentInstrumentId' when calling patchPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'patchPaymentInstrumentRequest' is set
        if (patchPaymentInstrumentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'patchPaymentInstrumentRequest' when calling patchPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

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
        return apiClient.invokeAPI("/tms/v1/paymentinstruments/{paymentInstrumentId}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Payment Instrument**&lt;br&gt;Your system can use this API to update an existing Payment Instrument. 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param patchPaymentInstrumentRequest The patchPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> patchPaymentInstrument(String paymentInstrumentId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner patchPaymentInstrumentRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return patchPaymentInstrumentRequestCreation(paymentInstrumentId, patchPaymentInstrumentRequest, profileId, ifMatch).bodyToMono(localVarReturnType);
    }

    /**
     * Update a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Payment Instrument**&lt;br&gt;Your system can use this API to update an existing Payment Instrument. 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param patchPaymentInstrumentRequest The patchPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseEntity&lt;PaymentInstrumentListEmbeddedPaymentInstrumentsInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>> patchPaymentInstrumentWithHttpInfo(String paymentInstrumentId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner patchPaymentInstrumentRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return patchPaymentInstrumentRequestCreation(paymentInstrumentId, patchPaymentInstrumentRequest, profileId, ifMatch).toEntity(localVarReturnType);
    }

    /**
     * Update a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Payment Instrument**&lt;br&gt;Your system can use this API to update an existing Payment Instrument. 
     * <p><b>200</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param paymentInstrumentId The Id of a payment instrument.
     * @param patchPaymentInstrumentRequest The patchPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec patchPaymentInstrumentWithResponseSpec(String paymentInstrumentId, PaymentInstrumentListEmbeddedPaymentInstrumentsInner patchPaymentInstrumentRequest, String profileId, String ifMatch) throws WebClientResponseException {
        return patchPaymentInstrumentRequestCreation(paymentInstrumentId, patchPaymentInstrumentRequest, profileId, ifMatch);
    }
    /**
     * Create a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**&lt;br&gt;&lt;br&gt;**Creating a Payment Instrument**&lt;br&gt;It is recommended you [create a Payment Instrument via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Payment Instruments**&lt;br&gt;To perform a payment with a particular Payment Instrument specify the [Payment Instrument in the payment request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postPaymentInstrumentRequest The postPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postPaymentInstrumentRequestCreation(PaymentInstrumentListEmbeddedPaymentInstrumentsInner postPaymentInstrumentRequest, String profileId) throws WebClientResponseException {
        Object postBody = postPaymentInstrumentRequest;
        // verify the required parameter 'postPaymentInstrumentRequest' is set
        if (postPaymentInstrumentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'postPaymentInstrumentRequest' when calling postPaymentInstrument", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

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
        return apiClient.invokeAPI("/tms/v1/paymentinstruments", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**&lt;br&gt;&lt;br&gt;**Creating a Payment Instrument**&lt;br&gt;It is recommended you [create a Payment Instrument via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Payment Instruments**&lt;br&gt;To perform a payment with a particular Payment Instrument specify the [Payment Instrument in the payment request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postPaymentInstrumentRequest The postPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PaymentInstrumentListEmbeddedPaymentInstrumentsInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> postPaymentInstrument(PaymentInstrumentListEmbeddedPaymentInstrumentsInner postPaymentInstrumentRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return postPaymentInstrumentRequestCreation(postPaymentInstrumentRequest, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**&lt;br&gt;&lt;br&gt;**Creating a Payment Instrument**&lt;br&gt;It is recommended you [create a Payment Instrument via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Payment Instruments**&lt;br&gt;To perform a payment with a particular Payment Instrument specify the [Payment Instrument in the payment request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postPaymentInstrumentRequest The postPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;PaymentInstrumentListEmbeddedPaymentInstrumentsInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>> postPaymentInstrumentWithHttpInfo(PaymentInstrumentListEmbeddedPaymentInstrumentsInner postPaymentInstrumentRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentListEmbeddedPaymentInstrumentsInner>() {};
        return postPaymentInstrumentRequestCreation(postPaymentInstrumentRequest, profileId).toEntity(localVarReturnType);
    }

    /**
     * Create a Payment Instrument
     * |  |  |  | | --- | --- | --- | |**Standalone Payment Instruments**&lt;br&gt;A Payment Instrument represents tokenized payment information such as expiration date, billing address &amp; card type.&lt;br&gt;A Payment Instrument token does not store the card number. A Payment Instrument is associated with an [Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier) that represents either a payment card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;**Standalone Payment Instruments do not belong to a [Customer](#token-management_customer_create-a-customer).**&lt;br&gt;&lt;br&gt;**Creating a Payment Instrument**&lt;br&gt;It is recommended you [create a Payment Instrument via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Payment Instruments**&lt;br&gt;To perform a payment with a particular Payment Instrument specify the [Payment Instrument in the payment request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - Returns an existing Payment Instrument associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postPaymentInstrumentRequest The postPaymentInstrumentRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postPaymentInstrumentWithResponseSpec(PaymentInstrumentListEmbeddedPaymentInstrumentsInner postPaymentInstrumentRequest, String profileId) throws WebClientResponseException {
        return postPaymentInstrumentRequestCreation(postPaymentInstrumentRequest, profileId);
    }
}
