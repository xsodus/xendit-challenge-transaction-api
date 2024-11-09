package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.RiskV1AddressVerificationsPost201Response;
import org.openapitools.client.model.RiskV1AddressVerificationsPost400Response;
import org.openapitools.client.model.RiskV1AddressVerificationsPost502Response;
import org.openapitools.client.model.RiskV1ExportComplianceInquiriesPost201Response;
import org.openapitools.client.model.RiskV1ExportComplianceInquiriesPost400Response;
import org.openapitools.client.model.RiskV1ExportComplianceInquiriesPost502Response;
import org.openapitools.client.model.ValidateExportComplianceRequest;
import org.openapitools.client.model.VerifyCustomerAddressRequest;

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
public class VerificationApi {
    private ApiClient apiClient;

    public VerificationApi() {
        this(new ApiClient());
    }

    @Autowired
    public VerificationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Validate export compliance
     * This call checks customer data against specified watch lists to ensure export compliance. 
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param validateExportComplianceRequest The validateExportComplianceRequest parameter
     * @return RiskV1ExportComplianceInquiriesPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec validateExportComplianceRequestCreation(ValidateExportComplianceRequest validateExportComplianceRequest) throws WebClientResponseException {
        Object postBody = validateExportComplianceRequest;
        // verify the required parameter 'validateExportComplianceRequest' is set
        if (validateExportComplianceRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'validateExportComplianceRequest' when calling validateExportCompliance", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<RiskV1ExportComplianceInquiriesPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1ExportComplianceInquiriesPost201Response>() {};
        return apiClient.invokeAPI("/risk/v1/export-compliance-inquiries", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Validate export compliance
     * This call checks customer data against specified watch lists to ensure export compliance. 
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param validateExportComplianceRequest The validateExportComplianceRequest parameter
     * @return RiskV1ExportComplianceInquiriesPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<RiskV1ExportComplianceInquiriesPost201Response> validateExportCompliance(ValidateExportComplianceRequest validateExportComplianceRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1ExportComplianceInquiriesPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1ExportComplianceInquiriesPost201Response>() {};
        return validateExportComplianceRequestCreation(validateExportComplianceRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Validate export compliance
     * This call checks customer data against specified watch lists to ensure export compliance. 
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param validateExportComplianceRequest The validateExportComplianceRequest parameter
     * @return ResponseEntity&lt;RiskV1ExportComplianceInquiriesPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<RiskV1ExportComplianceInquiriesPost201Response>> validateExportComplianceWithHttpInfo(ValidateExportComplianceRequest validateExportComplianceRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1ExportComplianceInquiriesPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1ExportComplianceInquiriesPost201Response>() {};
        return validateExportComplianceRequestCreation(validateExportComplianceRequest).toEntity(localVarReturnType);
    }

    /**
     * Validate export compliance
     * This call checks customer data against specified watch lists to ensure export compliance. 
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param validateExportComplianceRequest The validateExportComplianceRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec validateExportComplianceWithResponseSpec(ValidateExportComplianceRequest validateExportComplianceRequest) throws WebClientResponseException {
        return validateExportComplianceRequestCreation(validateExportComplianceRequest);
    }
    /**
     * Verify customer address
     * This call verifies that the customer address submitted is valid.
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param verifyCustomerAddressRequest The verifyCustomerAddressRequest parameter
     * @return RiskV1AddressVerificationsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec verifyCustomerAddressRequestCreation(VerifyCustomerAddressRequest verifyCustomerAddressRequest) throws WebClientResponseException {
        Object postBody = verifyCustomerAddressRequest;
        // verify the required parameter 'verifyCustomerAddressRequest' is set
        if (verifyCustomerAddressRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'verifyCustomerAddressRequest' when calling verifyCustomerAddress", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<RiskV1AddressVerificationsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AddressVerificationsPost201Response>() {};
        return apiClient.invokeAPI("/risk/v1/address-verifications", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Verify customer address
     * This call verifies that the customer address submitted is valid.
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param verifyCustomerAddressRequest The verifyCustomerAddressRequest parameter
     * @return RiskV1AddressVerificationsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<RiskV1AddressVerificationsPost201Response> verifyCustomerAddress(VerifyCustomerAddressRequest verifyCustomerAddressRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1AddressVerificationsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AddressVerificationsPost201Response>() {};
        return verifyCustomerAddressRequestCreation(verifyCustomerAddressRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Verify customer address
     * This call verifies that the customer address submitted is valid.
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param verifyCustomerAddressRequest The verifyCustomerAddressRequest parameter
     * @return ResponseEntity&lt;RiskV1AddressVerificationsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<RiskV1AddressVerificationsPost201Response>> verifyCustomerAddressWithHttpInfo(VerifyCustomerAddressRequest verifyCustomerAddressRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1AddressVerificationsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AddressVerificationsPost201Response>() {};
        return verifyCustomerAddressRequestCreation(verifyCustomerAddressRequest).toEntity(localVarReturnType);
    }

    /**
     * Verify customer address
     * This call verifies that the customer address submitted is valid.
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param verifyCustomerAddressRequest The verifyCustomerAddressRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec verifyCustomerAddressWithResponseSpec(VerifyCustomerAddressRequest verifyCustomerAddressRequest) throws WebClientResponseException {
        return verifyCustomerAddressRequestCreation(verifyCustomerAddressRequest);
    }
}
