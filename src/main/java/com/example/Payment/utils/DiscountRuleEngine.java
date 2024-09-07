package com.example.Payment.utils;


import com.example.Payment.model.Payment;
import com.example.Payment.model.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DiscountRuleEngine {

    private static final Logger log = LoggerFactory.getLogger(DiscountRuleEngine.class);
    @Autowired
    KieContainer kieContainer;

    public PaymentResponse getDiscount(Payment formedPayment) {
        PaymentResponse finalPayment = new PaymentResponse();
        /** Setting Values **/
        finalPayment.setReceiverAccountNumber(formedPayment.getReceiverAccountNumber());
        finalPayment.setSenderAccountNumber(formedPayment.getSenderAccountNumber());
        finalPayment.setAmount(formedPayment.getAmount());
        finalPayment.setPaymentType(formedPayment.getPaymentType());
        finalPayment.setDiscount(formedPayment.getDiscount());
        log.info("Payment Details before Rule Execution :{}",finalPayment);

        KieSession kieSession = kieContainer.newKieSession();
        log.info("KieSession before Rule Execution :{}",kieSession);
        kieSession.setGlobal("finalPayment", finalPayment);
        kieSession.insert(formedPayment);
        kieSession.fireAllRules();
        kieSession.dispose();

        return finalPayment;
    }


}
