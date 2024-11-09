package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import java.time.LocalDate;
import org.openapitools.client.model.Reportingv3ReportDownloadsGet400Response;

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
public class ReportDownloadsApi {
    private ApiClient apiClient;

    public ReportDownloadsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ReportDownloadsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Download a Report
     * Download a report using the unique report name and date. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param reportDate Valid date on which to download the report in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**  yyyy-mm-dd For reports that span multiple days, this value would be the end date of the report in the time zone of the report subscription. Example 1: If your report start date is 2020-03-06 and the end date is 2020-03-09, the reportDate passed in the query is 2020-03-09. Example 2: If your report runs from midnight to midnight on 2020-03-09, the reportDate passed in the query is 2020-03-10 
     * @param reportName Name of the report to download
     * @param organizationId Valid Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec downloadReportRequestCreation(LocalDate reportDate, String reportName, String organizationId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'reportDate' is set
        if (reportDate == null) {
            throw new WebClientResponseException("Missing the required parameter 'reportDate' when calling downloadReport", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'reportName' is set
        if (reportName == null) {
            throw new WebClientResponseException("Missing the required parameter 'reportName' when calling downloadReport", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reportDate", reportDate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reportName", reportName));
        
        final String[] localVarAccepts = { 
            "application/xml", "text/csv"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/reporting/v3/report-downloads", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Download a Report
     * Download a report using the unique report name and date. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param reportDate Valid date on which to download the report in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**  yyyy-mm-dd For reports that span multiple days, this value would be the end date of the report in the time zone of the report subscription. Example 1: If your report start date is 2020-03-06 and the end date is 2020-03-09, the reportDate passed in the query is 2020-03-09. Example 2: If your report runs from midnight to midnight on 2020-03-09, the reportDate passed in the query is 2020-03-10 
     * @param reportName Name of the report to download
     * @param organizationId Valid Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> downloadReport(LocalDate reportDate, String reportName, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return downloadReportRequestCreation(reportDate, reportName, organizationId).bodyToMono(localVarReturnType);
    }

    /**
     * Download a Report
     * Download a report using the unique report name and date. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param reportDate Valid date on which to download the report in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**  yyyy-mm-dd For reports that span multiple days, this value would be the end date of the report in the time zone of the report subscription. Example 1: If your report start date is 2020-03-06 and the end date is 2020-03-09, the reportDate passed in the query is 2020-03-09. Example 2: If your report runs from midnight to midnight on 2020-03-09, the reportDate passed in the query is 2020-03-10 
     * @param reportName Name of the report to download
     * @param organizationId Valid Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> downloadReportWithHttpInfo(LocalDate reportDate, String reportName, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return downloadReportRequestCreation(reportDate, reportName, organizationId).toEntity(localVarReturnType);
    }

    /**
     * Download a Report
     * Download a report using the unique report name and date. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param reportDate Valid date on which to download the report in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**  yyyy-mm-dd For reports that span multiple days, this value would be the end date of the report in the time zone of the report subscription. Example 1: If your report start date is 2020-03-06 and the end date is 2020-03-09, the reportDate passed in the query is 2020-03-09. Example 2: If your report runs from midnight to midnight on 2020-03-09, the reportDate passed in the query is 2020-03-10 
     * @param reportName Name of the report to download
     * @param organizationId Valid Organization Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec downloadReportWithResponseSpec(LocalDate reportDate, String reportName, String organizationId) throws WebClientResponseException {
        return downloadReportRequestCreation(reportDate, reportName, organizationId);
    }
}
