package com.example.Payment.controller;


import com.example.Payment.model.Payment;
import com.example.Payment.model.PaymentResponse;
import com.example.Payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api_v01/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.processPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @GetMapping("/get_allpayments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.listAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/get_payment_for_account")
    public ResponseEntity<PaymentResponse> getPaymentDetailsForAccount(@RequestParam("accountNumber") String accountNumber) {
        PaymentResponse payments = paymentService.getSenderAccountPayment(accountNumber);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    // For simplicity, the update and delete operations are not fully implemented
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        // Update logic here
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        // Delete logic here
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}