package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetBatchReport200Response;
import org.openapitools.client.model.GetBatchStatus200Response;
import org.openapitools.client.model.GetBatchesList200Response;
import org.openapitools.client.model.GetBatchesList401Response;
import org.openapitools.client.model.PostBatch202Response;
import org.openapitools.client.model.PostBatchRequest;

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
public class BatchesApi {
    private ApiClient apiClient;

    public BatchesApi() {
        this(new ApiClient());
    }

    @Autowired
    public BatchesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Retrieve a Batch Report
     * **Get Batch Report**&lt;br&gt;This resource accepts a batch id and returns: - The batch status. - The total number of accepted, rejected, updated records. - The total number of card association responses. - The billable quantities of:   - New Account Numbers (NAN)   - New Expiry Dates (NED)   - Account Closures (ACL)   - Contact Card Holders (CCH) - Source record information including token ids, masked card number, expiration dates &amp; card type. - Response record information including response code, reason, token ids, masked card number, expiration dates &amp; card type. 
     * <p><b>200</b> - The report for a batch.
     * <p><b>403</b> - Unable to perform action for supplied batch ID/merchant.
     * @param batchId Unique identification number assigned to the submitted request.
     * @return GetBatchReport200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getBatchReportRequestCreation(String batchId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'batchId' is set
        if (batchId == null) {
            throw new WebClientResponseException("Missing the required parameter 'batchId' when calling getBatchReport", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("batchId", batchId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetBatchReport200Response> localVarReturnType = new ParameterizedTypeReference<GetBatchReport200Response>() {};
        return apiClient.invokeAPI("/accountupdater/v1/batches/{batchId}/report", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve a Batch Report
     * **Get Batch Report**&lt;br&gt;This resource accepts a batch id and returns: - The batch status. - The total number of accepted, rejected, updated records. - The total number of card association responses. - The billable quantities of:   - New Account Numbers (NAN)   - New Expiry Dates (NED)   - Account Closures (ACL)   - Contact Card Holders (CCH) - Source record information including token ids, masked card number, expiration dates &amp; card type. - Response record information including response code, reason, token ids, masked card number, expiration dates &amp; card type. 
     * <p><b>200</b> - The report for a batch.
     * <p><b>403</b> - Unable to perform action for supplied batch ID/merchant.
     * @param batchId Unique identification number assigned to the submitted request.
     * @return GetBatchReport200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetBatchReport200Response> getBatchReport(String batchId) throws WebClientResponseException {
        ParameterizedTypeReference<GetBatchReport200Response> localVarReturnType = new ParameterizedTypeReference<GetBatchReport200Response>() {};
        return getBatchReportRequestCreation(batchId).bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve a Batch Report
     * **Get Batch Report**&lt;br&gt;This resource accepts a batch id and returns: - The batch status. - The total number of accepted, rejected, updated records. - The total number of card association responses. - The billable quantities of:   - New Account Numbers (NAN)   - New Expiry Dates (NED)   - Account Closures (ACL)   - Contact Card Holders (CCH) - Source record information including token ids, masked card number, expiration dates &amp; card type. - Response record information including response code, reason, token ids, masked card number, expiration dates &amp; card type. 
     * <p><b>200</b> - The report for a batch.
     * <p><b>403</b> - Unable to perform action for supplied batch ID/merchant.
     * @param batchId Unique identification number assigned to the submitted request.
     * @return ResponseEntity&lt;GetBatchReport200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetBatchReport200Response>> getBatchReportWithHttpInfo(String batchId) throws WebClientResponseException {
        ParameterizedTypeReference<GetBatchReport200Response> localVarReturnType = new ParameterizedTypeReference<GetBatchReport200Response>() {};
        return getBatchReportRequestCreation(batchId).toEntity(localVarReturnType);
    }

    /**
     * Retrieve a Batch Report
     * **Get Batch Report**&lt;br&gt;This resource accepts a batch id and returns: - The batch status. - The total number of accepted, rejected, updated records. - The total number of card association responses. - The billable quantities of:   - New Account Numbers (NAN)   - New Expiry Dates (NED)   - Account Closures (ACL)   - Contact Card Holders (CCH) - Source record information including token ids, masked card number, expiration dates &amp; card type. - Response record information including response code, reason, token ids, masked card number, expiration dates &amp; card type. 
     * <p><b>200</b> - The report for a batch.
     * <p><b>403</b> - Unable to perform action for supplied batch ID/merchant.
     * @param batchId Unique identification number assigned to the submitted request.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getBatchReportWithResponseSpec(String batchId) throws WebClientResponseException {
        return getBatchReportRequestCreation(batchId);
    }
    /**
     * Retrieve a Batch Status
     * **Get Batch Status**&lt;br&gt;This resource accepts a batch id and returns: - The batch status. - The total number of accepted, rejected, updated records. - The total number of card association responses. - The billable quantities of:   - New Account Numbers (NAN)   - New Expiry Dates (NED)   - Account Closures (ACL)   - Contact Card Holders (CCH) 
     * <p><b>200</b> - The status of a batch.
     * <p><b>403</b> - Unable to perform action for supplied batch ID/merchant.
     * @param batchId Unique identification number assigned to the submitted request.
     * @return GetBatchStatus200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getBatchStatusRequestCreation(String batchId) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'batchId' is set
        if (batchId == null) {
            throw new WebClientResponseException("Missing the required parameter 'batchId' when calling getBatchStatus", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("batchId", batchId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetBatchStatus200Response> localVarReturnType = new ParameterizedTypeReference<GetBatchStatus200Response>() {};
        return apiClient.invokeAPI("/accountupdater/v1/batches/{batchId}/status", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve a Batch Status
     * **Get Batch Status**&lt;br&gt;This resource accepts a batch id and returns: - The batch status. - The total number of accepted, rejected, updated records. - The total number of card association responses. - The billable quantities of:   - New Account Numbers (NAN)   - New Expiry Dates (NED)   - Account Closures (ACL)   - Contact Card Holders (CCH) 
     * <p><b>200</b> - The status of a batch.
     * <p><b>403</b> - Unable to perform action for supplied batch ID/merchant.
     * @param batchId Unique identification number assigned to the submitted request.
     * @return GetBatchStatus200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetBatchStatus200Response> getBatchStatus(String batchId) throws WebClientResponseException {
        ParameterizedTypeReference<GetBatchStatus200Response> localVarReturnType = new ParameterizedTypeReference<GetBatchStatus200Response>() {};
        return getBatchStatusRequestCreation(batchId).bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve a Batch Status
     * **Get Batch Status**&lt;br&gt;This resource accepts a batch id and returns: - The batch status. - The total number of accepted, rejected, updated records. - The total number of card association responses. - The billable quantities of:   - New Account Numbers (NAN)   - New Expiry Dates (NED)   - Account Closures (ACL)   - Contact Card Holders (CCH) 
     * <p><b>200</b> - The status of a batch.
     * <p><b>403</b> - Unable to perform action for supplied batch ID/merchant.
     * @param batchId Unique identification number assigned to the submitted request.
     * @return ResponseEntity&lt;GetBatchStatus200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetBatchStatus200Response>> getBatchStatusWithHttpInfo(String batchId) throws WebClientResponseException {
        ParameterizedTypeReference<GetBatchStatus200Response> localVarReturnType = new ParameterizedTypeReference<GetBatchStatus200Response>() {};
        return getBatchStatusRequestCreation(batchId).toEntity(localVarReturnType);
    }

    /**
     * Retrieve a Batch Status
     * **Get Batch Status**&lt;br&gt;This resource accepts a batch id and returns: - The batch status. - The total number of accepted, rejected, updated records. - The total number of card association responses. - The billable quantities of:   - New Account Numbers (NAN)   - New Expiry Dates (NED)   - Account Closures (ACL)   - Contact Card Holders (CCH) 
     * <p><b>200</b> - The status of a batch.
     * <p><b>403</b> - Unable to perform action for supplied batch ID/merchant.
     * @param batchId Unique identification number assigned to the submitted request.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getBatchStatusWithResponseSpec(String batchId) throws WebClientResponseException {
        return getBatchStatusRequestCreation(batchId);
    }
    /**
     * List Batches
     * **List Batches**&lt;br&gt;This resource accepts a optional date range, record offset and limit, returning a paginated response of batches containing: - The batch id. - The batch status. - The batch created / modified dates. - The total number of accepted, rejected, updated records. - The total number of card association responses. 
     * <p><b>200</b> - A list of batches have been returned.
     * <p><b>401</b> - Not authorized to access resource.
     * <p><b>422</b> - Failure to process request.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset.
     * @param fromDate ISO-8601 format: yyyyMMddTHHmmssZ
     * @param toDate ISO-8601 format: yyyyMMddTHHmmssZ
     * @return GetBatchesList200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getBatchesListRequestCreation(Long offset, Long limit, String fromDate, String toDate) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fromDate", fromDate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "toDate", toDate));
        
        final String[] localVarAccepts = { 
            "application/json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetBatchesList200Response> localVarReturnType = new ParameterizedTypeReference<GetBatchesList200Response>() {};
        return apiClient.invokeAPI("/accountupdater/v1/batches", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Batches
     * **List Batches**&lt;br&gt;This resource accepts a optional date range, record offset and limit, returning a paginated response of batches containing: - The batch id. - The batch status. - The batch created / modified dates. - The total number of accepted, rejected, updated records. - The total number of card association responses. 
     * <p><b>200</b> - A list of batches have been returned.
     * <p><b>401</b> - Not authorized to access resource.
     * <p><b>422</b> - Failure to process request.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset.
     * @param fromDate ISO-8601 format: yyyyMMddTHHmmssZ
     * @param toDate ISO-8601 format: yyyyMMddTHHmmssZ
     * @return GetBatchesList200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetBatchesList200Response> getBatchesList(Long offset, Long limit, String fromDate, String toDate) throws WebClientResponseException {
        ParameterizedTypeReference<GetBatchesList200Response> localVarReturnType = new ParameterizedTypeReference<GetBatchesList200Response>() {};
        return getBatchesListRequestCreation(offset, limit, fromDate, toDate).bodyToMono(localVarReturnType);
    }

    /**
     * List Batches
     * **List Batches**&lt;br&gt;This resource accepts a optional date range, record offset and limit, returning a paginated response of batches containing: - The batch id. - The batch status. - The batch created / modified dates. - The total number of accepted, rejected, updated records. - The total number of card association responses. 
     * <p><b>200</b> - A list of batches have been returned.
     * <p><b>401</b> - Not authorized to access resource.
     * <p><b>422</b> - Failure to process request.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset.
     * @param fromDate ISO-8601 format: yyyyMMddTHHmmssZ
     * @param toDate ISO-8601 format: yyyyMMddTHHmmssZ
     * @return ResponseEntity&lt;GetBatchesList200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetBatchesList200Response>> getBatchesListWithHttpInfo(Long offset, Long limit, String fromDate, String toDate) throws WebClientResponseException {
        ParameterizedTypeReference<GetBatchesList200Response> localVarReturnType = new ParameterizedTypeReference<GetBatchesList200Response>() {};
        return getBatchesListRequestCreation(offset, limit, fromDate, toDate).toEntity(localVarReturnType);
    }

    /**
     * List Batches
     * **List Batches**&lt;br&gt;This resource accepts a optional date range, record offset and limit, returning a paginated response of batches containing: - The batch id. - The batch status. - The batch created / modified dates. - The total number of accepted, rejected, updated records. - The total number of card association responses. 
     * <p><b>200</b> - A list of batches have been returned.
     * <p><b>401</b> - Not authorized to access resource.
     * <p><b>422</b> - Failure to process request.
     * @param offset Starting record in zero-based dataset that should be returned as the first object in the array.
     * @param limit The maximum number that can be returned in the array starting from the offset record in zero-based dataset.
     * @param fromDate ISO-8601 format: yyyyMMddTHHmmssZ
     * @param toDate ISO-8601 format: yyyyMMddTHHmmssZ
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getBatchesListWithResponseSpec(Long offset, Long limit, String fromDate, String toDate) throws WebClientResponseException {
        return getBatchesListRequestCreation(offset, limit, fromDate, toDate);
    }
    /**
     * Create a Batch
     * **Create a Batch**&lt;br&gt;This resource accepts TMS tokens ids of a Customer, Payment Instrument or Instrument Identifier. &lt;br&gt; The card numbers for the supplied tokens ids are then sent to the relevant card associations to check for updates.&lt;br&gt;The following type of batches can be submitted: -  **oneOff** batch containing tokens id for Visa or MasterCard card numbers. - **amexRegistration** batch containing tokens id for Amex card numbers.  A batch id will be returned on a successful response which can be used to get the batch status and the batch report. 
     * <p><b>202</b> - A new batch has been created.
     * <p><b>400</b> - Bad request.
     * <p><b>401</b> - Not authorized to access resource.
     * <p><b>415</b> - Unsupported media type provided.
     * <p><b>422</b> - Failure to process request.
     * @param body The body parameter
     * @return PostBatch202Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postBatchRequestCreation(PostBatchRequest body) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling postBatch", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PostBatch202Response> localVarReturnType = new ParameterizedTypeReference<PostBatch202Response>() {};
        return apiClient.invokeAPI("/accountupdater/v1/batches", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Batch
     * **Create a Batch**&lt;br&gt;This resource accepts TMS tokens ids of a Customer, Payment Instrument or Instrument Identifier. &lt;br&gt; The card numbers for the supplied tokens ids are then sent to the relevant card associations to check for updates.&lt;br&gt;The following type of batches can be submitted: -  **oneOff** batch containing tokens id for Visa or MasterCard card numbers. - **amexRegistration** batch containing tokens id for Amex card numbers.  A batch id will be returned on a successful response which can be used to get the batch status and the batch report. 
     * <p><b>202</b> - A new batch has been created.
     * <p><b>400</b> - Bad request.
     * <p><b>401</b> - Not authorized to access resource.
     * <p><b>415</b> - Unsupported media type provided.
     * <p><b>422</b> - Failure to process request.
     * @param body The body parameter
     * @return PostBatch202Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PostBatch202Response> postBatch(PostBatchRequest body) throws WebClientResponseException {
        ParameterizedTypeReference<PostBatch202Response> localVarReturnType = new ParameterizedTypeReference<PostBatch202Response>() {};
        return postBatchRequestCreation(body).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Batch
     * **Create a Batch**&lt;br&gt;This resource accepts TMS tokens ids of a Customer, Payment Instrument or Instrument Identifier. &lt;br&gt; The card numbers for the supplied tokens ids are then sent to the relevant card associations to check for updates.&lt;br&gt;The following type of batches can be submitted: -  **oneOff** batch containing tokens id for Visa or MasterCard card numbers. - **amexRegistration** batch containing tokens id for Amex card numbers.  A batch id will be returned on a successful response which can be used to get the batch status and the batch report. 
     * <p><b>202</b> - A new batch has been created.
     * <p><b>400</b> - Bad request.
     * <p><b>401</b> - Not authorized to access resource.
     * <p><b>415</b> - Unsupported media type provided.
     * <p><b>422</b> - Failure to process request.
     * @param body The body parameter
     * @return ResponseEntity&lt;PostBatch202Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PostBatch202Response>> postBatchWithHttpInfo(PostBatchRequest body) throws WebClientResponseException {
        ParameterizedTypeReference<PostBatch202Response> localVarReturnType = new ParameterizedTypeReference<PostBatch202Response>() {};
        return postBatchRequestCreation(body).toEntity(localVarReturnType);
    }

    /**
     * Create a Batch
     * **Create a Batch**&lt;br&gt;This resource accepts TMS tokens ids of a Customer, Payment Instrument or Instrument Identifier. &lt;br&gt; The card numbers for the supplied tokens ids are then sent to the relevant card associations to check for updates.&lt;br&gt;The following type of batches can be submitted: -  **oneOff** batch containing tokens id for Visa or MasterCard card numbers. - **amexRegistration** batch containing tokens id for Amex card numbers.  A batch id will be returned on a successful response which can be used to get the batch status and the batch report. 
     * <p><b>202</b> - A new batch has been created.
     * <p><b>400</b> - Bad request.
     * <p><b>401</b> - Not authorized to access resource.
     * <p><b>415</b> - Unsupported media type provided.
     * <p><b>422</b> - Failure to process request.
     * @param body The body parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postBatchWithResponseSpec(PostBatchRequest body) throws WebClientResponseException {
        return postBatchRequestCreation(body);
    }
}
