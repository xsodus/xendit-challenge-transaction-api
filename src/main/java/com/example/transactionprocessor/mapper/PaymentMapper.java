package com.example.transactionprocessor.mapper;


import Model.CreatePaymentRequest;
import Model.PtsV2PaymentsPost201Response;
import Model.Ptsv2paymentsClientReferenceInformation;
import Model.Ptsv2paymentsOrderInformation;
import Model.Ptsv2paymentsOrderInformationAmountDetails;
import Model.Ptsv2paymentsOrderInformationBillTo;
import Model.Ptsv2paymentsPaymentInformation;
import Model.Ptsv2paymentsPaymentInformationCard;
import Model.Ptsv2paymentsProcessingInformation;
import com.example.transactionprocessor.dto.request.ProcessPaymentRequestDTO;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    // Implement a function to map CreatePaymentRequest to ProcessPaymentRequestDTO
    public CreatePaymentRequest toCreatePaymentRequestForSimpleAuthorization(
            ProcessPaymentRequestDTO processPaymentRequestDTO) {
        /*Ptsv2paymentsPaymentInformation paymentInformation = new Ptsv2paymentsPaymentInformation();

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

        Ptsv2paymentsClientReferenceInformation createPaymentRequestClientReferenceInformation = new Ptsv2paymentsClientReferenceInformation();
        createPaymentRequestClientReferenceInformation.setCode("TC50171_3");

        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
        createPaymentRequest.setOrderInformation(ptsv2paymentsOrderInformation);
        createPaymentRequest.setPaymentInformation(paymentInformation);
        createPaymentRequest.setClientReferenceInformation(createPaymentRequestClientReferenceInformation);*/

        // Generate a random transactionId with 22 digits based on the current time
        String transactionId = String.valueOf(System.currentTimeMillis()) + ThreadLocalRandom.current().nextInt(100000, 999999);

        CreatePaymentRequest requestObj = new CreatePaymentRequest();

        Ptsv2paymentsClientReferenceInformation clientReferenceInformation = new Ptsv2paymentsClientReferenceInformation();
        clientReferenceInformation.code("TC50171_3");
        clientReferenceInformation.transactionId(transactionId);
        requestObj.clientReferenceInformation(clientReferenceInformation);

        Ptsv2paymentsProcessingInformation processingInformation = new Ptsv2paymentsProcessingInformation();
        processingInformation.capture(true);

        processingInformation.commerceIndicator("internet");
        requestObj.processingInformation(processingInformation);

        Ptsv2paymentsPaymentInformation paymentInformation = new Ptsv2paymentsPaymentInformation();
        Ptsv2paymentsPaymentInformationCard paymentInformationCard = new Ptsv2paymentsPaymentInformationCard();
        paymentInformationCard.number("4111111111111111");
        paymentInformationCard.expirationMonth("12");
        paymentInformationCard.expirationYear("2031");
        paymentInformationCard.securityCode("123");
        paymentInformation.card(paymentInformationCard);

        requestObj.paymentInformation(paymentInformation);

        Ptsv2paymentsOrderInformation orderInformation = new Ptsv2paymentsOrderInformation();
        Ptsv2paymentsOrderInformationAmountDetails orderInformationAmountDetails = new Ptsv2paymentsOrderInformationAmountDetails();
        orderInformationAmountDetails.totalAmount("102.21");
        orderInformationAmountDetails.currency("USD");
        orderInformation.amountDetails(orderInformationAmountDetails);

        Ptsv2paymentsOrderInformationBillTo orderInformationBillTo = new Ptsv2paymentsOrderInformationBillTo();
        orderInformationBillTo.firstName("John");
        orderInformationBillTo.lastName("Doe");
        orderInformationBillTo.address1("1 Market St");
        orderInformationBillTo.address2("Address 2");
        orderInformationBillTo.locality("san francisco");
        orderInformationBillTo.administrativeArea("CA");
        orderInformationBillTo.postalCode("94105");
        orderInformationBillTo.country("US");
        orderInformationBillTo.email("test@cybs.com");
        orderInformationBillTo.phoneNumber("4158880000");
        orderInformation.billTo(orderInformationBillTo);

        requestObj.orderInformation(orderInformation);

        return requestObj;
    }

}
