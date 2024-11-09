package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateStandardOrClassicSubscription400Response;
import java.time.LocalDate;
import org.openapitools.client.model.V1FileDetailsGet200Response;
import org.openapitools.client.model.V1FileDetailsGet401Response;
import org.openapitools.client.model.V1FileDetailsGet404Response;
import org.openapitools.client.model.V1FileDetailsGet500Response;
import org.openapitools.client.model.V1FilesGet400Response;

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
public class SecureFileShareApi {
    private ApiClient apiClient;

    public SecureFileShareApi() {
        this(new ApiClient());
    }

    @Autowired
    public SecureFileShareApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Download a File with File Identifier
     * Download a file for the given file identifier
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param fileId Unique identifier for each file
     * @param organizationId Valid Cybersource Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getFileRequestCreation(String fileId, String organizationId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'fileId' is set
        if (fileId == null) {
            throw new WebClientResponseException("Missing the required parameter 'fileId' when calling getFile", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("fileId", fileId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        
        final String[] localVarAccepts = { 
            "application/xml", "text/csv", "application/pdf"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/sfs/v1/files/{fileId}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Download a File with File Identifier
     * Download a file for the given file identifier
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param fileId Unique identifier for each file
     * @param organizationId Valid Cybersource Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getFile(String fileId, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getFileRequestCreation(fileId, organizationId).bodyToMono(localVarReturnType);
    }

    /**
     * Download a File with File Identifier
     * Download a file for the given file identifier
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param fileId Unique identifier for each file
     * @param organizationId Valid Cybersource Organization Id
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getFileWithHttpInfo(String fileId, String organizationId) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getFileRequestCreation(fileId, organizationId).toEntity(localVarReturnType);
    }

    /**
     * Download a File with File Identifier
     * Download a file for the given file identifier
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid Request
     * <p><b>404</b> - No Reports Found
     * @param fileId Unique identifier for each file
     * @param organizationId Valid Cybersource Organization Id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getFileWithResponseSpec(String fileId, String organizationId) throws WebClientResponseException {
        return getFileRequestCreation(fileId, organizationId);
    }
    /**
     * Get List of Files
     * Get list of files and it&#39;s information of them available inside the report directory
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Ok
     * <p><b>404</b> - Files Info not found
     * <p><b>500</b> - Internal Server Error
     * @param startDate Valid start date in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd 
     * @param endDate Valid end date in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd 
     * @param organizationId Valid Cybersource Organization Id
     * @param name **Tailored to searches for specific files with in given Date range** example : MyTransactionDetailreport.xml 
     * @return V1FileDetailsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getFileDetailRequestCreation(LocalDate startDate, LocalDate endDate, String organizationId, String name) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'startDate' is set
        if (startDate == null) {
            throw new WebClientResponseException("Missing the required parameter 'startDate' when calling getFileDetail", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'endDate' is set
        if (endDate == null) {
            throw new WebClientResponseException("Missing the required parameter 'endDate' when calling getFileDetail", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startDate", startDate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "endDate", endDate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        
        final String[] localVarAccepts = { 
            "application/hal+json", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<V1FileDetailsGet200Response> localVarReturnType = new ParameterizedTypeReference<V1FileDetailsGet200Response>() {};
        return apiClient.invokeAPI("/sfs/v1/file-details", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get List of Files
     * Get list of files and it&#39;s information of them available inside the report directory
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Ok
     * <p><b>404</b> - Files Info not found
     * <p><b>500</b> - Internal Server Error
     * @param startDate Valid start date in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd 
     * @param endDate Valid end date in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd 
     * @param organizationId Valid Cybersource Organization Id
     * @param name **Tailored to searches for specific files with in given Date range** example : MyTransactionDetailreport.xml 
     * @return V1FileDetailsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<V1FileDetailsGet200Response> getFileDetail(LocalDate startDate, LocalDate endDate, String organizationId, String name) throws WebClientResponseException {
        ParameterizedTypeReference<V1FileDetailsGet200Response> localVarReturnType = new ParameterizedTypeReference<V1FileDetailsGet200Response>() {};
        return getFileDetailRequestCreation(startDate, endDate, organizationId, name).bodyToMono(localVarReturnType);
    }

    /**
     * Get List of Files
     * Get list of files and it&#39;s information of them available inside the report directory
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Ok
     * <p><b>404</b> - Files Info not found
     * <p><b>500</b> - Internal Server Error
     * @param startDate Valid start date in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd 
     * @param endDate Valid end date in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd 
     * @param organizationId Valid Cybersource Organization Id
     * @param name **Tailored to searches for specific files with in given Date range** example : MyTransactionDetailreport.xml 
     * @return ResponseEntity&lt;V1FileDetailsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<V1FileDetailsGet200Response>> getFileDetailWithHttpInfo(LocalDate startDate, LocalDate endDate, String organizationId, String name) throws WebClientResponseException {
        ParameterizedTypeReference<V1FileDetailsGet200Response> localVarReturnType = new ParameterizedTypeReference<V1FileDetailsGet200Response>() {};
        return getFileDetailRequestCreation(startDate, endDate, organizationId, name).toEntity(localVarReturnType);
    }

    /**
     * Get List of Files
     * Get list of files and it&#39;s information of them available inside the report directory
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Ok
     * <p><b>404</b> - Files Info not found
     * <p><b>500</b> - Internal Server Error
     * @param startDate Valid start date in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd 
     * @param endDate Valid end date in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd 
     * @param organizationId Valid Cybersource Organization Id
     * @param name **Tailored to searches for specific files with in given Date range** example : MyTransactionDetailreport.xml 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getFileDetailWithResponseSpec(LocalDate startDate, LocalDate endDate, String organizationId, String name) throws WebClientResponseException {
        return getFileDetailRequestCreation(startDate, endDate, organizationId, name);
    }
}
