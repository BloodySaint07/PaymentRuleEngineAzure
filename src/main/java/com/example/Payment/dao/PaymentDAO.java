package com.example.Payment.dao;

import com.example.Payment.model.Payment;

import java.util.List;



public interface PaymentDAO {
    Payment createPayment(Payment payment);
    List<Payment> getAllPayments();
}