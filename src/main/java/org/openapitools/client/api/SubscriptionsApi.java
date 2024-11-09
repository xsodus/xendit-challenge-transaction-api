package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ActivateSubscriptionResponse;
import org.openapitools.client.model.CancelSubscriptionResponse;
import org.openapitools.client.model.CreateSubscription400Response;
import org.openapitools.client.model.CreateSubscriptionRequest;
import org.openapitools.client.model.CreateSubscriptionResponse;
import org.openapitools.client.model.GetAllSubscriptionsResponse;
import org.openapitools.client.model.GetPlan404Response;
import org.openapitools.client.model.GetPlans400Response;
import org.openapitools.client.model.GetPlans502Response;
import org.openapitools.client.model.GetSubscriptionCodeResponse;
import org.openapitools.client.model.GetSubscriptionResponse;
import org.openapitools.client.model.SuspendSubscriptionResponse;
import org.openapitools.client.model.UpdateSubscriptionRequest;
import org.openapitools.client.model.UpdateSubscriptionResponse;

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
public class SubscriptionsApi {
    private ApiClient apiClient;

    public SubscriptionsApi() {
        this(new ApiClient());
    }

    @Autowired
    public SubscriptionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Activate a Subscription
     * Activate a &#x60;CANCELLED&#x60; Or &#x60;SUSPENDED&#x60; Subscription 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ActivateSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec activateSubscriptionRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling activateSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ActivateSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<ActivateSubscriptionResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/subscriptions/{id}/activate", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Activate a Subscription
     * Activate a &#x60;CANCELLED&#x60; Or &#x60;SUSPENDED&#x60; Subscription 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ActivateSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ActivateSubscriptionResponse> activateSubscription(String id) throws WebClientResponseException {
        ParameterizedTypeReference<ActivateSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<ActivateSubscriptionResponse>() {};
        return activateSubscriptionRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Activate a Subscription
     * Activate a &#x60;CANCELLED&#x60; Or &#x60;SUSPENDED&#x60; Subscription 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ResponseEntity&lt;ActivateSubscriptionResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ActivateSubscriptionResponse>> activateSubscriptionWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<ActivateSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<ActivateSubscriptionResponse>() {};
        return activateSubscriptionRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Activate a Subscription
     * Activate a &#x60;CANCELLED&#x60; Or &#x60;SUSPENDED&#x60; Subscription 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec activateSubscriptionWithResponseSpec(String id) throws WebClientResponseException {
        return activateSubscriptionRequestCreation(id);
    }
    /**
     * Cancel a Subscription
     * Cancel a Subscription
     * <p><b>202</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return CancelSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec cancelSubscriptionRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling cancelSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<CancelSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<CancelSubscriptionResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/subscriptions/{id}/cancel", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Cancel a Subscription
     * Cancel a Subscription
     * <p><b>202</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return CancelSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CancelSubscriptionResponse> cancelSubscription(String id) throws WebClientResponseException {
        ParameterizedTypeReference<CancelSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<CancelSubscriptionResponse>() {};
        return cancelSubscriptionRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Cancel a Subscription
     * Cancel a Subscription
     * <p><b>202</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ResponseEntity&lt;CancelSubscriptionResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<CancelSubscriptionResponse>> cancelSubscriptionWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<CancelSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<CancelSubscriptionResponse>() {};
        return cancelSubscriptionRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Cancel a Subscription
     * Cancel a Subscription
     * <p><b>202</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec cancelSubscriptionWithResponseSpec(String id) throws WebClientResponseException {
        return cancelSubscriptionRequestCreation(id);
    }
    /**
     * Create a Subscription
     * Create a Recurring Billing Subscription
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSubscriptionRequest The createSubscriptionRequest parameter
     * @return CreateSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createSubscriptionRequestCreation(CreateSubscriptionRequest createSubscriptionRequest) throws WebClientResponseException {
        Object postBody = createSubscriptionRequest;
        // verify the required parameter 'createSubscriptionRequest' is set
        if (createSubscriptionRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'createSubscriptionRequest' when calling createSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<CreateSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<CreateSubscriptionResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/subscriptions", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Subscription
     * Create a Recurring Billing Subscription
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSubscriptionRequest The createSubscriptionRequest parameter
     * @return CreateSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CreateSubscriptionResponse> createSubscription(CreateSubscriptionRequest createSubscriptionRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CreateSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<CreateSubscriptionResponse>() {};
        return createSubscriptionRequestCreation(createSubscriptionRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Subscription
     * Create a Recurring Billing Subscription
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSubscriptionRequest The createSubscriptionRequest parameter
     * @return ResponseEntity&lt;CreateSubscriptionResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<CreateSubscriptionResponse>> createSubscriptionWithHttpInfo(CreateSubscriptionRequest createSubscriptionRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CreateSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<CreateSubscriptionResponse>() {};
        return createSubscriptionRequestCreation(createSubscriptionRequest).toEntity(localVarReturnType);
    }

    /**
     * Create a Subscription
     * Create a Recurring Billing Subscription
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSubscriptionRequest The createSubscriptionRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createSubscriptionWithResponseSpec(CreateSubscriptionRequest createSubscriptionRequest) throws WebClientResponseException {
        return createSubscriptionRequestCreation(createSubscriptionRequest);
    }
    /**
     * Get a List of Subscriptions
     * Retrieve Subscriptions by Subscription Code &amp; Subscription Status. 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param offset Page offset number.
     * @param limit Number of items to be returned. Default - &#x60;20&#x60;, Max - &#x60;100&#x60; 
     * @param code Filter by Subscription Code
     * @param status Filter by Subscription Status
     * @return GetAllSubscriptionsResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getAllSubscriptionsRequestCreation(Integer offset, Integer limit, String code, String status) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "code", code));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        
        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetAllSubscriptionsResponse> localVarReturnType = new ParameterizedTypeReference<GetAllSubscriptionsResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/subscriptions", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a List of Subscriptions
     * Retrieve Subscriptions by Subscription Code &amp; Subscription Status. 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param offset Page offset number.
     * @param limit Number of items to be returned. Default - &#x60;20&#x60;, Max - &#x60;100&#x60; 
     * @param code Filter by Subscription Code
     * @param status Filter by Subscription Status
     * @return GetAllSubscriptionsResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetAllSubscriptionsResponse> getAllSubscriptions(Integer offset, Integer limit, String code, String status) throws WebClientResponseException {
        ParameterizedTypeReference<GetAllSubscriptionsResponse> localVarReturnType = new ParameterizedTypeReference<GetAllSubscriptionsResponse>() {};
        return getAllSubscriptionsRequestCreation(offset, limit, code, status).bodyToMono(localVarReturnType);
    }

    /**
     * Get a List of Subscriptions
     * Retrieve Subscriptions by Subscription Code &amp; Subscription Status. 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param offset Page offset number.
     * @param limit Number of items to be returned. Default - &#x60;20&#x60;, Max - &#x60;100&#x60; 
     * @param code Filter by Subscription Code
     * @param status Filter by Subscription Status
     * @return ResponseEntity&lt;GetAllSubscriptionsResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetAllSubscriptionsResponse>> getAllSubscriptionsWithHttpInfo(Integer offset, Integer limit, String code, String status) throws WebClientResponseException {
        ParameterizedTypeReference<GetAllSubscriptionsResponse> localVarReturnType = new ParameterizedTypeReference<GetAllSubscriptionsResponse>() {};
        return getAllSubscriptionsRequestCreation(offset, limit, code, status).toEntity(localVarReturnType);
    }

    /**
     * Get a List of Subscriptions
     * Retrieve Subscriptions by Subscription Code &amp; Subscription Status. 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param offset Page offset number.
     * @param limit Number of items to be returned. Default - &#x60;20&#x60;, Max - &#x60;100&#x60; 
     * @param code Filter by Subscription Code
     * @param status Filter by Subscription Status
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getAllSubscriptionsWithResponseSpec(Integer offset, Integer limit, String code, String status) throws WebClientResponseException {
        return getAllSubscriptionsRequestCreation(offset, limit, code, status);
    }
    /**
     * Get a Subscription
     * Get a Subscription by Subscription Id
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return GetSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSubscriptionRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<GetSubscriptionResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/subscriptions/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Subscription
     * Get a Subscription by Subscription Id
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return GetSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetSubscriptionResponse> getSubscription(String id) throws WebClientResponseException {
        ParameterizedTypeReference<GetSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<GetSubscriptionResponse>() {};
        return getSubscriptionRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Get a Subscription
     * Get a Subscription by Subscription Id
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ResponseEntity&lt;GetSubscriptionResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetSubscriptionResponse>> getSubscriptionWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<GetSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<GetSubscriptionResponse>() {};
        return getSubscriptionRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Subscription
     * Get a Subscription by Subscription Id
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getSubscriptionWithResponseSpec(String id) throws WebClientResponseException {
        return getSubscriptionRequestCreation(id);
    }
    /**
     * Get a Subscription Code
     * Get a Unique Subscription Code
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @return GetSubscriptionCodeResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSubscriptionCodeRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetSubscriptionCodeResponse> localVarReturnType = new ParameterizedTypeReference<GetSubscriptionCodeResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/subscriptions/code", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Subscription Code
     * Get a Unique Subscription Code
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @return GetSubscriptionCodeResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetSubscriptionCodeResponse> getSubscriptionCode() throws WebClientResponseException {
        ParameterizedTypeReference<GetSubscriptionCodeResponse> localVarReturnType = new ParameterizedTypeReference<GetSubscriptionCodeResponse>() {};
        return getSubscriptionCodeRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Get a Subscription Code
     * Get a Unique Subscription Code
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @return ResponseEntity&lt;GetSubscriptionCodeResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetSubscriptionCodeResponse>> getSubscriptionCodeWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<GetSubscriptionCodeResponse> localVarReturnType = new ParameterizedTypeReference<GetSubscriptionCodeResponse>() {};
        return getSubscriptionCodeRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Get a Subscription Code
     * Get a Unique Subscription Code
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getSubscriptionCodeWithResponseSpec() throws WebClientResponseException {
        return getSubscriptionCodeRequestCreation();
    }
    /**
     * Suspend a Subscription
     * Suspend a Subscription
     * <p><b>202</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return SuspendSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec suspendSubscriptionRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling suspendSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<SuspendSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<SuspendSubscriptionResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/subscriptions/{id}/suspend", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Suspend a Subscription
     * Suspend a Subscription
     * <p><b>202</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return SuspendSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SuspendSubscriptionResponse> suspendSubscription(String id) throws WebClientResponseException {
        ParameterizedTypeReference<SuspendSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<SuspendSubscriptionResponse>() {};
        return suspendSubscriptionRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Suspend a Subscription
     * Suspend a Subscription
     * <p><b>202</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ResponseEntity&lt;SuspendSubscriptionResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<SuspendSubscriptionResponse>> suspendSubscriptionWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<SuspendSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<SuspendSubscriptionResponse>() {};
        return suspendSubscriptionRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Suspend a Subscription
     * Suspend a Subscription
     * <p><b>202</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec suspendSubscriptionWithResponseSpec(String id) throws WebClientResponseException {
        return suspendSubscriptionRequestCreation(id);
    }
    /**
     * Update a Subscription
     * Update a Subscription by Subscription Id
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @param updateSubscription Update Subscription
     * @return UpdateSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateSubscriptionRequestCreation(String id, UpdateSubscriptionRequest updateSubscription) throws WebClientResponseException {
        Object postBody = updateSubscription;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling updateSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updateSubscription' is set
        if (updateSubscription == null) {
            throw new WebClientResponseException("Missing the required parameter 'updateSubscription' when calling updateSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<UpdateSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<UpdateSubscriptionResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/subscriptions/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Subscription
     * Update a Subscription by Subscription Id
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @param updateSubscription Update Subscription
     * @return UpdateSubscriptionResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<UpdateSubscriptionResponse> updateSubscription(String id, UpdateSubscriptionRequest updateSubscription) throws WebClientResponseException {
        ParameterizedTypeReference<UpdateSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<UpdateSubscriptionResponse>() {};
        return updateSubscriptionRequestCreation(id, updateSubscription).bodyToMono(localVarReturnType);
    }

    /**
     * Update a Subscription
     * Update a Subscription by Subscription Id
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @param updateSubscription Update Subscription
     * @return ResponseEntity&lt;UpdateSubscriptionResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<UpdateSubscriptionResponse>> updateSubscriptionWithHttpInfo(String id, UpdateSubscriptionRequest updateSubscription) throws WebClientResponseException {
        ParameterizedTypeReference<UpdateSubscriptionResponse> localVarReturnType = new ParameterizedTypeReference<UpdateSubscriptionResponse>() {};
        return updateSubscriptionRequestCreation(id, updateSubscription).toEntity(localVarReturnType);
    }

    /**
     * Update a Subscription
     * Update a Subscription by Subscription Id
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Subscription Id
     * @param updateSubscription Update Subscription
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateSubscriptionWithResponseSpec(String id, UpdateSubscriptionRequest updateSubscription) throws WebClientResponseException {
        return updateSubscriptionRequestCreation(id, updateSubscription);
    }
}
