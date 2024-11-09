package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.openapitools.client.model.PtsV1TransactionBatchDetailsGet400Response;
import org.openapitools.client.model.PtsV1TransactionBatchDetailsGet401Response;
import org.openapitools.client.model.PtsV1TransactionBatchDetailsGet403Response;
import org.openapitools.client.model.PtsV1TransactionBatchDetailsGet404Response;
import org.openapitools.client.model.PtsV1TransactionBatchDetailsGet502Response;
import org.openapitools.client.model.PtsV1TransactionBatchesGet200Response;
import org.openapitools.client.model.PtsV1TransactionBatchesGet400Response;
import org.openapitools.client.model.PtsV1TransactionBatchesGet401Response;
import org.openapitools.client.model.PtsV1TransactionBatchesGet403Response;
import org.openapitools.client.model.PtsV1TransactionBatchesGet404Response;
import org.openapitools.client.model.PtsV1TransactionBatchesGet500Response;
import org.openapitools.client.model.PtsV1TransactionBatchesGet502Response;
import org.openapitools.client.model.PtsV1TransactionBatchesIdGet200Response;

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
public class TransactionBatchesApi {
    private ApiClient apiClient;

    public TransactionBatchesApi() {
        this(new ApiClient());
    }

    @Autowired
    public TransactionBatchesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Transaction Details for a given Batch Id
     * Provides real-time detailed status information about the transactions that you previously uploaded in the Business Center or processed with the Offline Transaction File Submission service. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>502</b> - Bad Gateway
     * @param id The batch id assigned for the template.
     * @param uploadDate Date in which the original batch file was uploaded. Date must be in ISO-8601 format. Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) **Example date format:**  - yyyy-MM-dd 
     * @param status Allows you to filter by rejected response.  Valid values: - Rejected 
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTransactionBatchDetailsRequestCreation(String id, LocalDate uploadDate, String status) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getTransactionBatchDetails", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "uploadDate", uploadDate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        
        final String[] localVarAccepts = { 
            "text/vnd.cybersource.map-csv", "text/csv", "application/xml"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/pts/v1/transaction-batch-details/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Transaction Details for a given Batch Id
     * Provides real-time detailed status information about the transactions that you previously uploaded in the Business Center or processed with the Offline Transaction File Submission service. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>502</b> - Bad Gateway
     * @param id The batch id assigned for the template.
     * @param uploadDate Date in which the original batch file was uploaded. Date must be in ISO-8601 format. Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) **Example date format:**  - yyyy-MM-dd 
     * @param status Allows you to filter by rejected response.  Valid values: - Rejected 
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> getTransactionBatchDetails(String id, LocalDate uploadDate, String status) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getTransactionBatchDetailsRequestCreation(id, uploadDate, status).bodyToMono(localVarReturnType);
    }

    /**
     * Get Transaction Details for a given Batch Id
     * Provides real-time detailed status information about the transactions that you previously uploaded in the Business Center or processed with the Offline Transaction File Submission service. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>502</b> - Bad Gateway
     * @param id The batch id assigned for the template.
     * @param uploadDate Date in which the original batch file was uploaded. Date must be in ISO-8601 format. Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) **Example date format:**  - yyyy-MM-dd 
     * @param status Allows you to filter by rejected response.  Valid values: - Rejected 
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> getTransactionBatchDetailsWithHttpInfo(String id, LocalDate uploadDate, String status) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return getTransactionBatchDetailsRequestCreation(id, uploadDate, status).toEntity(localVarReturnType);
    }

    /**
     * Get Transaction Details for a given Batch Id
     * Provides real-time detailed status information about the transactions that you previously uploaded in the Business Center or processed with the Offline Transaction File Submission service. 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>502</b> - Bad Gateway
     * @param id The batch id assigned for the template.
     * @param uploadDate Date in which the original batch file was uploaded. Date must be in ISO-8601 format. Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14) **Example date format:**  - yyyy-MM-dd 
     * @param status Allows you to filter by rejected response.  Valid values: - Rejected 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTransactionBatchDetailsWithResponseSpec(String id, LocalDate uploadDate, String status) throws WebClientResponseException {
        return getTransactionBatchDetailsRequestCreation(id, uploadDate, status);
    }
    /**
     * Get Individual Batch File
     * This API provides details like upload date, completion date, transaction count and accepted and rejected transaction count of the individual batch file using the batch id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>502</b> - Bad Gateway
     * @param id The batch id assigned for the template.
     * @return PtsV1TransactionBatchesIdGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTransactionBatchIdRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getTransactionBatchId", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/hal+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PtsV1TransactionBatchesIdGet200Response> localVarReturnType = new ParameterizedTypeReference<PtsV1TransactionBatchesIdGet200Response>() {};
        return apiClient.invokeAPI("/pts/v1/transaction-batches/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Individual Batch File
     * This API provides details like upload date, completion date, transaction count and accepted and rejected transaction count of the individual batch file using the batch id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>502</b> - Bad Gateway
     * @param id The batch id assigned for the template.
     * @return PtsV1TransactionBatchesIdGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV1TransactionBatchesIdGet200Response> getTransactionBatchId(String id) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV1TransactionBatchesIdGet200Response> localVarReturnType = new ParameterizedTypeReference<PtsV1TransactionBatchesIdGet200Response>() {};
        return getTransactionBatchIdRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Get Individual Batch File
     * This API provides details like upload date, completion date, transaction count and accepted and rejected transaction count of the individual batch file using the batch id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>502</b> - Bad Gateway
     * @param id The batch id assigned for the template.
     * @return ResponseEntity&lt;PtsV1TransactionBatchesIdGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV1TransactionBatchesIdGet200Response>> getTransactionBatchIdWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV1TransactionBatchesIdGet200Response> localVarReturnType = new ParameterizedTypeReference<PtsV1TransactionBatchesIdGet200Response>() {};
        return getTransactionBatchIdRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get Individual Batch File
     * This API provides details like upload date, completion date, transaction count and accepted and rejected transaction count of the individual batch file using the batch id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>502</b> - Bad Gateway
     * @param id The batch id assigned for the template.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTransactionBatchIdWithResponseSpec(String id) throws WebClientResponseException {
        return getTransactionBatchIdRequestCreation(id);
    }
    /**
     * Get a List of Batch Files
     * Provide the date and time search range to get a list of Batch Files ready for settlement
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>500</b> - Bad Gateway
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZZ 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZZ 
     * @return PtsV1TransactionBatchesGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTransactionBatchesRequestCreation(OffsetDateTime startTime, OffsetDateTime endTime) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'startTime' is set
        if (startTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'startTime' when calling getTransactionBatches", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'endTime' is set
        if (endTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'endTime' when calling getTransactionBatches", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
            "application/hal+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PtsV1TransactionBatchesGet200Response> localVarReturnType = new ParameterizedTypeReference<PtsV1TransactionBatchesGet200Response>() {};
        return apiClient.invokeAPI("/pts/v1/transaction-batches", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a List of Batch Files
     * Provide the date and time search range to get a list of Batch Files ready for settlement
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>500</b> - Bad Gateway
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZZ 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZZ 
     * @return PtsV1TransactionBatchesGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV1TransactionBatchesGet200Response> getTransactionBatches(OffsetDateTime startTime, OffsetDateTime endTime) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV1TransactionBatchesGet200Response> localVarReturnType = new ParameterizedTypeReference<PtsV1TransactionBatchesGet200Response>() {};
        return getTransactionBatchesRequestCreation(startTime, endTime).bodyToMono(localVarReturnType);
    }

    /**
     * Get a List of Batch Files
     * Provide the date and time search range to get a list of Batch Files ready for settlement
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>500</b> - Bad Gateway
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZZ 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZZ 
     * @return ResponseEntity&lt;PtsV1TransactionBatchesGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV1TransactionBatchesGet200Response>> getTransactionBatchesWithHttpInfo(OffsetDateTime startTime, OffsetDateTime endTime) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV1TransactionBatchesGet200Response> localVarReturnType = new ParameterizedTypeReference<PtsV1TransactionBatchesGet200Response>() {};
        return getTransactionBatchesRequestCreation(startTime, endTime).toEntity(localVarReturnType);
    }

    /**
     * Get a List of Batch Files
     * Provide the date and time search range to get a list of Batch Files ready for settlement
     * <p><b>200</b> - OK
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Not Authorized
     * <p><b>403</b> - No Authenticated
     * <p><b>404</b> - No Reports Found
     * <p><b>500</b> - Bad Gateway
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZZ 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)   **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZZ 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTransactionBatchesWithResponseSpec(OffsetDateTime startTime, OffsetDateTime endTime) throws WebClientResponseException {
        return getTransactionBatchesRequestCreation(startTime, endTime);
    }
}
