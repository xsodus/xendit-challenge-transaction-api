package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.ParseEmvTagsRequest;
import org.openapitools.client.model.TssV2GetEmvTags200Response;
import org.openapitools.client.model.TssV2PostEmvTags200Response;

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
public class EmvTagDetailsApi {
    private ApiClient apiClient;

    public EmvTagDetailsApi() {
        this(new ApiClient());
    }

    @Autowired
    public EmvTagDetailsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Retrieve the EMV Dictionary
     * Returns the entire EMV tag dictionary
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @return TssV2GetEmvTags200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getEmvTagsRequestCreation() throws WebClientResponseException {
        Object postBody = null;
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
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<TssV2GetEmvTags200Response> localVarReturnType = new ParameterizedTypeReference<TssV2GetEmvTags200Response>() {};
        return apiClient.invokeAPI("/tss/v2/transactions/emvTagDetails", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Retrieve the EMV Dictionary
     * Returns the entire EMV tag dictionary
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @return TssV2GetEmvTags200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TssV2GetEmvTags200Response> getEmvTags() throws WebClientResponseException {
        ParameterizedTypeReference<TssV2GetEmvTags200Response> localVarReturnType = new ParameterizedTypeReference<TssV2GetEmvTags200Response>() {};
        return getEmvTagsRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Retrieve the EMV Dictionary
     * Returns the entire EMV tag dictionary
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @return ResponseEntity&lt;TssV2GetEmvTags200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<TssV2GetEmvTags200Response>> getEmvTagsWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<TssV2GetEmvTags200Response> localVarReturnType = new ParameterizedTypeReference<TssV2GetEmvTags200Response>() {};
        return getEmvTagsRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Retrieve the EMV Dictionary
     * Returns the entire EMV tag dictionary
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getEmvTagsWithResponseSpec() throws WebClientResponseException {
        return getEmvTagsRequestCreation();
    }
    /**
     * Parse an EMV String
     * Pass an EMV Tag-Length-Value (TLV) string for parsing.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param body The body parameter
     * @return TssV2PostEmvTags200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec parseEmvTagsRequestCreation(ParseEmvTagsRequest body) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling parseEmvTags", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<TssV2PostEmvTags200Response> localVarReturnType = new ParameterizedTypeReference<TssV2PostEmvTags200Response>() {};
        return apiClient.invokeAPI("/tss/v2/transactions/emvTagDetails", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Parse an EMV String
     * Pass an EMV Tag-Length-Value (TLV) string for parsing.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param body The body parameter
     * @return TssV2PostEmvTags200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TssV2PostEmvTags200Response> parseEmvTags(ParseEmvTagsRequest body) throws WebClientResponseException {
        ParameterizedTypeReference<TssV2PostEmvTags200Response> localVarReturnType = new ParameterizedTypeReference<TssV2PostEmvTags200Response>() {};
        return parseEmvTagsRequestCreation(body).bodyToMono(localVarReturnType);
    }

    /**
     * Parse an EMV String
     * Pass an EMV Tag-Length-Value (TLV) string for parsing.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param body The body parameter
     * @return ResponseEntity&lt;TssV2PostEmvTags200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<TssV2PostEmvTags200Response>> parseEmvTagsWithHttpInfo(ParseEmvTagsRequest body) throws WebClientResponseException {
        ParameterizedTypeReference<TssV2PostEmvTags200Response> localVarReturnType = new ParameterizedTypeReference<TssV2PostEmvTags200Response>() {};
        return parseEmvTagsRequestCreation(body).toEntity(localVarReturnType);
    }

    /**
     * Parse an EMV String
     * Pass an EMV Tag-Length-Value (TLV) string for parsing.
     * <p><b>200</b> - Successful response.
     * <p><b>404</b> - The specified resource not found in the system.
     * <p><b>500</b> - Unexpected server error
     * @param body The body parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec parseEmvTagsWithResponseSpec(ParseEmvTagsRequest body) throws WebClientResponseException {
        return parseEmvTagsRequestCreation(body);
    }
}
