package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateSearchRequest;
import org.openapitools.client.model.TssV2TransactionsPost201Response;
import org.openapitools.client.model.TssV2TransactionsPost400Response;
import org.openapitools.client.model.TssV2TransactionsPost502Response;

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
public class SearchTransactionsApi {
    private ApiClient apiClient;

    public SearchTransactionsApi() {
        this(new ApiClient());
    }

    @Autowired
    public SearchTransactionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Search Request
     * Create a search request. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSearchRequest The createSearchRequest parameter
     * @return TssV2TransactionsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createSearchRequestCreation(CreateSearchRequest createSearchRequest) throws WebClientResponseException {
        Object postBody = createSearchRequest;
        // verify the required parameter 'createSearchRequest' is set
        if (createSearchRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'createSearchRequest' when calling createSearch", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
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

        ParameterizedTypeReference<TssV2TransactionsPost201Response> localVarReturnType = new ParameterizedTypeReference<TssV2TransactionsPost201Response>() {};
        return apiClient.invokeAPI("/tss/v2/searches", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Search Request
     * Create a search request. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSearchRequest The createSearchRequest parameter
     * @return TssV2TransactionsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TssV2TransactionsPost201Response> createSearch(CreateSearchRequest createSearchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<TssV2TransactionsPost201Response> localVarReturnType = new ParameterizedTypeReference<TssV2TransactionsPost201Response>() {};
        return createSearchRequestCreation(createSearchRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Search Request
     * Create a search request. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSearchRequest The createSearchRequest parameter
     * @return ResponseEntity&lt;TssV2TransactionsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<TssV2TransactionsPost201Response>> createSearchWithHttpInfo(CreateSearchRequest createSearchRequest) throws WebClientResponseException {
        ParameterizedTypeReference<TssV2TransactionsPost201Response> localVarReturnType = new ParameterizedTypeReference<TssV2TransactionsPost201Response>() {};
        return createSearchRequestCreation(createSearchRequest).toEntity(localVarReturnType);
    }

    /**
     * Create a Search Request
     * Create a search request. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSearchRequest The createSearchRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createSearchWithResponseSpec(CreateSearchRequest createSearchRequest) throws WebClientResponseException {
        return createSearchRequestCreation(createSearchRequest);
    }
    /**
     * Get Search Results
     * Include the Search ID in the GET request to retrieve the search results.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error.
     * @param searchId Search ID.
     * @return TssV2TransactionsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSearchRequestCreation(String searchId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'searchId' is set
        if (searchId == null) {
            throw new WebClientResponseException("Missing the required parameter 'searchId' when calling getSearch", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("searchId", searchId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<TssV2TransactionsPost201Response> localVarReturnType = new ParameterizedTypeReference<TssV2TransactionsPost201Response>() {};
        return apiClient.invokeAPI("/tss/v2/searches/{searchId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Search Results
     * Include the Search ID in the GET request to retrieve the search results.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error.
     * @param searchId Search ID.
     * @return TssV2TransactionsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TssV2TransactionsPost201Response> getSearch(String searchId) throws WebClientResponseException {
        ParameterizedTypeReference<TssV2TransactionsPost201Response> localVarReturnType = new ParameterizedTypeReference<TssV2TransactionsPost201Response>() {};
        return getSearchRequestCreation(searchId).bodyToMono(localVarReturnType);
    }

    /**
     * Get Search Results
     * Include the Search ID in the GET request to retrieve the search results.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error.
     * @param searchId Search ID.
     * @return ResponseEntity&lt;TssV2TransactionsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<TssV2TransactionsPost201Response>> getSearchWithHttpInfo(String searchId) throws WebClientResponseException {
        ParameterizedTypeReference<TssV2TransactionsPost201Response> localVarReturnType = new ParameterizedTypeReference<TssV2TransactionsPost201Response>() {};
        return getSearchRequestCreation(searchId).toEntity(localVarReturnType);
    }

    /**
     * Get Search Results
     * Include the Search ID in the GET request to retrieve the search results.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error.
     * @param searchId Search ID.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getSearchWithResponseSpec(String searchId) throws WebClientResponseException {
        return getSearchRequestCreation(searchId);
    }
}
