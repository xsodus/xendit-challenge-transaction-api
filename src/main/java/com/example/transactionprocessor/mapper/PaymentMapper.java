package com.example.transactionprocessor.mapper;


import Model.CapturePaymentRequest;
import Model.CreatePaymentRequest;
import Model.PtsV2PaymentsPost201Response;
import Model.Ptsv2paymentsClientReferenceInformation;
import Model.Ptsv2paymentsOrderInformation;
import Model.Ptsv2paymentsOrderInformationAmountDetails;
import Model.Ptsv2paymentsOrderInformationBillTo;
import Model.Ptsv2paymentsPaymentInformation;
import Model.Ptsv2paymentsPaymentInformationCard;
import Model.Ptsv2paymentsProcessingInformation;
import Model.Ptsv2paymentsidcapturesOrderInformation;
import Model.Ptsv2paymentsidcapturesOrderInformationAmountDetails;
import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import com.example.transactionprocessor.model.Transaction;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    private final String SUPPORTED_CLIENT_REFERENCE_INFORMATION = "TC50171_3";

    private final String COMMERCE_INDICATOR = "internet";

    // Implement a function to map CreatePaymentRequest to ProcessPaymentRequestDTO
    public CreatePaymentRequest toCreatePaymentRequestForSimpleAuthorization(
            ProcessPaymentRequestDTO processPaymentRequestDTO) {
        Ptsv2paymentsPaymentInformation paymentInformation = new Ptsv2paymentsPaymentInformation();

        Ptsv2paymentsPaymentInformationCard card = new Ptsv2paymentsPaymentInformationCard();
        card.setNumber(processPaymentRequestDTO.getCreditCardDetail().getNumber());
        card.setExpirationMonth(processPaymentRequestDTO.getCreditCardDetail().getExpirationMonth());
        card.setExpirationYear(processPaymentRequestDTO.getCreditCardDetail().getExpirationYear());
        paymentInformation.setCard(card);

        Ptsv2paymentsOrderInformation ptsv2paymentsOrderInformation = new Ptsv2paymentsOrderInformation();
        Model.Ptsv2paymentsOrderInformationAmountDetails amountDetails = new Model.Ptsv2paymentsOrderInformationAmountDetails();
        amountDetails.setCurrency(processPaymentRequestDTO.getCurrency());
        amountDetails.setTotalAmount(processPaymentRequestDTO.getAmount().toPlainString());
        ptsv2paymentsOrderInformation.setAmountDetails(amountDetails);

        Ptsv2paymentsOrderInformationBillTo billTo = new Ptsv2paymentsOrderInformationBillTo();
        billTo.setFirstName(processPaymentRequestDTO.getBillingDetail().getFirstName());
        billTo.setLastName(processPaymentRequestDTO.getBillingDetail().getLastName());
        billTo.setAddress1(processPaymentRequestDTO.getBillingDetail().getAddress1());
        billTo.setLocality(processPaymentRequestDTO.getBillingDetail().getLocality());
        billTo.setAdministrativeArea(processPaymentRequestDTO.getBillingDetail().getAdministrativeArea());
        billTo.setPostalCode(processPaymentRequestDTO.getBillingDetail().getPostalCode());
        billTo.setCountry(processPaymentRequestDTO.getBillingDetail().getCountry());
        billTo.setEmail(processPaymentRequestDTO.getBillingDetail().getEmail());
        billTo.setPhoneNumber(processPaymentRequestDTO.getBillingDetail().getPhoneNumber());
        ptsv2paymentsOrderInformation.setBillTo(billTo);

        // Set the client reference information
        Ptsv2paymentsClientReferenceInformation clientReferenceInformation = new Ptsv2paymentsClientReferenceInformation();
        clientReferenceInformation.code(SUPPORTED_CLIENT_REFERENCE_INFORMATION);


        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
        createPaymentRequest.setOrderInformation(ptsv2paymentsOrderInformation);
        createPaymentRequest.setPaymentInformation(paymentInformation);
        createPaymentRequest.setClientReferenceInformation(clientReferenceInformation);


        return createPaymentRequest;
    }

    public CapturePaymentRequest toCapturePaymentRequest(Transaction transaction) {
        CapturePaymentRequest requestObj = new CapturePaymentRequest();

        Ptsv2paymentsClientReferenceInformation clientReferenceInformation = new Ptsv2paymentsClientReferenceInformation();
        clientReferenceInformation.code(SUPPORTED_CLIENT_REFERENCE_INFORMATION);
        requestObj.clientReferenceInformation(clientReferenceInformation);

        Ptsv2paymentsidcapturesOrderInformation orderInformation = new Ptsv2paymentsidcapturesOrderInformation();
        Ptsv2paymentsidcapturesOrderInformationAmountDetails orderInformationAmountDetails = new Ptsv2paymentsidcapturesOrderInformationAmountDetails();
        orderInformationAmountDetails.totalAmount(transaction.getAmount().toPlainString());
        orderInformationAmountDetails.currency(transaction.getCurrency());
        orderInformation.amountDetails(orderInformationAmountDetails);

        requestObj.orderInformation(orderInformation);

        return requestObj;
    }
}
