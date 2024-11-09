package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.CreateInvoiceRequest;
import org.openapitools.client.model.InvoicingV2InvoicesAllGet200Response;
import org.openapitools.client.model.InvoicingV2InvoicesAllGet400Response;
import org.openapitools.client.model.InvoicingV2InvoicesAllGet404Response;
import org.openapitools.client.model.InvoicingV2InvoicesAllGet502Response;
import org.openapitools.client.model.InvoicingV2InvoicesCancel200Response;
import org.openapitools.client.model.InvoicingV2InvoicesCancel400Response;
import org.openapitools.client.model.InvoicingV2InvoicesCancel404Response;
import org.openapitools.client.model.InvoicingV2InvoicesCancel502Response;
import org.openapitools.client.model.InvoicingV2InvoicesGet200Response;
import org.openapitools.client.model.InvoicingV2InvoicesGet400Response;
import org.openapitools.client.model.InvoicingV2InvoicesGet404Response;
import org.openapitools.client.model.InvoicingV2InvoicesGet502Response;
import org.openapitools.client.model.InvoicingV2InvoicesPost201Response;
import org.openapitools.client.model.InvoicingV2InvoicesPost202Response;
import org.openapitools.client.model.InvoicingV2InvoicesPost400Response;
import org.openapitools.client.model.InvoicingV2InvoicesPost404Response;
import org.openapitools.client.model.InvoicingV2InvoicesPost502Response;
import org.openapitools.client.model.InvoicingV2InvoicesPut200Response;
import org.openapitools.client.model.InvoicingV2InvoicesPut400Response;
import org.openapitools.client.model.InvoicingV2InvoicesPut404Response;
import org.openapitools.client.model.InvoicingV2InvoicesPut502Response;
import org.openapitools.client.model.InvoicingV2InvoicesSend200Response;
import org.openapitools.client.model.InvoicingV2InvoicesSend400Response;
import org.openapitools.client.model.InvoicingV2InvoicesSend404Response;
import org.openapitools.client.model.InvoicingV2InvoicesSend502Response;
import org.openapitools.client.model.UpdateInvoiceRequest;

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
public class InvoicesApi {
    private ApiClient apiClient;

    public InvoicesApi() {
        this(new ApiClient());
    }

