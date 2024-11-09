package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

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
public class UserManagementApi {
    private ApiClient apiClient;

    public UserManagementApi() {
        this(new ApiClient());
    }

    @Autowired
    public UserManagementApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get User Information - Deprecated
     * This endpoint is deprecated. Please use the search end point.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request.
     * <p><b>500</b> - Unexpected server error.
     * @param organizationId This is the orgId of the organization which the user belongs to.
     * @param userName User ID of the user you want to get details on.
     * @param permissionId permission that you are trying to search user on.
     * @param roleId role of the user you are trying to search on.
     * @return UmsV1UsersGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     * @deprecated
     */
    @Deprecated
    private ResponseSpec getUsersRequestCreation(String organizationId, String userName, String permissionId, String roleId) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "userName", userName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "permissionId", permissionId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "roleId", roleId));
        
        final String[] localVarAccepts = { 
            "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<UmsV1UsersGet200Response> localVarReturnType = new ParameterizedTypeReference<UmsV1UsersGet200Response>() {};
        return apiClient.invokeAPI("/ums/v1/users", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get User Information - Deprecated
     * This endpoint is deprecated. Please use the search end point.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request.
     * <p><b>500</b> - Unexpected server error.
     * @param organizationId This is the orgId of the organization which the user belongs to.
     * @param userName User ID of the user you want to get details on.
     * @param permissionId permission that you are trying to search user on.
     * @param roleId role of the user you are trying to search on.
     * @return UmsV1UsersGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<UmsV1UsersGet200Response> getUsers(String organizationId, String userName, String permissionId, String roleId) throws WebClientResponseException {
        ParameterizedTypeReference<UmsV1UsersGet200Response> localVarReturnType = new ParameterizedTypeReference<UmsV1UsersGet200Response>() {};
        return getUsersRequestCreation(organizationId, userName, permissionId, roleId).bodyToMono(localVarReturnType);
    }

    /**
     * Get User Information - Deprecated
     * This endpoint is deprecated. Please use the search end point.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request.
     * <p><b>500</b> - Unexpected server error.
     * @param organizationId This is the orgId of the organization which the user belongs to.
     * @param userName User ID of the user you want to get details on.
     * @param permissionId permission that you are trying to search user on.
     * @param roleId role of the user you are trying to search on.
     * @return ResponseEntity&lt;UmsV1UsersGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<UmsV1UsersGet200Response>> getUsersWithHttpInfo(String organizationId, String userName, String permissionId, String roleId) throws WebClientResponseException {
        ParameterizedTypeReference<UmsV1UsersGet200Response> localVarReturnType = new ParameterizedTypeReference<UmsV1UsersGet200Response>() {};
        return getUsersRequestCreation(organizationId, userName, permissionId, roleId).toEntity(localVarReturnType);
    }

    /**
     * Get User Information - Deprecated
     * This endpoint is deprecated. Please use the search end point.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request.
     * <p><b>500</b> - Unexpected server error.
     * @param organizationId This is the orgId of the organization which the user belongs to.
     * @param userName User ID of the user you want to get details on.
     * @param permissionId permission that you are trying to search user on.
     * @param roleId role of the user you are trying to search on.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getUsersWithResponseSpec(String organizationId, String userName, String permissionId, String roleId) throws WebClientResponseException {
        return getUsersRequestCreation(organizationId, userName, permissionId, roleId);
    }
}
