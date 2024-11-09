package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.GenerateCaptureContextDefaultResponse;
import org.openapitools.client.model.GenerateCaptureContextRequest;

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
public class MicroformIntegrationApi {
    private ApiClient apiClient;

    public MicroformIntegrationApi() {
        this(new ApiClient());
    }

    @Autowired
    public MicroformIntegrationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Generate Capture Context
     * This API is used to generate the Capture Context data structure for the Microform Integration.  Microform is a browser-based acceptance solution that allows a seller to capture payment information is a secure manner from their website.  For more information about Flex Microform transactions, see the [Flex Developer Guides Page](https://developer.cybersource.com/api/developer-guides/dita-flex/SAFlexibleToken.html). For examples on how to integrate Flex Microform within your webpage please see our [GitHub Flex Samples](https://github.com/CyberSource?q&#x3D;flex&amp;type&#x3D;&amp;language&#x3D;) This API is a server-to-server API to generate the capture context that can be used to initiate instance of microform on a acceptance page.  The capture context is a digitally signed JWT that provides authentication, one-time keys, and the target origin to the Microform Integration application. 
     * <p><b>201</b> - Capture Context Created
     * <p><b>0</b> - Error retrieving key.
     * @param generateCaptureContextRequest The generateCaptureContextRequest parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec generateCaptureContextRequestCreation(GenerateCaptureContextRequest generateCaptureContextRequest) throws WebClientResponseException {
        Object postBody = generateCaptureContextRequest;
        // verify the required parameter 'generateCaptureContextRequest' is set
        if (generateCaptureContextRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'generateCaptureContextRequest' when calling generateCaptureContext", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/jwt"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/microform/v2/sessions", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Generate Capture Context
     * This API is used to generate the Capture Context data structure for the Microform Integration.  Microform is a browser-based acceptance solution that allows a seller to capture payment information is a secure manner from their website.  For more information about Flex Microform transactions, see the [Flex Developer Guides Page](https://developer.cybersource.com/api/developer-guides/dita-flex/SAFlexibleToken.html). For examples on how to integrate Flex Microform within your webpage please see our [GitHub Flex Samples](https://github.com/CyberSource?q&#x3D;flex&amp;type&#x3D;&amp;language&#x3D;) This API is a server-to-server API to generate the capture context that can be used to initiate instance of microform on a acceptance page.  The capture context is a digitally signed JWT that provides authentication, one-time keys, and the target origin to the Microform Integration application. 
     * <p><b>201</b> - Capture Context Created
     * <p><b>0</b> - Error retrieving key.
     * @param generateCaptureContextRequest The generateCaptureContextRequest parameter
     * @return String
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<String> generateCaptureContext(GenerateCaptureContextRequest generateCaptureContextRequest) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return generateCaptureContextRequestCreation(generateCaptureContextRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Generate Capture Context
     * This API is used to generate the Capture Context data structure for the Microform Integration.  Microform is a browser-based acceptance solution that allows a seller to capture payment information is a secure manner from their website.  For more information about Flex Microform transactions, see the [Flex Developer Guides Page](https://developer.cybersource.com/api/developer-guides/dita-flex/SAFlexibleToken.html). For examples on how to integrate Flex Microform within your webpage please see our [GitHub Flex Samples](https://github.com/CyberSource?q&#x3D;flex&amp;type&#x3D;&amp;language&#x3D;) This API is a server-to-server API to generate the capture context that can be used to initiate instance of microform on a acceptance page.  The capture context is a digitally signed JWT that provides authentication, one-time keys, and the target origin to the Microform Integration application. 
     * <p><b>201</b> - Capture Context Created
     * <p><b>0</b> - Error retrieving key.
     * @param generateCaptureContextRequest The generateCaptureContextRequest parameter
     * @return ResponseEntity&lt;String&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<String>> generateCaptureContextWithHttpInfo(GenerateCaptureContextRequest generateCaptureContextRequest) throws WebClientResponseException {
        ParameterizedTypeReference<String> localVarReturnType = new ParameterizedTypeReference<String>() {};
        return generateCaptureContextRequestCreation(generateCaptureContextRequest).toEntity(localVarReturnType);
    }

    /**
     * Generate Capture Context
     * This API is used to generate the Capture Context data structure for the Microform Integration.  Microform is a browser-based acceptance solution that allows a seller to capture payment information is a secure manner from their website.  For more information about Flex Microform transactions, see the [Flex Developer Guides Page](https://developer.cybersource.com/api/developer-guides/dita-flex/SAFlexibleToken.html). For examples on how to integrate Flex Microform within your webpage please see our [GitHub Flex Samples](https://github.com/CyberSource?q&#x3D;flex&amp;type&#x3D;&amp;language&#x3D;) This API is a server-to-server API to generate the capture context that can be used to initiate instance of microform on a acceptance page.  The capture context is a digitally signed JWT that provides authentication, one-time keys, and the target origin to the Microform Integration application. 
     * <p><b>201</b> - Capture Context Created
     * <p><b>0</b> - Error retrieving key.
     * @param generateCaptureContextRequest The generateCaptureContextRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec generateCaptureContextWithResponseSpec(GenerateCaptureContextRequest generateCaptureContextRequest) throws WebClientResponseException {
        return generateCaptureContextRequestCreation(generateCaptureContextRequest);
    }
}
