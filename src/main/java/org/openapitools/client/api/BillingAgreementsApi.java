package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.BillingAgreementsDeRegistrationRequest;
import org.openapitools.client.model.BillingAgreementsIntimationRequest;
import org.openapitools.client.model.BillingAgreementsRegistrationRequest;
import org.openapitools.client.model.PtsV2CreateBillingAgreementPost201Response;
import org.openapitools.client.model.PtsV2CreateBillingAgreementPost400Response;
import org.openapitools.client.model.PtsV2CreateBillingAgreementPost502Response;
import org.openapitools.client.model.PtsV2CreditsPost201Response1;
import org.openapitools.client.model.PtsV2CreditsPost400Response1;
import org.openapitools.client.model.PtsV2CreditsPost502Response1;
import org.openapitools.client.model.PtsV2ModifyBillingAgreementPost201Response;
import org.openapitools.client.model.PtsV2ModifyBillingAgreementPost400Response;
import org.openapitools.client.model.PtsV2ModifyBillingAgreementPost502Response;

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
public class BillingAgreementsApi {
    private ApiClient apiClient;

    public BillingAgreementsApi() {
        this(new ApiClient());
    }

    @Autowired
    public BillingAgreementsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Modify a Billing Agreement
     * #### Standing Instruction: Standing Instruction with or without Token.  #### Revoke Mandate: When you revoke a mandate, any pending direct debits linked to that mandate are canceled. No notifications are sent. When you revoke a mandate with no pending direct debits, the Bacs scheme or customer&#39;s bank notify you of any subsequent direct debit events. When you revoke a mandate, you cannot send a direct debit request using the mandate ID. Customer payments cannot be made against a revoked mandate. You can revoke a mandate when the customer:   - Requests that you revoke the mandate.   - Closes their account with you. Possible revoke mandate status values -   - Revoked—the revoke mandate request was successfully processed.   - Failed—the revoke mandate request was not accepted.  #### Update Mandate: In most cases, the account details of an existing mandate cannot be updated in the Bacs schema, except by creating a new mandate. However, some very limited customer information, like name and address, can be updated to the mandate without needing to revoke it first  #### Mandate Status: After the customer signs the mandate, request that the mandate status service verify the mandate status. Possible mandate status values:   - Active—the mandate is successfully created. A direct debit can be sent for this mandate ID.   - Pending—a pending mandate means the mandate is not yet signed.   - Failed—the customer did not authenticate.   - Expired—the deadline to create the mandate passed.   - Revoked—the mandate is cancelled.  #### Paypal Billing Agreement:  A billing agreement is set up between PayPal and your customer. When you collect the details of a customer&#39;s billing agreement, you are able to bill that customer without requiring an authorization for each payment.  You can bill the customer at the same time you process their PayPal Express checkout order, which simplifies your business processes. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id ID for de-registration or cancellation of Billing Agreement
     * @param modifyBillingAgreement The modifyBillingAgreement parameter
     * @return PtsV2ModifyBillingAgreementPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec billingAgreementsDeRegistrationRequestCreation(String id, BillingAgreementsDeRegistrationRequest modifyBillingAgreement) throws WebClientResponseException {
        Object postBody = modifyBillingAgreement;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling billingAgreementsDeRegistration", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'modifyBillingAgreement' is set
        if (modifyBillingAgreement == null) {
            throw new WebClientResponseException("Missing the required parameter 'modifyBillingAgreement' when calling billingAgreementsDeRegistration", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2ModifyBillingAgreementPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2ModifyBillingAgreementPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/billing-agreements/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Modify a Billing Agreement
     * #### Standing Instruction: Standing Instruction with or without Token.  #### Revoke Mandate: When you revoke a mandate, any pending direct debits linked to that mandate are canceled. No notifications are sent. When you revoke a mandate with no pending direct debits, the Bacs scheme or customer&#39;s bank notify you of any subsequent direct debit events. When you revoke a mandate, you cannot send a direct debit request using the mandate ID. Customer payments cannot be made against a revoked mandate. You can revoke a mandate when the customer:   - Requests that you revoke the mandate.   - Closes their account with you. Possible revoke mandate status values -   - Revoked—the revoke mandate request was successfully processed.   - Failed—the revoke mandate request was not accepted.  #### Update Mandate: In most cases, the account details of an existing mandate cannot be updated in the Bacs schema, except by creating a new mandate. However, some very limited customer information, like name and address, can be updated to the mandate without needing to revoke it first  #### Mandate Status: After the customer signs the mandate, request that the mandate status service verify the mandate status. Possible mandate status values:   - Active—the mandate is successfully created. A direct debit can be sent for this mandate ID.   - Pending—a pending mandate means the mandate is not yet signed.   - Failed—the customer did not authenticate.   - Expired—the deadline to create the mandate passed.   - Revoked—the mandate is cancelled.  #### Paypal Billing Agreement:  A billing agreement is set up between PayPal and your customer. When you collect the details of a customer&#39;s billing agreement, you are able to bill that customer without requiring an authorization for each payment.  You can bill the customer at the same time you process their PayPal Express checkout order, which simplifies your business processes. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id ID for de-registration or cancellation of Billing Agreement
     * @param modifyBillingAgreement The modifyBillingAgreement parameter
     * @return PtsV2ModifyBillingAgreementPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2ModifyBillingAgreementPost201Response> billingAgreementsDeRegistration(String id, BillingAgreementsDeRegistrationRequest modifyBillingAgreement) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2ModifyBillingAgreementPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2ModifyBillingAgreementPost201Response>() {};
        return billingAgreementsDeRegistrationRequestCreation(id, modifyBillingAgreement).bodyToMono(localVarReturnType);
    }

    /**
     * Modify a Billing Agreement
     * #### Standing Instruction: Standing Instruction with or without Token.  #### Revoke Mandate: When you revoke a mandate, any pending direct debits linked to that mandate are canceled. No notifications are sent. When you revoke a mandate with no pending direct debits, the Bacs scheme or customer&#39;s bank notify you of any subsequent direct debit events. When you revoke a mandate, you cannot send a direct debit request using the mandate ID. Customer payments cannot be made against a revoked mandate. You can revoke a mandate when the customer:   - Requests that you revoke the mandate.   - Closes their account with you. Possible revoke mandate status values -   - Revoked—the revoke mandate request was successfully processed.   - Failed—the revoke mandate request was not accepted.  #### Update Mandate: In most cases, the account details of an existing mandate cannot be updated in the Bacs schema, except by creating a new mandate. However, some very limited customer information, like name and address, can be updated to the mandate without needing to revoke it first  #### Mandate Status: After the customer signs the mandate, request that the mandate status service verify the mandate status. Possible mandate status values:   - Active—the mandate is successfully created. A direct debit can be sent for this mandate ID.   - Pending—a pending mandate means the mandate is not yet signed.   - Failed—the customer did not authenticate.   - Expired—the deadline to create the mandate passed.   - Revoked—the mandate is cancelled.  #### Paypal Billing Agreement:  A billing agreement is set up between PayPal and your customer. When you collect the details of a customer&#39;s billing agreement, you are able to bill that customer without requiring an authorization for each payment.  You can bill the customer at the same time you process their PayPal Express checkout order, which simplifies your business processes. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id ID for de-registration or cancellation of Billing Agreement
     * @param modifyBillingAgreement The modifyBillingAgreement parameter
     * @return ResponseEntity&lt;PtsV2ModifyBillingAgreementPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2ModifyBillingAgreementPost201Response>> billingAgreementsDeRegistrationWithHttpInfo(String id, BillingAgreementsDeRegistrationRequest modifyBillingAgreement) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2ModifyBillingAgreementPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2ModifyBillingAgreementPost201Response>() {};
        return billingAgreementsDeRegistrationRequestCreation(id, modifyBillingAgreement).toEntity(localVarReturnType);
    }

    /**
     * Modify a Billing Agreement
     * #### Standing Instruction: Standing Instruction with or without Token.  #### Revoke Mandate: When you revoke a mandate, any pending direct debits linked to that mandate are canceled. No notifications are sent. When you revoke a mandate with no pending direct debits, the Bacs scheme or customer&#39;s bank notify you of any subsequent direct debit events. When you revoke a mandate, you cannot send a direct debit request using the mandate ID. Customer payments cannot be made against a revoked mandate. You can revoke a mandate when the customer:   - Requests that you revoke the mandate.   - Closes their account with you. Possible revoke mandate status values -   - Revoked—the revoke mandate request was successfully processed.   - Failed—the revoke mandate request was not accepted.  #### Update Mandate: In most cases, the account details of an existing mandate cannot be updated in the Bacs schema, except by creating a new mandate. However, some very limited customer information, like name and address, can be updated to the mandate without needing to revoke it first  #### Mandate Status: After the customer signs the mandate, request that the mandate status service verify the mandate status. Possible mandate status values:   - Active—the mandate is successfully created. A direct debit can be sent for this mandate ID.   - Pending—a pending mandate means the mandate is not yet signed.   - Failed—the customer did not authenticate.   - Expired—the deadline to create the mandate passed.   - Revoked—the mandate is cancelled.  #### Paypal Billing Agreement:  A billing agreement is set up between PayPal and your customer. When you collect the details of a customer&#39;s billing agreement, you are able to bill that customer without requiring an authorization for each payment.  You can bill the customer at the same time you process their PayPal Express checkout order, which simplifies your business processes. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id ID for de-registration or cancellation of Billing Agreement
     * @param modifyBillingAgreement The modifyBillingAgreement parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec billingAgreementsDeRegistrationWithResponseSpec(String id, BillingAgreementsDeRegistrationRequest modifyBillingAgreement) throws WebClientResponseException {
        return billingAgreementsDeRegistrationRequestCreation(id, modifyBillingAgreement);
    }
    /**
     * Standing Instruction intimation
     * Standing Instruction with or without Token.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id ID for intimation of Billing Agreement
     * @param intimateBillingAgreement The intimateBillingAgreement parameter
     * @return PtsV2CreditsPost201Response1
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec billingAgreementsIntimationRequestCreation(String id, BillingAgreementsIntimationRequest intimateBillingAgreement) throws WebClientResponseException {
        Object postBody = intimateBillingAgreement;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling billingAgreementsIntimation", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'intimateBillingAgreement' is set
        if (intimateBillingAgreement == null) {
            throw new WebClientResponseException("Missing the required parameter 'intimateBillingAgreement' when calling billingAgreementsIntimation", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2CreditsPost201Response1> localVarReturnType = new ParameterizedTypeReference<PtsV2CreditsPost201Response1>() {};
        return apiClient.invokeAPI("/pts/v2/billing-agreements/{id}/intimations", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Standing Instruction intimation
     * Standing Instruction with or without Token.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id ID for intimation of Billing Agreement
     * @param intimateBillingAgreement The intimateBillingAgreement parameter
     * @return PtsV2CreditsPost201Response1
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2CreditsPost201Response1> billingAgreementsIntimation(String id, BillingAgreementsIntimationRequest intimateBillingAgreement) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CreditsPost201Response1> localVarReturnType = new ParameterizedTypeReference<PtsV2CreditsPost201Response1>() {};
        return billingAgreementsIntimationRequestCreation(id, intimateBillingAgreement).bodyToMono(localVarReturnType);
    }

    /**
     * Standing Instruction intimation
     * Standing Instruction with or without Token.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id ID for intimation of Billing Agreement
     * @param intimateBillingAgreement The intimateBillingAgreement parameter
     * @return ResponseEntity&lt;PtsV2CreditsPost201Response1&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2CreditsPost201Response1>> billingAgreementsIntimationWithHttpInfo(String id, BillingAgreementsIntimationRequest intimateBillingAgreement) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CreditsPost201Response1> localVarReturnType = new ParameterizedTypeReference<PtsV2CreditsPost201Response1>() {};
        return billingAgreementsIntimationRequestCreation(id, intimateBillingAgreement).toEntity(localVarReturnType);
    }

    /**
     * Standing Instruction intimation
     * Standing Instruction with or without Token.
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param id ID for intimation of Billing Agreement
     * @param intimateBillingAgreement The intimateBillingAgreement parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec billingAgreementsIntimationWithResponseSpec(String id, BillingAgreementsIntimationRequest intimateBillingAgreement) throws WebClientResponseException {
        return billingAgreementsIntimationRequestCreation(id, intimateBillingAgreement);
    }
    /**
     * Create a Billing Agreement
     * #### Standing Instruction: Standing Instruction with or without Token. Transaction amount in case First payment is coming along with registration. Only 2 decimal places allowed  #### Create Mandate: You can create a mandate through the direct debit mandate flow. Possible create mandate status values:   - Pending—the create mandate request was successfully processed.   - Failed—the create mandate request was not accepted.  #### Import Mandate: In the Bacs scheme, a mandate is created with a status of active. Direct debit collections can be made against it immediately. You can import a mandate to the CyberSource database when:   - You have existing customers with signed, active mandates   - You manage mandates outside of CyberSource.  When you import an existing mandate to the CyberSource database, provide a unique value for the mandate ID or the request results in an error. If an import mandate request is not accepted, the import mandate status value is failed. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createBillingAgreement The createBillingAgreement parameter
     * @return PtsV2CreateBillingAgreementPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec billingAgreementsRegistrationRequestCreation(BillingAgreementsRegistrationRequest createBillingAgreement) throws WebClientResponseException {
        Object postBody = createBillingAgreement;
        // verify the required parameter 'createBillingAgreement' is set
        if (createBillingAgreement == null) {
            throw new WebClientResponseException("Missing the required parameter 'createBillingAgreement' when calling billingAgreementsRegistration", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<PtsV2CreateBillingAgreementPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CreateBillingAgreementPost201Response>() {};
        return apiClient.invokeAPI("/pts/v2/billing-agreements", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Billing Agreement
     * #### Standing Instruction: Standing Instruction with or without Token. Transaction amount in case First payment is coming along with registration. Only 2 decimal places allowed  #### Create Mandate: You can create a mandate through the direct debit mandate flow. Possible create mandate status values:   - Pending—the create mandate request was successfully processed.   - Failed—the create mandate request was not accepted.  #### Import Mandate: In the Bacs scheme, a mandate is created with a status of active. Direct debit collections can be made against it immediately. You can import a mandate to the CyberSource database when:   - You have existing customers with signed, active mandates   - You manage mandates outside of CyberSource.  When you import an existing mandate to the CyberSource database, provide a unique value for the mandate ID or the request results in an error. If an import mandate request is not accepted, the import mandate status value is failed. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createBillingAgreement The createBillingAgreement parameter
     * @return PtsV2CreateBillingAgreementPost201Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<PtsV2CreateBillingAgreementPost201Response> billingAgreementsRegistration(BillingAgreementsRegistrationRequest createBillingAgreement) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CreateBillingAgreementPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CreateBillingAgreementPost201Response>() {};
        return billingAgreementsRegistrationRequestCreation(createBillingAgreement).bodyToMono(localVarReturnType);
    }

    /**
     * Create a Billing Agreement
     * #### Standing Instruction: Standing Instruction with or without Token. Transaction amount in case First payment is coming along with registration. Only 2 decimal places allowed  #### Create Mandate: You can create a mandate through the direct debit mandate flow. Possible create mandate status values:   - Pending—the create mandate request was successfully processed.   - Failed—the create mandate request was not accepted.  #### Import Mandate: In the Bacs scheme, a mandate is created with a status of active. Direct debit collections can be made against it immediately. You can import a mandate to the CyberSource database when:   - You have existing customers with signed, active mandates   - You manage mandates outside of CyberSource.  When you import an existing mandate to the CyberSource database, provide a unique value for the mandate ID or the request results in an error. If an import mandate request is not accepted, the import mandate status value is failed. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createBillingAgreement The createBillingAgreement parameter
     * @return ResponseEntity&lt;PtsV2CreateBillingAgreementPost201Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<PtsV2CreateBillingAgreementPost201Response>> billingAgreementsRegistrationWithHttpInfo(BillingAgreementsRegistrationRequest createBillingAgreement) throws WebClientResponseException {
        ParameterizedTypeReference<PtsV2CreateBillingAgreementPost201Response> localVarReturnType = new ParameterizedTypeReference<PtsV2CreateBillingAgreementPost201Response>() {};
        return billingAgreementsRegistrationRequestCreation(createBillingAgreement).toEntity(localVarReturnType);
    }

    /**
     * Create a Billing Agreement
     * #### Standing Instruction: Standing Instruction with or without Token. Transaction amount in case First payment is coming along with registration. Only 2 decimal places allowed  #### Create Mandate: You can create a mandate through the direct debit mandate flow. Possible create mandate status values:   - Pending—the create mandate request was successfully processed.   - Failed—the create mandate request was not accepted.  #### Import Mandate: In the Bacs scheme, a mandate is created with a status of active. Direct debit collections can be made against it immediately. You can import a mandate to the CyberSource database when:   - You have existing customers with signed, active mandates   - You manage mandates outside of CyberSource.  When you import an existing mandate to the CyberSource database, provide a unique value for the mandate ID or the request results in an error. If an import mandate request is not accepted, the import mandate status value is failed. 
     * <p><b>201</b> - Successful response.
     * <p><b>400</b> - Invalid request.
     * <p><b>502</b> - Unexpected system error or system timeout.
     * @param createBillingAgreement The createBillingAgreement parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec billingAgreementsRegistrationWithResponseSpec(BillingAgreementsRegistrationRequest createBillingAgreement) throws WebClientResponseException {
        return billingAgreementsRegistrationRequestCreation(createBillingAgreement);
    }
}
