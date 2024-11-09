package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateCreditRequest;
import org.openapitools.client.model.PtsV2CreditsPost201Response;
import org.openapitools.client.model.PtsV2CreditsPost400Response;
import org.openapitools.client.model.PtsV2CreditsPost502Response;

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
public class CreditApi {
    private ApiClient apiClient;

    public CreditApi() {
        this(new ApiClient());
    }

    @Autowired
    public CreditApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Process a Credit
     * POST to the credit resource to credit funds to a specified credit card.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createCreditRequest The createCreditRequest parameter
     * @return PtsV2CreditsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createCreditRequestCreation(CreateCreditRequest createCreditRequest) throws WebClientResponseException {
        Object postBody = createCreditRequest;
        // verify the required parameter 'createCreditRequest' is set
        if (createCreditRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'createCreditRequest' when calling createCredit", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<PtsV2CreditsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CreditsPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/credits", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Process a Credit
     * POST to the credit resource to credit funds to a specified credit card.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createCreditRequest The createCreditRequest parameter
     * @return PtsV2CreditsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2CreditsPost201Response> createCredit(CreateCreditRequest createCreditRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CreditsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CreditsPost201Response>() {};
        return createCreditRequestCreation(createCreditRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Process a Credit
     * POST to the credit resource to credit funds to a specified credit card.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createCreditRequest The createCreditRequest parameter
     * @return ResponseEntity&lt;PtsV2CreditsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2CreditsPost201Response>> createCreditWithHttpInfo(CreateCreditRequest createCreditRequest) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CreditsPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CreditsPost201Response>() {};
        return createCreditRequestCreation(createCreditRequest).toEntity(localVarReturnType);
    }

    /**
     * Process a Credit
     * POST to the credit resource to credit funds to a specified credit card.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createCreditRequest The createCreditRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createCreditWithResponseSpec(CreateCreditRequest createCreditRequest) throws WebClientResponseException {
        return createCreditRequestCreation(createCreditRequest);
    }
}
