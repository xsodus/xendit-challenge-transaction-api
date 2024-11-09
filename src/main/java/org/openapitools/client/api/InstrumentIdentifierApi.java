package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetCustomer410Response;
import org.openapitools.client.model.PatchCustomer412Response;
import org.openapitools.client.model.PaymentInstrumentList;
import org.openapitools.client.model.PostCustomer400Response;
import org.openapitools.client.model.PostCustomer403Response;
import org.openapitools.client.model.PostCustomer409Response;
import org.openapitools.client.model.PostCustomer424Response;
import org.openapitools.client.model.PostCustomer500Response;
import org.openapitools.client.model.PostInstrumentIdentifierRequest;

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
public class InstrumentIdentifierApi {
    private ApiClient apiClient;

    public InstrumentIdentifierApi() {
        this(new ApiClient());
    }

    @Autowired
    public InstrumentIdentifierApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing &lt;br&gt;and account numbers.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the &lt;br&gt;Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) &lt;br&gt;or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting an Instrument Identifier**&lt;br&gt;Your system can use this API to delete an existing Instrument Identifier.&lt;br&gt;An Instrument Identifier cannot be deleted if it is linked to any Payment Instruments.&lt;br&gt;You can [retrieve all Payment Instruments associated with an Instrument Identifier](#token-management_instrument-identifier_list-payment-instruments-for-an-instrument-identifier). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteInstrumentIdentifierRequestCreation(String instrumentIdentifierId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'instrumentIdentifierId' is set
        if (instrumentIdentifierId == null) {
            throw new WebClientResponseException("Missing the required parameter 'instrumentIdentifierId' when calling deleteInstrumentIdentifier", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("instrumentIdentifierId", instrumentIdentifierId);

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
        return apiClient.invokeAPI("/tms/v1/instrumentidentifiers/{instrumentIdentifierId}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing &lt;br&gt;and account numbers.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the &lt;br&gt;Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) &lt;br&gt;or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting an Instrument Identifier**&lt;br&gt;Your system can use this API to delete an existing Instrument Identifier.&lt;br&gt;An Instrument Identifier cannot be deleted if it is linked to any Payment Instruments.&lt;br&gt;You can [retrieve all Payment Instruments associated with an Instrument Identifier](#token-management_instrument-identifier_list-payment-instruments-for-an-instrument-identifier). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteInstrumentIdentifier(String instrumentIdentifierId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteInstrumentIdentifierRequestCreation(instrumentIdentifierId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Delete an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing &lt;br&gt;and account numbers.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the &lt;br&gt;Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) &lt;br&gt;or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting an Instrument Identifier**&lt;br&gt;Your system can use this API to delete an existing Instrument Identifier.&lt;br&gt;An Instrument Identifier cannot be deleted if it is linked to any Payment Instruments.&lt;br&gt;You can [retrieve all Payment Instruments associated with an Instrument Identifier](#token-management_instrument-identifier_list-payment-instruments-for-an-instrument-identifier). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteInstrumentIdentifierWithHttpInfo(String instrumentIdentifierId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteInstrumentIdentifierRequestCreation(instrumentIdentifierId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Delete an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing &lt;br&gt;and account numbers.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the &lt;br&gt;Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) &lt;br&gt;or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting an Instrument Identifier**&lt;br&gt;Your system can use this API to delete an existing Instrument Identifier.&lt;br&gt;An Instrument Identifier cannot be deleted if it is linked to any Payment Instruments.&lt;br&gt;You can [retrieve all Payment Instruments associated with an Instrument Identifier](#token-management_instrument-identifier_list-payment-instruments-for-an-instrument-identifier). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteInstrumentIdentifierWithResponseSpec(String instrumentIdentifierId, String profileId) throws WebClientResponseException {
        return deleteInstrumentIdentifierRequestCreation(instrumentIdentifierId, profileId);
    }
    /**
     * Retrieve an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).&lt;br&gt;&lt;br&gt;**Retrieving an Instrument Identifier**&lt;br&gt;Your system can use this API to retrieve an Instrument Identifier.&lt;br&gt;**Note: the actual card data will be masked.**&lt;br&gt;The Instrument Identifier will also be returned when retrieving a [Customer](#token-management_customer_retrieve-a-customer), [Customer Payment Instrument](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_retrieve-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Instrument Identifiers**&lt;br&gt;To perform a payment with an Instrument Identifier simply specify the [Instrument Identifier Id in the payments request along with the expiration date, card type, &amp; billing address](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-instrument-identifier-token-id_liveconsole-tab-request-body).&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PostInstrumentIdentifierRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getInstrumentIdentifierRequestCreation(String instrumentIdentifierId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'instrumentIdentifierId' is set
        if (instrumentIdentifierId == null) {
            throw new WebClientResponseException("Missing the required parameter 'instrumentIdentifierId' when calling getInstrumentIdentifier", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("instrumentIdentifierId", instrumentIdentifierId);

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

        ParameterizedTypeReference<PostInstrumentIdentifierRequest> localVarReturnType = new ParameterizedTypeReference<PostInstrumentIdentifierRequest>() {};
        return apiClient.invokeAPI("/tms/v1/instrumentidentifiers/{instrumentIdentifierId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).&lt;br&gt;&lt;br&gt;**Retrieving an Instrument Identifier**&lt;br&gt;Your system can use this API to retrieve an Instrument Identifier.&lt;br&gt;**Note: the actual card data will be masked.**&lt;br&gt;The Instrument Identifier will also be returned when retrieving a [Customer](#token-management_customer_retrieve-a-customer), [Customer Payment Instrument](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_retrieve-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Instrument Identifiers**&lt;br&gt;To perform a payment with an Instrument Identifier simply specify the [Instrument Identifier Id in the payments request along with the expiration date, card type, &amp; billing address](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-instrument-identifier-token-id_liveconsole-tab-request-body).&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PostInstrumentIdentifierRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PostInstrumentIdentifierRequest> getInstrumentIdentifier(String instrumentIdentifierId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PostInstrumentIdentifierRequest> localVarReturnType = new ParameterizedTypeReference<PostInstrumentIdentifierRequest>() {};
        return getInstrumentIdentifierRequestCreation(instrumentIdentifierId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).&lt;br&gt;&lt;br&gt;**Retrieving an Instrument Identifier**&lt;br&gt;Your system can use this API to retrieve an Instrument Identifier.&lt;br&gt;**Note: the actual card data will be masked.**&lt;br&gt;The Instrument Identifier will also be returned when retrieving a [Customer](#token-management_customer_retrieve-a-customer), [Customer Payment Instrument](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_retrieve-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Instrument Identifiers**&lt;br&gt;To perform a payment with an Instrument Identifier simply specify the [Instrument Identifier Id in the payments request along with the expiration date, card type, &amp; billing address](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-instrument-identifier-token-id_liveconsole-tab-request-body).&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;PostInstrumentIdentifierRequest&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PostInstrumentIdentifierRequest>> getInstrumentIdentifierWithHttpInfo(String instrumentIdentifierId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PostInstrumentIdentifierRequest> localVarReturnType = new ParameterizedTypeReference<PostInstrumentIdentifierRequest>() {};
        return getInstrumentIdentifierRequestCreation(instrumentIdentifierId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Retrieve an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).&lt;br&gt;&lt;br&gt;**Retrieving an Instrument Identifier**&lt;br&gt;Your system can use this API to retrieve an Instrument Identifier.&lt;br&gt;**Note: the actual card data will be masked.**&lt;br&gt;The Instrument Identifier will also be returned when retrieving a [Customer](#token-management_customer_retrieve-a-customer), [Customer Payment Instrument](#token-management_customer-payment-instrument_retrieve-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_retrieve-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Instrument Identifiers**&lt;br&gt;To perform a payment with an Instrument Identifier simply specify the [Instrument Identifier Id in the payments request along with the expiration date, card type, &amp; billing address](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-instrument-identifier-token-id_liveconsole-tab-request-body).&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getInstrumentIdentifierWithResponseSpec(String instrumentIdentifierId, String profileId) throws WebClientResponseException {
        return getInstrumentIdentifierRequestCreation(instrumentIdentifierId, profileId);
    }
    /**
     * List Payment Instruments for an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing &lt;br&gt;and account numbers.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the &lt;br&gt;Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) &lt;br&gt;or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Payment Instruments associated with an Instrument Identifier**&lt;br&gt;Your system can use this API to retrieve all Payment Instruments linked to an Instrument Identifier. 
     * <p><b>200</b> - Returns all existing Payment Instruments associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array. Default is 0.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset. Default is 20, maximum is 100.
     * @return PaymentInstrumentList
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getInstrumentIdentifierPaymentInstrumentsListRequestCreation(String instrumentIdentifierId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'instrumentIdentifierId' is set
        if (instrumentIdentifierId == null) {
            throw new WebClientResponseException("Missing the required parameter 'instrumentIdentifierId' when calling getInstrumentIdentifierPaymentInstrumentsList", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("instrumentIdentifierId", instrumentIdentifierId);

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
        return apiClient.invokeAPI("/tms/v1/instrumentidentifiers/{instrumentIdentifierId}/paymentinstruments", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Payment Instruments for an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing &lt;br&gt;and account numbers.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the &lt;br&gt;Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) &lt;br&gt;or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Payment Instruments associated with an Instrument Identifier**&lt;br&gt;Your system can use this API to retrieve all Payment Instruments linked to an Instrument Identifier. 
     * <p><b>200</b> - Returns all existing Payment Instruments associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array. Default is 0.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset. Default is 20, maximum is 100.
     * @return PaymentInstrumentList
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PaymentInstrumentList> getInstrumentIdentifierPaymentInstrumentsList(String instrumentIdentifierId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentList> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentList>() {};
        return getInstrumentIdentifierPaymentInstrumentsListRequestCreation(instrumentIdentifierId, profileId, offset, limit).bodyToMono(localVarReturnType);
    }

    /**
     * List Payment Instruments for an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing &lt;br&gt;and account numbers.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the &lt;br&gt;Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) &lt;br&gt;or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Payment Instruments associated with an Instrument Identifier**&lt;br&gt;Your system can use this API to retrieve all Payment Instruments linked to an Instrument Identifier. 
     * <p><b>200</b> - Returns all existing Payment Instruments associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array. Default is 0.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset. Default is 20, maximum is 100.
     * @return ResponseEntity&lt;PaymentInstrumentList&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PaymentInstrumentList>> getInstrumentIdentifierPaymentInstrumentsListWithHttpInfo(String instrumentIdentifierId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        ParameterizedTypeReference<PaymentInstrumentList> localVarReturnType = new ParameterizedTypeReference<PaymentInstrumentList>() {};
        return getInstrumentIdentifierPaymentInstrumentsListRequestCreation(instrumentIdentifierId, profileId, offset, limit).toEntity(localVarReturnType);
    }

    /**
     * List Payment Instruments for an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing &lt;br&gt;and account numbers.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the &lt;br&gt;Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) &lt;br&gt;or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Payment Instruments associated with an Instrument Identifier**&lt;br&gt;Your system can use this API to retrieve all Payment Instruments linked to an Instrument Identifier. 
     * <p><b>200</b> - Returns all existing Payment Instruments associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array. Default is 0.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset. Default is 20, maximum is 100.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getInstrumentIdentifierPaymentInstrumentsListWithResponseSpec(String instrumentIdentifierId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        return getInstrumentIdentifierPaymentInstrumentsListRequestCreation(instrumentIdentifierId, profileId, offset, limit);
    }
    /**
     * Update an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating an Instrument Identifier**&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments.&lt;br&gt;Your system can use this API to update these values. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param patchInstrumentIdentifierRequest Specify the previous transaction Id to update.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return PostInstrumentIdentifierRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec patchInstrumentIdentifierRequestCreation(String instrumentIdentifierId, PostInstrumentIdentifierRequest patchInstrumentIdentifierRequest, String profileId, String ifMatch) throws WebClientResponseException {
        Object postBody = patchInstrumentIdentifierRequest;
        // verify the required parameter 'instrumentIdentifierId' is set
        if (instrumentIdentifierId == null) {
            throw new WebClientResponseException("Missing the required parameter 'instrumentIdentifierId' when calling patchInstrumentIdentifier", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'patchInstrumentIdentifierRequest' is set
        if (patchInstrumentIdentifierRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'patchInstrumentIdentifierRequest' when calling patchInstrumentIdentifier", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("instrumentIdentifierId", instrumentIdentifierId);

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

        ParameterizedTypeReference<PostInstrumentIdentifierRequest> localVarReturnType = new ParameterizedTypeReference<PostInstrumentIdentifierRequest>() {};
        return apiClient.invokeAPI("/tms/v1/instrumentidentifiers/{instrumentIdentifierId}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating an Instrument Identifier**&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments.&lt;br&gt;Your system can use this API to update these values. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param patchInstrumentIdentifierRequest Specify the previous transaction Id to update.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return PostInstrumentIdentifierRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PostInstrumentIdentifierRequest> patchInstrumentIdentifier(String instrumentIdentifierId, PostInstrumentIdentifierRequest patchInstrumentIdentifierRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<PostInstrumentIdentifierRequest> localVarReturnType = new ParameterizedTypeReference<PostInstrumentIdentifierRequest>() {};
        return patchInstrumentIdentifierRequestCreation(instrumentIdentifierId, patchInstrumentIdentifierRequest, profileId, ifMatch).bodyToMono(localVarReturnType);
    }

    /**
     * Update an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating an Instrument Identifier**&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments.&lt;br&gt;Your system can use this API to update these values. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param patchInstrumentIdentifierRequest Specify the previous transaction Id to update.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseEntity&lt;PostInstrumentIdentifierRequest&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PostInstrumentIdentifierRequest>> patchInstrumentIdentifierWithHttpInfo(String instrumentIdentifierId, PostInstrumentIdentifierRequest patchInstrumentIdentifierRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<PostInstrumentIdentifierRequest> localVarReturnType = new ParameterizedTypeReference<PostInstrumentIdentifierRequest>() {};
        return patchInstrumentIdentifierRequestCreation(instrumentIdentifierId, patchInstrumentIdentifierRequest, profileId, ifMatch).toEntity(localVarReturnType);
    }

    /**
     * Update an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating an Instrument Identifier**&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments.&lt;br&gt;Your system can use this API to update these values. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param patchInstrumentIdentifierRequest Specify the previous transaction Id to update.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec patchInstrumentIdentifierWithResponseSpec(String instrumentIdentifierId, PostInstrumentIdentifierRequest patchInstrumentIdentifierRequest, String profileId, String ifMatch) throws WebClientResponseException {
        return patchInstrumentIdentifierRequestCreation(instrumentIdentifierId, patchInstrumentIdentifierRequest, profileId, ifMatch);
    }
    /**
     * Create an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).&lt;br&gt;&lt;br&gt;**Creating an Instrument Identifier**&lt;br&gt;It is recommended you [create an Instrument Identifier via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-instrument-identifier-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;An Instrument Identifier will also be created if you [create a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body)&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Instrument Identifiers**&lt;br&gt;To perform a payment with an Instrument Identifier simply specify the [Instrument Identifier Id in the payments request along with the expiration date, card type, &amp; billing address](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-instrument-identifier-token-id_liveconsole-tab-request-body).&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>201</b> - A new Instrument Identifier has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postInstrumentIdentifierRequest Specify either a Card, Bank Account or Enrollable Card
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PostInstrumentIdentifierRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postInstrumentIdentifierRequestCreation(PostInstrumentIdentifierRequest postInstrumentIdentifierRequest, String profileId) throws WebClientResponseException {
        Object postBody = postInstrumentIdentifierRequest;
        // verify the required parameter 'postInstrumentIdentifierRequest' is set
        if (postInstrumentIdentifierRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'postInstrumentIdentifierRequest' when calling postInstrumentIdentifier", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PostInstrumentIdentifierRequest> localVarReturnType = new ParameterizedTypeReference<PostInstrumentIdentifierRequest>() {};
        return apiClient.invokeAPI("/tms/v1/instrumentidentifiers", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).&lt;br&gt;&lt;br&gt;**Creating an Instrument Identifier**&lt;br&gt;It is recommended you [create an Instrument Identifier via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-instrument-identifier-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;An Instrument Identifier will also be created if you [create a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body)&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Instrument Identifiers**&lt;br&gt;To perform a payment with an Instrument Identifier simply specify the [Instrument Identifier Id in the payments request along with the expiration date, card type, &amp; billing address](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-instrument-identifier-token-id_liveconsole-tab-request-body).&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>201</b> - A new Instrument Identifier has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postInstrumentIdentifierRequest Specify either a Card, Bank Account or Enrollable Card
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PostInstrumentIdentifierRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PostInstrumentIdentifierRequest> postInstrumentIdentifier(PostInstrumentIdentifierRequest postInstrumentIdentifierRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PostInstrumentIdentifierRequest> localVarReturnType = new ParameterizedTypeReference<PostInstrumentIdentifierRequest>() {};
        return postInstrumentIdentifierRequestCreation(postInstrumentIdentifierRequest, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Create an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).&lt;br&gt;&lt;br&gt;**Creating an Instrument Identifier**&lt;br&gt;It is recommended you [create an Instrument Identifier via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-instrument-identifier-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;An Instrument Identifier will also be created if you [create a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body)&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Instrument Identifiers**&lt;br&gt;To perform a payment with an Instrument Identifier simply specify the [Instrument Identifier Id in the payments request along with the expiration date, card type, &amp; billing address](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-instrument-identifier-token-id_liveconsole-tab-request-body).&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>201</b> - A new Instrument Identifier has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postInstrumentIdentifierRequest Specify either a Card, Bank Account or Enrollable Card
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;PostInstrumentIdentifierRequest&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PostInstrumentIdentifierRequest>> postInstrumentIdentifierWithHttpInfo(PostInstrumentIdentifierRequest postInstrumentIdentifierRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PostInstrumentIdentifierRequest> localVarReturnType = new ParameterizedTypeReference<PostInstrumentIdentifierRequest>() {};
        return postInstrumentIdentifierRequestCreation(postInstrumentIdentifierRequest, profileId).toEntity(localVarReturnType);
    }

    /**
     * Create an Instrument Identifier
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).&lt;br&gt;&lt;br&gt;**Creating an Instrument Identifier**&lt;br&gt;It is recommended you [create an Instrument Identifier via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-instrument-identifier-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;An Instrument Identifier will also be created if you [create a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body)&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Instrument Identifiers**&lt;br&gt;To perform a payment with an Instrument Identifier simply specify the [Instrument Identifier Id in the payments request along with the expiration date, card type, &amp; billing address](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-instrument-identifier-token-id_liveconsole-tab-request-body).&lt;br&gt;When an Instrument Identifier is used in a payment the **_previousTransactionId_** and **_originalAuthorizedAmount_** values are automatically recorded.&lt;br&gt;These values will be added for you to future Merchant Initiated Transaction payments. 
     * <p><b>200</b> - Returns an existing Instrument Identifier associated with the supplied Id.
     * <p><b>201</b> - A new Instrument Identifier has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postInstrumentIdentifierRequest Specify either a Card, Bank Account or Enrollable Card
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postInstrumentIdentifierWithResponseSpec(PostInstrumentIdentifierRequest postInstrumentIdentifierRequest, String profileId) throws WebClientResponseException {
        return postInstrumentIdentifierRequestCreation(postInstrumentIdentifierRequest, profileId);
    }
    /**
     * Enroll an Instrument Identifier for Payment Network Token
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Enroll an Instrument Identifier for a Payment Network Token**&lt;br&gt;Your system can use this API to provision a Network token for an existing Instrument Identifier.&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Network token can be [provisioned when creating an Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier_samplerequests-dropdown_create-instrument-identifier-card-enroll-for-network-token_liveconsole-tab-request-body).This will occur automatically when creating a [Customer](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), [Payment Instrument](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body) or [Instrument Identifier](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-instrument-identifier-token-creation_liveconsole-tab-request-body) via the Payments API.&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide. 
     * <p><b>202</b> - The request has been accepted for processing, but the processing has not been completed.
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param postInstrumentIdentifierEnrollmentRequest Specify Enrollable Card details
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postInstrumentIdentifierEnrollmentRequestCreation(String instrumentIdentifierId, PostInstrumentIdentifierRequest postInstrumentIdentifierEnrollmentRequest, String profileId) throws WebClientResponseException {
        Object postBody = postInstrumentIdentifierEnrollmentRequest;
        // verify the required parameter 'instrumentIdentifierId' is set
        if (instrumentIdentifierId == null) {
            throw new WebClientResponseException("Missing the required parameter 'instrumentIdentifierId' when calling postInstrumentIdentifierEnrollment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'postInstrumentIdentifierEnrollmentRequest' is set
        if (postInstrumentIdentifierEnrollmentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'postInstrumentIdentifierEnrollmentRequest' when calling postInstrumentIdentifierEnrollment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("instrumentIdentifierId", instrumentIdentifierId);

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

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/tms/v1/instrumentidentifiers/{instrumentIdentifierId}/enrollment", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Enroll an Instrument Identifier for Payment Network Token
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Enroll an Instrument Identifier for a Payment Network Token**&lt;br&gt;Your system can use this API to provision a Network token for an existing Instrument Identifier.&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Network token can be [provisioned when creating an Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier_samplerequests-dropdown_create-instrument-identifier-card-enroll-for-network-token_liveconsole-tab-request-body).This will occur automatically when creating a [Customer](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), [Payment Instrument](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body) or [Instrument Identifier](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-instrument-identifier-token-creation_liveconsole-tab-request-body) via the Payments API.&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide. 
     * <p><b>202</b> - The request has been accepted for processing, but the processing has not been completed.
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param postInstrumentIdentifierEnrollmentRequest Specify Enrollable Card details
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> postInstrumentIdentifierEnrollment(String instrumentIdentifierId, PostInstrumentIdentifierRequest postInstrumentIdentifierEnrollmentRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return postInstrumentIdentifierEnrollmentRequestCreation(instrumentIdentifierId, postInstrumentIdentifierEnrollmentRequest, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Enroll an Instrument Identifier for Payment Network Token
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Enroll an Instrument Identifier for a Payment Network Token**&lt;br&gt;Your system can use this API to provision a Network token for an existing Instrument Identifier.&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Network token can be [provisioned when creating an Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier_samplerequests-dropdown_create-instrument-identifier-card-enroll-for-network-token_liveconsole-tab-request-body).This will occur automatically when creating a [Customer](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), [Payment Instrument](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body) or [Instrument Identifier](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-instrument-identifier-token-creation_liveconsole-tab-request-body) via the Payments API.&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide. 
     * <p><b>202</b> - The request has been accepted for processing, but the processing has not been completed.
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param postInstrumentIdentifierEnrollmentRequest Specify Enrollable Card details
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> postInstrumentIdentifierEnrollmentWithHttpInfo(String instrumentIdentifierId, PostInstrumentIdentifierRequest postInstrumentIdentifierEnrollmentRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return postInstrumentIdentifierEnrollmentRequestCreation(instrumentIdentifierId, postInstrumentIdentifierEnrollmentRequest, profileId).toEntity(localVarReturnType);
    }

    /**
     * Enroll an Instrument Identifier for Payment Network Token
     * |  |  |  | | --- | --- | --- | |**Instrument Identifiers**&lt;br&gt;An Instrument Identifier represents either a card number, or in the case of an ACH bank account, the routing and account number.&lt;br&gt;The same token Id is returned for a specific card number or bank account &amp; routing number allowing the Instrument Identifier Id to be used for cross-channel payment tracking.&lt;br&gt;An Instrument Identifier can exist independently but also be associated with a [Customer Payment Instrument](#token-management_customer-payment-instrument_create-a-customer-payment-instrument) or [Standalone Payment Instrument](#token-management_payment-instrument_create-a-payment-instrument).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Enroll an Instrument Identifier for a Payment Network Token**&lt;br&gt;Your system can use this API to provision a Network token for an existing Instrument Identifier.&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Network token can be [provisioned when creating an Instrument Identifier](#token-management_instrument-identifier_create-an-instrument-identifier_samplerequests-dropdown_create-instrument-identifier-card-enroll-for-network-token_liveconsole-tab-request-body).This will occur automatically when creating a [Customer](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), [Payment Instrument](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body) or [Instrument Identifier](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-instrument-identifier-token-creation_liveconsole-tab-request-body) via the Payments API.&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide. 
     * <p><b>202</b> - The request has been accepted for processing, but the processing has not been completed.
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param instrumentIdentifierId The Id of an Instrument Identifier.
     * @param postInstrumentIdentifierEnrollmentRequest Specify Enrollable Card details
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postInstrumentIdentifierEnrollmentWithResponseSpec(String instrumentIdentifierId, PostInstrumentIdentifierRequest postInstrumentIdentifierEnrollmentRequest, String profileId) throws WebClientResponseException {
        return postInstrumentIdentifierEnrollmentRequestCreation(instrumentIdentifierId, postInstrumentIdentifierEnrollmentRequest, profileId);
    }
}
