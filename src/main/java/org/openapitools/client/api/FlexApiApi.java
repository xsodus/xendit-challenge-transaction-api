package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GenerateFlexAPICaptureContext400Response;
import org.openapitools.client.model.GenerateFlexAPICaptureContextRequest;

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
public class FlexApiApi {
    private ApiClient apiClient;

    public FlexApiApi() {
        this(new ApiClient());
    }

    @Autowired
    public FlexApiApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Establish a Payment Session with a Capture Context
     * To establish a payment session, include the API fields you plan to use in that session in the body of the request.  The system then returns a JSON Web Token (JWT) that includes the capture context.   To determine which fields to include in your capture context, identify the personal information that you wish to isolate from the payment session.  **Capture Context Fields**&lt;br&gt; When making a session request, any fields that you request to be added to the capture context are required by default.  However, you can choose to make a field optional by setting the required parameter to false. 
     * <p><b>201</b> - Capture Context Created
     * <p><b>400</b> - Bad Request: e.g. Merchant APIKey is invalid.
     * <p><b>500</b> - Internal error.
     * @param generateFlexAPICaptureContextRequest The generateFlexAPICaptureContextRequest parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec generateFlexAPICaptureContextRequestCreation(GenerateFlexAPICaptureContextRequest generateFlexAPICaptureContextRequest) throws WebClientResponseException {
        Object postBody = generateFlexAPICaptureContextRequest;
        // verify the required parameter 'generateFlexAPICaptureContextRequest' is set
        if (generateFlexAPICaptureContextRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'generateFlexAPICaptureContextRequest' when calling generateFlexAPICaptureContext", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/jwt", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/flex/v2/sessions", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Establish a Payment Session with a Capture Context
     * To establish a payment session, include the API fields you plan to use in that session in the body of the request.  The system then returns a JSON Web Token (JWT) that includes the capture context.   To determine which fields to include in your capture context, identify the personal information that you wish to isolate from the payment session.  **Capture Context Fields**&lt;br&gt; When making a session request, any fields that you request to be added to the capture context are required by default.  However, you can choose to make a field optional by setting the required parameter to false. 
     * <p><b>201</b> - Capture Context Created
     * <p><b>400</b> - Bad Request: e.g. Merchant APIKey is invalid.
     * <p><b>500</b> - Internal error.
     * @param generateFlexAPICaptureContextRequest The generateFlexAPICaptureContextRequest parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> generateFlexAPICaptureContext(GenerateFlexAPICaptureContextRequest generateFlexAPICaptureContextRequest) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return generateFlexAPICaptureContextRequestCreation(generateFlexAPICaptureContextRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Establish a Payment Session with a Capture Context
     * To establish a payment session, include the API fields you plan to use in that session in the body of the request.  The system then returns a JSON Web Token (JWT) that includes the capture context.   To determine which fields to include in your capture context, identify the personal information that you wish to isolate from the payment session.  **Capture Context Fields**&lt;br&gt; When making a session request, any fields that you request to be added to the capture context are required by default.  However, you can choose to make a field optional by setting the required parameter to false. 
     * <p><b>201</b> - Capture Context Created
     * <p><b>400</b> - Bad Request: e.g. Merchant APIKey is invalid.
     * <p><b>500</b> - Internal error.
     * @param generateFlexAPICaptureContextRequest The generateFlexAPICaptureContextRequest parameter
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> generateFlexAPICaptureContextWithHttpInfo(GenerateFlexAPICaptureContextRequest generateFlexAPICaptureContextRequest) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return generateFlexAPICaptureContextRequestCreation(generateFlexAPICaptureContextRequest).toEntity(localVarReturnType);
    }

    /**
     * Establish a Payment Session with a Capture Context
     * To establish a payment session, include the API fields you plan to use in that session in the body of the request.  The system then returns a JSON Web Token (JWT) that includes the capture context.   To determine which fields to include in your capture context, identify the personal information that you wish to isolate from the payment session.  **Capture Context Fields**&lt;br&gt; When making a session request, any fields that you request to be added to the capture context are required by default.  However, you can choose to make a field optional by setting the required parameter to false. 
     * <p><b>201</b> - Capture Context Created
     * <p><b>400</b> - Bad Request: e.g. Merchant APIKey is invalid.
     * <p><b>500</b> - Internal error.
     * @param generateFlexAPICaptureContextRequest The generateFlexAPICaptureContextRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec generateFlexAPICaptureContextWithResponseSpec(GenerateFlexAPICaptureContextRequest generateFlexAPICaptureContextRequest) throws WebClientResponseException {
        return generateFlexAPICaptureContextRequestCreation(generateFlexAPICaptureContextRequest);
    }
}
