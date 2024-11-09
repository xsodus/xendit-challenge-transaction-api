package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CalculateTaxRequest;
import org.openapitools.client.model.VasV2PaymentsPost201Response;
import org.openapitools.client.model.VasV2PaymentsPost400Response;
import org.openapitools.client.model.VasV2PaymentsPost502Response;
import org.openapitools.client.model.VasV2TaxVoid200Response;
import org.openapitools.client.model.VasV2TaxVoidsPost400Response;
import org.openapitools.client.model.VasV2TaxVoidsPost502Response;
import org.openapitools.client.model.VoidTaxRequest;

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
public class TaxesApi {
    private ApiClient apiClient;

    public TaxesApi() {
        this(new ApiClient());
    }

    @Autowired
    public TaxesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Calculate Taxes
     * The tax calculation service provides real-time sales tax and VAT calculations for orders placed with your business worldwide.  It enhances your ability to conduct business globally and enables you to avoid the risk and complexity of managing online tax calculation.  The service supports product-based tax rules and exemptions for goods and services.  The tax rates are updated twice a month and calculations include sub-level detail (rates per taxing jurisdiction, names and types of jurisdictions). Implementation guidance, list of supported countries, and information on tax reporting are in the [Tax User Guide](https://developer.cybersource.com/docs/cybs/en-us/tax-calculation/developer/all/rest/tax-calculation/tax-overview.html). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param taxRequest The taxRequest parameter
     * @return VasV2PaymentsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec calculateTaxRequestCreation(CalculateTaxRequest taxRequest) throws WebClientResponseException {
        Object postBody = taxRequest;
        // verify the required parameter 'taxRequest' is set
        if (taxRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'taxRequest' when calling calculateTax", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<VasV2PaymentsPost201Response> localVarReturnType = new ParameterizedTypeReference<VasV2PaymentsPost201Response>() {};
        return apiClient.invokeAPI("/vas/v2/tax", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Calculate Taxes
     * The tax calculation service provides real-time sales tax and VAT calculations for orders placed with your business worldwide.  It enhances your ability to conduct business globally and enables you to avoid the risk and complexity of managing online tax calculation.  The service supports product-based tax rules and exemptions for goods and services.  The tax rates are updated twice a month and calculations include sub-level detail (rates per taxing jurisdiction, names and types of jurisdictions). Implementation guidance, list of supported countries, and information on tax reporting are in the [Tax User Guide](https://developer.cybersource.com/docs/cybs/en-us/tax-calculation/developer/all/rest/tax-calculation/tax-overview.html). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param taxRequest The taxRequest parameter
     * @return VasV2PaymentsPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<VasV2PaymentsPost201Response> calculateTax(CalculateTaxRequest taxRequest) throws WebClientResponseException {
        ParameterizedTypeReference<VasV2PaymentsPost201Response> localVarReturnType = new ParameterizedTypeReference<VasV2PaymentsPost201Response>() {};
        return calculateTaxRequestCreation(taxRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Calculate Taxes
     * The tax calculation service provides real-time sales tax and VAT calculations for orders placed with your business worldwide.  It enhances your ability to conduct business globally and enables you to avoid the risk and complexity of managing online tax calculation.  The service supports product-based tax rules and exemptions for goods and services.  The tax rates are updated twice a month and calculations include sub-level detail (rates per taxing jurisdiction, names and types of jurisdictions). Implementation guidance, list of supported countries, and information on tax reporting are in the [Tax User Guide](https://developer.cybersource.com/docs/cybs/en-us/tax-calculation/developer/all/rest/tax-calculation/tax-overview.html). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param taxRequest The taxRequest parameter
     * @return ResponseEntity&lt;VasV2PaymentsPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<VasV2PaymentsPost201Response>> calculateTaxWithHttpInfo(CalculateTaxRequest taxRequest) throws WebClientResponseException {
        ParameterizedTypeReference<VasV2PaymentsPost201Response> localVarReturnType = new ParameterizedTypeReference<VasV2PaymentsPost201Response>() {};
        return calculateTaxRequestCreation(taxRequest).toEntity(localVarReturnType);
    }

    /**
     * Calculate Taxes
     * The tax calculation service provides real-time sales tax and VAT calculations for orders placed with your business worldwide.  It enhances your ability to conduct business globally and enables you to avoid the risk and complexity of managing online tax calculation.  The service supports product-based tax rules and exemptions for goods and services.  The tax rates are updated twice a month and calculations include sub-level detail (rates per taxing jurisdiction, names and types of jurisdictions). Implementation guidance, list of supported countries, and information on tax reporting are in the [Tax User Guide](https://developer.cybersource.com/docs/cybs/en-us/tax-calculation/developer/all/rest/tax-calculation/tax-overview.html). 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param taxRequest The taxRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec calculateTaxWithResponseSpec(CalculateTaxRequest taxRequest) throws WebClientResponseException {
        return calculateTaxRequestCreation(taxRequest);
    }
    /**
     * Void Taxes
     * Pass the Tax Request ID in the PATCH request to void the committed tax calculation.
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The tax ID returned from a previous request.
     * @param voidTaxRequest The voidTaxRequest parameter
     * @return VasV2TaxVoid200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec voidTaxRequestCreation(String id, VoidTaxRequest voidTaxRequest) throws WebClientResponseException {
        Object postBody = voidTaxRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling voidTax", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'voidTaxRequest' is set
        if (voidTaxRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'voidTaxRequest' when calling voidTax", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

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

        ParameterizedTypeReference<VasV2TaxVoid200Response> localVarReturnType = new ParameterizedTypeReference<VasV2TaxVoid200Response>() {};
        return apiClient.invokeAPI("/vas/v2/tax/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Void Taxes
     * Pass the Tax Request ID in the PATCH request to void the committed tax calculation.
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The tax ID returned from a previous request.
     * @param voidTaxRequest The voidTaxRequest parameter
     * @return VasV2TaxVoid200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<VasV2TaxVoid200Response> voidTax(String id, VoidTaxRequest voidTaxRequest) throws WebClientResponseException {
        ParameterizedTypeReference<VasV2TaxVoid200Response> localVarReturnType = new ParameterizedTypeReference<VasV2TaxVoid200Response>() {};
        return voidTaxRequestCreation(id, voidTaxRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Void Taxes
     * Pass the Tax Request ID in the PATCH request to void the committed tax calculation.
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The tax ID returned from a previous request.
     * @param voidTaxRequest The voidTaxRequest parameter
     * @return ResponseEntity&lt;VasV2TaxVoid200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<VasV2TaxVoid200Response>> voidTaxWithHttpInfo(String id, VoidTaxRequest voidTaxRequest) throws WebClientResponseException {
        ParameterizedTypeReference<VasV2TaxVoid200Response> localVarReturnType = new ParameterizedTypeReference<VasV2TaxVoid200Response>() {};
        return voidTaxRequestCreation(id, voidTaxRequest).toEntity(localVarReturnType);
    }

    /**
     * Void Taxes
     * Pass the Tax Request ID in the PATCH request to void the committed tax calculation.
     * <p><b>200</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id The tax ID returned from a previous request.
     * @param voidTaxRequest The voidTaxRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec voidTaxWithResponseSpec(String id, VoidTaxRequest voidTaxRequest) throws WebClientResponseException {
        return voidTaxRequestCreation(id, voidTaxRequest);
    }
}
