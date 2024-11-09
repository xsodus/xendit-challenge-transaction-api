package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.MitVoidRequest;
import org.openapitools.client.model.PtsV2CapturesVoidsPost201Response;
import org.openapitools.client.model.PtsV2CapturesVoidsPost400Response;
import org.openapitools.client.model.PtsV2CapturesVoidsPost502Response;
import org.openapitools.client.model.PtsV2CreditsVoidsPost201Response;
import org.openapitools.client.model.PtsV2CreditsVoidsPost400Response;
import org.openapitools.client.model.PtsV2CreditsVoidsPost502Response;
import org.openapitools.client.model.PtsV2PaymentsVoidsPost201Response;
import org.openapitools.client.model.PtsV2PaymentsVoidsPost400Response;
import org.openapitools.client.model.PtsV2PaymentsVoidsPost502Response;
import org.openapitools.client.model.PtsV2RefundsVoidsPost201Response;
import org.openapitools.client.model.PtsV2RefundsVoidsPost400Response;
import org.openapitools.client.model.PtsV2RefundsVoidsPost502Response;
import org.openapitools.client.model.PtsV2VoidsPost200Response;
import org.openapitools.client.model.PtsV2VoidsPost400Response;
import org.openapitools.client.model.PtsV2VoidsPost502Response;
import org.openapitools.client.model.VoidPaymentRequest;

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
public class VoidApi {
    private ApiClient apiClient;

    public VoidApi() {
        this(new ApiClient());
    }

