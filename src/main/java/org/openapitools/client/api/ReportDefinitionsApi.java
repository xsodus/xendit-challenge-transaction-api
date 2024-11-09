package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ReportingV3ReportDefinitionsGet200Response;
import org.openapitools.client.model.ReportingV3ReportDefinitionsGet400Response;
import org.openapitools.client.model.ReportingV3ReportDefinitionsNameGet200Response;
import org.openapitools.client.model.ReportingV3ReportDefinitionsNameGet400Response;

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
public class ReportDefinitionsApi {
    private ApiClient apiClient;

    public ReportDefinitionsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ReportDefinitionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Report Definition
     * View the attributes of an individual report type. For a list of values for reportDefinitionName, see the [Reporting Developer Guide](https://www.cybersource.com/developers/documentation/reporting_and_reconciliation/) 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Report not found
     * @param reportDefinitionName Name of the Report definition to retrieve
     * @param subscriptionType The subscription type for which report definition is required. By default the type will be CUSTOM. Valid Values: - CLASSIC - CUSTOM - STANDARD 
     * @param reportMimeType The format for which the report definition is required. By default the value will be CSV. Valid Values: - application/xml - text/csv 
     * @param organizationId Valid Organization Id
     * @return ReportingV3ReportDefinitionsNameGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getResourceInfoByReportDefinitionRequestCreation(String reportDefinitionName, String subscriptionType, String reportMimeType, String organizationId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'reportDefinitionName' is set
        if (reportDefinitionName == null) {
            throw new WebClientResponseException("Missing the required parameter 'reportDefinitionName' when calling getResourceInfoByReportDefinition", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("reportDefinitionName", reportDefinitionName);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "subscriptionType", subscriptionType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "reportMimeType", reportMimeType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        
        final String[] localVarAccepts = { 
            "application/hal+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ReportingV3ReportDefinitionsNameGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportDefinitionsNameGet200Response>() {};
        return apiClient.invokeAPI("/reporting/v3/report-definitions/{reportDefinitionName}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Report Definition
     * View the attributes of an individual report type. For a list of values for reportDefinitionName, see the [Reporting Developer Guide](https://www.cybersource.com/developers/documentation/reporting_and_reconciliation/) 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Report not found
     * @param reportDefinitionName Name of the Report definition to retrieve
     * @param subscriptionType The subscription type for which report definition is required. By default the type will be CUSTOM. Valid Values: - CLASSIC - CUSTOM - STANDARD 
     * @param reportMimeType The format for which the report definition is required. By default the value will be CSV. Valid Values: - application/xml - text/csv 
     * @param organizationId Valid Organization Id
     * @return ReportingV3ReportDefinitionsNameGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ReportingV3ReportDefinitionsNameGet200Response> getResourceInfoByReportDefinition(String reportDefinitionName, String subscriptionType, String reportMimeType, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3ReportDefinitionsNameGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportDefinitionsNameGet200Response>() {};
        return getResourceInfoByReportDefinitionRequestCreation(reportDefinitionName, subscriptionType, reportMimeType, organizationId).bodyToMono(localVarReturnType);
    }

    /**
     * Get Report Definition
     * View the attributes of an individual report type. For a list of values for reportDefinitionName, see the [Reporting Developer Guide](https://www.cybersource.com/developers/documentation/reporting_and_reconciliation/) 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Report not found
     * @param reportDefinitionName Name of the Report definition to retrieve
     * @param subscriptionType The subscription type for which report definition is required. By default the type will be CUSTOM. Valid Values: - CLASSIC - CUSTOM - STANDARD 
     * @param reportMimeType The format for which the report definition is required. By default the value will be CSV. Valid Values: - application/xml - text/csv 
     * @param organizationId Valid Organization Id
     * @return ResponseEntity&lt;ReportingV3ReportDefinitionsNameGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ReportingV3ReportDefinitionsNameGet200Response>> getResourceInfoByReportDefinitionWithHttpInfo(String reportDefinitionName, String subscriptionType, String reportMimeType, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3ReportDefinitionsNameGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportDefinitionsNameGet200Response>() {};
        return getResourceInfoByReportDefinitionRequestCreation(reportDefinitionName, subscriptionType, reportMimeType, organizationId).toEntity(localVarReturnType);
    }

    /**
     * Get Report Definition
     * View the attributes of an individual report type. For a list of values for reportDefinitionName, see the [Reporting Developer Guide](https://www.cybersource.com/developers/documentation/reporting_and_reconciliation/) 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Report not found
     * @param reportDefinitionName Name of the Report definition to retrieve
     * @param subscriptionType The subscription type for which report definition is required. By default the type will be CUSTOM. Valid Values: - CLASSIC - CUSTOM - STANDARD 
     * @param reportMimeType The format for which the report definition is required. By default the value will be CSV. Valid Values: - application/xml - text/csv 
     * @param organizationId Valid Organization Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getResourceInfoByReportDefinitionWithResponseSpec(String reportDefinitionName, String subscriptionType, String reportMimeType, String organizationId) throws WebClientResponseException {
        return getResourceInfoByReportDefinitionRequestCreation(reportDefinitionName, subscriptionType, reportMimeType, organizationId);
    }
    /**
     * Get Reporting Resource Information
     * View a list of supported reports and their attributes before subscribing to them. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Report not found
     * @param subscriptionType Valid Values: - CLASSIC - CUSTOM - STANDARD 
     * @param organizationId Valid Organization Id
     * @return ReportingV3ReportDefinitionsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getResourceV2InfoRequestCreation(String subscriptionType, String organizationId) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "subscriptionType", subscriptionType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        
        final String[] localVarAccepts = { 
            "application/hal+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ReportingV3ReportDefinitionsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportDefinitionsGet200Response>() {};
        return apiClient.invokeAPI("/reporting/v3/report-definitions", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Reporting Resource Information
     * View a list of supported reports and their attributes before subscribing to them. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Report not found
     * @param subscriptionType Valid Values: - CLASSIC - CUSTOM - STANDARD 
     * @param organizationId Valid Organization Id
     * @return ReportingV3ReportDefinitionsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ReportingV3ReportDefinitionsGet200Response> getResourceV2Info(String subscriptionType, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3ReportDefinitionsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportDefinitionsGet200Response>() {};
        return getResourceV2InfoRequestCreation(subscriptionType, organizationId).bodyToMono(localVarReturnType);
    }

    /**
     * Get Reporting Resource Information
     * View a list of supported reports and their attributes before subscribing to them. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Report not found
     * @param subscriptionType Valid Values: - CLASSIC - CUSTOM - STANDARD 
     * @param organizationId Valid Organization Id
     * @return ResponseEntity&lt;ReportingV3ReportDefinitionsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ReportingV3ReportDefinitionsGet200Response>> getResourceV2InfoWithHttpInfo(String subscriptionType, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3ReportDefinitionsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3ReportDefinitionsGet200Response>() {};
        return getResourceV2InfoRequestCreation(subscriptionType, organizationId).toEntity(localVarReturnType);
    }

    /**
     * Get Reporting Resource Information
     * View a list of supported reports and their attributes before subscribing to them. 
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>404</b> - Report not found
     * @param subscriptionType Valid Values: - CLASSIC - CUSTOM - STANDARD 
     * @param organizationId Valid Organization Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getResourceV2InfoWithResponseSpec(String subscriptionType, String organizationId) throws WebClientResponseException {
        return getResourceV2InfoRequestCreation(subscriptionType, organizationId);
    }
}
