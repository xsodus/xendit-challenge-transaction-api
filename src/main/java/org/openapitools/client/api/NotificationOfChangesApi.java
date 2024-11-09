package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import java.time.OffsetDateTime;
import org.openapitools.client.model.ReportingV3NotificationofChangesGet200Response;
import org.openapitools.client.model.ReportingV3NotificationofChangesGet400Response;
import org.openapitools.client.model.ReportingV3NotificationofChangesGet404Response;
import org.openapitools.client.model.ReportingV3NotificationofChangesGet500Response;

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
public class NotificationOfChangesApi {
    private ApiClient apiClient;

    public NotificationOfChangesApi() {
        this(new ApiClient());
    }

    @Autowired
    public NotificationOfChangesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Notification of Changes
     * Download the Notification of Change report. This report shows eCheck-related fields updated as a result of a response to an eCheck settlement transaction. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized. Token provided is no more valid.
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @return ReportingV3NotificationofChangesGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getNotificationOfChangeReportRequestCreation(OffsetDateTime startTime, OffsetDateTime endTime) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'startTime' is set
        if (startTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'startTime' when calling getNotificationOfChangeReport", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'endTime' is set
        if (endTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'endTime' when calling getNotificationOfChangeReport", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startTime", startTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "endTime", endTime));
        
        final String[] localVarAccepts = { 
            "application/hal+json", "text/csv", "application/xml"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ReportingV3NotificationofChangesGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3NotificationofChangesGet200Response>() {};
        return apiClient.invokeAPI("/reporting/v3/notification-of-changes", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Notification of Changes
     * Download the Notification of Change report. This report shows eCheck-related fields updated as a result of a response to an eCheck settlement transaction. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized. Token provided is no more valid.
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @return ReportingV3NotificationofChangesGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ReportingV3NotificationofChangesGet200Response> getNotificationOfChangeReport(OffsetDateTime startTime, OffsetDateTime endTime) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3NotificationofChangesGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3NotificationofChangesGet200Response>() {};
        return getNotificationOfChangeReportRequestCreation(startTime, endTime).bodyToMono(localVarReturnType);
    }

    /**
     * Get Notification of Changes
     * Download the Notification of Change report. This report shows eCheck-related fields updated as a result of a response to an eCheck settlement transaction. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized. Token provided is no more valid.
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @return ResponseEntity&lt;ReportingV3NotificationofChangesGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ReportingV3NotificationofChangesGet200Response>> getNotificationOfChangeReportWithHttpInfo(OffsetDateTime startTime, OffsetDateTime endTime) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3NotificationofChangesGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3NotificationofChangesGet200Response>() {};
        return getNotificationOfChangeReportRequestCreation(startTime, endTime).toEntity(localVarReturnType);
    }

    /**
     * Get Notification of Changes
     * Download the Notification of Change report. This report shows eCheck-related fields updated as a result of a response to an eCheck settlement transaction. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized. Token provided is no more valid.
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getNotificationOfChangeReportWithResponseSpec(OffsetDateTime startTime, OffsetDateTime endTime) throws WebClientResponseException {
        return getNotificationOfChangeReportRequestCreation(startTime, endTime);
    }
}
