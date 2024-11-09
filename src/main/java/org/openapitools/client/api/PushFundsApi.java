package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreatePushFundsTransferRequest;
import org.openapitools.client.model.PushFunds201Response;
import org.openapitools.client.model.PushFunds400Response;
import org.openapitools.client.model.PushFunds401Response;
import org.openapitools.client.model.PushFunds404Response;
import org.openapitools.client.model.PushFunds502Response;

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
public class PushFundsApi {
    private ApiClient apiClient;

    public PushFundsApi() {
        this(new ApiClient());
    }

    @Autowired
    public PushFundsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Process a Push Funds Transfer
     * Receive funds using an Original Credit Transaction (OCT). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Unauthorized.
     * <p><b>404</b> - Not Found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param contentType The contentType parameter
     * @param xRequestid The xRequestid parameter
     * @param vCMerchantId The vCMerchantId parameter
     * @param vCPermissions The vCPermissions parameter
     * @param vCCorrelationId The vCCorrelationId parameter
     * @param vCOrganizationId The vCOrganizationId parameter
     * @param pushFundsRequest The pushFundsRequest parameter
     * @return PushFunds201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createPushFundsTransferRequestCreation(String contentType, String xRequestid, String vCMerchantId, String vCPermissions, String vCCorrelationId, String vCOrganizationId, CreatePushFundsTransferRequest pushFundsRequest) throws WebClientResponseException {
        Object postBody = pushFundsRequest;
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new WebClientResponseException("Missing the required parameter 'contentType' when calling createPushFundsTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'xRequestid' is set
        if (xRequestid == null) {
            throw new WebClientResponseException("Missing the required parameter 'xRequestid' when calling createPushFundsTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'vCMerchantId' is set
        if (vCMerchantId == null) {
            throw new WebClientResponseException("Missing the required parameter 'vCMerchantId' when calling createPushFundsTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'vCPermissions' is set
        if (vCPermissions == null) {
            throw new WebClientResponseException("Missing the required parameter 'vCPermissions' when calling createPushFundsTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'vCCorrelationId' is set
        if (vCCorrelationId == null) {
            throw new WebClientResponseException("Missing the required parameter 'vCCorrelationId' when calling createPushFundsTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'vCOrganizationId' is set
        if (vCOrganizationId == null) {
            throw new WebClientResponseException("Missing the required parameter 'vCOrganizationId' when calling createPushFundsTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'pushFundsRequest' is set
        if (pushFundsRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'pushFundsRequest' when calling createPushFundsTransfer", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();


        if (contentType != null)
        headerParams.add("Content-Type", apiClient.parameterToString(contentType));
        if (xRequestid != null)
        headerParams.add("x-requestid", apiClient.parameterToString(xRequestid));
        if (vCMerchantId != null)
        headerParams.add("v-c-merchant-id", apiClient.parameterToString(vCMerchantId));
        if (vCPermissions != null)
        headerParams.add("v-c-permissions", apiClient.parameterToString(vCPermissions));
        if (vCCorrelationId != null)
        headerParams.add("v-c-correlation-id", apiClient.parameterToString(vCCorrelationId));
        if (vCOrganizationId != null)
        headerParams.add("v-c-organization-id", apiClient.parameterToString(vCOrganizationId));
        final String[] localVarAccepts = { 
            "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PushFunds201Response> localVarReturnType = new ParameterizedTypeReference<PushFunds201Response>() {};
        return apiClient.invokeAPI("/pts/v1/push-funds-transfer", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Process a Push Funds Transfer
     * Receive funds using an Original Credit Transaction (OCT). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Unauthorized.
     * <p><b>404</b> - Not Found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param contentType The contentType parameter
     * @param xRequestid The xRequestid parameter
     * @param vCMerchantId The vCMerchantId parameter
     * @param vCPermissions The vCPermissions parameter
     * @param vCCorrelationId The vCCorrelationId parameter
     * @param vCOrganizationId The vCOrganizationId parameter
     * @param pushFundsRequest The pushFundsRequest parameter
     * @return PushFunds201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PushFunds201Response> createPushFundsTransfer(String contentType, String xRequestid, String vCMerchantId, String vCPermissions, String vCCorrelationId, String vCOrganizationId, CreatePushFundsTransferRequest pushFundsRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PushFunds201Response> localVarReturnType = new ParameterizedTypeReference<PushFunds201Response>() {};
        return createPushFundsTransferRequestCreation(contentType, xRequestid, vCMerchantId, vCPermissions, vCCorrelationId, vCOrganizationId, pushFundsRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Process a Push Funds Transfer
     * Receive funds using an Original Credit Transaction (OCT). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Unauthorized.
     * <p><b>404</b> - Not Found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param contentType The contentType parameter
     * @param xRequestid The xRequestid parameter
     * @param vCMerchantId The vCMerchantId parameter
     * @param vCPermissions The vCPermissions parameter
     * @param vCCorrelationId The vCCorrelationId parameter
     * @param vCOrganizationId The vCOrganizationId parameter
     * @param pushFundsRequest The pushFundsRequest parameter
     * @return ResponseEntity&lt;PushFunds201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PushFunds201Response>> createPushFundsTransferWithHttpInfo(String contentType, String xRequestid, String vCMerchantId, String vCPermissions, String vCCorrelationId, String vCOrganizationId, CreatePushFundsTransferRequest pushFundsRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PushFunds201Response> localVarReturnType = new ParameterizedTypeReference<PushFunds201Response>() {};
        return createPushFundsTransferRequestCreation(contentType, xRequestid, vCMerchantId, vCPermissions, vCCorrelationId, vCOrganizationId, pushFundsRequest).toEntity(localVarReturnType);
    }

    /**
     * Process a Push Funds Transfer
     * Receive funds using an Original Credit Transaction (OCT). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>401</b> - Unauthorized.
     * <p><b>404</b> - Not Found.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param contentType The contentType parameter
     * @param xRequestid The xRequestid parameter
     * @param vCMerchantId The vCMerchantId parameter
     * @param vCPermissions The vCPermissions parameter
     * @param vCCorrelationId The vCCorrelationId parameter
     * @param vCOrganizationId The vCOrganizationId parameter
     * @param pushFundsRequest The pushFundsRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createPushFundsTransferWithResponseSpec(String contentType, String xRequestid, String vCMerchantId, String vCPermissions, String vCCorrelationId, String vCOrganizationId, CreatePushFundsTransferRequest pushFundsRequest) throws WebClientResponseException {
        return createPushFundsTransferRequestCreation(contentType, xRequestid, vCMerchantId, vCPermissions, vCCorrelationId, vCOrganizationId, pushFundsRequest);
    }
}
