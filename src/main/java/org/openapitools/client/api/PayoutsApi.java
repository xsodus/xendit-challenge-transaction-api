package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.OctCreatePaymentRequest;
import org.openapitools.client.model.PtsV2PayoutsPost201Response;
import org.openapitools.client.model.PtsV2PayoutsPost400Response;
import org.openapitools.client.model.PtsV2PayoutsPost502Response;

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
public class PayoutsApi {
    private ApiClient apiClient;

    public PayoutsApi() {
        this(new ApiClient());
    }

    @Autowired
    public PayoutsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Process a Payout
     * Send funds from a selected funding source to a designated credit/debit card account or a prepaid card using an Original Credit Transaction (OCT). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param octCreatePaymentRequest The octCreatePaymentRequest parameter
     * @return PtsV2PayoutsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec octCreatePaymentRequestCreation(OctCreatePaymentRequest octCreatePaymentRequest) throws WebClientResponseException {
        Object postBody = octCreatePaymentRequest;
        // verify the required parameter 'octCreatePaymentRequest' is set
        if (octCreatePaymentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'octCreatePaymentRequest' when calling octCreatePayment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2PayoutsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PayoutsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/payouts", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Process a Payout
     * Send funds from a selected funding source to a designated credit/debit card account or a prepaid card using an Original Credit Transaction (OCT). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param octCreatePaymentRequest The octCreatePaymentRequest parameter
     * @return PtsV2PayoutsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2PayoutsPost201Response> octCreatePayment(OctCreatePaymentRequest octCreatePaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PayoutsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PayoutsPost201Response>() {};
        return octCreatePaymentRequestCreation(octCreatePaymentRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Process a Payout
     * Send funds from a selected funding source to a designated credit/debit card account or a prepaid card using an Original Credit Transaction (OCT). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param octCreatePaymentRequest The octCreatePaymentRequest parameter
     * @return ResponseEntity&lt;PtsV2PayoutsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2PayoutsPost201Response>> octCreatePaymentWithHttpInfo(OctCreatePaymentRequest octCreatePaymentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2PayoutsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2PayoutsPost201Response>() {};
        return octCreatePaymentRequestCreation(octCreatePaymentRequest).toEntity(localVarReturnType);
    }

    /**
     * Process a Payout
     * Send funds from a selected funding source to a designated credit/debit card account or a prepaid card using an Original Credit Transaction (OCT). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param octCreatePaymentRequest The octCreatePaymentRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec octCreatePaymentWithResponseSpec(OctCreatePaymentRequest octCreatePaymentRequest) throws WebClientResponseException {
        return octCreatePaymentRequestCreation(octCreatePaymentRequest);
    }
}
