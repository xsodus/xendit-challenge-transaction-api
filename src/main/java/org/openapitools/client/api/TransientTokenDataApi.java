package org.openapitools.client.api;

import org.openapitools.client.ApiClient;


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
public class TransientTokenDataApi {
    private ApiClient apiClient;

    public TransientTokenDataApi() {
        this(new ApiClient());
    }

    @Autowired
    public TransientTokenDataApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Payment Credentials
     * Retrieve the Payment data captured by Unified Checkout. This API is used to retrieve the detailed data represented by the Transient Token. This API will return PCI payment data captured by the Unified Checkout platform.
     * <p><b>200</b> - Retrieved payment credentials reference
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param paymentCredentialsReference The paymentCredentialsReference field contained within the Transient token returned from a successful Unified Checkout transaction 
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getPaymentCredentialsForTransientTokenRequestCreation(String paymentCredentialsReference) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'paymentCredentialsReference' is set
        if (paymentCredentialsReference == null) {
            throw new WebClientResponseException("Missing the required parameter 'paymentCredentialsReference' when calling getPaymentCredentialsForTransientToken", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("paymentCredentialsReference", paymentCredentialsReference);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/jwe"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/flex/v2/payment-credentials/{paymentCredentialsReference}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Payment Credentials
     * Retrieve the Payment data captured by Unified Checkout. This API is used to retrieve the detailed data represented by the Transient Token. This API will return PCI payment data captured by the Unified Checkout platform.
     * <p><b>200</b> - Retrieved payment credentials reference
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param paymentCredentialsReference The paymentCredentialsReference field contained within the Transient token returned from a successful Unified Checkout transaction 
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> getPaymentCredentialsForTransientToken(String paymentCredentialsReference) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return getPaymentCredentialsForTransientTokenRequestCreation(paymentCredentialsReference).bodyToMono(localVarReturnType);
    }

    /**
     * Get Payment Credentials
     * Retrieve the Payment data captured by Unified Checkout. This API is used to retrieve the detailed data represented by the Transient Token. This API will return PCI payment data captured by the Unified Checkout platform.
     * <p><b>200</b> - Retrieved payment credentials reference
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param paymentCredentialsReference The paymentCredentialsReference field contained within the Transient token returned from a successful Unified Checkout transaction 
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> getPaymentCredentialsForTransientTokenWithHttpInfo(String paymentCredentialsReference) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return getPaymentCredentialsForTransientTokenRequestCreation(paymentCredentialsReference).toEntity(localVarReturnType);
    }

    /**
     * Get Payment Credentials
     * Retrieve the Payment data captured by Unified Checkout. This API is used to retrieve the detailed data represented by the Transient Token. This API will return PCI payment data captured by the Unified Checkout platform.
     * <p><b>200</b> - Retrieved payment credentials reference
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param paymentCredentialsReference The paymentCredentialsReference field contained within the Transient token returned from a successful Unified Checkout transaction 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getPaymentCredentialsForTransientTokenWithResponseSpec(String paymentCredentialsReference) throws WebClientResponseException {
        return getPaymentCredentialsForTransientTokenRequestCreation(paymentCredentialsReference);
    }
    /**
     * Get Transient Token Data
     * Retrieve the data captured by Unified Checkout. This API is used to retrieve the detailed data represented by the Transient Token. This API will not return PCI payment data (PAN). Include the Request ID in the GET request to retrieve the transaction details.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param transientToken Transient Token returned by the Unified Checkout application. 
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTransactionForTransientTokenRequestCreation(String transientToken) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'transientToken' is set
        if (transientToken == null) {
            throw new WebClientResponseException("Missing the required parameter 'transientToken' when calling getTransactionForTransientToken", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("transientToken", transientToken);

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

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/up/v1/payment-details/{transientToken}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Transient Token Data
     * Retrieve the data captured by Unified Checkout. This API is used to retrieve the detailed data represented by the Transient Token. This API will not return PCI payment data (PAN). Include the Request ID in the GET request to retrieve the transaction details.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param transientToken Transient Token returned by the Unified Checkout application. 
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getTransactionForTransientToken(String transientToken) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getTransactionForTransientTokenRequestCreation(transientToken).bodyToMono(localVarReturnType);
    }

    /**
     * Get Transient Token Data
     * Retrieve the data captured by Unified Checkout. This API is used to retrieve the detailed data represented by the Transient Token. This API will not return PCI payment data (PAN). Include the Request ID in the GET request to retrieve the transaction details.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param transientToken Transient Token returned by the Unified Checkout application. 
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getTransactionForTransientTokenWithHttpInfo(String transientToken) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getTransactionForTransientTokenRequestCreation(transientToken).toEntity(localVarReturnType);
    }

    /**
     * Get Transient Token Data
     * Retrieve the data captured by Unified Checkout. This API is used to retrieve the detailed data represented by the Transient Token. This API will not return PCI payment data (PAN). Include the Request ID in the GET request to retrieve the transaction details.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param transientToken Transient Token returned by the Unified Checkout application. 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTransactionForTransientTokenWithResponseSpec(String transientToken) throws WebClientResponseException {
        return getTransactionForTransientTokenRequestCreation(transientToken);
    }
}
