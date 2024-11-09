package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateStandardOrClassicSubscription400Response;
import org.openapitools.client.model.CreateStandardOrClassicSubscriptionRequest;

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
public class ReportSubscriptionsApi {
    private ApiClient apiClient;

    public ReportSubscriptionsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ReportSubscriptionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Standard or Classic Subscription
     * Create or update an already existing classic or standard subscription. 
     * <p><b>200</b> - Ok
     * <p><b>201</b> - Created
     * <p><b>400</b> - Invalid request
     * @param predefinedSubscriptionRequestBean Report subscription request payload
     * @param organizationId Valid Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createStandardOrClassicSubscriptionRequestCreation(CreateStandardOrClassicSubscriptionRequest predefinedSubscriptionRequestBean, String organizationId) throws WebClientResponseException {
        Object postBody = predefinedSubscriptionRequestBean;
        // verify the required parameter 'predefinedSubscriptionRequestBean' is set
        if (predefinedSubscriptionRequestBean == null) {
            throw new WebClientResponseException("Missing the required parameter 'predefinedSubscriptionRequestBean' when calling createStandardOrClassicSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        
        final String[] localVarAccepts = { 
            "application/hal+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/reporting/v3/predefined-report-subscriptions", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Standard or Classic Subscription
     * Create or update an already existing classic or standard subscription. 
     * <p><b>200</b> - Ok
     * <p><b>201</b> - Created
     * <p><b>400</b> - Invalid request
     * @param predefinedSubscriptionRequestBean Report subscription request payload
     * @param organizationId Valid Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> createStandardOrClassicSubscription(CreateStandardOrClassicSubscriptionRequest predefinedSubscriptionRequestBean, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return createStandardOrClassicSubscriptionRequestCreation(predefinedSubscriptionRequestBean, organizationId).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Standard or Classic Subscription
     * Create or update an already existing classic or standard subscription. 
     * <p><b>200</b> - Ok
     * <p><b>201</b> - Created
     * <p><b>400</b> - Invalid request
     * @param predefinedSubscriptionRequestBean Report subscription request payload
     * @param organizationId Valid Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> createStandardOrClassicSubscriptionWithHttpInfo(CreateStandardOrClassicSubscriptionRequest predefinedSubscriptionRequestBean, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return createStandardOrClassicSubscriptionRequestCreation(predefinedSubscriptionRequestBean, organizationId).toEntity(localVarReturnType);
    }

    /**
     * Create a Standard or Classic Subscription
     * Create or update an already existing classic or standard subscription. 
     * <p><b>200</b> - Ok
     * <p><b>201</b> - Created
     * <p><b>400</b> - Invalid request
     * @param predefinedSubscriptionRequestBean Report subscription request payload
     * @param organizationId Valid Organization Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createStandardOrClassicSubscriptionWithResponseSpec(CreateStandardOrClassicSubscriptionRequest predefinedSubscriptionRequestBean, String organizationId) throws WebClientResponseException {
        return createStandardOrClassicSubscriptionRequestCreation(predefinedSubscriptionRequestBean, organizationId);
    }
}
