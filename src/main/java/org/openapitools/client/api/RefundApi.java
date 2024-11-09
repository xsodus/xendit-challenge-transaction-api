package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.PtsV2CapturesRefundsPost201Response;
import org.openapitools.client.model.PtsV2CapturesRefundsPost400Response;
import org.openapitools.client.model.PtsV2CapturesRefundsPost502Response;
import org.openapitools.client.model.PtsV2PaymentsRefundPost201Response;
import org.openapitools.client.model.PtsV2PaymentsRefundPost400Response;
import org.openapitools.client.model.PtsV2PaymentsRefundPost502Response;
import org.openapitools.client.model.RefundPaymentRequest;

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
public class RefundApi {
    private ApiClient apiClient;

    public RefundApi() {
        this(new ApiClient());
    }

    @Autowired
    public RefundApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Refund a Capture
     * Refund a capture API is only used, if you have requested Capture independenlty using [/pts/v2/payments/{id}/captures](https://developer.cybersource.com/api-reference-assets/index.html#payments_capture) API call. Include the capture ID in the POST request to refund the captured amount. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The capture ID. This ID is returned from a previous capture request.
     * @param refundCaptureRequest The refundCaptureRequest parameter
     * @return PtsV2CapturesRefundsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec refundCaptureRequestCreation(String id, RefundPaymentRequest refundCaptureRequest) throws WebClientResponseException {
        Object postBody = refundCaptureRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling refundCapture", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'refundCaptureRequest' is set
        if (refundCaptureRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'refundCaptureRequest' when calling refundCapture", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2CapturesRefundsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CapturesRefundsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/captures/{id}/refunds", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Refund a Capture
     * Refund a capture API is only used, if you have requested Capture independenlty using [/pts/v2/payments/{id}/captures](https://developer.cybersource.com/api-reference-assets/index.html#payments_capture) API call. Include the capture ID in the POST request to refund the captured amount. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The capture ID. This ID is returned from a previous capture request.
     * @param refundCaptureRequest The refundCaptureRequest parameter
     * @return PtsV2CapturesRefundsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2CapturesRefundsPost201Response> refundCapture(String id, RefundPaymentRequest refundCaptureRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CapturesRefundsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CapturesRefundsPost201Response>() {};
        return refundCaptureRequestCreation(id, refundCaptureRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Refund a Capture
     * Refund a capture API is only used, if you have requested Capture independenlty using [/pts/v2/payments/{id}/captures](https://developer.cybersource.com/api-reference-assets/index.html#payments_capture) API call. Include the capture ID in the POST request to refund the captured amount. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The capture ID. This ID is returned from a previous capture request.
     * @param refundCaptureRequest The refundCaptureRequest parameter
     * @return ResponseEntity&lt;PtsV2CapturesRefundsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2CapturesRefundsPost201Response>> refundCaptureWithHttpInfo(String id, RefundPaymentRequest refundCaptureRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CapturesRefundsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CapturesRefundsPost201Response>() {};
        return refundCaptureRequestCreation(id, refundCaptureRequest).toEntity(localVarReturnType);
    }

    /**
     * Refund a Capture
     * Refund a capture API is only used, if you have requested Capture independenlty using [/pts/v2/payments/{id}/captures](https://developer.cybersource.com/api-reference-assets/index.html#payments_capture) API call. Include the capture ID in the POST request to refund the captured amount. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The capture ID. This ID is returned from a previous capture request.
     * @param refundCaptureRequest The refundCaptureRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec refundCaptureWithResponseSpec(String id, RefundPaymentRequest refundCaptureRequest) throws WebClientResponseException {
        return refundCaptureRequestCreation(id, refundCaptureRequest);
    }
    /**
     * Refund a Payment
     * Refund a Payment API is only used, if you have requested Authorization and Capture together in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call. Include the payment ID in the POST request to refund the payment amount. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID. This ID is returned from a previous payment request.
     * @param refundPaymentRequest The refundPaymentRequest parameter
     * @return PtsV2PaymentsRefundPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec refundPaymentRequestCreation(String id, RefundPaymentRequest refundPaymentRequest) throws WebClientResponseException {
        Object postBody = refundPaymentRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling refundPayment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'refundPaymentRequest' is set
        if (refundPaymentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'refundPaymentRequest' when calling refundPayment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2PaymentsRefundPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsRefundPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/payments/{id}/refunds", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Refund a Payment
     * Refund a Payment API is only used, if you have requested Authorization and Capture together in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call. Include the payment ID in the POST request to refund the payment amount. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID. This ID is returned from a previous payment request.
     * @param refundPaymentRequest The refundPaymentRequest parameter
     * @return PtsV2PaymentsRefundPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PaymentsRefundPost201Response> refundPayment(String id, RefundPaymentRequest refundPaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsRefundPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsRefundPost201Response>() {};
        return refundPaymentRequestCreation(id, refundPaymentRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Refund a Payment
     * Refund a Payment API is only used, if you have requested Authorization and Capture together in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call. Include the payment ID in the POST request to refund the payment amount. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID. This ID is returned from a previous payment request.
     * @param refundPaymentRequest The refundPaymentRequest parameter
     * @return ResponseEntity&lt;PtsV2PaymentsRefundPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PaymentsRefundPost201Response>> refundPaymentWithHttpInfo(String id, RefundPaymentRequest refundPaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsRefundPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsRefundPost201Response>() {};
        return refundPaymentRequestCreation(id, refundPaymentRequest).toEntity(localVarReturnType);
    }

    /**
     * Refund a Payment
     * Refund a Payment API is only used, if you have requested Authorization and Capture together in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call. Include the payment ID in the POST request to refund the payment amount. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID. This ID is returned from a previous payment request.
     * @param refundPaymentRequest The refundPaymentRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec refundPaymentWithResponseSpec(String id, RefundPaymentRequest refundPaymentRequest) throws WebClientResponseException {
        return refundPaymentRequestCreation(id, refundPaymentRequest);
    }
}
