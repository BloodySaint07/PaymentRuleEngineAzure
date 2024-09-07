package com.example.Payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class PaymentResponse {

    @JsonProperty("sender_account")
    private String senderAccountNumber;

    @JsonProperty("receiver_account")
    private String receiverAccountNumber;

    private BigDecimal amount;
    @JsonProperty("payment_type")
    private String paymentType;

    private BigDecimal discount;

    public PaymentResponse(String senderAccountNumber, String receiverAccountNumber, BigDecimal amount, String paymentType, BigDecimal discount) {
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.paymentType = paymentType;
        this.discount = discount;
    }

    public PaymentResponse() {
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "senderAccountNumber='" + senderAccountNumber + '\'' +
                ", receiverAccountNumber='" + receiverAccountNumber + '\'' +
                ", amount=" + amount +
                ", paymentType='" + paymentType + '\'' +
                ", discount=" + discount +
                '}';
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentResponse that)) return false;
        return Objects.equals(senderAccountNumber, that.senderAccountNumber) && Objects.equals(receiverAccountNumber, that.receiverAccountNumber) && Objects.equals(amount, that.amount) && Objects.equals(paymentType, that.paymentType) && Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderAccountNumber, receiverAccountNumber, amount, paymentType, discount);
    }
}
