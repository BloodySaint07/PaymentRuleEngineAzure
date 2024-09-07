package com.example.Payment.dao;

import com.example.Payment.model.Payment;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
    private final List<Payment> payments = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public PaymentDAOImpl() {
        // Pre-populate the list with some dummy data
        payments.add(new Payment(counter.incrementAndGet(), "123456789", "987654321", new BigDecimal("100.00"), LocalDateTime.now(), "TRANSFER", new BigDecimal("2.00")));
        payments.add(new Payment(counter.incrementAndGet(), "111111111", "222222222", new BigDecimal("250.00"), LocalDateTime.now().minusDays(1), "DEPOSIT", new BigDecimal("10.00")));
        payments.add(new Payment(counter.incrementAndGet(), "333333333", "444444444", new BigDecimal("500.00"), LocalDateTime.now().minusDays(2), "WITHDRAWAL", new BigDecimal("0.00")));
    }

    @Override
    public Payment createPayment(Payment payment) {
        payment.setId(counter.incrementAndGet());
        payments.add(payment);
        return payment;
    }

    @Override
    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments);
    }
}