    @Autowired
    public InvoicesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a New Invoice
     * The invoicing product enables you to bill any customer with an email address and accept digital payments securely from any connected device. You can either use the system generated email or use the invoice payment link in your own communication. You can add discounts and taxes for the entire invoice or for each line item. To customize the invoice to match your brand see [Invoice Settings](https://developer.cybersource.com/api-reference-assets/index.html#invoicing_invoice-settings_update-invoice-settings). The invoice payment page uses Unified Checkout to process the payments.
     * <p><b>201</b> - Created.
     * <p><b>202</b> - Invoice created but failed to send an email. Send the invoice separately.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - The specified resource is not found.
     * <p><b>0</b> - Unexpected error.
     * @param createInvoiceRequest The createInvoiceRequest parameter
     * @return InvoicingV2InvoicesPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createInvoiceRequestCreation(CreateInvoiceRequest createInvoiceRequest) throws WebClientResponseException {
        Object postBody = createInvoiceRequest;
        // verify the required parameter 'createInvoiceRequest' is set
        if (createInvoiceRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'createInvoiceRequest' when calling createInvoice", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<InvoicingV2InvoicesPost201Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesPost201Response>() {};
        return apiClient.invokeAPI("/invoicing/v2/invoices", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a New Invoice
     * The invoicing product enables you to bill any customer with an email address and accept digital payments securely from any connected device. You can either use the system generated email or use the invoice payment link in your own communication. You can add discounts and taxes for the entire invoice or for each line item. To customize the invoice to match your brand see [Invoice Settings](https://developer.cybersource.com/api-reference-assets/index.html#invoicing_invoice-settings_update-invoice-settings). The invoice payment page uses Unified Checkout to process the payments.
     * <p><b>201</b> - Created.
     * <p><b>202</b> - Invoice created but failed to send an email. Send the invoice separately.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - The specified resource is not found.
     * <p><b>0</b> - Unexpected error.
     * @param createInvoiceRequest The createInvoiceRequest parameter
     * @return InvoicingV2InvoicesPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoicingV2InvoicesPost201Response> createInvoice(CreateInvoiceRequest createInvoiceRequest) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesPost201Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesPost201Response>() {};
        return createInvoiceRequestCreation(createInvoiceRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Create a New Invoice
     * The invoicing product enables you to bill any customer with an email address and accept digital payments securely from any connected device. You can either use the system generated email or use the invoice payment link in your own communication. You can add discounts and taxes for the entire invoice or for each line item. To customize the invoice to match your brand see [Invoice Settings](https://developer.cybersource.com/api-reference-assets/index.html#invoicing_invoice-settings_update-invoice-settings). The invoice payment page uses Unified Checkout to process the payments.
     * <p><b>201</b> - Created.
     * <p><b>202</b> - Invoice created but failed to send an email. Send the invoice separately.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - The specified resource is not found.
     * <p><b>0</b> - Unexpected error.
     * @param createInvoiceRequest The createInvoiceRequest parameter
     * @return ResponseEntity&lt;InvoicingV2InvoicesPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<InvoicingV2InvoicesPost201Response>> createInvoiceWithHttpInfo(CreateInvoiceRequest createInvoiceRequest) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesPost201Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesPost201Response>() {};
        return createInvoiceRequestCreation(createInvoiceRequest).toEntity(localVarReturnType);
    }

    /**
     * Create a New Invoice
     * The invoicing product enables you to bill any customer with an email address and accept digital payments securely from any connected device. You can either use the system generated email or use the invoice payment link in your own communication. You can add discounts and taxes for the entire invoice or for each line item. To customize the invoice to match your brand see [Invoice Settings](https://developer.cybersource.com/api-reference-assets/index.html#invoicing_invoice-settings_update-invoice-settings). The invoice payment page uses Unified Checkout to process the payments.
     * <p><b>201</b> - Created.
     * <p><b>202</b> - Invoice created but failed to send an email. Send the invoice separately.
     * <p><b>400</b> - Invalid request.
     * <p><b>404</b> - The specified resource is not found.
     * <p><b>0</b> - Unexpected error.
     * @param createInvoiceRequest The createInvoiceRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createInvoiceWithResponseSpec(CreateInvoiceRequest createInvoiceRequest) throws WebClientResponseException {
        return createInvoiceRequestCreation(createInvoiceRequest);
    }
    /**
     * Get a List of Invoices
     * Provides a (filtered) list of invoices that have been created in your account. You can filter the list based on Invoice Status by setting the status query parameter to one of DRAFT, CREATED, SENT, PARTIAL, PAID or CANCELED.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Invalid invoice status. The status should be one of: &#x60;DRAFT&#x60;, &#x60;CREATED&#x60;, &#x60;SENT&#x60;, &#x60;PARTIAL&#x60;, &#x60;PAID&#x60;, &#x60;CANCELED&#x60; or &#x60;PENDING&#x60;.
     * <p><b>404</b> - No invoices found.
     * <p><b>0</b> - Unexpected error.
     * @param offset Page offset number.
     * @param limit Maximum number of items you would like returned.
     * @param status The status of the invoice.  Possible values:   - DRAFT   - CREATED   - SENT   - PARTIAL   - PAID   - CANCELED   - PENDING 
     * @return InvoicingV2InvoicesAllGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getAllInvoicesRequestCreation(Integer offset, Integer limit, String status) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'offset' is set
        if (offset == null) {
            throw new WebClientResponseException("Missing the required parameter 'offset' when calling getAllInvoices", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'limit' is set
        if (limit == null) {
            throw new WebClientResponseException("Missing the required parameter 'limit' when calling getAllInvoices", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        
        final String[] localVarAccepts = { 
            "application/json", "application/hal+json", "application/json;charset=utf-8", "application/hal+json;charset=utf-8"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<InvoicingV2InvoicesAllGet200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesAllGet200Response>() {};
        return apiClient.invokeAPI("/invoicing/v2/invoices", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a List of Invoices
     * Provides a (filtered) list of invoices that have been created in your account. You can filter the list based on Invoice Status by setting the status query parameter to one of DRAFT, CREATED, SENT, PARTIAL, PAID or CANCELED.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Invalid invoice status. The status should be one of: &#x60;DRAFT&#x60;, &#x60;CREATED&#x60;, &#x60;SENT&#x60;, &#x60;PARTIAL&#x60;, &#x60;PAID&#x60;, &#x60;CANCELED&#x60; or &#x60;PENDING&#x60;.
     * <p><b>404</b> - No invoices found.
     * <p><b>0</b> - Unexpected error.
     * @param offset Page offset number.
     * @param limit Maximum number of items you would like returned.
     * @param status The status of the invoice.  Possible values:   - DRAFT   - CREATED   - SENT   - PARTIAL   - PAID   - CANCELED   - PENDING 
     * @return InvoicingV2InvoicesAllGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoicingV2InvoicesAllGet200Response> getAllInvoices(Integer offset, Integer limit, String status) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesAllGet200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesAllGet200Response>() {};
        return getAllInvoicesRequestCreation(offset, limit, status).bodyToMono(localVarReturnType);
    }

    /**
     * Get a List of Invoices
     * Provides a (filtered) list of invoices that have been created in your account. You can filter the list based on Invoice Status by setting the status query parameter to one of DRAFT, CREATED, SENT, PARTIAL, PAID or CANCELED.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Invalid invoice status. The status should be one of: &#x60;DRAFT&#x60;, &#x60;CREATED&#x60;, &#x60;SENT&#x60;, &#x60;PARTIAL&#x60;, &#x60;PAID&#x60;, &#x60;CANCELED&#x60; or &#x60;PENDING&#x60;.
     * <p><b>404</b> - No invoices found.
     * <p><b>0</b> - Unexpected error.
     * @param offset Page offset number.
     * @param limit Maximum number of items you would like returned.
     * @param status The status of the invoice.  Possible values:   - DRAFT   - CREATED   - SENT   - PARTIAL   - PAID   - CANCELED   - PENDING 
     * @return ResponseEntity&lt;InvoicingV2InvoicesAllGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<InvoicingV2InvoicesAllGet200Response>> getAllInvoicesWithHttpInfo(Integer offset, Integer limit, String status) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesAllGet200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesAllGet200Response>() {};
        return getAllInvoicesRequestCreation(offset, limit, status).toEntity(localVarReturnType);
    }

    /**
     * Get a List of Invoices
     * Provides a (filtered) list of invoices that have been created in your account. You can filter the list based on Invoice Status by setting the status query parameter to one of DRAFT, CREATED, SENT, PARTIAL, PAID or CANCELED.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Invalid invoice status. The status should be one of: &#x60;DRAFT&#x60;, &#x60;CREATED&#x60;, &#x60;SENT&#x60;, &#x60;PARTIAL&#x60;, &#x60;PAID&#x60;, &#x60;CANCELED&#x60; or &#x60;PENDING&#x60;.
     * <p><b>404</b> - No invoices found.
     * <p><b>0</b> - Unexpected error.
     * @param offset Page offset number.
     * @param limit Maximum number of items you would like returned.
     * @param status The status of the invoice.  Possible values:   - DRAFT   - CREATED   - SENT   - PARTIAL   - PAID   - CANCELED   - PENDING 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getAllInvoicesWithResponseSpec(Integer offset, Integer limit, String status) throws WebClientResponseException {
        return getAllInvoicesRequestCreation(offset, limit, status);
    }
    /**
     * Get Invoice Details
     * You can retrieve details of a specific invoice. This can be used to check the Invoice status and get a list of invoice payments in the invoice history section of the response. For each payment transaction you can use the Transaction Details API to get more details on the payment transaction.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Invoicing service is not enabled.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return InvoicingV2InvoicesGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getInvoiceRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getInvoice", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

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

        ParameterizedTypeReference<InvoicingV2InvoicesGet200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesGet200Response>() {};
        return apiClient.invokeAPI("/invoicing/v2/invoices/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Invoice Details
     * You can retrieve details of a specific invoice. This can be used to check the Invoice status and get a list of invoice payments in the invoice history section of the response. For each payment transaction you can use the Transaction Details API to get more details on the payment transaction.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Invoicing service is not enabled.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return InvoicingV2InvoicesGet200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoicingV2InvoicesGet200Response> getInvoice(String id) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesGet200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesGet200Response>() {};
        return getInvoiceRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Get Invoice Details
     * You can retrieve details of a specific invoice. This can be used to check the Invoice status and get a list of invoice payments in the invoice history section of the response. For each payment transaction you can use the Transaction Details API to get more details on the payment transaction.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Invoicing service is not enabled.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return ResponseEntity&lt;InvoicingV2InvoicesGet200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<InvoicingV2InvoicesGet200Response>> getInvoiceWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesGet200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesGet200Response>() {};
        return getInvoiceRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get Invoice Details
     * You can retrieve details of a specific invoice. This can be used to check the Invoice status and get a list of invoice payments in the invoice history section of the response. For each payment transaction you can use the Transaction Details API to get more details on the payment transaction.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Invoicing service is not enabled.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getInvoiceWithResponseSpec(String id) throws WebClientResponseException {
        return getInvoiceRequestCreation(id);
    }
    /**
     * Cancel an Invoice
     * You can cancel an invoice if no payment is made to it. You cannot cancel partially or fully paid invoices.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Requested action is not allowed.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return InvoicingV2InvoicesCancel200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec performCancelActionRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling performCancelAction", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

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

        ParameterizedTypeReference<InvoicingV2InvoicesCancel200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesCancel200Response>() {};
        return apiClient.invokeAPI("/invoicing/v2/invoices/{id}/cancelation", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Cancel an Invoice
     * You can cancel an invoice if no payment is made to it. You cannot cancel partially or fully paid invoices.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Requested action is not allowed.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return InvoicingV2InvoicesCancel200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoicingV2InvoicesCancel200Response> performCancelAction(String id) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesCancel200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesCancel200Response>() {};
        return performCancelActionRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Cancel an Invoice
     * You can cancel an invoice if no payment is made to it. You cannot cancel partially or fully paid invoices.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Requested action is not allowed.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return ResponseEntity&lt;InvoicingV2InvoicesCancel200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<InvoicingV2InvoicesCancel200Response>> performCancelActionWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesCancel200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesCancel200Response>() {};
        return performCancelActionRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Cancel an Invoice
     * You can cancel an invoice if no payment is made to it. You cannot cancel partially or fully paid invoices.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Requested action is not allowed.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec performCancelActionWithResponseSpec(String id) throws WebClientResponseException {
        return performCancelActionRequestCreation(id);
    }
    /**
     * Send an Invoice
     * You can send an invoice in draft or created state or resend a sent or partially paid invoice. Fully paid or canceled invoices cannot be resent.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Requested action is not allowed.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return InvoicingV2InvoicesSend200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec performSendActionRequestCreation(String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling performSendAction", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

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

        ParameterizedTypeReference<InvoicingV2InvoicesSend200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesSend200Response>() {};
        return apiClient.invokeAPI("/invoicing/v2/invoices/{id}/delivery", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Send an Invoice
     * You can send an invoice in draft or created state or resend a sent or partially paid invoice. Fully paid or canceled invoices cannot be resent.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Requested action is not allowed.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return InvoicingV2InvoicesSend200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoicingV2InvoicesSend200Response> performSendAction(String id) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesSend200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesSend200Response>() {};
        return performSendActionRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Send an Invoice
     * You can send an invoice in draft or created state or resend a sent or partially paid invoice. Fully paid or canceled invoices cannot be resent.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Requested action is not allowed.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return ResponseEntity&lt;InvoicingV2InvoicesSend200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<InvoicingV2InvoicesSend200Response>> performSendActionWithHttpInfo(String id) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesSend200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesSend200Response>() {};
        return performSendActionRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Send an Invoice
     * You can send an invoice in draft or created state or resend a sent or partially paid invoice. Fully paid or canceled invoices cannot be resent.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Requested action is not allowed.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec performSendActionWithResponseSpec(String id) throws WebClientResponseException {
        return performSendActionRequestCreation(id);
    }
    /**
     * Update an Invoice
     * You can update all information except the invoice number till any payment is received for an invoice. Invoices that are partially or fully paid or cancelled cannot be updated.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Field validation errors.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @param updateInvoiceRequest Updating the invoice does not resend the invoice automatically. You must resend the invoice separately.
     * @return InvoicingV2InvoicesPut200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateInvoiceRequestCreation(String id, UpdateInvoiceRequest updateInvoiceRequest) throws WebClientResponseException {
        Object postBody = updateInvoiceRequest;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling updateInvoice", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updateInvoiceRequest' is set
        if (updateInvoiceRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'updateInvoiceRequest' when calling updateInvoice", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

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

        ParameterizedTypeReference<InvoicingV2InvoicesPut200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesPut200Response>() {};
        return apiClient.invokeAPI("/invoicing/v2/invoices/{id}", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update an Invoice
     * You can update all information except the invoice number till any payment is received for an invoice. Invoices that are partially or fully paid or cancelled cannot be updated.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Field validation errors.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @param updateInvoiceRequest Updating the invoice does not resend the invoice automatically. You must resend the invoice separately.
     * @return InvoicingV2InvoicesPut200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<InvoicingV2InvoicesPut200Response> updateInvoice(String id, UpdateInvoiceRequest updateInvoiceRequest) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesPut200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesPut200Response>() {};
        return updateInvoiceRequestCreation(id, updateInvoiceRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Update an Invoice
     * You can update all information except the invoice number till any payment is received for an invoice. Invoices that are partially or fully paid or cancelled cannot be updated.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Field validation errors.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @param updateInvoiceRequest Updating the invoice does not resend the invoice automatically. You must resend the invoice separately.
     * @return ResponseEntity&lt;InvoicingV2InvoicesPut200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<InvoicingV2InvoicesPut200Response>> updateInvoiceWithHttpInfo(String id, UpdateInvoiceRequest updateInvoiceRequest) throws WebClientResponseException {
        ParameterizedTypeReference<InvoicingV2InvoicesPut200Response> localVarReturnType = new ParameterizedTypeReference<InvoicingV2InvoicesPut200Response>() {};
        return updateInvoiceRequestCreation(id, updateInvoiceRequest).toEntity(localVarReturnType);
    }

    /**
     * Update an Invoice
     * You can update all information except the invoice number till any payment is received for an invoice. Invoices that are partially or fully paid or cancelled cannot be updated.
     * <p><b>200</b> - OK.
     * <p><b>400</b> - Field validation errors.
     * <p><b>404</b> - Invoice does not exist.
     * <p><b>0</b> - Unexpected error.
     * @param id The invoice number.
     * @param updateInvoiceRequest Updating the invoice does not resend the invoice automatically. You must resend the invoice separately.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateInvoiceWithResponseSpec(String id, UpdateInvoiceRequest updateInvoiceRequest) throws WebClientResponseException {
        return updateInvoiceRequestCreation(id, updateInvoiceRequest);
    }
}
