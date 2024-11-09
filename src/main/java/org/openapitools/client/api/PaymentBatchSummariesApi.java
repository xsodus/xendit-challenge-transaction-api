package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import java.time.OffsetDateTime;
import org.openapitools.client.model.ReportingV3PaymentBatchSummariesGet200Response;
import org.openapitools.client.model.ReportingV3PaymentBatchSummariesGet200Response1;

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
public class PaymentBatchSummariesApi {
    private ApiClient apiClient;

    public PaymentBatchSummariesApi() {
        this(new ApiClient());
    }

    @Autowired
    public PaymentBatchSummariesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Payment Batch Summary Data
     * Scope can be either account/merchant or reseller.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Payment Batch Summary not found
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param rollUp Conditional - RollUp for data for day/week/month. Required while getting breakdown data for a Merchant
     * @param breakdown Conditional - Breakdown on account_rollup/all_merchant/selected_merchant. Required while getting breakdown data for a Merchant.
     * @param startDayOfWeek Optional - Start day of week to breakdown data for weeks in a month
     * @return ReportingV3PaymentBatchSummariesGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getPaymentBatchSummaryRequestCreation(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String rollUp, String breakdown, Integer startDayOfWeek) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'startTime' is set
        if (startTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'startTime' when calling getPaymentBatchSummary", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'endTime' is set
        if (endTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'endTime' when calling getPaymentBatchSummary", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startTime", startTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "endTime", endTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "rollUp", rollUp));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "breakdown", breakdown));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startDayOfWeek", startDayOfWeek));
        
        final String[] localVarAccepts = { 
            "application/hal+json", "text/csv", "application/xml"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ReportingV3PaymentBatchSummariesGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3PaymentBatchSummariesGet200Response>() {};
        return apiClient.invokeAPI("/reporting/v3/payment-batch-summaries", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Payment Batch Summary Data
     * Scope can be either account/merchant or reseller.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Payment Batch Summary not found
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param rollUp Conditional - RollUp for data for day/week/month. Required while getting breakdown data for a Merchant
     * @param breakdown Conditional - Breakdown on account_rollup/all_merchant/selected_merchant. Required while getting breakdown data for a Merchant.
     * @param startDayOfWeek Optional - Start day of week to breakdown data for weeks in a month
     * @return ReportingV3PaymentBatchSummariesGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ReportingV3PaymentBatchSummariesGet200Response> getPaymentBatchSummary(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String rollUp, String breakdown, Integer startDayOfWeek) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3PaymentBatchSummariesGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3PaymentBatchSummariesGet200Response>() {};
        return getPaymentBatchSummaryRequestCreation(startTime, endTime, organizationId, rollUp, breakdown, startDayOfWeek).bodyToMono(localVarReturnType);
    }

    /**
     * Get Payment Batch Summary Data
     * Scope can be either account/merchant or reseller.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Payment Batch Summary not found
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param rollUp Conditional - RollUp for data for day/week/month. Required while getting breakdown data for a Merchant
     * @param breakdown Conditional - Breakdown on account_rollup/all_merchant/selected_merchant. Required while getting breakdown data for a Merchant.
     * @param startDayOfWeek Optional - Start day of week to breakdown data for weeks in a month
     * @return ResponseEntity&lt;ReportingV3PaymentBatchSummariesGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ReportingV3PaymentBatchSummariesGet200Response>> getPaymentBatchSummaryWithHttpInfo(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String rollUp, String breakdown, Integer startDayOfWeek) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3PaymentBatchSummariesGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3PaymentBatchSummariesGet200Response>() {};
        return getPaymentBatchSummaryRequestCreation(startTime, endTime, organizationId, rollUp, breakdown, startDayOfWeek).toEntity(localVarReturnType);
    }

    /**
     * Get Payment Batch Summary Data
     * Scope can be either account/merchant or reseller.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Payment Batch Summary not found
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param rollUp Conditional - RollUp for data for day/week/month. Required while getting breakdown data for a Merchant
     * @param breakdown Conditional - Breakdown on account_rollup/all_merchant/selected_merchant. Required while getting breakdown data for a Merchant.
     * @param startDayOfWeek Optional - Start day of week to breakdown data for weeks in a month
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getPaymentBatchSummaryWithResponseSpec(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String rollUp, String breakdown, Integer startDayOfWeek) throws WebClientResponseException {
        return getPaymentBatchSummaryRequestCreation(startTime, endTime, organizationId, rollUp, breakdown, startDayOfWeek);
    }
}
