package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.InvoicingV2InvoiceSettingsGet200Response;
import org.openapitools.client.model.InvoicingV2InvoiceSettingsGet400Response;
import org.openapitools.client.model.InvoicingV2InvoiceSettingsGet502Response;
import org.openapitools.client.model.InvoicingV2InvoiceSettingsPut200Response;
import org.openapitools.client.model.InvoicingV2InvoiceSettingsPut400Response;
import org.openapitools.client.model.InvoicingV2InvoiceSettingsPut502Response;
import org.openapitools.client.model.UpdateInvoiceSettingsRequest;

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
public class InvoiceSettingsApi {
    private ApiClient apiClient;

    public InvoiceSettingsApi() {
        this(new ApiClient());
    }

    @Autowired
    public InvoiceSettingsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Invoice Settings
     * Allows you to retrieve the invoice settings for the payment page.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Could not get the invoice settings for this merchant.
     * <p><b>0</b> - Unexpected error.
     * @return InvoicingV2InvoiceSettingsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getInvoiceSettingsRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<InvoicingV2InvoiceSettingsGet200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoiceSettingsGet200Response>() {};
        return apiClient.invokeAPI("/invoicing/v2/invoiceSettings", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Invoice Settings
     * Allows you to retrieve the invoice settings for the payment page.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Could not get the invoice settings for this merchant.
     * <p><b>0</b> - Unexpected error.
     * @return InvoicingV2InvoiceSettingsGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoicingV2InvoiceSettingsGet200Response> getInvoiceSettings() throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoiceSettingsGet200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoiceSettingsGet200Response>() {};
        return getInvoiceSettingsRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * Get Invoice Settings
     * Allows you to retrieve the invoice settings for the payment page.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Could not get the invoice settings for this merchant.
     * <p><b>0</b> - Unexpected error.
     * @return ResponseEntity&lt;InvoicingV2InvoiceSettingsGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<InvoicingV2InvoiceSettingsGet200Response>> getInvoiceSettingsWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoiceSettingsGet200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoiceSettingsGet200Response>() {};
        return getInvoiceSettingsRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Get Invoice Settings
     * Allows you to retrieve the invoice settings for the payment page.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Could not get the invoice settings for this merchant.
     * <p><b>0</b> - Unexpected error.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getInvoiceSettingsWithResponseSpec() throws WebClientResponseException {
        return getInvoiceSettingsRequestCreation();
    }
    /**
     * Update Invoice Settings
     * Allows you to customize the payment page, the checkout experience, email communication and payer authentication. You can customize the invoice to match your brand with your business name, logo and brand colors, and a VAT Tax number. You can choose to capture the payers shipping details, phone number and email during the checkout process. You can add a custom message to all invoice emails and enable or disable payer authentication for invoice payments.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Could not update the invoice settings for this merchant.
     * <p><b>0</b> - Unexpected error.
     * @param invoiceSettingsRequest The invoiceSettingsRequest parameter
     * @return InvoicingV2InvoiceSettingsPut200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateInvoiceSettingsRequestCreation(UpdateInvoiceSettingsRequest invoiceSettingsRequest) throws WebClientResponseException {
        Object postBody = invoiceSettingsRequest;
        // verify the required parameter 'invoiceSettingsRequest' is set
        if (invoiceSettingsRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'invoiceSettingsRequest' when calling updateInvoiceSettings", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json;charset=utf-8"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<InvoicingV2InvoiceSettingsPut200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoiceSettingsPut200Response>() {};
        return apiClient.invokeAPI("/invoicing/v2/invoiceSettings", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update Invoice Settings
     * Allows you to customize the payment page, the checkout experience, email communication and payer authentication. You can customize the invoice to match your brand with your business name, logo and brand colors, and a VAT Tax number. You can choose to capture the payers shipping details, phone number and email during the checkout process. You can add a custom message to all invoice emails and enable or disable payer authentication for invoice payments.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Could not update the invoice settings for this merchant.
     * <p><b>0</b> - Unexpected error.
     * @param invoiceSettingsRequest The invoiceSettingsRequest parameter
     * @return InvoicingV2InvoiceSettingsPut200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoicingV2InvoiceSettingsPut200Response> updateInvoiceSettings(UpdateInvoiceSettingsRequest invoiceSettingsRequest) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoiceSettingsPut200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoiceSettingsPut200Response>() {};
        return updateInvoiceSettingsRequestCreation(invoiceSettingsRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Update Invoice Settings
     * Allows you to customize the payment page, the checkout experience, email communication and payer authentication. You can customize the invoice to match your brand with your business name, logo and brand colors, and a VAT Tax number. You can choose to capture the payers shipping details, phone number and email during the checkout process. You can add a custom message to all invoice emails and enable or disable payer authentication for invoice payments.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Could not update the invoice settings for this merchant.
     * <p><b>0</b> - Unexpected error.
     * @param invoiceSettingsRequest The invoiceSettingsRequest parameter
     * @return ResponseEntity&lt;InvoicingV2InvoiceSettingsPut200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<InvoicingV2InvoiceSettingsPut200Response>> updateInvoiceSettingsWithHttpInfo(UpdateInvoiceSettingsRequest invoiceSettingsRequest) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoiceSettingsPut200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoiceSettingsPut200Response>() {};
        return updateInvoiceSettingsRequestCreation(invoiceSettingsRequest).toEntity(localVarReturnType);
    }

    /**
     * Update Invoice Settings
     * Allows you to customize the payment page, the checkout experience, email communication and payer authentication. You can customize the invoice to match your brand with your business name, logo and brand colors, and a VAT Tax number. You can choose to capture the payers shipping details, phone number and email during the checkout process. You can add a custom message to all invoice emails and enable or disable payer authentication for invoice payments.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Could not update the invoice settings for this merchant.
     * <p><b>0</b> - Unexpected error.
     * @param invoiceSettingsRequest The invoiceSettingsRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateInvoiceSettingsWithResponseSpec(UpdateInvoiceSettingsRequest invoiceSettingsRequest) throws WebClientResponseException {
        return updateInvoiceSettingsRequestCreation(invoiceSettingsRequest);
    }
}
