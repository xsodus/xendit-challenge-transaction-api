package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateWebhookSubscription201Response;
import org.openapitools.client.model.CreateWebhookSubscriptionRequest;
import org.openapitools.client.model.FindProductsToSubscribe200ResponseInner;
import org.openapitools.client.model.SaveSymEgressKey201Response;
import org.openapitools.client.model.SaveSymEgressKeyRequest;

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
public class CreateNewWebhooksApi {
    private ApiClient apiClient;

    public CreateNewWebhooksApi() {
        this(new ApiClient());
    }

    @Autowired
    public CreateNewWebhooksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Webhook
     * Create a new webhook subscription. Before creating a webhook, ensure that a security key has been created at the top of this developer center section. You will not need to pass us back the key during the creation of the webhook, but you will receive an error if you did not already create a key or store one on file. 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server error
     * @param createWebhookRequest The webhook payload
     * @return CreateWebhookSubscription201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createWebhookSubscriptionRequestCreation(CreateWebhookSubscriptionRequest createWebhookRequest) throws WebClientResponseException {
        Object postBody = createWebhookRequest;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<CreateWebhookSubscription201Response> localVarReturnType = new ParameterizedTypeReference<CreateWebhookSubscription201Response>() {};
        return apiClient.invokeAPI("/notification-subscriptions/v1/webhooks", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Webhook
     * Create a new webhook subscription. Before creating a webhook, ensure that a security key has been created at the top of this developer center section. You will not need to pass us back the key during the creation of the webhook, but you will receive an error if you did not already create a key or store one on file. 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server error
     * @param createWebhookRequest The webhook payload
     * @return CreateWebhookSubscription201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CreateWebhookSubscription201Response> createWebhookSubscription(CreateWebhookSubscriptionRequest createWebhookRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CreateWebhookSubscription201Response> localVarReturnType = new ParameterizedTypeReference<CreateWebhookSubscription201Response>() {};
        return createWebhookSubscriptionRequestCreation(createWebhookRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Webhook
     * Create a new webhook subscription. Before creating a webhook, ensure that a security key has been created at the top of this developer center section. You will not need to pass us back the key during the creation of the webhook, but you will receive an error if you did not already create a key or store one on file. 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server error
     * @param createWebhookRequest The webhook payload
     * @return ResponseEntity&lt;CreateWebhookSubscription201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<CreateWebhookSubscription201Response>> createWebhookSubscriptionWithHttpInfo(CreateWebhookSubscriptionRequest createWebhookRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CreateWebhookSubscription201Response> localVarReturnType = new ParameterizedTypeReference<CreateWebhookSubscription201Response>() {};
        return createWebhookSubscriptionRequestCreation(createWebhookRequest).toEntity(localVarReturnType);
    }

    /**
     * Create a Webhook
     * Create a new webhook subscription. Before creating a webhook, ensure that a security key has been created at the top of this developer center section. You will not need to pass us back the key during the creation of the webhook, but you will receive an error if you did not already create a key or store one on file. 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server error
     * @param createWebhookRequest The webhook payload
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createWebhookSubscriptionWithResponseSpec(CreateWebhookSubscriptionRequest createWebhookRequest) throws WebClientResponseException {
        return createWebhookSubscriptionRequestCreation(createWebhookRequest);
    }
    /**
     * Find Products You Can Subscribe To
     * Retrieve a list of products and event types that your account is eligible for. These products and events are the ones that you may subscribe to in the next step of creating webhooks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param organizationId The Organization Identifier.
     * @return List&lt;FindProductsToSubscribe200ResponseInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec findProductsToSubscribeRequestCreation(String organizationId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new WebClientResponseException("Missing the required parameter 'organizationId' when calling findProductsToSubscribe", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("organizationId", organizationId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<FindProductsToSubscribe200ResponseInner> localVarReturnType = new ParameterizedTypeReference<FindProductsToSubscribe200ResponseInner>() {};
        return apiClient.invokeAPI("/notification-subscriptions/v1/products/{organizationId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Find Products You Can Subscribe To
     * Retrieve a list of products and event types that your account is eligible for. These products and events are the ones that you may subscribe to in the next step of creating webhooks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param organizationId The Organization Identifier.
     * @return List&lt;FindProductsToSubscribe200ResponseInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<FindProductsToSubscribe200ResponseInner> findProductsToSubscribe(String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<FindProductsToSubscribe200ResponseInner> localVarReturnType = new ParameterizedTypeReference<FindProductsToSubscribe200ResponseInner>() {};
        return findProductsToSubscribeRequestCreation(organizationId).bodyToFlux(localVarReturnType);
    }

    /**
     * Find Products You Can Subscribe To
     * Retrieve a list of products and event types that your account is eligible for. These products and events are the ones that you may subscribe to in the next step of creating webhooks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param organizationId The Organization Identifier.
     * @return ResponseEntity&lt;List&lt;FindProductsToSubscribe200ResponseInner&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<List<FindProductsToSubscribe200ResponseInner>>> findProductsToSubscribeWithHttpInfo(String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<FindProductsToSubscribe200ResponseInner> localVarReturnType = new ParameterizedTypeReference<FindProductsToSubscribe200ResponseInner>() {};
        return findProductsToSubscribeRequestCreation(organizationId).toEntityList(localVarReturnType);
    }

    /**
     * Find Products You Can Subscribe To
     * Retrieve a list of products and event types that your account is eligible for. These products and events are the ones that you may subscribe to in the next step of creating webhooks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param organizationId The Organization Identifier.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec findProductsToSubscribeWithResponseSpec(String organizationId) throws WebClientResponseException {
        return findProductsToSubscribeRequestCreation(organizationId);
    }
    /**
     * Create Webhook Security Keys
     * Create security keys that CyberSource will use internally to connect to your servers and validate messages using a digital signature.  Select the CREATE example for CyberSource to generate the key on our server and maintain it for you as well. Remeber to save the key in the API response, so that you can use it to validate messages later. 
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized Request
     * <p><b>502</b> - Unexpected system error or system timeout
     * @param vCSenderOrganizationId Sender organization id
     * @param vCPermissions Encoded user permissions returned by the CGK, for the entity user who initiated the boarding
     * @param vCCorrelationId A globally unique id associated with your request
     * @param saveSymEgressKey Provide egress Symmetric key information to save (create or store or refresh)
     * @return SaveSymEgressKey201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec saveSymEgressKeyRequestCreation(String vCSenderOrganizationId, String vCPermissions, String vCCorrelationId, SaveSymEgressKeyRequest saveSymEgressKey) throws WebClientResponseException {
        Object postBody = saveSymEgressKey;
        // verify the required parameter 'vCSenderOrganizationId' is set
        if (vCSenderOrganizationId == null) {
            throw new WebClientResponseException("Missing the required parameter 'vCSenderOrganizationId' when calling saveSymEgressKey", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'vCPermissions' is set
        if (vCPermissions == null) {
            throw new WebClientResponseException("Missing the required parameter 'vCPermissions' when calling saveSymEgressKey", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();


        if (vCCorrelationId != null)
        headerParams.add("v-c-correlation-id", apiClient.parameterToString(vCCorrelationId));
        if (vCSenderOrganizationId != null)
        headerParams.add("v-c-sender-organization-id", apiClient.parameterToString(vCSenderOrganizationId));
        if (vCPermissions != null)
        headerParams.add("v-c-permissions", apiClient.parameterToString(vCPermissions));
        final String[] localVarAccepts = { 
            "application/json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<SaveSymEgressKey201Response> localVarReturnType = new ParameterizedTypeReference<SaveSymEgressKey201Response>() {};
        return apiClient.invokeAPI("/kms/egress/v2/keys-sym", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Webhook Security Keys
     * Create security keys that CyberSource will use internally to connect to your servers and validate messages using a digital signature.  Select the CREATE example for CyberSource to generate the key on our server and maintain it for you as well. Remeber to save the key in the API response, so that you can use it to validate messages later. 
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized Request
     * <p><b>502</b> - Unexpected system error or system timeout
     * @param vCSenderOrganizationId Sender organization id
     * @param vCPermissions Encoded user permissions returned by the CGK, for the entity user who initiated the boarding
     * @param vCCorrelationId A globally unique id associated with your request
     * @param saveSymEgressKey Provide egress Symmetric key information to save (create or store or refresh)
     * @return SaveSymEgressKey201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SaveSymEgressKey201Response> saveSymEgressKey(String vCSenderOrganizationId, String vCPermissions, String vCCorrelationId, SaveSymEgressKeyRequest saveSymEgressKey) throws WebClientResponseException {
        ParameterizedTypeReference<SaveSymEgressKey201Response> localVarReturnType = new ParameterizedTypeReference<SaveSymEgressKey201Response>() {};
        return saveSymEgressKeyRequestCreation(vCSenderOrganizationId, vCPermissions, vCCorrelationId, saveSymEgressKey).bodyToMono(localVarReturnType);
    }

    /**
     * Create Webhook Security Keys
     * Create security keys that CyberSource will use internally to connect to your servers and validate messages using a digital signature.  Select the CREATE example for CyberSource to generate the key on our server and maintain it for you as well. Remeber to save the key in the API response, so that you can use it to validate messages later. 
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized Request
     * <p><b>502</b> - Unexpected system error or system timeout
     * @param vCSenderOrganizationId Sender organization id
     * @param vCPermissions Encoded user permissions returned by the CGK, for the entity user who initiated the boarding
     * @param vCCorrelationId A globally unique id associated with your request
     * @param saveSymEgressKey Provide egress Symmetric key information to save (create or store or refresh)
     * @return ResponseEntity&lt;SaveSymEgressKey201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<SaveSymEgressKey201Response>> saveSymEgressKeyWithHttpInfo(String vCSenderOrganizationId, String vCPermissions, String vCCorrelationId, SaveSymEgressKeyRequest saveSymEgressKey) throws WebClientResponseException {
        ParameterizedTypeReference<SaveSymEgressKey201Response> localVarReturnType = new ParameterizedTypeReference<SaveSymEgressKey201Response>() {};
        return saveSymEgressKeyRequestCreation(vCSenderOrganizationId, vCPermissions, vCCorrelationId, saveSymEgressKey).toEntity(localVarReturnType);
    }

    /**
     * Create Webhook Security Keys
     * Create security keys that CyberSource will use internally to connect to your servers and validate messages using a digital signature.  Select the CREATE example for CyberSource to generate the key on our server and maintain it for you as well. Remeber to save the key in the API response, so that you can use it to validate messages later. 
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized Request
     * <p><b>502</b> - Unexpected system error or system timeout
     * @param vCSenderOrganizationId Sender organization id
     * @param vCPermissions Encoded user permissions returned by the CGK, for the entity user who initiated the boarding
     * @param vCCorrelationId A globally unique id associated with your request
     * @param saveSymEgressKey Provide egress Symmetric key information to save (create or store or refresh)
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec saveSymEgressKeyWithResponseSpec(String vCSenderOrganizationId, String vCPermissions, String vCCorrelationId, SaveSymEgressKeyRequest saveSymEgressKey) throws WebClientResponseException {
        return saveSymEgressKeyRequestCreation(vCSenderOrganizationId, vCPermissions, vCCorrelationId, saveSymEgressKey);
    }
}