    @Autowired
    public VoidApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Timeout Void
     * This is to void a previous payment, capture, refund, or credit that merchant does not receive a reply(Mostly due to timeout). To use this feature/API, make sure to pass unique value to field - clientReferenceInformation -&gt; transactionId in your payment, capture, refund, or credit API call and use same transactionId in this API request payload to reverse the payment.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param mitVoidRequest The mitVoidRequest parameter
     * @return PtsV2VoidsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec mitVoidRequestCreation(MitVoidRequest mitVoidRequest) throws WebClientResponseException {
        Object postBody = mitVoidRequest;
        // verify the required parameter 'mitVoidRequest' is set
        if (mitVoidRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'mitVoidRequest' when calling mitVoid", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2VoidsPost200Response> localVarReturnType = new ParameterizedTypeReference<PtsV2VoidsPost200Response>() {};
        return apiClient.invokeAPI("/pts/v2/voids", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Timeout Void
     * This is to void a previous payment, capture, refund, or credit that merchant does not receive a reply(Mostly due to timeout). To use this feature/API, make sure to pass unique value to field - clientReferenceInformation -&gt; transactionId in your payment, capture, refund, or credit API call and use same transactionId in this API request payload to reverse the payment.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param mitVoidRequest The mitVoidRequest parameter
     * @return PtsV2VoidsPost200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2VoidsPost200Response> mitVoid(MitVoidRequest mitVoidRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2VoidsPost200Response> localVarReturnType = new ParameterizedTypeReference<PtsV2VoidsPost200Response>() {};
        return mitVoidRequestCreation(mitVoidRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Timeout Void
     * This is to void a previous payment, capture, refund, or credit that merchant does not receive a reply(Mostly due to timeout). To use this feature/API, make sure to pass unique value to field - clientReferenceInformation -&gt; transactionId in your payment, capture, refund, or credit API call and use same transactionId in this API request payload to reverse the payment.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param mitVoidRequest The mitVoidRequest parameter
     * @return ResponseEntity&lt;PtsV2VoidsPost200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2VoidsPost200Response>> mitVoidWithHttpInfo(MitVoidRequest mitVoidRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2VoidsPost200Response> localVarReturnType = new ParameterizedTypeReference<PtsV2VoidsPost200Response>() {};
        return mitVoidRequestCreation(mitVoidRequest).toEntity(localVarReturnType);
    }

    /**
     * Timeout Void
     * This is to void a previous payment, capture, refund, or credit that merchant does not receive a reply(Mostly due to timeout). To use this feature/API, make sure to pass unique value to field - clientReferenceInformation -&gt; transactionId in your payment, capture, refund, or credit API call and use same transactionId in this API request payload to reverse the payment.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param mitVoidRequest The mitVoidRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec mitVoidWithResponseSpec(MitVoidRequest mitVoidRequest) throws WebClientResponseException {
        return mitVoidRequestCreation(mitVoidRequest);
    }
    /**
     * Void a Capture
     * Refund a capture API is only used, if you have requested Capture independenlty using [/pts/v2/payments/{id}/captures](https://developer.cybersource.com/api-reference-assets/index.html#payments_capture) API call. Include the capture ID in the POST request to cancel the capture. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The capture ID returned from a previous capture request.
     * @param voidCaptureRequest The voidCaptureRequest parameter
     * @return PtsV2CapturesVoidsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec voidCaptureRequestCreation(String id, VoidPaymentRequest voidCaptureRequest) throws WebClientResponseException {
        Object postBody = voidCaptureRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling voidCapture", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'voidCaptureRequest' is set
        if (voidCaptureRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'voidCaptureRequest' when calling voidCapture", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2CapturesVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CapturesVoidsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/captures/{id}/voids", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Void a Capture
     * Refund a capture API is only used, if you have requested Capture independenlty using [/pts/v2/payments/{id}/captures](https://developer.cybersource.com/api-reference-assets/index.html#payments_capture) API call. Include the capture ID in the POST request to cancel the capture. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The capture ID returned from a previous capture request.
     * @param voidCaptureRequest The voidCaptureRequest parameter
     * @return PtsV2CapturesVoidsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2CapturesVoidsPost201Response> voidCapture(String id, VoidPaymentRequest voidCaptureRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CapturesVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CapturesVoidsPost201Response>() {};
        return voidCaptureRequestCreation(id, voidCaptureRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Void a Capture
     * Refund a capture API is only used, if you have requested Capture independenlty using [/pts/v2/payments/{id}/captures](https://developer.cybersource.com/api-reference-assets/index.html#payments_capture) API call. Include the capture ID in the POST request to cancel the capture. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The capture ID returned from a previous capture request.
     * @param voidCaptureRequest The voidCaptureRequest parameter
     * @return ResponseEntity&lt;PtsV2CapturesVoidsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2CapturesVoidsPost201Response>> voidCaptureWithHttpInfo(String id, VoidPaymentRequest voidCaptureRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CapturesVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CapturesVoidsPost201Response>() {};
        return voidCaptureRequestCreation(id, voidCaptureRequest).toEntity(localVarReturnType);
    }

    /**
     * Void a Capture
     * Refund a capture API is only used, if you have requested Capture independenlty using [/pts/v2/payments/{id}/captures](https://developer.cybersource.com/api-reference-assets/index.html#payments_capture) API call. Include the capture ID in the POST request to cancel the capture. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The capture ID returned from a previous capture request.
     * @param voidCaptureRequest The voidCaptureRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec voidCaptureWithResponseSpec(String id, VoidPaymentRequest voidCaptureRequest) throws WebClientResponseException {
        return voidCaptureRequestCreation(id, voidCaptureRequest);
    }
    /**
     * Void a Credit
     * Include the credit ID in the POST request to cancel the credit.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The credit ID returned from a previous credit request.
     * @param voidCreditRequest The voidCreditRequest parameter
     * @return PtsV2CreditsVoidsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec voidCreditRequestCreation(String id, VoidPaymentRequest voidCreditRequest) throws WebClientResponseException {
        Object postBody = voidCreditRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling voidCredit", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'voidCreditRequest' is set
        if (voidCreditRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'voidCreditRequest' when calling voidCredit", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2CreditsVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CreditsVoidsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/credits/{id}/voids", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Void a Credit
     * Include the credit ID in the POST request to cancel the credit.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The credit ID returned from a previous credit request.
     * @param voidCreditRequest The voidCreditRequest parameter
     * @return PtsV2CreditsVoidsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2CreditsVoidsPost201Response> voidCredit(String id, VoidPaymentRequest voidCreditRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CreditsVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CreditsVoidsPost201Response>() {};
        return voidCreditRequestCreation(id, voidCreditRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Void a Credit
     * Include the credit ID in the POST request to cancel the credit.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The credit ID returned from a previous credit request.
     * @param voidCreditRequest The voidCreditRequest parameter
     * @return ResponseEntity&lt;PtsV2CreditsVoidsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2CreditsVoidsPost201Response>> voidCreditWithHttpInfo(String id, VoidPaymentRequest voidCreditRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CreditsVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CreditsVoidsPost201Response>() {};
        return voidCreditRequestCreation(id, voidCreditRequest).toEntity(localVarReturnType);
    }

    /**
     * Void a Credit
     * Include the credit ID in the POST request to cancel the credit.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The credit ID returned from a previous credit request.
     * @param voidCreditRequest The voidCreditRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec voidCreditWithResponseSpec(String id, VoidPaymentRequest voidCreditRequest) throws WebClientResponseException {
        return voidCreditRequestCreation(id, voidCreditRequest);
    }
    /**
     * Void a Payment
     * Void a Payment API is only used, if you have requested Authorization and Capture together in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call. Include the payment ID in the POST request to cancel the payment. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request.
     * @param voidPaymentRequest The voidPaymentRequest parameter
     * @return PtsV2PaymentsVoidsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec voidPaymentRequestCreation(String id, VoidPaymentRequest voidPaymentRequest) throws WebClientResponseException {
        Object postBody = voidPaymentRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling voidPayment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'voidPaymentRequest' is set
        if (voidPaymentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'voidPaymentRequest' when calling voidPayment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2PaymentsVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsVoidsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/payments/{id}/voids", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Void a Payment
     * Void a Payment API is only used, if you have requested Authorization and Capture together in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call. Include the payment ID in the POST request to cancel the payment. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request.
     * @param voidPaymentRequest The voidPaymentRequest parameter
     * @return PtsV2PaymentsVoidsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PaymentsVoidsPost201Response> voidPayment(String id, VoidPaymentRequest voidPaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsVoidsPost201Response>() {};
        return voidPaymentRequestCreation(id, voidPaymentRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Void a Payment
     * Void a Payment API is only used, if you have requested Authorization and Capture together in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call. Include the payment ID in the POST request to cancel the payment. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request.
     * @param voidPaymentRequest The voidPaymentRequest parameter
     * @return ResponseEntity&lt;PtsV2PaymentsVoidsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PaymentsVoidsPost201Response>> voidPaymentWithHttpInfo(String id, VoidPaymentRequest voidPaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsVoidsPost201Response>() {};
        return voidPaymentRequestCreation(id, voidPaymentRequest).toEntity(localVarReturnType);
    }

    /**
     * Void a Payment
     * Void a Payment API is only used, if you have requested Authorization and Capture together in [/pts/v2/payments](https://developer.cybersource.com/api-reference-assets/index.html#payments_payments) API call. Include the payment ID in the POST request to cancel the payment. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID returned from a previous payment request.
     * @param voidPaymentRequest The voidPaymentRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec voidPaymentWithResponseSpec(String id, VoidPaymentRequest voidPaymentRequest) throws WebClientResponseException {
        return voidPaymentRequestCreation(id, voidPaymentRequest);
    }
    /**
     * Void a Refund
     * Include the refund ID in the POST request to cancel the refund.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The refund ID returned from a previous refund request.
     * @param voidRefundRequest The voidRefundRequest parameter
     * @return PtsV2RefundsVoidsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec voidRefundRequestCreation(String id, VoidPaymentRequest voidRefundRequest) throws WebClientResponseException {
        Object postBody = voidRefundRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling voidRefund", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'voidRefundRequest' is set
        if (voidRefundRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'voidRefundRequest' when calling voidRefund", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2RefundsVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2RefundsVoidsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/refunds/{id}/voids", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Void a Refund
     * Include the refund ID in the POST request to cancel the refund.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The refund ID returned from a previous refund request.
     * @param voidRefundRequest The voidRefundRequest parameter
     * @return PtsV2RefundsVoidsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2RefundsVoidsPost201Response> voidRefund(String id, VoidPaymentRequest voidRefundRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2RefundsVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2RefundsVoidsPost201Response>() {};
        return voidRefundRequestCreation(id, voidRefundRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Void a Refund
     * Include the refund ID in the POST request to cancel the refund.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The refund ID returned from a previous refund request.
     * @param voidRefundRequest The voidRefundRequest parameter
     * @return ResponseEntity&lt;PtsV2RefundsVoidsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2RefundsVoidsPost201Response>> voidRefundWithHttpInfo(String id, VoidPaymentRequest voidRefundRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2RefundsVoidsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2RefundsVoidsPost201Response>() {};
        return voidRefundRequestCreation(id, voidRefundRequest).toEntity(localVarReturnType);
    }

    /**
     * Void a Refund
     * Include the refund ID in the POST request to cancel the refund.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The refund ID returned from a previous refund request.
     * @param voidRefundRequest The voidRefundRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec voidRefundWithResponseSpec(String id, VoidPaymentRequest voidRefundRequest) throws WebClientResponseException {
        return voidRefundRequestCreation(id, voidRefundRequest);
    }
}
