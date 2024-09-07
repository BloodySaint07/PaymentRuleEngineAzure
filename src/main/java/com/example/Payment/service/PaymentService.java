package com.example.Payment.service;

import com.example.Payment.model.Payment;
import com.example.Payment.model.PaymentResponse;

import java.util.List;

public interface PaymentService {
    Payment processPayment(Payment payment);
    List<Payment> listAllPayments();
    PaymentResponse getSenderAccountPayment(String senderAccountNumber);
}