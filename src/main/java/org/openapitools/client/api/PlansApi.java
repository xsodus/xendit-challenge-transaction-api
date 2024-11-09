package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ActivateDeactivatePlanResponse;
import org.openapitools.client.model.CreatePlanRequest;
import org.openapitools.client.model.CreatePlanResponse;
import org.openapitools.client.model.DeletePlanResponse;
import org.openapitools.client.model.GetAllPlansResponse;
import org.openapitools.client.model.GetPlan404Response;
import org.openapitools.client.model.GetPlanCodeResponse;
import org.openapitools.client.model.GetPlanResponse;
import org.openapitools.client.model.GetPlans400Response;
import org.openapitools.client.model.GetPlans502Response;
import org.openapitools.client.model.UpdatePlanRequest;
import org.openapitools.client.model.UpdatePlanResponse;

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
public class PlansApi {
    private ApiClient apiClient;

    public PlansApi() {
        this(new ApiClient());
    }

    @Autowired
    public PlansApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Activate a Plan
     * Activate a Plan
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ActivateDeactivatePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec activatePlanRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling activatePlan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ActivateDeactivatePlanResponse> localVarReturnType = new ParameterizedTypeReference<ActivateDeactivatePlanResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/plans/{id}/activate", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Activate a Plan
     * Activate a Plan
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ActivateDeactivatePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ActivateDeactivatePlanResponse> activatePlan(String id) throws WebClientResponseException {
        ParameterizedTypeReference<ActivateDeactivatePlanResponse> localVarReturnType = new ParameterizedTypeReference<ActivateDeactivatePlanResponse>() {};
        return activatePlanRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Activate a Plan
     * Activate a Plan
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ResponseEntity&lt;ActivateDeactivatePlanResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ActivateDeactivatePlanResponse>> activatePlanWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<ActivateDeactivatePlanResponse> localVarReturnType = new ParameterizedTypeReference<ActivateDeactivatePlanResponse>() {};
        return activatePlanRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Activate a Plan
     * Activate a Plan
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec activatePlanWithResponseSpec(String id) throws WebClientResponseException {
        return activatePlanRequestCreation(id);
    }
    /**
     * Create a Plan
     * The recurring billing service enables you to manage payment plans and subscriptions for recurring payment schedules. It securely stores your customer&#39;s payment information and personal data within secure Visa data centers, reducing storage risks and PCI DSS scope through the use of *Token Management* (*TMS*).  The three key elements of *Cybersource* Recurring Billing are:  -  **Token**: stores customer billing, shipping, and payment details.  -  **Plan**: stores the billing schedule.  -  **Subscription**: combines the token and plan, and defines the subscription start date, name, and description.  The APIs in this section demonstrate the management of the Plans and Subscriptions. For Tokens please refer to [Token Management](#token-management) 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createPlanRequest The createPlanRequest parameter
     * @return CreatePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createPlanRequestCreation(CreatePlanRequest createPlanRequest) throws WebClientResponseException {
        Object postBody = createPlanRequest;
        // verify the required parameter 'createPlanRequest' is set
        if (createPlanRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'createPlanRequest' when calling createPlan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<CreatePlanResponse> localVarReturnType = new ParameterizedTypeReference<CreatePlanResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/plans", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Plan
     * The recurring billing service enables you to manage payment plans and subscriptions for recurring payment schedules. It securely stores your customer&#39;s payment information and personal data within secure Visa data centers, reducing storage risks and PCI DSS scope through the use of *Token Management* (*TMS*).  The three key elements of *Cybersource* Recurring Billing are:  -  **Token**: stores customer billing, shipping, and payment details.  -  **Plan**: stores the billing schedule.  -  **Subscription**: combines the token and plan, and defines the subscription start date, name, and description.  The APIs in this section demonstrate the management of the Plans and Subscriptions. For Tokens please refer to [Token Management](#token-management) 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createPlanRequest The createPlanRequest parameter
     * @return CreatePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<CreatePlanResponse> createPlan(CreatePlanRequest createPlanRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CreatePlanResponse> localVarReturnType = new ParameterizedTypeReference<CreatePlanResponse>() {};
        return createPlanRequestCreation(createPlanRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Plan
     * The recurring billing service enables you to manage payment plans and subscriptions for recurring payment schedules. It securely stores your customer&#39;s payment information and personal data within secure Visa data centers, reducing storage risks and PCI DSS scope through the use of *Token Management* (*TMS*).  The three key elements of *Cybersource* Recurring Billing are:  -  **Token**: stores customer billing, shipping, and payment details.  -  **Plan**: stores the billing schedule.  -  **Subscription**: combines the token and plan, and defines the subscription start date, name, and description.  The APIs in this section demonstrate the management of the Plans and Subscriptions. For Tokens please refer to [Token Management](#token-management) 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createPlanRequest The createPlanRequest parameter
     * @return ResponseEntity&lt;CreatePlanResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<CreatePlanResponse>> createPlanWithHttpInfo(CreatePlanRequest createPlanRequest) throws WebClientResponseException {
        ParameterizedTypeReference<CreatePlanResponse> localVarReturnType = new ParameterizedTypeReference<CreatePlanResponse>() {};
        return createPlanRequestCreation(createPlanRequest).toEntity(localVarReturnType);
    }

    /**
     * Create a Plan
     * The recurring billing service enables you to manage payment plans and subscriptions for recurring payment schedules. It securely stores your customer&#39;s payment information and personal data within secure Visa data centers, reducing storage risks and PCI DSS scope through the use of *Token Management* (*TMS*).  The three key elements of *Cybersource* Recurring Billing are:  -  **Token**: stores customer billing, shipping, and payment details.  -  **Plan**: stores the billing schedule.  -  **Subscription**: combines the token and plan, and defines the subscription start date, name, and description.  The APIs in this section demonstrate the management of the Plans and Subscriptions. For Tokens please refer to [Token Management](#token-management) 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createPlanRequest The createPlanRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createPlanWithResponseSpec(CreatePlanRequest createPlanRequest) throws WebClientResponseException {
        return createPlanRequestCreation(createPlanRequest);
    }
    /**
     * Deactivate a Plan
     * Deactivate a Plan
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ActivateDeactivatePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deactivatePlanRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling deactivatePlan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ActivateDeactivatePlanResponse> localVarReturnType = new ParameterizedTypeReference<ActivateDeactivatePlanResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/plans/{id}/deactivate", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Deactivate a Plan
     * Deactivate a Plan
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ActivateDeactivatePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ActivateDeactivatePlanResponse> deactivatePlan(String id) throws WebClientResponseException {
        ParameterizedTypeReference<ActivateDeactivatePlanResponse> localVarReturnType = new ParameterizedTypeReference<ActivateDeactivatePlanResponse>() {};
        return deactivatePlanRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Deactivate a Plan
     * Deactivate a Plan
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ResponseEntity&lt;ActivateDeactivatePlanResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ActivateDeactivatePlanResponse>> deactivatePlanWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<ActivateDeactivatePlanResponse> localVarReturnType = new ParameterizedTypeReference<ActivateDeactivatePlanResponse>() {};
        return deactivatePlanRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Deactivate a Plan
     * Deactivate a Plan
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deactivatePlanWithResponseSpec(String id) throws WebClientResponseException {
        return deactivatePlanRequestCreation(id);
    }
    /**
     * Delete a Plan
     * Delete a Plan is only allowed: - plan status is in &#x60;DRAFT&#x60; - plan status is in &#x60;ACTIVE&#x60;, and &#x60;INACTIVE&#x60; only allowed when no subscriptions attached to a plan in the lifetime of a plan 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return DeletePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deletePlanRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling deletePlan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<DeletePlanResponse> localVarReturnType = new ParameterizedTypeReference<DeletePlanResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/plans/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Plan
     * Delete a Plan is only allowed: - plan status is in &#x60;DRAFT&#x60; - plan status is in &#x60;ACTIVE&#x60;, and &#x60;INACTIVE&#x60; only allowed when no subscriptions attached to a plan in the lifetime of a plan 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return DeletePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DeletePlanResponse> deletePlan(String id) throws WebClientResponseException {
        ParameterizedTypeReference<DeletePlanResponse> localVarReturnType = new ParameterizedTypeReference<DeletePlanResponse>() {};
        return deletePlanRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Delete a Plan
     * Delete a Plan is only allowed: - plan status is in &#x60;DRAFT&#x60; - plan status is in &#x60;ACTIVE&#x60;, and &#x60;INACTIVE&#x60; only allowed when no subscriptions attached to a plan in the lifetime of a plan 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ResponseEntity&lt;DeletePlanResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<DeletePlanResponse>> deletePlanWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<DeletePlanResponse> localVarReturnType = new ParameterizedTypeReference<DeletePlanResponse>() {};
        return deletePlanRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Plan
     * Delete a Plan is only allowed: - plan status is in &#x60;DRAFT&#x60; - plan status is in &#x60;ACTIVE&#x60;, and &#x60;INACTIVE&#x60; only allowed when no subscriptions attached to a plan in the lifetime of a plan 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deletePlanWithResponseSpec(String id) throws WebClientResponseException {
        return deletePlanRequestCreation(id);
    }
    /**
     * Get a Plan
     * Retrieve a Plan details by Plan Id.
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return GetPlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getPlanRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getPlan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<GetPlanResponse> localVarReturnType = new ParameterizedTypeReference<GetPlanResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/plans/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Plan
     * Retrieve a Plan details by Plan Id.
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return GetPlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetPlanResponse> getPlan(String id) throws WebClientResponseException {
        ParameterizedTypeReference<GetPlanResponse> localVarReturnType = new ParameterizedTypeReference<GetPlanResponse>() {};
        return getPlanRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Get a Plan
     * Retrieve a Plan details by Plan Id.
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ResponseEntity&lt;GetPlanResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetPlanResponse>> getPlanWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<GetPlanResponse> localVarReturnType = new ParameterizedTypeReference<GetPlanResponse>() {};
        return getPlanRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Plan
     * Retrieve a Plan details by Plan Id.
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - Not found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getPlanWithResponseSpec(String id) throws WebClientResponseException {
        return getPlanRequestCreation(id);
    }
    /**
     * Get a Plan Code
     * Get a Unique Plan Code
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @return GetPlanCodeResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getPlanCodeRequestCreation() throws WebClientResponseException {
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

        ParameterizedTypeReference<GetPlanCodeResponse> localVarReturnType = new ParameterizedTypeReference<GetPlanCodeResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/plans/code", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Plan Code
     * Get a Unique Plan Code
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @return GetPlanCodeResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetPlanCodeResponse> getPlanCode() throws WebClientResponseException {
        ParameterizedTypeReference<GetPlanCodeResponse> localVarReturnType = new ParameterizedTypeReference<GetPlanCodeResponse>() {};
        return getPlanCodeRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Get a Plan Code
     * Get a Unique Plan Code
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @return ResponseEntity&lt;GetPlanCodeResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetPlanCodeResponse>> getPlanCodeWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<GetPlanCodeResponse> localVarReturnType = new ParameterizedTypeReference<GetPlanCodeResponse>() {};
        return getPlanCodeRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Get a Plan Code
     * Get a Unique Plan Code
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getPlanCodeWithResponseSpec() throws WebClientResponseException {
        return getPlanCodeRequestCreation();
    }
    /**
     * Get a List of Plans
     * Retrieve Plans by Plan Code &amp; Plan Status. 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param offset Page offset number.
     * @param limit Number of items to be returned. Default - &#x60;20&#x60;, Max - &#x60;100&#x60; 
     * @param code Filter by Plan Code
     * @param status Filter by Plan Status
     * @param name Filter by Plan Name. (First sub string or full string) **[Not Recommended]** 
     * @return GetAllPlansResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getPlansRequestCreation(Integer offset, Integer limit, String code, String status, String name) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        
        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetAllPlansResponse> localVarReturnType = new ParameterizedTypeReference<GetAllPlansResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/plans", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a List of Plans
     * Retrieve Plans by Plan Code &amp; Plan Status. 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param offset Page offset number.
     * @param limit Number of items to be returned. Default - &#x60;20&#x60;, Max - &#x60;100&#x60; 
     * @param code Filter by Plan Code
     * @param status Filter by Plan Status
     * @param name Filter by Plan Name. (First sub string or full string) **[Not Recommended]** 
     * @return GetAllPlansResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetAllPlansResponse> getPlans(Integer offset, Integer limit, String code, String status, String name) throws WebClientResponseException {
        ParameterizedTypeReference<GetAllPlansResponse> localVarReturnType = new ParameterizedTypeReference<GetAllPlansResponse>() {};
        return getPlansRequestCreation(offset, limit, code, status, name).bodyToMono(localVarReturnType);
    }

    /**
     * Get a List of Plans
     * Retrieve Plans by Plan Code &amp; Plan Status. 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param offset Page offset number.
     * @param limit Number of items to be returned. Default - &#x60;20&#x60;, Max - &#x60;100&#x60; 
     * @param code Filter by Plan Code
     * @param status Filter by Plan Status
     * @param name Filter by Plan Name. (First sub string or full string) **[Not Recommended]** 
     * @return ResponseEntity&lt;GetAllPlansResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetAllPlansResponse>> getPlansWithHttpInfo(Integer offset, Integer limit, String code, String status, String name) throws WebClientResponseException {
        ParameterizedTypeReference<GetAllPlansResponse> localVarReturnType = new ParameterizedTypeReference<GetAllPlansResponse>() {};
        return getPlansRequestCreation(offset, limit, code, status, name).toEntity(localVarReturnType);
    }

    /**
     * Get a List of Plans
     * Retrieve Plans by Plan Code &amp; Plan Status. 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param offset Page offset number.
     * @param limit Number of items to be returned. Default - &#x60;20&#x60;, Max - &#x60;100&#x60; 
     * @param code Filter by Plan Code
     * @param status Filter by Plan Status
     * @param name Filter by Plan Name. (First sub string or full string) **[Not Recommended]** 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getPlansWithResponseSpec(Integer offset, Integer limit, String code, String status, String name) throws WebClientResponseException {
        return getPlansRequestCreation(offset, limit, code, status, name);
    }
    /**
     * Update a Plan
     * Update a Plan  Plan in &#x60;DRAFT&#x60; status - All updates are allowed on Plan with &#x60;DRAFT&#x60; status  Plan in &#x60;ACTIVE&#x60; status [Following fields are **Not Updatable**] - &#x60;planInformation.billingPeriod&#x60; - &#x60;planInformation.billingCycles&#x60; [Update is only allowed to **increase** billingCycles] - &#x60;orderInformation.amountDetails.currency&#x60; 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @param updatePlanRequest The updatePlanRequest parameter
     * @return UpdatePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updatePlanRequestCreation(String id, UpdatePlanRequest updatePlanRequest) throws WebClientResponseException {
        Object postBody = updatePlanRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling updatePlan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updatePlanRequest' is set
        if (updatePlanRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'updatePlanRequest' when calling updatePlan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<UpdatePlanResponse> localVarReturnType = new ParameterizedTypeReference<UpdatePlanResponse>() {};
        return apiClient.invokeAPI("/rbs/v1/plans/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Plan
     * Update a Plan  Plan in &#x60;DRAFT&#x60; status - All updates are allowed on Plan with &#x60;DRAFT&#x60; status  Plan in &#x60;ACTIVE&#x60; status [Following fields are **Not Updatable**] - &#x60;planInformation.billingPeriod&#x60; - &#x60;planInformation.billingCycles&#x60; [Update is only allowed to **increase** billingCycles] - &#x60;orderInformation.amountDetails.currency&#x60; 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @param updatePlanRequest The updatePlanRequest parameter
     * @return UpdatePlanResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<UpdatePlanResponse> updatePlan(String id, UpdatePlanRequest updatePlanRequest) throws WebClientResponseException {
        ParameterizedTypeReference<UpdatePlanResponse> localVarReturnType = new ParameterizedTypeReference<UpdatePlanResponse>() {};
        return updatePlanRequestCreation(id, updatePlanRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Update a Plan
     * Update a Plan  Plan in &#x60;DRAFT&#x60; status - All updates are allowed on Plan with &#x60;DRAFT&#x60; status  Plan in &#x60;ACTIVE&#x60; status [Following fields are **Not Updatable**] - &#x60;planInformation.billingPeriod&#x60; - &#x60;planInformation.billingCycles&#x60; [Update is only allowed to **increase** billingCycles] - &#x60;orderInformation.amountDetails.currency&#x60; 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @param updatePlanRequest The updatePlanRequest parameter
     * @return ResponseEntity&lt;UpdatePlanResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<UpdatePlanResponse>> updatePlanWithHttpInfo(String id, UpdatePlanRequest updatePlanRequest) throws WebClientResponseException {
        ParameterizedTypeReference<UpdatePlanResponse> localVarReturnType = new ParameterizedTypeReference<UpdatePlanResponse>() {};
        return updatePlanRequestCreation(id, updatePlanRequest).toEntity(localVarReturnType);
    }

    /**
     * Update a Plan
     * Update a Plan  Plan in &#x60;DRAFT&#x60; status - All updates are allowed on Plan with &#x60;DRAFT&#x60; status  Plan in &#x60;ACTIVE&#x60; status [Following fields are **Not Updatable**] - &#x60;planInformation.billingPeriod&#x60; - &#x60;planInformation.billingCycles&#x60; [Update is only allowed to **increase** billingCycles] - &#x60;orderInformation.amountDetails.currency&#x60; 
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Plan Id
     * @param updatePlanRequest The updatePlanRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updatePlanWithResponseSpec(String id, UpdatePlanRequest updatePlanRequest) throws WebClientResponseException {
        return updatePlanRequestCreation(id, updatePlanRequest);
    }
}
