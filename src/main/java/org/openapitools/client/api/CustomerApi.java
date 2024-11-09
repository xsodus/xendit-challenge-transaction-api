package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetCustomer410Response;
import org.openapitools.client.model.PatchCustomer412Response;
import org.openapitools.client.model.PostCustomer400Response;
import org.openapitools.client.model.PostCustomer403Response;
import org.openapitools.client.model.PostCustomer409Response;
import org.openapitools.client.model.PostCustomer424Response;
import org.openapitools.client.model.PostCustomer500Response;
import org.openapitools.client.model.PostCustomerRequest;
import org.openapitools.client.model.TmsV2CustomersResponse;

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
public class CustomerApi {
    private ApiClient apiClient;

    public CustomerApi() {
        this(new ApiClient());
    }

    @Autowired
    public CustomerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customer**&lt;br&gt;Your system can use this API to delete a complete Customer.&lt;br&gt;When a Customer is deleted all associated Payment Instruments &amp; Shipping Addresses are deleted.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments.&lt;br&gt;Note: Individual [Payment Instruments](#token-management_customer-payment-instrument_delete-a-customer-payment-instrument) or [Shipping Addresses](#token-management_customer-shipping-address_delete-a-customer-shipping-address) can be deleted via their own dedicated API resources. 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteCustomerRequestCreation(String customerId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling deleteCustomer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customer**&lt;br&gt;Your system can use this API to delete a complete Customer.&lt;br&gt;When a Customer is deleted all associated Payment Instruments &amp; Shipping Addresses are deleted.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments.&lt;br&gt;Note: Individual [Payment Instruments](#token-management_customer-payment-instrument_delete-a-customer-payment-instrument) or [Shipping Addresses](#token-management_customer-shipping-address_delete-a-customer-shipping-address) can be deleted via their own dedicated API resources. 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteCustomer(String customerId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteCustomerRequestCreation(customerId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customer**&lt;br&gt;Your system can use this API to delete a complete Customer.&lt;br&gt;When a Customer is deleted all associated Payment Instruments &amp; Shipping Addresses are deleted.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments.&lt;br&gt;Note: Individual [Payment Instruments](#token-management_customer-payment-instrument_delete-a-customer-payment-instrument) or [Shipping Addresses](#token-management_customer-shipping-address_delete-a-customer-shipping-address) can be deleted via their own dedicated API resources. 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteCustomerWithHttpInfo(String customerId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteCustomerRequestCreation(customerId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customer**&lt;br&gt;Your system can use this API to delete a complete Customer.&lt;br&gt;When a Customer is deleted all associated Payment Instruments &amp; Shipping Addresses are deleted.&lt;br&gt;Any Instrument Identifiers representing the card number will also be deleted if they are not associated with any other Payment Instruments.&lt;br&gt;Note: Individual [Payment Instruments](#token-management_customer-payment-instrument_delete-a-customer-payment-instrument) or [Shipping Addresses](#token-management_customer-shipping-address_delete-a-customer-shipping-address) can be deleted via their own dedicated API resources. 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteCustomerWithResponseSpec(String customerId, String profileId) throws WebClientResponseException {
        return deleteCustomerRequestCreation(customerId, profileId);
    }
    /**
     * Retrieve a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.&lt;br&gt;&lt;br&gt;**Retrieving a Customer**&lt;br&gt;When your customer signs into their account, your system can use this API to retrieve the Customers default Payment Instrument and Shipping Address.&lt;br&gt;**Note: the actual card data will be masked.**&lt;br&gt;If your customer wants to see other available Payment Instruments, your system can [retrieve all Payment Instruments](#token-management_customer-payment-instrument_list-payment-instruments-for-a-customer) associated with the Customer.&lt;br&gt;The same applies to [Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers**&lt;br&gt;To perform a payment with the Customers default details specify the [Customer Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-token-id_liveconsole-tab-request-body).&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address &lt;br&gt;specify the [Payment Instrument or Shipping Address Ids in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Customer associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PostCustomerRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCustomerRequestCreation(String customerId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling getCustomer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PostCustomerRequest> localVarReturnType = new ParameterizedTypeReference<PostCustomerRequest>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.&lt;br&gt;&lt;br&gt;**Retrieving a Customer**&lt;br&gt;When your customer signs into their account, your system can use this API to retrieve the Customers default Payment Instrument and Shipping Address.&lt;br&gt;**Note: the actual card data will be masked.**&lt;br&gt;If your customer wants to see other available Payment Instruments, your system can [retrieve all Payment Instruments](#token-management_customer-payment-instrument_list-payment-instruments-for-a-customer) associated with the Customer.&lt;br&gt;The same applies to [Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers**&lt;br&gt;To perform a payment with the Customers default details specify the [Customer Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-token-id_liveconsole-tab-request-body).&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address &lt;br&gt;specify the [Payment Instrument or Shipping Address Ids in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Customer associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return PostCustomerRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PostCustomerRequest> getCustomer(String customerId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PostCustomerRequest> localVarReturnType = new ParameterizedTypeReference<PostCustomerRequest>() {};
        return getCustomerRequestCreation(customerId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.&lt;br&gt;&lt;br&gt;**Retrieving a Customer**&lt;br&gt;When your customer signs into their account, your system can use this API to retrieve the Customers default Payment Instrument and Shipping Address.&lt;br&gt;**Note: the actual card data will be masked.**&lt;br&gt;If your customer wants to see other available Payment Instruments, your system can [retrieve all Payment Instruments](#token-management_customer-payment-instrument_list-payment-instruments-for-a-customer) associated with the Customer.&lt;br&gt;The same applies to [Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers**&lt;br&gt;To perform a payment with the Customers default details specify the [Customer Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-token-id_liveconsole-tab-request-body).&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address &lt;br&gt;specify the [Payment Instrument or Shipping Address Ids in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Customer associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;PostCustomerRequest&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PostCustomerRequest>> getCustomerWithHttpInfo(String customerId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<PostCustomerRequest> localVarReturnType = new ParameterizedTypeReference<PostCustomerRequest>() {};
        return getCustomerRequestCreation(customerId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Retrieve a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.&lt;br&gt;&lt;br&gt;**Retrieving a Customer**&lt;br&gt;When your customer signs into their account, your system can use this API to retrieve the Customers default Payment Instrument and Shipping Address.&lt;br&gt;**Note: the actual card data will be masked.**&lt;br&gt;If your customer wants to see other available Payment Instruments, your system can [retrieve all Payment Instruments](#token-management_customer-payment-instrument_list-payment-instruments-for-a-customer) associated with the Customer.&lt;br&gt;The same applies to [Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer).|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers**&lt;br&gt;To perform a payment with the Customers default details specify the [Customer Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-token-id_liveconsole-tab-request-body).&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address &lt;br&gt;specify the [Payment Instrument or Shipping Address Ids in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Customer associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getCustomerWithResponseSpec(String customerId, String profileId) throws WebClientResponseException {
        return getCustomerRequestCreation(customerId, profileId);
    }
    /**
     * Update a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customer**&lt;br&gt;Your system can use this API to update a Customers details including selecting a  [default Payment Instrument](#token-management_customer_update-a-customer_samplerequests-dropdown_update-customers-default-payment-instrument_liveconsole-tab-request-body) or [default Shipping Address](#token-management_customer_update-a-customer_samplerequests-dropdown_update-customers-default-shipping-address_liveconsole-tab-request-body) for use in payments.&lt;br&gt;Note: Updating a Customers [Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument) or [Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address) details is performed using their own dedicated API resources. 
     * <p><b>200</b> - Returns an existing Customer associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param patchCustomerRequest The patchCustomerRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return PostCustomerRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec patchCustomerRequestCreation(String customerId, PostCustomerRequest patchCustomerRequest, String profileId, String ifMatch) throws WebClientResponseException {
        Object postBody = patchCustomerRequest;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling patchCustomer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'patchCustomerRequest' is set
        if (patchCustomerRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'patchCustomerRequest' when calling patchCustomer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PostCustomerRequest> localVarReturnType = new ParameterizedTypeReference<PostCustomerRequest>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customer**&lt;br&gt;Your system can use this API to update a Customers details including selecting a  [default Payment Instrument](#token-management_customer_update-a-customer_samplerequests-dropdown_update-customers-default-payment-instrument_liveconsole-tab-request-body) or [default Shipping Address](#token-management_customer_update-a-customer_samplerequests-dropdown_update-customers-default-shipping-address_liveconsole-tab-request-body) for use in payments.&lt;br&gt;Note: Updating a Customers [Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument) or [Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address) details is performed using their own dedicated API resources. 
     * <p><b>200</b> - Returns an existing Customer associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param patchCustomerRequest The patchCustomerRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return PostCustomerRequest
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PostCustomerRequest> patchCustomer(String customerId, PostCustomerRequest patchCustomerRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<PostCustomerRequest> localVarReturnType = new ParameterizedTypeReference<PostCustomerRequest>() {};
        return patchCustomerRequestCreation(customerId, patchCustomerRequest, profileId, ifMatch).bodyToMono(localVarReturnType);
    }

    /**
     * Update a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customer**&lt;br&gt;Your system can use this API to update a Customers details including selecting a  [default Payment Instrument](#token-management_customer_update-a-customer_samplerequests-dropdown_update-customers-default-payment-instrument_liveconsole-tab-request-body) or [default Shipping Address](#token-management_customer_update-a-customer_samplerequests-dropdown_update-customers-default-shipping-address_liveconsole-tab-request-body) for use in payments.&lt;br&gt;Note: Updating a Customers [Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument) or [Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address) details is performed using their own dedicated API resources. 
     * <p><b>200</b> - Returns an existing Customer associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param patchCustomerRequest The patchCustomerRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseEntity&lt;PostCustomerRequest&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PostCustomerRequest>> patchCustomerWithHttpInfo(String customerId, PostCustomerRequest patchCustomerRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<PostCustomerRequest> localVarReturnType = new ParameterizedTypeReference<PostCustomerRequest>() {};
        return patchCustomerRequestCreation(customerId, patchCustomerRequest, profileId, ifMatch).toEntity(localVarReturnType);
    }

    /**
     * Update a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customer**&lt;br&gt;Your system can use this API to update a Customers details including selecting a  [default Payment Instrument](#token-management_customer_update-a-customer_samplerequests-dropdown_update-customers-default-payment-instrument_liveconsole-tab-request-body) or [default Shipping Address](#token-management_customer_update-a-customer_samplerequests-dropdown_update-customers-default-shipping-address_liveconsole-tab-request-body) for use in payments.&lt;br&gt;Note: Updating a Customers [Payment Instrument](#token-management_customer-payment-instrument_update-a-customer-payment-instrument) or [Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address) details is performed using their own dedicated API resources. 
     * <p><b>200</b> - Returns an existing Customer associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param patchCustomerRequest The patchCustomerRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec patchCustomerWithResponseSpec(String customerId, PostCustomerRequest patchCustomerRequest, String profileId, String ifMatch) throws WebClientResponseException {
        return patchCustomerRequestCreation(customerId, patchCustomerRequest, profileId, ifMatch);
    }
    /**
     * Create a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.&lt;br&gt;&lt;br&gt;**Creating a Customer**&lt;br&gt;It is recommended you [create a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;The Customer will be created with a Payment Instrument and Shipping Address.&lt;br&gt;You can also [add additional Payment Instruments to a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body).&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers**&lt;br&gt;To perform a payment with the Customers default details specify the [Customer Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-token-id_liveconsole-tab-request-body).&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address &lt;br&gt;specify the [Payment Instrument or Shipping Address Ids in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Customer has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postCustomerRequest The postCustomerRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return TmsV2CustomersResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postCustomerRequestCreation(PostCustomerRequest postCustomerRequest, String profileId) throws WebClientResponseException {
        Object postBody = postCustomerRequest;
        // verify the required parameter 'postCustomerRequest' is set
        if (postCustomerRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'postCustomerRequest' when calling postCustomer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<TmsV2CustomersResponse> localVarReturnType = new ParameterizedTypeReference<TmsV2CustomersResponse>() {};
        return apiClient.invokeAPI("/tms/v2/customers", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.&lt;br&gt;&lt;br&gt;**Creating a Customer**&lt;br&gt;It is recommended you [create a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;The Customer will be created with a Payment Instrument and Shipping Address.&lt;br&gt;You can also [add additional Payment Instruments to a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body).&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers**&lt;br&gt;To perform a payment with the Customers default details specify the [Customer Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-token-id_liveconsole-tab-request-body).&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address &lt;br&gt;specify the [Payment Instrument or Shipping Address Ids in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Customer has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postCustomerRequest The postCustomerRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return TmsV2CustomersResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TmsV2CustomersResponse> postCustomer(PostCustomerRequest postCustomerRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<TmsV2CustomersResponse> localVarReturnType = new ParameterizedTypeReference<TmsV2CustomersResponse>() {};
        return postCustomerRequestCreation(postCustomerRequest, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.&lt;br&gt;&lt;br&gt;**Creating a Customer**&lt;br&gt;It is recommended you [create a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;The Customer will be created with a Payment Instrument and Shipping Address.&lt;br&gt;You can also [add additional Payment Instruments to a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body).&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers**&lt;br&gt;To perform a payment with the Customers default details specify the [Customer Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-token-id_liveconsole-tab-request-body).&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address &lt;br&gt;specify the [Payment Instrument or Shipping Address Ids in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Customer has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postCustomerRequest The postCustomerRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;TmsV2CustomersResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<TmsV2CustomersResponse>> postCustomerWithHttpInfo(PostCustomerRequest postCustomerRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<TmsV2CustomersResponse> localVarReturnType = new ParameterizedTypeReference<TmsV2CustomersResponse>() {};
        return postCustomerRequestCreation(postCustomerRequest, profileId).toEntity(localVarReturnType);
    }

    /**
     * Create a Customer
     * |  |  |  | | --- | --- | --- | |**Customers**&lt;br&gt;A Customer represents your tokenized customer information.&lt;br&gt;You should associate the Customer Id with the customer account on your systems.&lt;br&gt;A Customer can have one or more [Payment Instruments](#token-management_customer-payment-instrument_create-a-customer-payment-instrumentl) or [Shipping Addresses](#token-management_customer-shipping-address_create-a-customer-shipping-address) with one allocated as the Customers default.&lt;br&gt;&lt;br&gt;**Creating a Customer**&lt;br&gt;It is recommended you [create a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-with-customer-token-creation_liveconsole-tab-request-body), this can be for a zero amount.&lt;br&gt;The Customer will be created with a Payment Instrument and Shipping Address.&lt;br&gt;You can also [add additional Payment Instruments to a Customer via a Payment Authorization](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body).&lt;br&gt;In Europe: You should perform Payer Authentication alongside the Authorization.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Network Tokens**&lt;br&gt;Network tokens perform better than regular card numbers and they are not necessarily invalidated when a cardholder loses their card, or it expires.&lt;br&gt;A Payment Network Token will be automatically created and used in future payments if you are enabled for the service.&lt;br&gt;A Payment Network Token can also be [provisioned for an existing Instrument Identifier](#token-management_instrument-identifier_enroll-an-instrument-identifier-for-payment-network-token).&lt;br&gt;For more information about Payment Network Tokens see the Developer Guide.&lt;br&gt;&lt;br&gt;**Payments with Customers**&lt;br&gt;To perform a payment with the Customers default details specify the [Customer Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-token-id_liveconsole-tab-request-body).&lt;br&gt;To perform a payment with a particular Payment Instrument or Shipping Address &lt;br&gt;specify the [Payment Instrument or Shipping Address Ids in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Customer has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param postCustomerRequest The postCustomerRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postCustomerWithResponseSpec(PostCustomerRequest postCustomerRequest, String profileId) throws WebClientResponseException {
        return postCustomerRequestCreation(postCustomerRequest, profileId);
    }
}
