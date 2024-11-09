package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetRegistration200Response;
import org.openapitools.client.model.GetRegistration404Response;
import org.openapitools.client.model.PostRegistration201Response;
import org.openapitools.client.model.PostRegistration400Response;
import org.openapitools.client.model.PostRegistration422Response;
import org.openapitools.client.model.PostRegistration500Response;
import org.openapitools.client.model.PostRegistrationRequest;

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
public class MerchantBoardingApi {
    private ApiClient apiClient;

    public MerchantBoardingApi() {
        this(new ApiClient());
    }

    @Autowired
    public MerchantBoardingApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Gets all the information on a boarding registration
     * This end point will get all information of a boarding registration 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Resource Not Found
     * <p><b>500</b> - Internal Server error
     * @param registrationId Identifies the boarding registration to be updated
     * @return GetRegistration200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getRegistrationRequestCreation(String registrationId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'registrationId' is set
        if (registrationId == null) {
            throw new WebClientResponseException("Missing the required parameter 'registrationId' when calling getRegistration", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("registrationId", registrationId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetRegistration200Response> localVarReturnType = new ParameterizedTypeReference<GetRegistration200Response>() {};
        return apiClient.invokeAPI("/boarding/v1/registrations/{registrationId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Gets all the information on a boarding registration
     * This end point will get all information of a boarding registration 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Resource Not Found
     * <p><b>500</b> - Internal Server error
     * @param registrationId Identifies the boarding registration to be updated
     * @return GetRegistration200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetRegistration200Response> getRegistration(String registrationId) throws WebClientResponseException {
        ParameterizedTypeReference<GetRegistration200Response> localVarReturnType = new ParameterizedTypeReference<GetRegistration200Response>() {};
        return getRegistrationRequestCreation(registrationId).bodyToMono(localVarReturnType);
    }

    /**
     * Gets all the information on a boarding registration
     * This end point will get all information of a boarding registration 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Resource Not Found
     * <p><b>500</b> - Internal Server error
     * @param registrationId Identifies the boarding registration to be updated
     * @return ResponseEntity&lt;GetRegistration200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetRegistration200Response>> getRegistrationWithHttpInfo(String registrationId) throws WebClientResponseException {
        ParameterizedTypeReference<GetRegistration200Response> localVarReturnType = new ParameterizedTypeReference<GetRegistration200Response>() {};
        return getRegistrationRequestCreation(registrationId).toEntity(localVarReturnType);
    }

    /**
     * Gets all the information on a boarding registration
     * This end point will get all information of a boarding registration 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Resource Not Found
     * <p><b>500</b> - Internal Server error
     * @param registrationId Identifies the boarding registration to be updated
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getRegistrationWithResponseSpec(String registrationId) throws WebClientResponseException {
        return getRegistrationRequestCreation(registrationId);
    }
    /**
     * Create a boarding registration
     * Create a registration to board merchant  If you have  Card Processing product enabled in your boarding request, select payment processor from Configuration -&gt; Sample Request. You may unselect attributes from the Request Builder tree which you do not need in the request. For VPC, CUP and EFTPOS processors, replace the processor name from VPC or CUP or EFTPOS to the actual processor name in the sample request. e.g. replace VPC with &amp;lt;your vpc processor&amp;gt; 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>422</b> - Business Validations failed
     * <p><b>500</b> - Internal Server error
     * @param postRegistrationBody Boarding registration data
     * @param vCIdempotencyId defines idempotency of the request
     * @return PostRegistration201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postRegistrationRequestCreation(PostRegistrationRequest postRegistrationBody, String vCIdempotencyId) throws WebClientResponseException {
        Object postBody = postRegistrationBody;
        // verify the required parameter 'postRegistrationBody' is set
        if (postRegistrationBody == null) {
            throw new WebClientResponseException("Missing the required parameter 'postRegistrationBody' when calling postRegistration", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();


        if (vCIdempotencyId != null)
        headerParams.add("v-c-idempotency-id", apiClient.parameterToString(vCIdempotencyId));
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PostRegistration201Response> localVarReturnType = new ParameterizedTypeReference<PostRegistration201Response>() {};
        return apiClient.invokeAPI("/boarding/v1/registrations", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a boarding registration
     * Create a registration to board merchant  If you have  Card Processing product enabled in your boarding request, select payment processor from Configuration -&gt; Sample Request. You may unselect attributes from the Request Builder tree which you do not need in the request. For VPC, CUP and EFTPOS processors, replace the processor name from VPC or CUP or EFTPOS to the actual processor name in the sample request. e.g. replace VPC with &amp;lt;your vpc processor&amp;gt; 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>422</b> - Business Validations failed
     * <p><b>500</b> - Internal Server error
     * @param postRegistrationBody Boarding registration data
     * @param vCIdempotencyId defines idempotency of the request
     * @return PostRegistration201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PostRegistration201Response> postRegistration(PostRegistrationRequest postRegistrationBody, String vCIdempotencyId) throws WebClientResponseException {
        ParameterizedTypeReference<PostRegistration201Response> localVarReturnType = new ParameterizedTypeReference<PostRegistration201Response>() {};
        return postRegistrationRequestCreation(postRegistrationBody, vCIdempotencyId).bodyToMono(localVarReturnType);
    }

    /**
     * Create a boarding registration
     * Create a registration to board merchant  If you have  Card Processing product enabled in your boarding request, select payment processor from Configuration -&gt; Sample Request. You may unselect attributes from the Request Builder tree which you do not need in the request. For VPC, CUP and EFTPOS processors, replace the processor name from VPC or CUP or EFTPOS to the actual processor name in the sample request. e.g. replace VPC with &amp;lt;your vpc processor&amp;gt; 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>422</b> - Business Validations failed
     * <p><b>500</b> - Internal Server error
     * @param postRegistrationBody Boarding registration data
     * @param vCIdempotencyId defines idempotency of the request
     * @return ResponseEntity&lt;PostRegistration201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PostRegistration201Response>> postRegistrationWithHttpInfo(PostRegistrationRequest postRegistrationBody, String vCIdempotencyId) throws WebClientResponseException {
        ParameterizedTypeReference<PostRegistration201Response> localVarReturnType = new ParameterizedTypeReference<PostRegistration201Response>() {};
        return postRegistrationRequestCreation(postRegistrationBody, vCIdempotencyId).toEntity(localVarReturnType);
    }

    /**
     * Create a boarding registration
     * Create a registration to board merchant  If you have  Card Processing product enabled in your boarding request, select payment processor from Configuration -&gt; Sample Request. You may unselect attributes from the Request Builder tree which you do not need in the request. For VPC, CUP and EFTPOS processors, replace the processor name from VPC or CUP or EFTPOS to the actual processor name in the sample request. e.g. replace VPC with &amp;lt;your vpc processor&amp;gt; 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>422</b> - Business Validations failed
     * <p><b>500</b> - Internal Server error
     * @param postRegistrationBody Boarding registration data
     * @param vCIdempotencyId defines idempotency of the request
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postRegistrationWithResponseSpec(PostRegistrationRequest postRegistrationBody, String vCIdempotencyId) throws WebClientResponseException {
        return postRegistrationRequestCreation(postRegistrationBody, vCIdempotencyId);
    }
}
