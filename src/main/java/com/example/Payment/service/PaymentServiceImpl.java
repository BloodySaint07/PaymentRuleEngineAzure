package com.example.Payment.service;

import com.example.Payment.dao.PaymentDAO;
import com.example.Payment.model.Payment;
import com.example.Payment.model.PaymentResponse;
import com.example.Payment.utils.DiscountRuleEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO paymentDao;

    @Autowired
    DiscountRuleEngine discountRuleEngine;

    @Autowired
    public PaymentServiceImpl(PaymentDAO paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Payment processPayment(Payment payment) {
        // Add any business logic here if needed
        return paymentDao.createPayment(payment);
    }

    @Override
    public List<Payment> listAllPayments() {
        return paymentDao.getAllPayments();
    }

    @Override
    public PaymentResponse getSenderAccountPayment(String senderAccountNumber) {
        Payment correctPayment=paymentDao.getAllPayments().stream().filter(value  -> value.getSenderAccountNumber().equals(senderAccountNumber)).findAny().get();
        PaymentResponse finalPayment=discountRuleEngine.getDiscount(correctPayment);
        return finalPayment;
    }
}