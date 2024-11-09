package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import java.time.OffsetDateTime;
import org.openapitools.client.model.ReportingV3PurchaseRefundDetailsGet200Response;
import org.openapitools.client.model.ReportingV3PurchaseRefundDetailsGet400Response;
import org.openapitools.client.model.ReportingV3PurchaseRefundDetailsGet401Response;
import org.openapitools.client.model.ReportingV3PurchaseRefundDetailsGet404Response;
import org.openapitools.client.model.ReportingV3PurchaseRefundDetailsGet500Response;

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
public class PurchaseAndRefundDetailsApi {
    private ApiClient apiClient;

    public PurchaseAndRefundDetailsApi() {
        this(new ApiClient());
    }

    @Autowired
    public PurchaseAndRefundDetailsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Purchase and Refund Details
     * Download the Purchase and Refund Details report. This report report includes all purchases and refund transactions, as well as all activities related to transactions resulting in an adjustment to the net proceeds. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param paymentSubtype Payment Subtypes.   - **ALL**:  All Payment Subtypes   - **VI** :  Visa   - **MC** :  Master Card   - **AX** :  American Express   - **DI** :  Discover   - **DP** :  Pinless Debit 
     * @param viewBy View results by Request Date or Submission Date.   - **requestDate** : Request Date   - **submissionDate**: Submission Date 
     * @param groupName Valid CyberSource Group Name.User can define groups using CBAPI and Group Management Module in EBC2. Groups are collection of organizationIds
     * @param offset Offset of the Purchase and Refund Results.
     * @param limit Results count per page. Range(1-2000)
     * @return ReportingV3PurchaseRefundDetailsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getPurchaseAndRefundDetailsRequestCreation(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String paymentSubtype, String viewBy, String groupName, Integer offset, Integer limit) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'startTime' is set
        if (startTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'startTime' when calling getPurchaseAndRefundDetails", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'endTime' is set
        if (endTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'endTime' when calling getPurchaseAndRefundDetails", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "paymentSubtype", paymentSubtype));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "viewBy", viewBy));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "groupName", groupName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        
        final String[] localVarAccepts = { 
            "application/hal+json", "application/xml", "text/csv", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ReportingV3PurchaseRefundDetailsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3PurchaseRefundDetailsGet200Response>() {};
        return apiClient.invokeAPI("/reporting/v3/purchase-refund-details", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Purchase and Refund Details
     * Download the Purchase and Refund Details report. This report report includes all purchases and refund transactions, as well as all activities related to transactions resulting in an adjustment to the net proceeds. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param paymentSubtype Payment Subtypes.   - **ALL**:  All Payment Subtypes   - **VI** :  Visa   - **MC** :  Master Card   - **AX** :  American Express   - **DI** :  Discover   - **DP** :  Pinless Debit 
     * @param viewBy View results by Request Date or Submission Date.   - **requestDate** : Request Date   - **submissionDate**: Submission Date 
     * @param groupName Valid CyberSource Group Name.User can define groups using CBAPI and Group Management Module in EBC2. Groups are collection of organizationIds
     * @param offset Offset of the Purchase and Refund Results.
     * @param limit Results count per page. Range(1-2000)
     * @return ReportingV3PurchaseRefundDetailsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ReportingV3PurchaseRefundDetailsGet200Response> getPurchaseAndRefundDetails(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String paymentSubtype, String viewBy, String groupName, Integer offset, Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3PurchaseRefundDetailsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3PurchaseRefundDetailsGet200Response>() {};
        return getPurchaseAndRefundDetailsRequestCreation(startTime, endTime, organizationId, paymentSubtype, viewBy, groupName, offset, limit).bodyToMono(localVarReturnType);
    }

    /**
     * Get Purchase and Refund Details
     * Download the Purchase and Refund Details report. This report report includes all purchases and refund transactions, as well as all activities related to transactions resulting in an adjustment to the net proceeds. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param paymentSubtype Payment Subtypes.   - **ALL**:  All Payment Subtypes   - **VI** :  Visa   - **MC** :  Master Card   - **AX** :  American Express   - **DI** :  Discover   - **DP** :  Pinless Debit 
     * @param viewBy View results by Request Date or Submission Date.   - **requestDate** : Request Date   - **submissionDate**: Submission Date 
     * @param groupName Valid CyberSource Group Name.User can define groups using CBAPI and Group Management Module in EBC2. Groups are collection of organizationIds
     * @param offset Offset of the Purchase and Refund Results.
     * @param limit Results count per page. Range(1-2000)
     * @return ResponseEntity&lt;ReportingV3PurchaseRefundDetailsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ReportingV3PurchaseRefundDetailsGet200Response>> getPurchaseAndRefundDetailsWithHttpInfo(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String paymentSubtype, String viewBy, String groupName, Integer offset, Integer limit) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3PurchaseRefundDetailsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3PurchaseRefundDetailsGet200Response>() {};
        return getPurchaseAndRefundDetailsRequestCreation(startTime, endTime, organizationId, paymentSubtype, viewBy, groupName, offset, limit).toEntity(localVarReturnType);
    }

    /**
     * Get Purchase and Refund Details
     * Download the Purchase and Refund Details report. This report report includes all purchases and refund transactions, as well as all activities related to transactions resulting in an adjustment to the net proceeds. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param paymentSubtype Payment Subtypes.   - **ALL**:  All Payment Subtypes   - **VI** :  Visa   - **MC** :  Master Card   - **AX** :  American Express   - **DI** :  Discover   - **DP** :  Pinless Debit 
     * @param viewBy View results by Request Date or Submission Date.   - **requestDate** : Request Date   - **submissionDate**: Submission Date 
     * @param groupName Valid CyberSource Group Name.User can define groups using CBAPI and Group Management Module in EBC2. Groups are collection of organizationIds
     * @param offset Offset of the Purchase and Refund Results.
     * @param limit Results count per page. Range(1-2000)
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getPurchaseAndRefundDetailsWithResponseSpec(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String paymentSubtype, String viewBy, String groupName, Integer offset, Integer limit) throws WebClientResponseException {
        return getPurchaseAndRefundDetailsRequestCreation(startTime, endTime, organizationId, paymentSubtype, viewBy, groupName, offset, limit);
    }
}
