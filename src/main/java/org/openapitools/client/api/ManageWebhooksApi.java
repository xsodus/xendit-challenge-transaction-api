package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetWebhookSubscriptionById200Response;
import org.openapitools.client.model.GetWebhookSubscriptionsByOrg200ResponseInner;
import org.openapitools.client.model.SaveAsymEgressKey201Response;
import org.openapitools.client.model.SaveAsymEgressKeyRequest;
import org.openapitools.client.model.UpdateWebhookSubscription404Response;
import org.openapitools.client.model.UpdateWebhookSubscriptionRequest;

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
public class ManageWebhooksApi {
    private ApiClient apiClient;

    public ManageWebhooksApi() {
        this(new ApiClient());
    }

    @Autowired
    public ManageWebhooksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a Webhook Subscription
     * Delete the webhook. Please note that deleting a particular webhook does not delete the history of the webhook notifications.
     * <p><b>200</b> - Ok
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook identifier.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteWebhookSubscriptionRequestCreation(String webhookId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new WebClientResponseException("Missing the required parameter 'webhookId' when calling deleteWebhookSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("webhookId", webhookId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/notification-subscriptions/v1/webhooks/{webhookId}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Webhook Subscription
     * Delete the webhook. Please note that deleting a particular webhook does not delete the history of the webhook notifications.
     * <p><b>200</b> - Ok
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook identifier.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteWebhookSubscription(String webhookId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteWebhookSubscriptionRequestCreation(webhookId).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a Webhook Subscription
     * Delete the webhook. Please note that deleting a particular webhook does not delete the history of the webhook notifications.
     * <p><b>200</b> - Ok
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook identifier.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> deleteWebhookSubscriptionWithHttpInfo(String webhookId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteWebhookSubscriptionRequestCreation(webhookId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Webhook Subscription
     * Delete the webhook. Please note that deleting a particular webhook does not delete the history of the webhook notifications.
     * <p><b>200</b> - Ok
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook identifier.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteWebhookSubscriptionWithResponseSpec(String webhookId) throws WebClientResponseException {
        return deleteWebhookSubscriptionRequestCreation(webhookId);
    }
    /**
     * Get Details On a Single Webhook
     * Retrieve the details of a specific webhook by supplying the webhook ID in the path.
     * <p><b>200</b> - Ok
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook Identifier
     * @return GetWebhookSubscriptionById200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getWebhookSubscriptionByIdRequestCreation(String webhookId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new WebClientResponseException("Missing the required parameter 'webhookId' when calling getWebhookSubscriptionById", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("webhookId", webhookId);

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

        ParameterizedTypeReference<GetWebhookSubscriptionById200Response> localVarReturnType = new ParameterizedTypeReference<GetWebhookSubscriptionById200Response>() {};
        return apiClient.invokeAPI("/notification-subscriptions/v1/webhooks/{webhookId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Details On a Single Webhook
     * Retrieve the details of a specific webhook by supplying the webhook ID in the path.
     * <p><b>200</b> - Ok
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook Identifier
     * @return GetWebhookSubscriptionById200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetWebhookSubscriptionById200Response> getWebhookSubscriptionById(String webhookId) throws WebClientResponseException {
        ParameterizedTypeReference<GetWebhookSubscriptionById200Response> localVarReturnType = new ParameterizedTypeReference<GetWebhookSubscriptionById200Response>() {};
        return getWebhookSubscriptionByIdRequestCreation(webhookId).bodyToMono(localVarReturnType);
    }

    /**
     * Get Details On a Single Webhook
     * Retrieve the details of a specific webhook by supplying the webhook ID in the path.
     * <p><b>200</b> - Ok
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook Identifier
     * @return ResponseEntity&lt;GetWebhookSubscriptionById200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetWebhookSubscriptionById200Response>> getWebhookSubscriptionByIdWithHttpInfo(String webhookId) throws WebClientResponseException {
        ParameterizedTypeReference<GetWebhookSubscriptionById200Response> localVarReturnType = new ParameterizedTypeReference<GetWebhookSubscriptionById200Response>() {};
        return getWebhookSubscriptionByIdRequestCreation(webhookId).toEntity(localVarReturnType);
    }

    /**
     * Get Details On a Single Webhook
     * Retrieve the details of a specific webhook by supplying the webhook ID in the path.
     * <p><b>200</b> - Ok
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook Identifier
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getWebhookSubscriptionByIdWithResponseSpec(String webhookId) throws WebClientResponseException {
        return getWebhookSubscriptionByIdRequestCreation(webhookId);
    }
    /**
     * Get Details On All Created Webhooks
     * Retrieve a list of all previously created webhooks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server error
     * @param organizationId The Organization Identifier.
     * @param productId The Product Identifier.
     * @param eventType The Event Type.
     * @return List&lt;GetWebhookSubscriptionsByOrg200ResponseInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getWebhookSubscriptionsByOrgRequestCreation(String organizationId, String productId, String eventType) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new WebClientResponseException("Missing the required parameter 'organizationId' when calling getWebhookSubscriptionsByOrg", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'productId' is set
        if (productId == null) {
            throw new WebClientResponseException("Missing the required parameter 'productId' when calling getWebhookSubscriptionsByOrg", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'eventType' is set
        if (eventType == null) {
            throw new WebClientResponseException("Missing the required parameter 'eventType' when calling getWebhookSubscriptionsByOrg", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "productId", productId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "eventType", eventType));
        
        final String[] localVarAccepts = { 
            "application/json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetWebhookSubscriptionsByOrg200ResponseInner> localVarReturnType = new ParameterizedTypeReference<GetWebhookSubscriptionsByOrg200ResponseInner>() {};
        return apiClient.invokeAPI("/notification-subscriptions/v1/webhooks", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Details On All Created Webhooks
     * Retrieve a list of all previously created webhooks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server error
     * @param organizationId The Organization Identifier.
     * @param productId The Product Identifier.
     * @param eventType The Event Type.
     * @return List&lt;GetWebhookSubscriptionsByOrg200ResponseInner&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Flux<GetWebhookSubscriptionsByOrg200ResponseInner> getWebhookSubscriptionsByOrg(String organizationId, String productId, String eventType) throws WebClientResponseException {
        ParameterizedTypeReference<GetWebhookSubscriptionsByOrg200ResponseInner> localVarReturnType = new ParameterizedTypeReference<GetWebhookSubscriptionsByOrg200ResponseInner>() {};
        return getWebhookSubscriptionsByOrgRequestCreation(organizationId, productId, eventType).bodyToFlux(localVarReturnType);
    }

    /**
     * Get Details On All Created Webhooks
     * Retrieve a list of all previously created webhooks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server error
     * @param organizationId The Organization Identifier.
     * @param productId The Product Identifier.
     * @param eventType The Event Type.
     * @return ResponseEntity&lt;List&lt;GetWebhookSubscriptionsByOrg200ResponseInner&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<List<GetWebhookSubscriptionsByOrg200ResponseInner>>> getWebhookSubscriptionsByOrgWithHttpInfo(String organizationId, String productId, String eventType) throws WebClientResponseException {
        ParameterizedTypeReference<GetWebhookSubscriptionsByOrg200ResponseInner> localVarReturnType = new ParameterizedTypeReference<GetWebhookSubscriptionsByOrg200ResponseInner>() {};
        return getWebhookSubscriptionsByOrgRequestCreation(organizationId, productId, eventType).toEntityList(localVarReturnType);
    }

    /**
     * Get Details On All Created Webhooks
     * Retrieve a list of all previously created webhooks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server error
     * @param organizationId The Organization Identifier.
     * @param productId The Product Identifier.
     * @param eventType The Event Type.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getWebhookSubscriptionsByOrgWithResponseSpec(String organizationId, String productId, String eventType) throws WebClientResponseException {
        return getWebhookSubscriptionsByOrgRequestCreation(organizationId, productId, eventType);
    }
    /**
     * Message Level Encryption
     * Store and manage certificates that will be used to preform Message Level Encryption (MLE). Each new webhook will need its own unique asymmetric certificate. You can either use a digital certificate issued/signed by a CA or self-sign your own using the documentation available on the Developer Guide. 
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized Request
     * <p><b>502</b> - Unexpected system error or system timeout
     * @param vCSenderOrganizationId Sender organization id
     * @param vCPermissions Encoded user permissions returned by the CGK, for the entity user who initiated the boarding
     * @param saveAsymEgressKey Provide egress Asymmetric key information to save (create or store)
     * @param vCCorrelationId A globally unique id associated with your request
     * @return SaveAsymEgressKey201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec saveAsymEgressKeyRequestCreation(String vCSenderOrganizationId, String vCPermissions, SaveAsymEgressKeyRequest saveAsymEgressKey, String vCCorrelationId) throws WebClientResponseException {
        Object postBody = saveAsymEgressKey;
        // verify the required parameter 'vCSenderOrganizationId' is set
        if (vCSenderOrganizationId == null) {
            throw new WebClientResponseException("Missing the required parameter 'vCSenderOrganizationId' when calling saveAsymEgressKey", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'vCPermissions' is set
        if (vCPermissions == null) {
            throw new WebClientResponseException("Missing the required parameter 'vCPermissions' when calling saveAsymEgressKey", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'saveAsymEgressKey' is set
        if (saveAsymEgressKey == null) {
            throw new WebClientResponseException("Missing the required parameter 'saveAsymEgressKey' when calling saveAsymEgressKey", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<SaveAsymEgressKey201Response> localVarReturnType = new ParameterizedTypeReference<SaveAsymEgressKey201Response>() {};
        return apiClient.invokeAPI("/kms/egress/v2/keys-asym", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Message Level Encryption
     * Store and manage certificates that will be used to preform Message Level Encryption (MLE). Each new webhook will need its own unique asymmetric certificate. You can either use a digital certificate issued/signed by a CA or self-sign your own using the documentation available on the Developer Guide. 
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized Request
     * <p><b>502</b> - Unexpected system error or system timeout
     * @param vCSenderOrganizationId Sender organization id
     * @param vCPermissions Encoded user permissions returned by the CGK, for the entity user who initiated the boarding
     * @param saveAsymEgressKey Provide egress Asymmetric key information to save (create or store)
     * @param vCCorrelationId A globally unique id associated with your request
     * @return SaveAsymEgressKey201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SaveAsymEgressKey201Response> saveAsymEgressKey(String vCSenderOrganizationId, String vCPermissions, SaveAsymEgressKeyRequest saveAsymEgressKey, String vCCorrelationId) throws WebClientResponseException {
        ParameterizedTypeReference<SaveAsymEgressKey201Response> localVarReturnType = new ParameterizedTypeReference<SaveAsymEgressKey201Response>() {};
        return saveAsymEgressKeyRequestCreation(vCSenderOrganizationId, vCPermissions, saveAsymEgressKey, vCCorrelationId).bodyToMono(localVarReturnType);
    }

    /**
     * Message Level Encryption
     * Store and manage certificates that will be used to preform Message Level Encryption (MLE). Each new webhook will need its own unique asymmetric certificate. You can either use a digital certificate issued/signed by a CA or self-sign your own using the documentation available on the Developer Guide. 
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized Request
     * <p><b>502</b> - Unexpected system error or system timeout
     * @param vCSenderOrganizationId Sender organization id
     * @param vCPermissions Encoded user permissions returned by the CGK, for the entity user who initiated the boarding
     * @param saveAsymEgressKey Provide egress Asymmetric key information to save (create or store)
     * @param vCCorrelationId A globally unique id associated with your request
     * @return ResponseEntity&lt;SaveAsymEgressKey201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<SaveAsymEgressKey201Response>> saveAsymEgressKeyWithHttpInfo(String vCSenderOrganizationId, String vCPermissions, SaveAsymEgressKeyRequest saveAsymEgressKey, String vCCorrelationId) throws WebClientResponseException {
        ParameterizedTypeReference<SaveAsymEgressKey201Response> localVarReturnType = new ParameterizedTypeReference<SaveAsymEgressKey201Response>() {};
        return saveAsymEgressKeyRequestCreation(vCSenderOrganizationId, vCPermissions, saveAsymEgressKey, vCCorrelationId).toEntity(localVarReturnType);
    }

    /**
     * Message Level Encryption
     * Store and manage certificates that will be used to preform Message Level Encryption (MLE). Each new webhook will need its own unique asymmetric certificate. You can either use a digital certificate issued/signed by a CA or self-sign your own using the documentation available on the Developer Guide. 
     * <p><b>201</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized Request
     * <p><b>502</b> - Unexpected system error or system timeout
     * @param vCSenderOrganizationId Sender organization id
     * @param vCPermissions Encoded user permissions returned by the CGK, for the entity user who initiated the boarding
     * @param saveAsymEgressKey Provide egress Asymmetric key information to save (create or store)
     * @param vCCorrelationId A globally unique id associated with your request
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec saveAsymEgressKeyWithResponseSpec(String vCSenderOrganizationId, String vCPermissions, SaveAsymEgressKeyRequest saveAsymEgressKey, String vCCorrelationId) throws WebClientResponseException {
        return saveAsymEgressKeyRequestCreation(vCSenderOrganizationId, vCPermissions, saveAsymEgressKey, vCCorrelationId);
    }
    /**
     * Update a Webhook Subscription
     * Update the webhook subscription using PATCH.
     * <p><b>200</b> - Updated
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The Webhook Identifier.
     * @param updateWebhookRequest The webhook payload or changes to apply.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateWebhookSubscriptionRequestCreation(String webhookId, UpdateWebhookSubscriptionRequest updateWebhookRequest) throws WebClientResponseException {
        Object postBody = updateWebhookRequest;
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new WebClientResponseException("Missing the required parameter 'webhookId' when calling updateWebhookSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("webhookId", webhookId);

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

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/notification-subscriptions/v1/webhooks/{webhookId}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Webhook Subscription
     * Update the webhook subscription using PATCH.
     * <p><b>200</b> - Updated
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The Webhook Identifier.
     * @param updateWebhookRequest The webhook payload or changes to apply.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> updateWebhookSubscription(String webhookId, UpdateWebhookSubscriptionRequest updateWebhookRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return updateWebhookSubscriptionRequestCreation(webhookId, updateWebhookRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Update a Webhook Subscription
     * Update the webhook subscription using PATCH.
     * <p><b>200</b> - Updated
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The Webhook Identifier.
     * @param updateWebhookRequest The webhook payload or changes to apply.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> updateWebhookSubscriptionWithHttpInfo(String webhookId, UpdateWebhookSubscriptionRequest updateWebhookRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return updateWebhookSubscriptionRequestCreation(webhookId, updateWebhookRequest).toEntity(localVarReturnType);
    }

    /**
     * Update a Webhook Subscription
     * Update the webhook subscription using PATCH.
     * <p><b>200</b> - Updated
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not found
     * <p><b>500</b> - Server error
     * @param webhookId The Webhook Identifier.
     * @param updateWebhookRequest The webhook payload or changes to apply.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateWebhookSubscriptionWithResponseSpec(String webhookId, UpdateWebhookSubscriptionRequest updateWebhookRequest) throws WebClientResponseException {
        return updateWebhookSubscriptionRequestCreation(webhookId, updateWebhookRequest);
    }
}
