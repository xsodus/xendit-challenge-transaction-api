package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GetCustomer410Response;
import org.openapitools.client.model.PostCustomer400Response;
import org.openapitools.client.model.PostCustomer403Response;
import org.openapitools.client.model.PostCustomer424Response;
import org.openapitools.client.model.PostCustomer500Response;
import org.openapitools.client.model.PostTokenPaymentCredentialsRequest;

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
public class TokenApi {
    private ApiClient apiClient;

    public TokenApi() {
        this(new ApiClient());
    }

    @Autowired
    public TokenApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Generate Payment Credentials for a TMS Token
     * |  |  |  |     | --- | --- | --- |     |**Token**&lt;br&gt;A Token can represent your tokenized Customer, Payment Instrument or Instrument Identifier information.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Credentials**&lt;br&gt;Contains payment information such as the network token, generated cryptogram for Visa &amp; MasterCard or dynamic CVV for Amex in a JSON Web Encryption (JWE) response.&lt;br&gt;Your system can use this API to retrieve the Payment Credentials for an existing Customer, Payment Instrument or Instrument Identifier. 
     * <p><b>201</b> - A base64 encoded JSON Web Encryption (JWE) response containing encrypted Payment Credentials.  Example: { \&quot;kid\&quot;:\&quot;a0eb65d572e556fddb68eb3a4078555605f7b283\&quot;, \&quot;cty\&quot;:\&quot;json\&quot;, \&quot;typ\&quot;:\&quot;JWT\&quot;, \&quot;enc\&quot;:\&quot;A256GCM\&quot;, \&quot;alg\&quot;:\&quot;RSA-OAEP-256\&quot; } [Encrypted Instrument Identifier Payment Credentials]  The encrypted Payment Credentials will contain the network token and cryptogram or dynamic CVV. 
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>500</b> - Unexpected error.
     * @param tokenId The Id of a token representing a Customer, Payment Instrument or Instrument Identifier.
     * @param postPaymentCredentialsRequest The postPaymentCredentialsRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec postTokenPaymentCredentialsRequestCreation(String tokenId, PostTokenPaymentCredentialsRequest postPaymentCredentialsRequest, String profileId) throws WebClientResponseException {
        Object postBody = postPaymentCredentialsRequest;
        // verify the required parameter 'tokenId' is set
        if (tokenId == null) {
            throw new WebClientResponseException("Missing the required parameter 'tokenId' when calling postTokenPaymentCredentials", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'postPaymentCredentialsRequest' is set
        if (postPaymentCredentialsRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'postPaymentCredentialsRequest' when calling postTokenPaymentCredentials", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("tokenId", tokenId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();


        if (profileId != null)
        headerParams.add("profile-id", apiClient.parameterToString(profileId));
        final String[] localVarAccepts = { 
            "application/jose;charset=utf-8", "Invalid Customer request body", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/tms/v2/tokens/{tokenId}/payment-credentials", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Generate Payment Credentials for a TMS Token
     * |  |  |  |     | --- | --- | --- |     |**Token**&lt;br&gt;A Token can represent your tokenized Customer, Payment Instrument or Instrument Identifier information.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Credentials**&lt;br&gt;Contains payment information such as the network token, generated cryptogram for Visa &amp; MasterCard or dynamic CVV for Amex in a JSON Web Encryption (JWE) response.&lt;br&gt;Your system can use this API to retrieve the Payment Credentials for an existing Customer, Payment Instrument or Instrument Identifier. 
     * <p><b>201</b> - A base64 encoded JSON Web Encryption (JWE) response containing encrypted Payment Credentials.  Example: { \&quot;kid\&quot;:\&quot;a0eb65d572e556fddb68eb3a4078555605f7b283\&quot;, \&quot;cty\&quot;:\&quot;json\&quot;, \&quot;typ\&quot;:\&quot;JWT\&quot;, \&quot;enc\&quot;:\&quot;A256GCM\&quot;, \&quot;alg\&quot;:\&quot;RSA-OAEP-256\&quot; } [Encrypted Instrument Identifier Payment Credentials]  The encrypted Payment Credentials will contain the network token and cryptogram or dynamic CVV. 
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>500</b> - Unexpected error.
     * @param tokenId The Id of a token representing a Customer, Payment Instrument or Instrument Identifier.
     * @param postPaymentCredentialsRequest The postPaymentCredentialsRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> postTokenPaymentCredentials(String tokenId, PostTokenPaymentCredentialsRequest postPaymentCredentialsRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return postTokenPaymentCredentialsRequestCreation(tokenId, postPaymentCredentialsRequest, profileId).bodyToMono(localVarReturnType);
    }

    /**
     * Generate Payment Credentials for a TMS Token
     * |  |  |  |     | --- | --- | --- |     |**Token**&lt;br&gt;A Token can represent your tokenized Customer, Payment Instrument or Instrument Identifier information.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Credentials**&lt;br&gt;Contains payment information such as the network token, generated cryptogram for Visa &amp; MasterCard or dynamic CVV for Amex in a JSON Web Encryption (JWE) response.&lt;br&gt;Your system can use this API to retrieve the Payment Credentials for an existing Customer, Payment Instrument or Instrument Identifier. 
     * <p><b>201</b> - A base64 encoded JSON Web Encryption (JWE) response containing encrypted Payment Credentials.  Example: { \&quot;kid\&quot;:\&quot;a0eb65d572e556fddb68eb3a4078555605f7b283\&quot;, \&quot;cty\&quot;:\&quot;json\&quot;, \&quot;typ\&quot;:\&quot;JWT\&quot;, \&quot;enc\&quot;:\&quot;A256GCM\&quot;, \&quot;alg\&quot;:\&quot;RSA-OAEP-256\&quot; } [Encrypted Instrument Identifier Payment Credentials]  The encrypted Payment Credentials will contain the network token and cryptogram or dynamic CVV. 
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>500</b> - Unexpected error.
     * @param tokenId The Id of a token representing a Customer, Payment Instrument or Instrument Identifier.
     * @param postPaymentCredentialsRequest The postPaymentCredentialsRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> postTokenPaymentCredentialsWithHttpInfo(String tokenId, PostTokenPaymentCredentialsRequest postPaymentCredentialsRequest, String profileId) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return postTokenPaymentCredentialsRequestCreation(tokenId, postPaymentCredentialsRequest, profileId).toEntity(localVarReturnType);
    }

    /**
     * Generate Payment Credentials for a TMS Token
     * |  |  |  |     | --- | --- | --- |     |**Token**&lt;br&gt;A Token can represent your tokenized Customer, Payment Instrument or Instrument Identifier information.|&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;|**Payment Credentials**&lt;br&gt;Contains payment information such as the network token, generated cryptogram for Visa &amp; MasterCard or dynamic CVV for Amex in a JSON Web Encryption (JWE) response.&lt;br&gt;Your system can use this API to retrieve the Payment Credentials for an existing Customer, Payment Instrument or Instrument Identifier. 
     * <p><b>201</b> - A base64 encoded JSON Web Encryption (JWE) response containing encrypted Payment Credentials.  Example: { \&quot;kid\&quot;:\&quot;a0eb65d572e556fddb68eb3a4078555605f7b283\&quot;, \&quot;cty\&quot;:\&quot;json\&quot;, \&quot;typ\&quot;:\&quot;JWT\&quot;, \&quot;enc\&quot;:\&quot;A256GCM\&quot;, \&quot;alg\&quot;:\&quot;RSA-OAEP-256\&quot; } [Encrypted Instrument Identifier Payment Credentials]  The encrypted Payment Credentials will contain the network token and cryptogram or dynamic CVV. 
     * <p><b>400</b> - Bad Request: e.g. A required header value could be missing.
     * <p><b>403</b> - Forbidden: e.g. The profile might not have permission to perform the operation.
     * <p><b>404</b> - Token Not Found. The Id may not exist or was entered incorrectly.
     * <p><b>410</b> - Token Not Available. The token has been deleted.
     * <p><b>500</b> - Unexpected error.
     * @param tokenId The Id of a token representing a Customer, Payment Instrument or Instrument Identifier.
     * @param postPaymentCredentialsRequest The postPaymentCredentialsRequest parameter
     * @param profileId The Id of a profile containing user specific TMS configuration.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec postTokenPaymentCredentialsWithResponseSpec(String tokenId, PostTokenPaymentCredentialsRequest postPaymentCredentialsRequest, String profileId) throws WebClientResponseException {
        return postTokenPaymentCredentialsRequestCreation(tokenId, postPaymentCredentialsRequest, profileId);
    }
}
