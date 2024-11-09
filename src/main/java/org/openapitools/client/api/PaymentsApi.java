package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateOrderRequestRequest;
import org.openapitools.client.model.CreatePaymentRequest;
import org.openapitools.client.model.CreateSessionRequestRequest;
import org.openapitools.client.model.IncrementAuthRequest;
import org.openapitools.client.model.PtsV2IncrementalAuthorizationPatch201Response;
import org.openapitools.client.model.PtsV2IncrementalAuthorizationPatch400Response;
import org.openapitools.client.model.PtsV2IncrementalAuthorizationPatch502Response;
import org.openapitools.client.model.PtsV2PaymentsOrderPost201Response;
import org.openapitools.client.model.PtsV2PaymentsPost201Response;
import org.openapitools.client.model.PtsV2PaymentsPost201Response1;
import org.openapitools.client.model.PtsV2PaymentsPost201Response2;
import org.openapitools.client.model.PtsV2PaymentsPost400Response;
import org.openapitools.client.model.PtsV2PaymentsPost502Response;
import org.openapitools.client.model.RefreshPaymentStatusRequest;

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
public class PaymentsApi {
    private ApiClient apiClient;

    public PaymentsApi() {
        this(new ApiClient());
    }

    @Autowired
    public PaymentsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Payment Order Request
     * Create a Payment Order Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Request identifier number for the order request. 
     * @param orderPaymentRequest The orderPaymentRequest parameter
     * @return PtsV2PaymentsOrderPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createOrderRequestRequestCreation(String id, CreateOrderRequestRequest orderPaymentRequest) throws WebClientResponseException {
        Object postBody = orderPaymentRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling createOrderRequest", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'orderPaymentRequest' is set
        if (orderPaymentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'orderPaymentRequest' when calling createOrderRequest", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2PaymentsOrderPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsOrderPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/payment-references/{id}/intents", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Payment Order Request
     * Create a Payment Order Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Request identifier number for the order request. 
     * @param orderPaymentRequest The orderPaymentRequest parameter
     * @return PtsV2PaymentsOrderPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PaymentsOrderPost201Response> createOrderRequest(String id, CreateOrderRequestRequest orderPaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsOrderPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsOrderPost201Response>() {};
        return createOrderRequestRequestCreation(id, orderPaymentRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Payment Order Request
     * Create a Payment Order Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Request identifier number for the order request. 
     * @param orderPaymentRequest The orderPaymentRequest parameter
     * @return ResponseEntity&lt;PtsV2PaymentsOrderPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PaymentsOrderPost201Response>> createOrderRequestWithHttpInfo(String id, CreateOrderRequestRequest orderPaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsOrderPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsOrderPost201Response>() {};
        return createOrderRequestRequestCreation(id, orderPaymentRequest).toEntity(localVarReturnType);
    }

    /**
     * Create a Payment Order Request
     * Create a Payment Order Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id Request identifier number for the order request. 
     * @param orderPaymentRequest The orderPaymentRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createOrderRequestWithResponseSpec(String id, CreateOrderRequestRequest orderPaymentRequest) throws WebClientResponseException {
        return createOrderRequestRequestCreation(id, orderPaymentRequest);
    }
    /**
     * Process a Payment
     * A payment authorizes the amount for the transaction. There are a number of supported payment features, such as E-commerce and Card Present - Credit Card/Debit Card, Echeck, e-Wallets, Level II/III Data, etc..  A payment response includes the status of the request. It also includes processor-specific information when the request is successful and errors if unsuccessful. See the [Payments Developer Guides Page](https://developer.cybersource.com/docs/cybs/en-us/payments/developer/ctv/rest/payments/payments-intro.html).  Authorization can be requested with Capture, Decision Manager, Payer Authentication(3ds), and Token Creation. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createPaymentRequest The createPaymentRequest parameter
     * @return PtsV2PaymentsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createPaymentRequestCreation(CreatePaymentRequest createPaymentRequest) throws WebClientResponseException {
        Object postBody = createPaymentRequest;
        // verify the required parameter 'createPaymentRequest' is set
        if (createPaymentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'createPaymentRequest' when calling createPayment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2PaymentsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/payments", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Process a Payment
     * A payment authorizes the amount for the transaction. There are a number of supported payment features, such as E-commerce and Card Present - Credit Card/Debit Card, Echeck, e-Wallets, Level II/III Data, etc..  A payment response includes the status of the request. It also includes processor-specific information when the request is successful and errors if unsuccessful. See the [Payments Developer Guides Page](https://developer.cybersource.com/docs/cybs/en-us/payments/developer/ctv/rest/payments/payments-intro.html).  Authorization can be requested with Capture, Decision Manager, Payer Authentication(3ds), and Token Creation. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createPaymentRequest The createPaymentRequest parameter
     * @return PtsV2PaymentsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PaymentsPost201Response> createPayment(CreatePaymentRequest createPaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response>() {};
        return createPaymentRequestCreation(createPaymentRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Process a Payment
     * A payment authorizes the amount for the transaction. There are a number of supported payment features, such as E-commerce and Card Present - Credit Card/Debit Card, Echeck, e-Wallets, Level II/III Data, etc..  A payment response includes the status of the request. It also includes processor-specific information when the request is successful and errors if unsuccessful. See the [Payments Developer Guides Page](https://developer.cybersource.com/docs/cybs/en-us/payments/developer/ctv/rest/payments/payments-intro.html).  Authorization can be requested with Capture, Decision Manager, Payer Authentication(3ds), and Token Creation. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createPaymentRequest The createPaymentRequest parameter
     * @return ResponseEntity&lt;PtsV2PaymentsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PaymentsPost201Response>> createPaymentWithHttpInfo(CreatePaymentRequest createPaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response>() {};
        return createPaymentRequestCreation(createPaymentRequest).toEntity(localVarReturnType);
    }

    /**
     * Process a Payment
     * A payment authorizes the amount for the transaction. There are a number of supported payment features, such as E-commerce and Card Present - Credit Card/Debit Card, Echeck, e-Wallets, Level II/III Data, etc..  A payment response includes the status of the request. It also includes processor-specific information when the request is successful and errors if unsuccessful. See the [Payments Developer Guides Page](https://developer.cybersource.com/docs/cybs/en-us/payments/developer/ctv/rest/payments/payments-intro.html).  Authorization can be requested with Capture, Decision Manager, Payer Authentication(3ds), and Token Creation. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createPaymentRequest The createPaymentRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createPaymentWithResponseSpec(CreatePaymentRequest createPaymentRequest) throws WebClientResponseException {
        return createPaymentRequestCreation(createPaymentRequest);
    }
    /**
     * Create Alternative Payments Sessions Request
     * Create Alternative Payments Sessions Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSessionReq The createSessionReq parameter
     * @return PtsV2PaymentsPost201Response2
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createSessionRequestRequestCreation(CreateSessionRequestRequest createSessionReq) throws WebClientResponseException {
        Object postBody = createSessionReq;
        // verify the required parameter 'createSessionReq' is set
        if (createSessionReq == null) {
            throw new WebClientResponseException("Missing the required parameter 'createSessionReq' when calling createSessionRequest", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2PaymentsPost201Response2> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response2>() {};
        return apiClient.invokeAPI("/pts/v2/payment-references", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Alternative Payments Sessions Request
     * Create Alternative Payments Sessions Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSessionReq The createSessionReq parameter
     * @return PtsV2PaymentsPost201Response2
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PaymentsPost201Response2> createSessionRequest(CreateSessionRequestRequest createSessionReq) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsPost201Response2> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response2>() {};
        return createSessionRequestRequestCreation(createSessionReq).bodyToMono(localVarReturnType);
    }

    /**
     * Create Alternative Payments Sessions Request
     * Create Alternative Payments Sessions Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSessionReq The createSessionReq parameter
     * @return ResponseEntity&lt;PtsV2PaymentsPost201Response2&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PaymentsPost201Response2>> createSessionRequestWithHttpInfo(CreateSessionRequestRequest createSessionReq) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsPost201Response2> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response2>() {};
        return createSessionRequestRequestCreation(createSessionReq).toEntity(localVarReturnType);
    }

    /**
     * Create Alternative Payments Sessions Request
     * Create Alternative Payments Sessions Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createSessionReq The createSessionReq parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createSessionRequestWithResponseSpec(CreateSessionRequestRequest createSessionReq) throws WebClientResponseException {
        return createSessionRequestRequestCreation(createSessionReq);
    }
    /**
     * Increment an Authorization
     * Use this service to authorize additional charges in a lodging or autorental transaction. Include the ID returned from the original authorization in the PATCH request to add additional charges to that authorization. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The ID returned from the original authorization request.
     * @param incrementAuthRequest The incrementAuthRequest parameter
     * @return PtsV2IncrementalAuthorizationPatch201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec incrementAuthRequestCreation(String id, IncrementAuthRequest incrementAuthRequest) throws WebClientResponseException {
        Object postBody = incrementAuthRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling incrementAuth", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'incrementAuthRequest' is set
        if (incrementAuthRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'incrementAuthRequest' when calling incrementAuth", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2IncrementalAuthorizationPatch201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2IncrementalAuthorizationPatch201Response>() {};
        return apiClient.invokeAPI("/pts/v2/payments/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Increment an Authorization
     * Use this service to authorize additional charges in a lodging or autorental transaction. Include the ID returned from the original authorization in the PATCH request to add additional charges to that authorization. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The ID returned from the original authorization request.
     * @param incrementAuthRequest The incrementAuthRequest parameter
     * @return PtsV2IncrementalAuthorizationPatch201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2IncrementalAuthorizationPatch201Response> incrementAuth(String id, IncrementAuthRequest incrementAuthRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2IncrementalAuthorizationPatch201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2IncrementalAuthorizationPatch201Response>() {};
        return incrementAuthRequestCreation(id, incrementAuthRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Increment an Authorization
     * Use this service to authorize additional charges in a lodging or autorental transaction. Include the ID returned from the original authorization in the PATCH request to add additional charges to that authorization. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The ID returned from the original authorization request.
     * @param incrementAuthRequest The incrementAuthRequest parameter
     * @return ResponseEntity&lt;PtsV2IncrementalAuthorizationPatch201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2IncrementalAuthorizationPatch201Response>> incrementAuthWithHttpInfo(String id, IncrementAuthRequest incrementAuthRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2IncrementalAuthorizationPatch201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2IncrementalAuthorizationPatch201Response>() {};
        return incrementAuthRequestCreation(id, incrementAuthRequest).toEntity(localVarReturnType);
    }

    /**
     * Increment an Authorization
     * Use this service to authorize additional charges in a lodging or autorental transaction. Include the ID returned from the original authorization in the PATCH request to add additional charges to that authorization. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The ID returned from the original authorization request.
     * @param incrementAuthRequest The incrementAuthRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec incrementAuthWithResponseSpec(String id, IncrementAuthRequest incrementAuthRequest) throws WebClientResponseException {
        return incrementAuthRequestCreation(id, incrementAuthRequest);
    }
    /**
     * Check a Payment Status
     * Checks and updates the payment status 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment id whose status needs to be checked and updated.
     * @param refreshPaymentStatusRequest The refreshPaymentStatusRequest parameter
     * @return PtsV2PaymentsPost201Response1
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec refreshPaymentStatusRequestCreation(String id, RefreshPaymentStatusRequest refreshPaymentStatusRequest) throws WebClientResponseException {
        Object postBody = refreshPaymentStatusRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling refreshPaymentStatus", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'refreshPaymentStatusRequest' is set
        if (refreshPaymentStatusRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'refreshPaymentStatusRequest' when calling refreshPaymentStatus", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2PaymentsPost201Response1> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response1>() {};
        return apiClient.invokeAPI("/pts/v2/refresh-payment-status/{id}", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Check a Payment Status
     * Checks and updates the payment status 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment id whose status needs to be checked and updated.
     * @param refreshPaymentStatusRequest The refreshPaymentStatusRequest parameter
     * @return PtsV2PaymentsPost201Response1
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PaymentsPost201Response1> refreshPaymentStatus(String id, RefreshPaymentStatusRequest refreshPaymentStatusRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsPost201Response1> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response1>() {};
        return refreshPaymentStatusRequestCreation(id, refreshPaymentStatusRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Check a Payment Status
     * Checks and updates the payment status 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment id whose status needs to be checked and updated.
     * @param refreshPaymentStatusRequest The refreshPaymentStatusRequest parameter
     * @return ResponseEntity&lt;PtsV2PaymentsPost201Response1&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PaymentsPost201Response1>> refreshPaymentStatusWithHttpInfo(String id, RefreshPaymentStatusRequest refreshPaymentStatusRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsPost201Response1> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response1>() {};
        return refreshPaymentStatusRequestCreation(id, refreshPaymentStatusRequest).toEntity(localVarReturnType);
    }

    /**
     * Check a Payment Status
     * Checks and updates the payment status 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment id whose status needs to be checked and updated.
     * @param refreshPaymentStatusRequest The refreshPaymentStatusRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec refreshPaymentStatusWithResponseSpec(String id, RefreshPaymentStatusRequest refreshPaymentStatusRequest) throws WebClientResponseException {
        return refreshPaymentStatusRequestCreation(id, refreshPaymentStatusRequest);
    }
    /**
     * Update Alternative Payments Sessions Request
     * Update Alternative Payments Sessions Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID. This ID is returned from a previous payment request.
     * @param createSessionRequest The createSessionRequest parameter
     * @return PtsV2PaymentsPost201Response2
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateSessionReqRequestCreation(String id, CreateSessionRequestRequest createSessionRequest) throws WebClientResponseException {
        Object postBody = createSessionRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling updateSessionReq", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'createSessionRequest' is set
        if (createSessionRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'createSessionRequest' when calling updateSessionReq", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2PaymentsPost201Response2> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response2>() {};
        return apiClient.invokeAPI("/pts/v2/payment-references/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update Alternative Payments Sessions Request
     * Update Alternative Payments Sessions Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID. This ID is returned from a previous payment request.
     * @param createSessionRequest The createSessionRequest parameter
     * @return PtsV2PaymentsPost201Response2
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PaymentsPost201Response2> updateSessionReq(String id, CreateSessionRequestRequest createSessionRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsPost201Response2> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response2>() {};
        return updateSessionReqRequestCreation(id, createSessionRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Update Alternative Payments Sessions Request
     * Update Alternative Payments Sessions Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID. This ID is returned from a previous payment request.
     * @param createSessionRequest The createSessionRequest parameter
     * @return ResponseEntity&lt;PtsV2PaymentsPost201Response2&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PaymentsPost201Response2>> updateSessionReqWithHttpInfo(String id, CreateSessionRequestRequest createSessionRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PaymentsPost201Response2> localVarReturnType = new ParameterizedTypeReference<PtsV2PaymentsPost201Response2>() {};
        return updateSessionReqRequestCreation(id, createSessionRequest).toEntity(localVarReturnType);
    }

    /**
     * Update Alternative Payments Sessions Request
     * Update Alternative Payments Sessions Request
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The payment ID. This ID is returned from a previous payment request.
     * @param createSessionRequest The createSessionRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateSessionReqWithResponseSpec(String id, CreateSessionRequestRequest createSessionRequest) throws WebClientResponseException {
        return updateSessionReqRequestCreation(id, createSessionRequest);
    }
}
