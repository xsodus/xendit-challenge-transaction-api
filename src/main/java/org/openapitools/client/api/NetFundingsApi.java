package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import java.time.OffsetDateTime;
import org.openapitools.client.model.ReportingV3NetFundingsGet200Response;
import org.openapitools.client.model.ReportingV3NetFundingsGet400Response;
import org.openapitools.client.model.ReportingV3NetFundingsGet500Response;

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
public class NetFundingsApi {
    private ApiClient apiClient;

    public NetFundingsApi() {
        this(new ApiClient());
    }

    @Autowired
    public NetFundingsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Netfunding Information for an Account or a Merchant
     * Get Netfunding information for an account or a merchant.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param groupName Valid CyberSource Group Name.
     * @return ReportingV3NetFundingsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getNetFundingDetailsRequestCreation(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String groupName) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'startTime' is set
        if (startTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'startTime' when calling getNetFundingDetails", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'endTime' is set
        if (endTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'endTime' when calling getNetFundingDetails", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startTime", startTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "endTime", endTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organizationId", organizationId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "groupName", groupName));
        
        final String[] localVarAccepts = { 
            "application/hal+json", "application/xml", "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ReportingV3NetFundingsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3NetFundingsGet200Response>() {};
        return apiClient.invokeAPI("/reporting/v3/net-fundings", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Netfunding Information for an Account or a Merchant
     * Get Netfunding information for an account or a merchant.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param groupName Valid CyberSource Group Name.
     * @return ReportingV3NetFundingsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ReportingV3NetFundingsGet200Response> getNetFundingDetails(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String groupName) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3NetFundingsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3NetFundingsGet200Response>() {};
        return getNetFundingDetailsRequestCreation(startTime, endTime, organizationId, groupName).bodyToMono(localVarReturnType);
    }

    /**
     * Get Netfunding Information for an Account or a Merchant
     * Get Netfunding information for an account or a merchant.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param groupName Valid CyberSource Group Name.
     * @return ResponseEntity&lt;ReportingV3NetFundingsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ReportingV3NetFundingsGet200Response>> getNetFundingDetailsWithHttpInfo(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String groupName) throws WebClientResponseException {
        ParameterizedTypeReference<ReportingV3NetFundingsGet200Response> localVarReturnType = new ParameterizedTypeReference<ReportingV3NetFundingsGet200Response>() {};
        return getNetFundingDetailsRequestCreation(startTime, endTime, organizationId, groupName).toEntity(localVarReturnType);
    }

    /**
     * Get Netfunding Information for an Account or a Merchant
     * Get Netfunding information for an account or a merchant.
     * <p><b>200</b> - Ok
     * <p><b>400</b> - Invalid request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Report not found
     * <p><b>500</b> - Internal Server Error
     * @param startTime Valid report Start Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param endTime Valid report End Time in **ISO 8601 format** Please refer the following link to know more about ISO 8601 format.[Rfc Date Format](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14)  **Example date format:**   - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ (e.g. 2018-01-01T00:00:00.000Z) 
     * @param organizationId Valid Organization Id
     * @param groupName Valid CyberSource Group Name.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getNetFundingDetailsWithResponseSpec(OffsetDateTime startTime, OffsetDateTime endTime, String organizationId, String groupName) throws WebClientResponseException {
        return getNetFundingDetailsRequestCreation(startTime, endTime, organizationId, groupName);
    }
}
