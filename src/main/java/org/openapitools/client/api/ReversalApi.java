package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.AuthReversalRequest;
import org.openapitools.client.model.MitReversalRequest;
import org.openapitools.client.model.PtsV2PaymentsReversalsPost201Response;
import org.openapitools.client.model.PtsV2PaymentsReversalsPost400Response;
import org.openapitools.client.model.PtsV2PaymentsReversalsPost502Response;
import org.openapitools.client.model.PtsV2ReversalsPost201Response;
import org.openapitools.client.model.PtsV2ReversalsPost400Response;
import org.openapitools.client.model.PtsV2ReversalsPost502Response;

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
public class ReversalApi {
    private ApiClient apiClient;

    public ReversalApi() {
        this(new ApiClient());
    }

    @Autowired
    public ReversalApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Process an Authorization Reversal
     * Include the payment ID in the POST request to reverse the payment amount.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request.
     * @param authReversalRequest The authReversalRequest parameter
     * @return PtsV2PaymentsReversalsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec authReversalRequestCreation(String id, AuthReversalRequest authReversalRequest) throws WebClientResponseException {
        Object postBody = authReversalRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling authReversal", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'authReversalRequest' is set
        if (authReversalRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'authReversalRequest' when calling authReversal", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PtsV2PaymentsReversalsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsReversalsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/payments/{id}/reversals", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Process an Authorization Reversal
     * Include the payment ID in the POST request to reverse the payment amount.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request.
     * @param authReversalRequest The authReversalRequest parameter
     * @return PtsV2PaymentsReversalsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PaymentsReversalsPost201Response> authReversal(String id, AuthReversalRequest authReversalRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsReversalsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsReversalsPost201Response>() {};
        return authReversalRequestCreation(id, authReversalRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Process an Authorization Reversal
     * Include the payment ID in the POST request to reverse the payment amount.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request.
     * @param authReversalRequest The authReversalRequest parameter
     * @return ResponseEntity&lt;PtsV2PaymentsReversalsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PaymentsReversalsPost201Response>> authReversalWithHttpInfo(String id, AuthReversalRequest authReversalRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsReversalsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsReversalsPost201Response>() {};
        return authReversalRequestCreation(id, authReversalRequest).toEntity(localVarReturnType);
    }

    /**
     * Process an Authorization Reversal
     * Include the payment ID in the POST request to reverse the payment amount.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request.
     * @param authReversalRequest The authReversalRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec authReversalWithResponseSpec(String id, AuthReversalRequest authReversalRequest) throws WebClientResponseException {
        return authReversalRequestCreation(id, authReversalRequest);
    }
    /**
     * Timeout Reversal
     * This is to reverse a previous payment that merchant does not receive a reply(Mostly due to Timeout). To use this feature/API, make sure to pass unique value to field - clientReferenceInformation -&gt; transactionId in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call and use same transactionId in this API request payload to reverse the payment.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param mitReversalRequest The mitReversalRequest parameter
     * @return PtsV2ReversalsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec mitReversalRequestCreation(MitReversalRequest mitReversalRequest) throws WebClientResponseException {
        Object postBody = mitReversalRequest;
        // verify the required parameter 'mitReversalRequest' is set
        if (mitReversalRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'mitReversalRequest' when calling mitReversal", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PtsV2ReversalsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2ReversalsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/reversals", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Timeout Reversal
     * This is to reverse a previous payment that merchant does not receive a reply(Mostly due to Timeout). To use this feature/API, make sure to pass unique value to field - clientReferenceInformation -&gt; transactionId in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call and use same transactionId in this API request payload to reverse the payment.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param mitReversalRequest The mitReversalRequest parameter
     * @return PtsV2ReversalsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2ReversalsPost201Response> mitReversal(MitReversalRequest mitReversalRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2ReversalsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2ReversalsPost201Response>() {};
        return mitReversalRequestCreation(mitReversalRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Timeout Reversal
     * This is to reverse a previous payment that merchant does not receive a reply(Mostly due to Timeout). To use this feature/API, make sure to pass unique value to field - clientReferenceInformation -&gt; transactionId in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call and use same transactionId in this API request payload to reverse the payment.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param mitReversalRequest The mitReversalRequest parameter
     * @return ResponseEntity&lt;PtsV2ReversalsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2ReversalsPost201Response>> mitReversalWithHttpInfo(MitReversalRequest mitReversalRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2ReversalsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2ReversalsPost201Response>() {};
        return mitReversalRequestCreation(mitReversalRequest).toEntity(localVarReturnType);
    }

    /**
     * Timeout Reversal
     * This is to reverse a previous payment that merchant does not receive a reply(Mostly due to Timeout). To use this feature/API, make sure to pass unique value to field - clientReferenceInformation -&gt; transactionId in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call and use same transactionId in this API request payload to reverse the payment.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param mitReversalRequest The mitReversalRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec mitReversalWithResponseSpec(MitReversalRequest mitReversalRequest) throws WebClientResponseException {
        return mitReversalRequestCreation(mitReversalRequest);
    }
}
