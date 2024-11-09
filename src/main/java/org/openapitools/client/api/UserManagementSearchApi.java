package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.SearchUsersRequest;
import org.openapitools.client.model.UmsV1UsersGet200Response;
import org.openapitools.client.model.UmsV1UsersGet400Response;

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
public class UserManagementSearchApi {
    private ApiClient apiClient;

    public UserManagementSearchApi() {
        this(new ApiClient());
    }

    @Autowired
    public UserManagementSearchApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Search User Information
     * This endpoint is to get all the user information depending on the filter criteria passed in request body.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request.
     * <p><b>500</b> - Unexpected server error.
     * @param searchRequest The searchRequest parameter
     * @return UmsV1UsersGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec searchUsersRequestCreation(SearchUsersRequest searchRequest) throws WebClientResponseException {
        Object postBody = searchRequest;
        // verify the required parameter 'searchRequest' is set
        if (searchRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'searchRequest' when calling searchUsers", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<UmsV1UsersGet200Response> localVarReturnType = new ParameterizedTypeReference<UmsV1UsersGet200Response>() {};
        return apiClient.invokeAPI("/ums/v1/users/search", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Search User Information
     * This endpoint is to get all the user information depending on the filter criteria passed in request body.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request.
     * <p><b>500</b> - Unexpected server error.
     * @param searchRequest The searchRequest parameter
     * @return UmsV1UsersGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<UmsV1UsersGet200Response> searchUsers(SearchUsersRequest searchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<UmsV1UsersGet200Response> localVarReturnType = new ParameterizedTypeReference<UmsV1UsersGet200Response>() {};
        return searchUsersRequestCreation(searchRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Search User Information
     * This endpoint is to get all the user information depending on the filter criteria passed in request body.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request.
     * <p><b>500</b> - Unexpected server error.
     * @param searchRequest The searchRequest parameter
     * @return ResponseEntity&lt;UmsV1UsersGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<UmsV1UsersGet200Response>> searchUsersWithHttpInfo(SearchUsersRequest searchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<UmsV1UsersGet200Response> localVarReturnType = new ParameterizedTypeReference<UmsV1UsersGet200Response>() {};
        return searchUsersRequestCreation(searchRequest).toEntity(localVarReturnType);
    }

    /**
     * Search User Information
     * This endpoint is to get all the user information depending on the filter criteria passed in request body.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request.
     * <p><b>500</b> - Unexpected server error.
     * @param searchRequest The searchRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec searchUsersWithResponseSpec(SearchUsersRequest searchRequest) throws WebClientResponseException {
        return searchUsersRequestCreation(searchRequest);
    }
}
