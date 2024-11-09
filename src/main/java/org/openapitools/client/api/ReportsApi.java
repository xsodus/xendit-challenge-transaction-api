package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateReportRequest;
import java.time.OffsetDateTime;
import org.openapitools.client.model.ReportingV3ReportsGet200Response;
import org.openapitools.client.model.ReportingV3ReportsGet400Response;
import org.openapitools.client.model.ReportingV3ReportsIdGet200Response;
import org.openapitools.client.model.ReportingV3ReportsIdPost400Response;
import org.openapitools.client.model.ReportingV3ReportsPost400Response;

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
public class ReportsApi {
    private ApiClient apiClient;

    public ReportsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ReportsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Adhoc Report
     * Create a one-time report. You must specify the type of report in reportDefinitionName. For a list of values for reportDefinitionName, see the [Reporting Developer Guide](https://www.cybersource.com/developers/documentation/reporting_and_reconciliation) 
     * <p><b>201</b> - Created
     * <p><b>304</b> - Not Modified
     * <p><b>400</b> - Invalid request
     * @param createAdhocReportRequest Report subscription request payload
     * @param organizationId Valid Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createReportRequestCreation(CreateReportRequest createAdhocReportRequest, String organizationId) throws WebClientResponseException {
        Object postBody = createAdhocReportRequest;
        // verify the required parameter 'createAdhocReportRequest' is set
        if (createAdhocReportRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'createAdhocReportRequest' when calling createReport", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        
        final String[] localVarAccepts = { 
            "application/hal+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/reporting/v3/reports", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Adhoc Report
     * Create a one-time report. You must specify the type of report in reportDefinitionName. For a list of values for reportDefinitionName, see the [Reporting Developer Guide](https://www.cybersource.com/developers/documentation/reporting_and_reconciliation) 
     * <p><b>201</b> - Created
     * <p><b>304</b> - Not Modified
     * <p><b>400</b> - Invalid request
     * @param createAdhocReportRequest Report subscription request payload
     * @param organizationId Valid Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> createReport(CreateReportRequest createAdhocReportRequest, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return createReportRequestCreation(createAdhocReportRequest, organizationId).bodyToMono(localVarReturnType);
    }

    /**
     * Create Adhoc Report
     * Create a one-time report. You must specify the type of report in reportDefinitionName. For a list of values for reportDefinitionName, see the [Reporting Developer Guide](https://www.cybersource.com/developers/documentation/reporting_and_reconciliation) 
     * <p><b>201</b> - Created
     * <p><b>304</b> - Not Modified
     * <p><b>400</b> - Invalid request
     * @param createAdhocReportRequest Report subscription request payload
     * @param organizationId Valid Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> createReportWithHttpInfo(CreateReportRequest createAdhocReportRequest, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return createReportRequestCreation(createAdhocReportRequest, organizationId).toEntity(localVarReturnType);
    }

    /**
     * Create Adhoc Report
     * Create a one-time report. You must specify the type of report in reportDefinitionName. For a list of values for reportDefinitionName, see the [Reporting Developer Guide](https://www.cybersource.com/developers/documentation/reporting_and_reconciliation) 
     * <p><b>201</b> - Created
     * <p><b>304</b> - Not Modified
     * <p><b>400</b> - Invalid request
     * @param createAdhocReportRequest Report subscription request payload
     * @param organizationId Valid Organization Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createReportWithResponseSpec(CreateReportRequest createAdhocReportRequest, String organizationId) throws WebClientResponseException {
        return createReportRequestCreation(createAdhocReportRequest, organizationId);
    }
    /**
     * Get Report Based on Report Id
     * Download a report using the reportId value. If you don&#39;t already know this value, you can obtain it using the Retrieve available reports call. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param reportId Valid Report Id
     * @param organizationId Valid Organization Id
     * @return ReportingV3ReportsIdGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getReportByReportIdRequestCreation(String reportId, String organizationId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new WebClientResponseException("Missing the required parameter 'reportId' when calling getReportByReportId", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("reportId", reportId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        
        final String[] localVarAccepts = { 
            "application/hal+json", "application/xml"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ReportingV3ReportsIdGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportsIdGet200Response>() {};
        return apiClient.invokeAPI("/reporting/v3/reports/{reportId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Report Based on Report Id
     * Download a report using the reportId value. If you don&#39;t already know this value, you can obtain it using the Retrieve available reports call. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param reportId Valid Report Id
     * @param organizationId Valid Organization Id
     * @return ReportingV3ReportsIdGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ReportingV3ReportsIdGet200Response> getReportByReportId(String reportId, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3ReportsIdGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportsIdGet200Response>() {};
        return getReportByReportIdRequestCreation(reportId, organizationId).bodyToMono(localVarReturnType);
    }

    /**
     * Get Report Based on Report Id
     * Download a report using the reportId value. If you don&#39;t already know this value, you can obtain it using the Retrieve available reports call. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param reportId Valid Report Id
     * @param organizationId Valid Organization Id
     * @return ResponseEntity&lt;ReportingV3ReportsIdGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ReportingV3ReportsIdGet200Response>> getReportByReportIdWithHttpInfo(String reportId, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3ReportsIdGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportsIdGet200Response>() {};
        return getReportByReportIdRequestCreation(reportId, organizationId).toEntity(localVarReturnType);
    }

    /**
     * Get Report Based on Report Id
     * Download a report using the reportId value. If you don&#39;t already know this value, you can obtain it using the Retrieve available reports call. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param reportId Valid Report Id
     * @param organizationId Valid Organization Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getReportByReportIdWithResponseSpec(String reportId, String organizationId) throws WebClientResponseException {
        return getReportByReportIdRequestCreation(reportId, organizationId);
    }
    /**
     * Retrieve Available Reports
     * Retrieve a list of the available reports to which you are subscribed. This will also give you the reportId value, which you can also use to download a report. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param timeQueryType Specify time you would like to search  Valid values: - reportTimeFrame - executedTime 
     * @param organizationId Valid Organization Id
     * @param reportMimeType Valid Report Format  Valid values: - application/xml - text/csv 
     * @param reportFrequency Valid Report Frequency  Valid values: - DAILY - WEEKLY - MONTHLY - USER_DEFINED - ADHOC 
     * @param reportName Valid Report Name
     * @param reportDefinitionId Valid Report Definition Id
     * @param reportStatus Valid Report Status  Valid values: - COMPLETED - PENDING - QUEUED - RUNNING - ERROR - NO_DATA 
     * @return ReportingV3ReportsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec searchReportsRequestCreation(OffsetDateTime startTime, OffsetDateTime endTime, String timeQueryType, String organizationId, String reportMimeType, String reportFrequency, String reportName, Integer reportDefinitionId, String reportStatus) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'startTime' is set
        if (startTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'startTime' when calling searchReports", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'endTime' is set
        if (endTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'endTime' when calling searchReports", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'timeQueryType' is set
        if (timeQueryType == null) {
            throw new WebClientResponseException("Missing the required parameter 'timeQueryType' when calling searchReports", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startTime", startTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "endTime", endTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "timeQueryType", timeQueryType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reportMimeType", reportMimeType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reportFrequency", reportFrequency));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reportName", reportName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reportDefinitionId", reportDefinitionId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reportStatus", reportStatus));
        
        final String[] localVarAccepts = { 
            "application/hal+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ReportingV3ReportsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportsGet200Response>() {};
        return apiClient.invokeAPI("/reporting/v3/reports", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve Available Reports
     * Retrieve a list of the available reports to which you are subscribed. This will also give you the reportId value, which you can also use to download a report. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param timeQueryType Specify time you would like to search  Valid values: - reportTimeFrame - executedTime 
     * @param organizationId Valid Organization Id
     * @param reportMimeType Valid Report Format  Valid values: - application/xml - text/csv 
     * @param reportFrequency Valid Report Frequency  Valid values: - DAILY - WEEKLY - MONTHLY - USER_DEFINED - ADHOC 
     * @param reportName Valid Report Name
     * @param reportDefinitionId Valid Report Definition Id
     * @param reportStatus Valid Report Status  Valid values: - COMPLETED - PENDING - QUEUED - RUNNING - ERROR - NO_DATA 
     * @return ReportingV3ReportsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ReportingV3ReportsGet200Response> searchReports(OffsetDateTime startTime, OffsetDateTime endTime, String timeQueryType, String organizationId, String reportMimeType, String reportFrequency, String reportName, Integer reportDefinitionId, String reportStatus) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3ReportsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportsGet200Response>() {};
        return searchReportsRequestCreation(startTime, endTime, timeQueryType, organizationId, reportMimeType, reportFrequency, reportName, reportDefinitionId, reportStatus).bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve Available Reports
     * Retrieve a list of the available reports to which you are subscribed. This will also give you the reportId value, which you can also use to download a report. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param timeQueryType Specify time you would like to search  Valid values: - reportTimeFrame - executedTime 
     * @param organizationId Valid Organization Id
     * @param reportMimeType Valid Report Format  Valid values: - application/xml - text/csv 
     * @param reportFrequency Valid Report Frequency  Valid values: - DAILY - WEEKLY - MONTHLY - USER_DEFINED - ADHOC 
     * @param reportName Valid Report Name
     * @param reportDefinitionId Valid Report Definition Id
     * @param reportStatus Valid Report Status  Valid values: - COMPLETED - PENDING - QUEUED - RUNNING - ERROR - NO_DATA 
     * @return ResponseEntity&lt;ReportingV3ReportsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ReportingV3ReportsGet200Response>> searchReportsWithHttpInfo(OffsetDateTime startTime, OffsetDateTime endTime, String timeQueryType, String organizationId, String reportMimeType, String reportFrequency, String reportName, Integer reportDefinitionId, String reportStatus) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3ReportsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportsGet200Response>() {};
        return searchReportsRequestCreation(startTime, endTime, timeQueryType, organizationId, reportMimeType, reportFrequency, reportName, reportDefinitionId, reportStatus).toEntity(localVarReturnType);
    }

    /**
     * Retrieve Available Reports
     * Retrieve a list of the available reports to which you are subscribed. This will also give you the reportId value, which you can also use to download a report. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param timeQueryType Specify time you would like to search  Valid values: - reportTimeFrame - executedTime 
     * @param organizationId Valid Organization Id
     * @param reportMimeType Valid Report Format  Valid values: - application/xml - text/csv 
     * @param reportFrequency Valid Report Frequency  Valid values: - DAILY - WEEKLY - MONTHLY - USER_DEFINED - ADHOC 
     * @param reportName Valid Report Name
     * @param reportDefinitionId Valid Report Definition Id
     * @param reportStatus Valid Report Status  Valid values: - COMPLETED - PENDING - QUEUED - RUNNING - ERROR - NO_DATA 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec searchReportsWithResponseSpec(OffsetDateTime startTime, OffsetDateTime endTime, String timeQueryType, String organizationId, String reportMimeType, String reportFrequency, String reportName, Integer reportDefinitionId, String reportStatus) throws WebClientResponseException {
        return searchReportsRequestCreation(startTime, endTime, timeQueryType, organizationId, reportMimeType, reportFrequency, reportName, reportDefinitionId, reportStatus);
    }
}
