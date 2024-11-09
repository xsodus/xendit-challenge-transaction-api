package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ReplayPreviousWebhooksRequest;

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
public class ReplayWebhooksApi {
    private ApiClient apiClient;

    public ReplayWebhooksApi() {
        this(new ApiClient());
    }

    @Autowired
    public ReplayWebhooksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Replay Previous Webhooks
     * Initiate a webhook replay request to replay transactions that happened in the past.  Cannot execute more than 1 replay request at a time. While one request is processing, you will not be allowed to execute another replay.  The difference between Start and End time cannot exceed a 24 hour window, and 1 month is the farthest date back that is eligible for replay. 
     * <p><b>202</b> - Accepted
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook uuid identifier.
     * @param replayWebhooksRequest The request query
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec replayPreviousWebhooksRequestCreation(String webhookId, ReplayPreviousWebhooksRequest replayWebhooksRequest) throws WebClientResponseException {
        Object postBody = replayWebhooksRequest;
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new WebClientResponseException("Missing the required parameter 'webhookId' when calling replayPreviousWebhooks", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("webhookId", webhookId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/nrtf/v1/webhooks/{webhookId}/replays", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Replay Previous Webhooks
     * Initiate a webhook replay request to replay transactions that happened in the past.  Cannot execute more than 1 replay request at a time. While one request is processing, you will not be allowed to execute another replay.  The difference between Start and End time cannot exceed a 24 hour window, and 1 month is the farthest date back that is eligible for replay. 
     * <p><b>202</b> - Accepted
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook uuid identifier.
     * @param replayWebhooksRequest The request query
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> replayPreviousWebhooks(String webhookId, ReplayPreviousWebhooksRequest replayWebhooksRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return replayPreviousWebhooksRequestCreation(webhookId, replayWebhooksRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Replay Previous Webhooks
     * Initiate a webhook replay request to replay transactions that happened in the past.  Cannot execute more than 1 replay request at a time. While one request is processing, you will not be allowed to execute another replay.  The difference between Start and End time cannot exceed a 24 hour window, and 1 month is the farthest date back that is eligible for replay. 
     * <p><b>202</b> - Accepted
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook uuid identifier.
     * @param replayWebhooksRequest The request query
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> replayPreviousWebhooksWithHttpInfo(String webhookId, ReplayPreviousWebhooksRequest replayWebhooksRequest) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return replayPreviousWebhooksRequestCreation(webhookId, replayWebhooksRequest).toEntity(localVarReturnType);
    }

    /**
     * Replay Previous Webhooks
     * Initiate a webhook replay request to replay transactions that happened in the past.  Cannot execute more than 1 replay request at a time. While one request is processing, you will not be allowed to execute another replay.  The difference between Start and End time cannot exceed a 24 hour window, and 1 month is the farthest date back that is eligible for replay. 
     * <p><b>202</b> - Accepted
     * <p><b>400</b> - Bad request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server error
     * @param webhookId The webhook uuid identifier.
     * @param replayWebhooksRequest The request query
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec replayPreviousWebhooksWithResponseSpec(String webhookId, ReplayPreviousWebhooksRequest replayWebhooksRequest) throws WebClientResponseException {
        return replayPreviousWebhooksRequestCreation(webhookId, replayWebhooksRequest);
    }
}
