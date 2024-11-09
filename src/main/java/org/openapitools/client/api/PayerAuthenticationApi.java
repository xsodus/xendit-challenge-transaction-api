package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CheckPayerAuthEnrollmentRequest;
import org.openapitools.client.model.PayerAuthSetupRequest;
import org.openapitools.client.model.RiskV1AuthenticationResultsPost201Response;
import org.openapitools.client.model.RiskV1AuthenticationResultsPost400Response;
import org.openapitools.client.model.RiskV1AuthenticationResultsPost502Response;
import org.openapitools.client.model.RiskV1AuthenticationSetupsPost201Response;
import org.openapitools.client.model.RiskV1AuthenticationsPost201Response;
import org.openapitools.client.model.RiskV1AuthenticationsPost400Response;
import org.openapitools.client.model.RiskV1AuthenticationsPost400Response1;
import org.openapitools.client.model.RiskV1AuthenticationsPost502Response;
import org.openapitools.client.model.ValidateAuthenticationResultsRequest;

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
public class PayerAuthenticationApi {
    private ApiClient apiClient;

    public PayerAuthenticationApi() {
        this(new ApiClient());
    }

    @Autowired
    public PayerAuthenticationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Check Payer Auth Enrollment
     * This call verifies that the card is enrolled in a card authentication program.
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param checkPayerAuthEnrollmentRequest The checkPayerAuthEnrollmentRequest parameter
     * @return RiskV1AuthenticationsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec checkPayerAuthEnrollmentRequestCreation(CheckPayerAuthEnrollmentRequest checkPayerAuthEnrollmentRequest) throws WebClientResponseException {
        Object postBody = checkPayerAuthEnrollmentRequest;
        // verify the required parameter 'checkPayerAuthEnrollmentRequest' is set
        if (checkPayerAuthEnrollmentRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'checkPayerAuthEnrollmentRequest' when calling checkPayerAuthEnrollment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<RiskV1AuthenticationsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AuthenticationsPost201Response>() {};
        return apiClient.invokeAPI("/risk/v1/authentications", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Check Payer Auth Enrollment
     * This call verifies that the card is enrolled in a card authentication program.
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param checkPayerAuthEnrollmentRequest The checkPayerAuthEnrollmentRequest parameter
     * @return RiskV1AuthenticationsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<RiskV1AuthenticationsPost201Response> checkPayerAuthEnrollment(CheckPayerAuthEnrollmentRequest checkPayerAuthEnrollmentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1AuthenticationsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AuthenticationsPost201Response>() {};
        return checkPayerAuthEnrollmentRequestCreation(checkPayerAuthEnrollmentRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Check Payer Auth Enrollment
     * This call verifies that the card is enrolled in a card authentication program.
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param checkPayerAuthEnrollmentRequest The checkPayerAuthEnrollmentRequest parameter
     * @return ResponseEntity&lt;RiskV1AuthenticationsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<RiskV1AuthenticationsPost201Response>> checkPayerAuthEnrollmentWithHttpInfo(CheckPayerAuthEnrollmentRequest checkPayerAuthEnrollmentRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1AuthenticationsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AuthenticationsPost201Response>() {};
        return checkPayerAuthEnrollmentRequestCreation(checkPayerAuthEnrollmentRequest).toEntity(localVarReturnType);
    }

    /**
     * Check Payer Auth Enrollment
     * This call verifies that the card is enrolled in a card authentication program.
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param checkPayerAuthEnrollmentRequest The checkPayerAuthEnrollmentRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec checkPayerAuthEnrollmentWithResponseSpec(CheckPayerAuthEnrollmentRequest checkPayerAuthEnrollmentRequest) throws WebClientResponseException {
        return checkPayerAuthEnrollmentRequestCreation(checkPayerAuthEnrollmentRequest);
    }
    /**
     * Setup Payer Auth
     * A new service for Merchants to get reference_id for Digital Wallets to use in place of BIN number in Cardinal. Set up file while authenticating with Cardinal. This service should be called by Merchant when payment instrument chosen or changes. This service has to be called before enrollment check.
     * <p><b>201</b> - Setup completed
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param payerAuthSetupRequest The payerAuthSetupRequest parameter
     * @return RiskV1AuthenticationSetupsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec payerAuthSetupRequestCreation(PayerAuthSetupRequest payerAuthSetupRequest) throws WebClientResponseException {
        Object postBody = payerAuthSetupRequest;
        // verify the required parameter 'payerAuthSetupRequest' is set
        if (payerAuthSetupRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'payerAuthSetupRequest' when calling payerAuthSetup", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<RiskV1AuthenticationSetupsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AuthenticationSetupsPost201Response>() {};
        return apiClient.invokeAPI("/risk/v1/authentication-setups", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Setup Payer Auth
     * A new service for Merchants to get reference_id for Digital Wallets to use in place of BIN number in Cardinal. Set up file while authenticating with Cardinal. This service should be called by Merchant when payment instrument chosen or changes. This service has to be called before enrollment check.
     * <p><b>201</b> - Setup completed
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param payerAuthSetupRequest The payerAuthSetupRequest parameter
     * @return RiskV1AuthenticationSetupsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<RiskV1AuthenticationSetupsPost201Response> payerAuthSetup(PayerAuthSetupRequest payerAuthSetupRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1AuthenticationSetupsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AuthenticationSetupsPost201Response>() {};
        return payerAuthSetupRequestCreation(payerAuthSetupRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Setup Payer Auth
     * A new service for Merchants to get reference_id for Digital Wallets to use in place of BIN number in Cardinal. Set up file while authenticating with Cardinal. This service should be called by Merchant when payment instrument chosen or changes. This service has to be called before enrollment check.
     * <p><b>201</b> - Setup completed
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param payerAuthSetupRequest The payerAuthSetupRequest parameter
     * @return ResponseEntity&lt;RiskV1AuthenticationSetupsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<RiskV1AuthenticationSetupsPost201Response>> payerAuthSetupWithHttpInfo(PayerAuthSetupRequest payerAuthSetupRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1AuthenticationSetupsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AuthenticationSetupsPost201Response>() {};
        return payerAuthSetupRequestCreation(payerAuthSetupRequest).toEntity(localVarReturnType);
    }

    /**
     * Setup Payer Auth
     * A new service for Merchants to get reference_id for Digital Wallets to use in place of BIN number in Cardinal. Set up file while authenticating with Cardinal. This service should be called by Merchant when payment instrument chosen or changes. This service has to be called before enrollment check.
     * <p><b>201</b> - Setup completed
     * <p><b>400</b> - Invalid request
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param payerAuthSetupRequest The payerAuthSetupRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec payerAuthSetupWithResponseSpec(PayerAuthSetupRequest payerAuthSetupRequest) throws WebClientResponseException {
        return payerAuthSetupRequestCreation(payerAuthSetupRequest);
    }
    /**
     * Validate Authentication Results
     * This call retrieves and validates the authentication results from issuer and allows the merchant to proceed with processing the payment. 
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param validateRequest The validateRequest parameter
     * @return RiskV1AuthenticationResultsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec validateAuthenticationResultsRequestCreation(ValidateAuthenticationResultsRequest validateRequest) throws WebClientResponseException {
        Object postBody = validateRequest;
        // verify the required parameter 'validateRequest' is set
        if (validateRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'validateRequest' when calling validateAuthenticationResults", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<RiskV1AuthenticationResultsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AuthenticationResultsPost201Response>() {};
        return apiClient.invokeAPI("/risk/v1/authentication-results", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Validate Authentication Results
     * This call retrieves and validates the authentication results from issuer and allows the merchant to proceed with processing the payment. 
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param validateRequest The validateRequest parameter
     * @return RiskV1AuthenticationResultsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<RiskV1AuthenticationResultsPost201Response> validateAuthenticationResults(ValidateAuthenticationResultsRequest validateRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1AuthenticationResultsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AuthenticationResultsPost201Response>() {};
        return validateAuthenticationResultsRequestCreation(validateRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Validate Authentication Results
     * This call retrieves and validates the authentication results from issuer and allows the merchant to proceed with processing the payment. 
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param validateRequest The validateRequest parameter
     * @return ResponseEntity&lt;RiskV1AuthenticationResultsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<RiskV1AuthenticationResultsPost201Response>> validateAuthenticationResultsWithHttpInfo(ValidateAuthenticationResultsRequest validateRequest) throws WebClientResponseException {
        ParameterizedTypeReference<RiskV1AuthenticationResultsPost201Response> localVarReturnType = new ParameterizedTypeReference<RiskV1AuthenticationResultsPost201Response>() {};
        return validateAuthenticationResultsRequestCreation(validateRequest).toEntity(localVarReturnType);
    }

    /**
     * Validate Authentication Results
     * This call retrieves and validates the authentication results from issuer and allows the merchant to proceed with processing the payment. 
     * <p><b>201</b> - Successful response
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param validateRequest The validateRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec validateAuthenticationResultsWithResponseSpec(ValidateAuthenticationResultsRequest validateRequest) throws WebClientResponseException {
        return validateAuthenticationResultsRequestCreation(validateRequest);
    }
}
