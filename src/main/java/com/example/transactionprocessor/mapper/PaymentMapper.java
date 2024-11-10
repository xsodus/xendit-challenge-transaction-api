package com.example.transactionprocessor.mapper;


import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import org.openapitools.client.model.CreatePaymentRequest;
import org.openapitools.client.model.CreatePaymentRequestClientReferenceInformation;
import org.openapitools.client.model.CreatePaymentRequestOrderInformation;
import org.openapitools.client.model.CreatePaymentRequestOrderInformationAmountDetails;
import org.openapitools.client.model.CreatePaymentRequestOrderInformationBillTo;
import org.openapitools.client.model.CreatePaymentRequestPaymentInformation;
import org.openapitools.client.model.CreatePaymentRequestPaymentInformationCard;
import org.openapitools.client.model.CreatePaymentRequestProcessingInformation;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    // Implement a function to map CreatePaymentRequest to ProcessPaymentRequestDTO
    public CreatePaymentRequest toCreatePaymentRequestForSimpleAuthorization(
            ProcessPaymentRequestDTO processPaymentRequestDTO) {
        CreatePaymentRequestPaymentInformation paymentInformation = new CreatePaymentRequestPaymentInformation();

        CreatePaymentRequestPaymentInformationCard card = new CreatePaymentRequestPaymentInformationCard();
        card.setNumber(processPaymentRequestDTO.getCreditCardDetail().getNumber());
        card.setExpirationMonth(processPaymentRequestDTO.getCreditCardDetail().getExpirationMonth());
        card.setExpirationYear(processPaymentRequestDTO.getCreditCardDetail().getExpirationYear());
        paymentInformation.setCard(card);

        CreatePaymentRequestOrderInformation createPaymentRequestOrderInformation = new CreatePaymentRequestOrderInformation();
        CreatePaymentRequestOrderInformationAmountDetails amountDetails = new CreatePaymentRequestOrderInformationAmountDetails();
        amountDetails.setCurrency(processPaymentRequestDTO.getCurrency());
        amountDetails.setTotalAmount(processPaymentRequestDTO.getAmount().toPlainString());
        createPaymentRequestOrderInformation.setAmountDetails(amountDetails);

        CreatePaymentRequestOrderInformationBillTo billTo = new CreatePaymentRequestOrderInformationBillTo();
        billTo.setFirstName(processPaymentRequestDTO.getBillingDetail().getFirstName());
        billTo.setLastName(processPaymentRequestDTO.getBillingDetail().getLastName());
        billTo.setAddress1(processPaymentRequestDTO.getBillingDetail().getAddress1());
        billTo.setLocality(processPaymentRequestDTO.getBillingDetail().getLocality());
        billTo.setAdministrativeArea(processPaymentRequestDTO.getBillingDetail().getAdministrativeArea());
        billTo.setPostalCode(processPaymentRequestDTO.getBillingDetail().getPostalCode());
        billTo.setCountry(processPaymentRequestDTO.getBillingDetail().getCountry());
        billTo.setEmail(processPaymentRequestDTO.getBillingDetail().getEmail());
        billTo.setPhoneNumber(processPaymentRequestDTO.getBillingDetail().getPhoneNumber());
        createPaymentRequestOrderInformation.setBillTo(billTo);

        CreatePaymentRequestClientReferenceInformation createPaymentRequestClientReferenceInformation = new CreatePaymentRequestClientReferenceInformation();
        createPaymentRequestClientReferenceInformation.setCode("TC50171_3");

        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
        createPaymentRequest.setOrderInformation(createPaymentRequestOrderInformation);
        createPaymentRequest.setPaymentInformation(paymentInformation);
        createPaymentRequest.setClientReferenceInformation(createPaymentRequestClientReferenceInformation);

        return createPaymentRequest;
    }

}
