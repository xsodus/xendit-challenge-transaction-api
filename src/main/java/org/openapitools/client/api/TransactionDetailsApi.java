package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.TssV2TransactionsGet200Response;

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
public class TransactionDetailsApi {
    private ApiClient apiClient;

    public TransactionDetailsApi() {
        this(new ApiClient());
    }

    @Autowired
    public TransactionDetailsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Retrieve a Transaction
     * Include the Request ID in the GET request to retrieve the transaction details.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param id Request ID. 
     * @return TssV2TransactionsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTransactionRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getTransaction", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<TssV2TransactionsGet200Response> localVarReturnType = new ParameterizedTypeReference<TssV2TransactionsGet200Response>() {};
        return apiClient.invokeAPI("/tss/v2/transactions/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve a Transaction
     * Include the Request ID in the GET request to retrieve the transaction details.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param id Request ID. 
     * @return TssV2TransactionsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TssV2TransactionsGet200Response> getTransaction(String id) throws WebClientResponseException {
        ParameterizedTypeReference<TssV2TransactionsGet200Response> localVarReturnType = new ParameterizedTypeReference<TssV2TransactionsGet200Response>() {};
        return getTransactionRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve a Transaction
     * Include the Request ID in the GET request to retrieve the transaction details.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param id Request ID. 
     * @return ResponseEntity&lt;TssV2TransactionsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<TssV2TransactionsGet200Response>> getTransactionWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<TssV2TransactionsGet200Response> localVarReturnType = new ParameterizedTypeReference<TssV2TransactionsGet200Response>() {};
        return getTransactionRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Retrieve a Transaction
     * Include the Request ID in the GET request to retrieve the transaction details.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param id Request ID. 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTransactionWithResponseSpec(String id) throws WebClientResponseException {
        return getTransactionRequestCreation(id);
    }
}
