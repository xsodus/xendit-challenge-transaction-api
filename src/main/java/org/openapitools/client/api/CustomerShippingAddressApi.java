package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetCustomer410Response;
import org.openapitools.client.model.PatchCustomer412Response;
import org.openapitools.client.model.PostCustomer400Response;
import org.openapitools.client.model.PostCustomer403Response;
import org.openapitools.client.model.PostCustomer409Response;
import org.openapitools.client.model.PostCustomer424Response;
import org.openapitools.client.model.PostCustomer500Response;
import org.openapitools.client.model.ShippingAddressListForCustomer;
import org.openapitools.client.model.ShippingAddressListForCustomerEmbeddedShippingAddressesInner;

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
public class CustomerShippingAddressApi {
    private ApiClient apiClient;

    public CustomerShippingAddressApi() {
        this(new ApiClient());
    }

    @Autowired
    public CustomerShippingAddressApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customers Shipping Address**&lt;br&gt;Your system can use this API to delete an existing Shipping Address for a Customer.&lt;br&gt;If a customer has more than one Shipping Address then the default Shipping Address cannot be deleted without first selecting a [new default Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address_samplerequests-dropdown_make-customer-shipping-address-the-default_liveconsole-tab-request-body). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteCustomerShippingAddressRequestCreation(String customerId, String shippingAddressId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling deleteCustomerShippingAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'shippingAddressId' is set
        if (shippingAddressId == null) {
            throw new WebClientResponseException("Missing the required parameter 'shippingAddressId' when calling deleteCustomerShippingAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);
        pathParams.put("shippingAddressId", shippingAddressId);

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
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/shipping-addresses/{shippingAddressId}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customers Shipping Address**&lt;br&gt;Your system can use this API to delete an existing Shipping Address for a Customer.&lt;br&gt;If a customer has more than one Shipping Address then the default Shipping Address cannot be deleted without first selecting a [new default Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address_samplerequests-dropdown_make-customer-shipping-address-the-default_liveconsole-tab-request-body). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteCustomerShippingAddress(String customerId, String shippingAddressId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteCustomerShippingAddressRequestCreation(customerId, shippingAddressId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customers Shipping Address**&lt;br&gt;Your system can use this API to delete an existing Shipping Address for a Customer.&lt;br&gt;If a customer has more than one Shipping Address then the default Shipping Address cannot be deleted without first selecting a [new default Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address_samplerequests-dropdown_make-customer-shipping-address-the-default_liveconsole-tab-request-body). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteCustomerShippingAddressWithHttpInfo(String customerId, String shippingAddressId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteCustomerShippingAddressRequestCreation(customerId, shippingAddressId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Deleting a Customers Shipping Address**&lt;br&gt;Your system can use this API to delete an existing Shipping Address for a Customer.&lt;br&gt;If a customer has more than one Shipping Address then the default Shipping Address cannot be deleted without first selecting a [new default Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address_samplerequests-dropdown_make-customer-shipping-address-the-default_liveconsole-tab-request-body). 
     * <p><b>204</b> - The request is fulfilled but does not need to return a body
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteCustomerShippingAddressWithResponseSpec(String customerId, String shippingAddressId, String profileId) throws WebClientResponseException {
        return deleteCustomerShippingAddressRequestCreation(customerId, shippingAddressId, profileId);
    }
    /**
     * Retrieve a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Customer Shipping Address**&lt;br&gt;Your system can use this API to retrieve an existing Shipping Address for a Customer.&lt;br&gt;To perform a payment with a particular Shipping Address simply specify the [Shipping Address Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Shipping Address associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ShippingAddressListForCustomerEmbeddedShippingAddressesInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCustomerShippingAddressRequestCreation(String customerId, String shippingAddressId, String profileId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling getCustomerShippingAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'shippingAddressId' is set
        if (shippingAddressId == null) {
            throw new WebClientResponseException("Missing the required parameter 'shippingAddressId' when calling getCustomerShippingAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);
        pathParams.put("shippingAddressId", shippingAddressId);

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

        ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/shipping-addresses/{shippingAddressId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Customer Shipping Address**&lt;br&gt;Your system can use this API to retrieve an existing Shipping Address for a Customer.&lt;br&gt;To perform a payment with a particular Shipping Address simply specify the [Shipping Address Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Shipping Address associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ShippingAddressListForCustomerEmbeddedShippingAddressesInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> getCustomerShippingAddress(String customerId, String shippingAddressId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>() {};
        return getCustomerShippingAddressRequestCreation(customerId, shippingAddressId, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Customer Shipping Address**&lt;br&gt;Your system can use this API to retrieve an existing Shipping Address for a Customer.&lt;br&gt;To perform a payment with a particular Shipping Address simply specify the [Shipping Address Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Shipping Address associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;ShippingAddressListForCustomerEmbeddedShippingAddressesInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>> getCustomerShippingAddressWithHttpInfo(String customerId, String shippingAddressId, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>() {};
        return getCustomerShippingAddressRequestCreation(customerId, shippingAddressId, profileId).toEntity(localVarReturnType);
    }

    /**
     * Retrieve a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving a Customer Shipping Address**&lt;br&gt;Your system can use this API to retrieve an existing Shipping Address for a Customer.&lt;br&gt;To perform a payment with a particular Shipping Address simply specify the [Shipping Address Id in the payments request](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-using-tokens_authorization-with-customer-payment-instrument-and-shipping-address-token-id_liveconsole-tab-request-body). 
     * <p><b>200</b> - Returns an existing Shipping Address associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getCustomerShippingAddressWithResponseSpec(String customerId, String shippingAddressId, String profileId) throws WebClientResponseException {
        return getCustomerShippingAddressRequestCreation(customerId, shippingAddressId, profileId);
    }
    /**
     * List Shipping Addresses for a Customer
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Customer Shipping Addresses**&lt;br&gt;Your system can use this API to retrieve all existing Shipping Addresses for a Customer. 
     * <p><b>200</b> - Returns all existing Shipping Addresses associated with the supplied Id.
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
     * @return ShippingAddressListForCustomer
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCustomerShippingAddressesListRequestCreation(String customerId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling getCustomerShippingAddressesList", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ShippingAddressListForCustomer> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomer>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/shipping-addresses", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Shipping Addresses for a Customer
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Customer Shipping Addresses**&lt;br&gt;Your system can use this API to retrieve all existing Shipping Addresses for a Customer. 
     * <p><b>200</b> - Returns all existing Shipping Addresses associated with the supplied Id.
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
     * @return ShippingAddressListForCustomer
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ShippingAddressListForCustomer> getCustomerShippingAddressesList(String customerId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        ParameterizedTypeReference<ShippingAddressListForCustomer> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomer>() {};
        return getCustomerShippingAddressesListRequestCreation(customerId, profileId, offset, limit).bodyToMono(localVarReturnType);
    }

    /**
     * List Shipping Addresses for a Customer
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Customer Shipping Addresses**&lt;br&gt;Your system can use this API to retrieve all existing Shipping Addresses for a Customer. 
     * <p><b>200</b> - Returns all existing Shipping Addresses associated with the supplied Id.
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
     * @return ResponseEntity&lt;ShippingAddressListForCustomer&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ShippingAddressListForCustomer>> getCustomerShippingAddressesListWithHttpInfo(String customerId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        ParameterizedTypeReference<ShippingAddressListForCustomer> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomer>() {};
        return getCustomerShippingAddressesListRequestCreation(customerId, profileId, offset, limit).toEntity(localVarReturnType);
    }

    /**
     * List Shipping Addresses for a Customer
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Retrieving all Customer Shipping Addresses**&lt;br&gt;Your system can use this API to retrieve all existing Shipping Addresses for a Customer. 
     * <p><b>200</b> - Returns all existing Shipping Addresses associated with the supplied Id.
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
    public ResponseSpec getCustomerShippingAddressesListWithResponseSpec(String customerId, String profileId, Long offset, Long limit) throws WebClientResponseException {
        return getCustomerShippingAddressesListRequestCreation(customerId, profileId, offset, limit);
    }
    /**
     * Update a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customers Shipping Address**&lt;br&gt;Your system can use this API to update an existing Shipping Addresses for a Customer, including selecting a [default Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address_samplerequests-dropdown_make-customer-shipping-address-the-default_liveconsole-tab-request-body) for use in payments. 
     * <p><b>200</b> - Returns an existing Shipping Address associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param patchCustomerShippingAddressRequest The patchCustomerShippingAddressRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ShippingAddressListForCustomerEmbeddedShippingAddressesInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec patchCustomersShippingAddressRequestCreation(String customerId, String shippingAddressId, ShippingAddressListForCustomerEmbeddedShippingAddressesInner patchCustomerShippingAddressRequest, String profileId, String ifMatch) throws WebClientResponseException {
        Object postBody = patchCustomerShippingAddressRequest;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling patchCustomersShippingAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'shippingAddressId' is set
        if (shippingAddressId == null) {
            throw new WebClientResponseException("Missing the required parameter 'shippingAddressId' when calling patchCustomersShippingAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'patchCustomerShippingAddressRequest' is set
        if (patchCustomerShippingAddressRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'patchCustomerShippingAddressRequest' when calling patchCustomersShippingAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("customerId", customerId);
        pathParams.put("shippingAddressId", shippingAddressId);

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

        ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/shipping-addresses/{shippingAddressId}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customers Shipping Address**&lt;br&gt;Your system can use this API to update an existing Shipping Addresses for a Customer, including selecting a [default Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address_samplerequests-dropdown_make-customer-shipping-address-the-default_liveconsole-tab-request-body) for use in payments. 
     * <p><b>200</b> - Returns an existing Shipping Address associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param patchCustomerShippingAddressRequest The patchCustomerShippingAddressRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ShippingAddressListForCustomerEmbeddedShippingAddressesInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> patchCustomersShippingAddress(String customerId, String shippingAddressId, ShippingAddressListForCustomerEmbeddedShippingAddressesInner patchCustomerShippingAddressRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>() {};
        return patchCustomersShippingAddressRequestCreation(customerId, shippingAddressId, patchCustomerShippingAddressRequest, profileId, ifMatch).bodyToMono(localVarReturnType);
    }

    /**
     * Update a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customers Shipping Address**&lt;br&gt;Your system can use this API to update an existing Shipping Addresses for a Customer, including selecting a [default Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address_samplerequests-dropdown_make-customer-shipping-address-the-default_liveconsole-tab-request-body) for use in payments. 
     * <p><b>200</b> - Returns an existing Shipping Address associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param patchCustomerShippingAddressRequest The patchCustomerShippingAddressRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseEntity&lt;ShippingAddressListForCustomerEmbeddedShippingAddressesInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>> patchCustomersShippingAddressWithHttpInfo(String customerId, String shippingAddressId, ShippingAddressListForCustomerEmbeddedShippingAddressesInner patchCustomerShippingAddressRequest, String profileId, String ifMatch) throws WebClientResponseException {
        ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>() {};
        return patchCustomersShippingAddressRequestCreation(customerId, shippingAddressId, patchCustomerShippingAddressRequest, profileId, ifMatch).toEntity(localVarReturnType);
    }

    /**
     * Update a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Updating a Customers Shipping Address**&lt;br&gt;Your system can use this API to update an existing Shipping Addresses for a Customer, including selecting a [default Shipping Address](#token-management_customer-shipping-address_update-a-customer-shipping-address_samplerequests-dropdown_make-customer-shipping-address-the-default_liveconsole-tab-request-body) for use in payments. 
     * <p><b>200</b> - Returns an existing Shipping Address associated with the supplied Id.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>412</b> - Precondition Failed: The If-Match request header value does not match the current resources ETag
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param shippingAddressId The Id of a shipping address.
     * @param patchCustomerShippingAddressRequest The patchCustomerShippingAddressRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @param ifMatch Contains an ETag value from a GET request to make the request conditional.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec patchCustomersShippingAddressWithResponseSpec(String customerId, String shippingAddressId, ShippingAddressListForCustomerEmbeddedShippingAddressesInner patchCustomerShippingAddressRequest, String profileId, String ifMatch) throws WebClientResponseException {
        return patchCustomersShippingAddressRequestCreation(customerId, shippingAddressId, patchCustomerShippingAddressRequest, profileId, ifMatch);
    }
    /**
     * Create a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Creating a Customer Shipping Address**&lt;br&gt;Your system can use this API to create an existing Customers default or non default Shipping Address.&lt;br&gt;You can also create additional Customer Shipping Addresses via the [Payments API](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Shipping Address has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param postCustomerShippingAddressRequest The postCustomerShippingAddressRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ShippingAddressListForCustomerEmbeddedShippingAddressesInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postCustomerShippingAddressRequestCreation(String customerId, ShippingAddressListForCustomerEmbeddedShippingAddressesInner postCustomerShippingAddressRequest, String profileId) throws WebClientResponseException {
        Object postBody = postCustomerShippingAddressRequest;
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new WebClientResponseException("Missing the required parameter 'customerId' when calling postCustomerShippingAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'postCustomerShippingAddressRequest' is set
        if (postCustomerShippingAddressRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'postCustomerShippingAddressRequest' when calling postCustomerShippingAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>() {};
        return apiClient.invokeAPI("/tms/v2/customers/{customerId}/shipping-addresses", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Creating a Customer Shipping Address**&lt;br&gt;Your system can use this API to create an existing Customers default or non default Shipping Address.&lt;br&gt;You can also create additional Customer Shipping Addresses via the [Payments API](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Shipping Address has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param postCustomerShippingAddressRequest The postCustomerShippingAddressRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ShippingAddressListForCustomerEmbeddedShippingAddressesInner
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> postCustomerShippingAddress(String customerId, ShippingAddressListForCustomerEmbeddedShippingAddressesInner postCustomerShippingAddressRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>() {};
        return postCustomerShippingAddressRequestCreation(customerId, postCustomerShippingAddressRequest, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Creating a Customer Shipping Address**&lt;br&gt;Your system can use this API to create an existing Customers default or non default Shipping Address.&lt;br&gt;You can also create additional Customer Shipping Addresses via the [Payments API](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Shipping Address has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param postCustomerShippingAddressRequest The postCustomerShippingAddressRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;ShippingAddressListForCustomerEmbeddedShippingAddressesInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>> postCustomerShippingAddressWithHttpInfo(String customerId, ShippingAddressListForCustomerEmbeddedShippingAddressesInner postCustomerShippingAddressRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner> localVarReturnType = new ParameterizedTypeReference<ShippingAddressListForCustomerEmbeddedShippingAddressesInner>() {};
        return postCustomerShippingAddressRequestCreation(customerId, postCustomerShippingAddressRequest, profileId).toEntity(localVarReturnType);
    }

    /**
     * Create a Customer Shipping Address
     * |  |  |  | | --- | --- | --- | |**Customer Shipping Address**&lt;br&gt;A Customer Shipping Address represents tokenized customer shipping information.&lt;br&gt;A [Customer](#token-management_customer_create-a-customer) can have [one or more Shipping Addresses](#token-management_customer-shipping-address_list-shipping-addresses-for-a-customer), with one allocated as the Customers default for use in payments.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Creating a Customer Shipping Address**&lt;br&gt;Your system can use this API to create an existing Customers default or non default Shipping Address.&lt;br&gt;You can also create additional Customer Shipping Addresses via the [Payments API](#payments_payments_process-a-payment_samplerequests-dropdown_authorization-with-token-create_authorization-create-default-payment-instrument-shipping-address-for-existing-customer_liveconsole-tab-request-body). 
     * <p><b>201</b> - A new Shipping Address has been created.
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>409</b> - Conflict. The token is linked to a Payment Instrument.
     * <p><b>424</b> - Failed Dependency: e.g. The profile represented by the profile-id may not exist or the profile-id was entered incorrectly.
     * <p><b>500</b> - Unexpected error.
     * @param customerId The Id of a Customer.
     * @param postCustomerShippingAddressRequest The postCustomerShippingAddressRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postCustomerShippingAddressWithResponseSpec(String customerId, ShippingAddressListForCustomerEmbeddedShippingAddressesInner postCustomerShippingAddressRequest, String profileId) throws WebClientResponseException {
        return postCustomerShippingAddressRequestCreation(customerId, postCustomerShippingAddressRequest, profileId);
    }
}
