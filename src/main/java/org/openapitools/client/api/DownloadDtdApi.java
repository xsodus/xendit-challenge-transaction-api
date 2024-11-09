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
public class DownloadDtdApi {
    private ApiClient apiClient;

    public DownloadDtdApi() {
        this(new ApiClient());
    }

    @Autowired
    public DownloadDtdApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Download DTD for Report
     * Used to download DTDs for reports on no-auth.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Bad request. DTD file name may be invalid
     * <p><b>404</b> - DTD file not found
     * <p><b>500</b> - Internal Server Error
     * @param reportDefinitionNameVersion Name and version of DTD file to download. Some DTDs only have one version. In that case version name is not needed. Some example values are ctdr-1.0, tdr, pbdr-1.1
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getDTDV2RequestCreation(String reportDefinitionNameVersion) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'reportDefinitionNameVersion' is set
        if (reportDefinitionNameVersion == null) {
            throw new WebClientResponseException("Missing the required parameter 'reportDefinitionNameVersion' when calling getDTDV2", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/reporting/v3/dtds/{reportDefinitionNameVersion}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Download DTD for Report
     * Used to download DTDs for reports on no-auth.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Bad request. DTD file name may be invalid
     * <p><b>404</b> - DTD file not found
     * <p><b>500</b> - Internal Server Error
     * @param reportDefinitionNameVersion Name and version of DTD file to download. Some DTDs only have one version. In that case version name is not needed. Some example values are ctdr-1.0, tdr, pbdr-1.1
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getDTDV2(String reportDefinitionNameVersion) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getDTDV2RequestCreation(reportDefinitionNameVersion).bodyToMono(localVarReturnType);
    }

    /**
     * Download DTD for Report
     * Used to download DTDs for reports on no-auth.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Bad request. DTD file name may be invalid
     * <p><b>404</b> - DTD file not found
     * <p><b>500</b> - Internal Server Error
     * @param reportDefinitionNameVersion Name and version of DTD file to download. Some DTDs only have one version. In that case version name is not needed. Some example values are ctdr-1.0, tdr, pbdr-1.1
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getDTDV2WithHttpInfo(String reportDefinitionNameVersion) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getDTDV2RequestCreation(reportDefinitionNameVersion).toEntity(localVarReturnType);
    }

    /**
     * Download DTD for Report
     * Used to download DTDs for reports on no-auth.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Bad request. DTD file name may be invalid
     * <p><b>404</b> - DTD file not found
     * <p><b>500</b> - Internal Server Error
     * @param reportDefinitionNameVersion Name and version of DTD file to download. Some DTDs only have one version. In that case version name is not needed. Some example values are ctdr-1.0, tdr, pbdr-1.1
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getDTDV2WithResponseSpec(String reportDefinitionNameVersion) throws WebClientResponseException {
        return getDTDV2RequestCreation(reportDefinitionNameVersion);
    }
}
