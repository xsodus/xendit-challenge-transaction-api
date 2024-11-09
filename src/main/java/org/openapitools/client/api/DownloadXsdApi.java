package org.openapitools.client.api;

import org.openapitools.client.ApiClient;


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
public class DownloadXsdApi {
    private ApiClient apiClient;

    public DownloadXsdApi() {
        this(new ApiClient());
    }

    @Autowired
    public DownloadXsdApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Download XSD for Report
     * Used to download XSDs for reports on no-auth.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Bad request. XSD file name may be invalid
     * <p><b>404</b> - XSD file not found
     * <p><b>500</b> - Internal Server Error
     * @param reportDefinitionNameVersion Name and version of XSD file to download. Some XSDs only have one version. In that case version name is not needed. Some example values are DecisionManagerDetailReport, DecisionManagerTypes
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getXSDV2RequestCreation(String reportDefinitionNameVersion) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'reportDefinitionNameVersion' is set
        if (reportDefinitionNameVersion == null) {
            throw new WebClientResponseException("Missing the required parameter 'reportDefinitionNameVersion' when calling getXSDV2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("reportDefinitionNameVersion", reportDefinitionNameVersion);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/reporting/v3/xsds/{reportDefinitionNameVersion}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Download XSD for Report
     * Used to download XSDs for reports on no-auth.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Bad request. XSD file name may be invalid
     * <p><b>404</b> - XSD file not found
     * <p><b>500</b> - Internal Server Error
     * @param reportDefinitionNameVersion Name and version of XSD file to download. Some XSDs only have one version. In that case version name is not needed. Some example values are DecisionManagerDetailReport, DecisionManagerTypes
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getXSDV2(String reportDefinitionNameVersion) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getXSDV2RequestCreation(reportDefinitionNameVersion).bodyToMono(localVarReturnType);
    }

    /**
     * Download XSD for Report
     * Used to download XSDs for reports on no-auth.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Bad request. XSD file name may be invalid
     * <p><b>404</b> - XSD file not found
     * <p><b>500</b> - Internal Server Error
     * @param reportDefinitionNameVersion Name and version of XSD file to download. Some XSDs only have one version. In that case version name is not needed. Some example values are DecisionManagerDetailReport, DecisionManagerTypes
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getXSDV2WithHttpInfo(String reportDefinitionNameVersion) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getXSDV2RequestCreation(reportDefinitionNameVersion).toEntity(localVarReturnType);
    }

    /**
     * Download XSD for Report
     * Used to download XSDs for reports on no-auth.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Bad request. XSD file name may be invalid
     * <p><b>404</b> - XSD file not found
     * <p><b>500</b> - Internal Server Error
     * @param reportDefinitionNameVersion Name and version of XSD file to download. Some XSDs only have one version. In that case version name is not needed. Some example values are DecisionManagerDetailReport, DecisionManagerTypes
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getXSDV2WithResponseSpec(String reportDefinitionNameVersion) throws WebClientResponseException {
        return getXSDV2RequestCreation(reportDefinitionNameVersion);
    }
}
