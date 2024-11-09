package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.BinLookupv400Response;
import org.openapitools.client.model.GetAccountInfo201Response;
import org.openapitools.client.model.GetAccountInfoRequest;
import org.openapitools.client.model.GetPlans502Response;

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
public class BinLookupApi {
    private ApiClient apiClient;

    public BinLookupApi() {
        this(new ApiClient());
    }

    @Autowired
    public BinLookupApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * BIN Lookup API
     * The BIN Lookup Service is a versatile business tool that provides card network agnostic solution designed to ensure frictionless transaction experience by utilizing up-to-date Bank Identification Number (BIN) attributes sourced from multiple global and regional data sources. This service helps to improve authorization rates by helping to route transactions to the best-suited card network, minimizes fraud through card detail verification and aids in regulatory compliance by identifying card properties. The service is flexible and provides businesses with a flexible choice of inputs such as primary account number (PAN), network token from major networks which includes device PAN (DPAN), and all types of tokens generated via CyberSource Token Management Service (TMS). Currently, the range of available credentials is contingent on the networks enabled for the business entity. Therefore, the network information specified in this documentation is illustrative and subject to personalized offerings for each reseller or merchant. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createBinLookupRequest The createBinLookupRequest parameter
     * @return GetAccountInfo201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getAccountInfoRequestCreation(GetAccountInfoRequest createBinLookupRequest) throws WebClientResponseException {
        Object postBody = createBinLookupRequest;
        // verify the required parameter 'createBinLookupRequest' is set
        if (createBinLookupRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'createBinLookupRequest' when calling getAccountInfo", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<GetAccountInfo201Response> localVarReturnType = new ParameterizedTypeReference<GetAccountInfo201Response>() {};
        return apiClient.invokeAPI("/bin/v1/binlookup", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * BIN Lookup API
     * The BIN Lookup Service is a versatile business tool that provides card network agnostic solution designed to ensure frictionless transaction experience by utilizing up-to-date Bank Identification Number (BIN) attributes sourced from multiple global and regional data sources. This service helps to improve authorization rates by helping to route transactions to the best-suited card network, minimizes fraud through card detail verification and aids in regulatory compliance by identifying card properties. The service is flexible and provides businesses with a flexible choice of inputs such as primary account number (PAN), network token from major networks which includes device PAN (DPAN), and all types of tokens generated via CyberSource Token Management Service (TMS). Currently, the range of available credentials is contingent on the networks enabled for the business entity. Therefore, the network information specified in this documentation is illustrative and subject to personalized offerings for each reseller or merchant. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createBinLookupRequest The createBinLookupRequest parameter
     * @return GetAccountInfo201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GetAccountInfo201Response> getAccountInfo(GetAccountInfoRequest createBinLookupRequest) throws WebClientResponseException {
        ParameterizedTypeReference<GetAccountInfo201Response> localVarReturnType = new ParameterizedTypeReference<GetAccountInfo201Response>() {};
        return getAccountInfoRequestCreation(createBinLookupRequest).bodyToMono(localVarReturnType);
    }

    /**
     * BIN Lookup API
     * The BIN Lookup Service is a versatile business tool that provides card network agnostic solution designed to ensure frictionless transaction experience by utilizing up-to-date Bank Identification Number (BIN) attributes sourced from multiple global and regional data sources. This service helps to improve authorization rates by helping to route transactions to the best-suited card network, minimizes fraud through card detail verification and aids in regulatory compliance by identifying card properties. The service is flexible and provides businesses with a flexible choice of inputs such as primary account number (PAN), network token from major networks which includes device PAN (DPAN), and all types of tokens generated via CyberSource Token Management Service (TMS). Currently, the range of available credentials is contingent on the networks enabled for the business entity. Therefore, the network information specified in this documentation is illustrative and subject to personalized offerings for each reseller or merchant. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createBinLookupRequest The createBinLookupRequest parameter
     * @return ResponseEntity&lt;GetAccountInfo201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GetAccountInfo201Response>> getAccountInfoWithHttpInfo(GetAccountInfoRequest createBinLookupRequest) throws WebClientResponseException {
        ParameterizedTypeReference<GetAccountInfo201Response> localVarReturnType = new ParameterizedTypeReference<GetAccountInfo201Response>() {};
        return getAccountInfoRequestCreation(createBinLookupRequest).toEntity(localVarReturnType);
    }

    /**
     * BIN Lookup API
     * The BIN Lookup Service is a versatile business tool that provides card network agnostic solution designed to ensure frictionless transaction experience by utilizing up-to-date Bank Identification Number (BIN) attributes sourced from multiple global and regional data sources. This service helps to improve authorization rates by helping to route transactions to the best-suited card network, minimizes fraud through card detail verification and aids in regulatory compliance by identifying card properties. The service is flexible and provides businesses with a flexible choice of inputs such as primary account number (PAN), network token from major networks which includes device PAN (DPAN), and all types of tokens generated via CyberSource Token Management Service (TMS). Currently, the range of available credentials is contingent on the networks enabled for the business entity. Therefore, the network information specified in this documentation is illustrative and subject to personalized offerings for each reseller or merchant. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createBinLookupRequest The createBinLookupRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getAccountInfoWithResponseSpec(GetAccountInfoRequest createBinLookupRequest) throws WebClientResponseException {
        return getAccountInfoRequestCreation(createBinLookupRequest);
    }
}
