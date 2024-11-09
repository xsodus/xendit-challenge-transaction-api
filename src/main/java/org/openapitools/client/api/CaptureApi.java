package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CapturePaymentRequest;
import org.openapitools.client.model.PtsV2PaymentsCapturesPost201Response;
import org.openapitools.client.model.PtsV2PaymentsCapturesPost400Response;
import org.openapitools.client.model.PtsV2PaymentsCapturesPost502Response;

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
public class CaptureApi {
    private ApiClient apiClient;

    public CaptureApi() {
        this(new ApiClient());
    }

    @Autowired
    public CaptureApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Capture a Payment
     * Include the payment ID in the POST request to capture the payment amount.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request. This ID links the capture to the payment. 
     * @param capturePaymentRequest The capturePaymentRequest parameter
     * @return PtsV2PaymentsCapturesPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec capturePaymentRequestCreation(String id, CapturePaymentRequest capturePaymentRequest) throws WebClientResponseException {
        Object postBody = capturePaymentRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling capturePayment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'capturePaymentRequest' is set
        if (capturePaymentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'capturePaymentRequest' when calling capturePayment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2PaymentsCapturesPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsCapturesPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/payments/{id}/captures", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Capture a Payment
     * Include the payment ID in the POST request to capture the payment amount.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request. This ID links the capture to the payment. 
     * @param capturePaymentRequest The capturePaymentRequest parameter
     * @return PtsV2PaymentsCapturesPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PaymentsCapturesPost201Response> capturePayment(String id, CapturePaymentRequest capturePaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsCapturesPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsCapturesPost201Response>() {};
        return capturePaymentRequestCreation(id, capturePaymentRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Capture a Payment
     * Include the payment ID in the POST request to capture the payment amount.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request. This ID links the capture to the payment. 
     * @param capturePaymentRequest The capturePaymentRequest parameter
     * @return ResponseEntity&lt;PtsV2PaymentsCapturesPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PaymentsCapturesPost201Response>> capturePaymentWithHttpInfo(String id, CapturePaymentRequest capturePaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsCapturesPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsCapturesPost201Response>() {};
        return capturePaymentRequestCreation(id, capturePaymentRequest).toEntity(localVarReturnType);
    }

    /**
     * Capture a Payment
     * Include the payment ID in the POST request to capture the payment amount.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request. This ID links the capture to the payment. 
     * @param capturePaymentRequest The capturePaymentRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec capturePaymentWithResponseSpec(String id, CapturePaymentRequest capturePaymentRequest) throws WebClientResponseException {
        return capturePaymentRequestCreation(id, capturePaymentRequest);
    }
}
