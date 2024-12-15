package com.example.dependency_injection.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PaymentService creditCardPaymentService; // Constructor Injection
    private PaymentService paypalPaymentServiceSetter;     // Setter Injection
    private PaymentService paypalPaymentServiceField;      // Field Injection

    @Autowired
    public OrderService(@Qualifier("creditCardPaymentService") PaymentService creditCardPaymentService) {
        this.creditCardPaymentService = creditCardPaymentService;
    }

    @Autowired
    public void setPaypalPaymentServiceSetter(@Qualifier("paypalPaymentService") PaymentService paypalPaymentServiceSetter) {
        this.paypalPaymentServiceSetter = paypalPaymentServiceSetter;
    }

    @Autowired
    @Qualifier("paypalPaymentService")
    private void setPaypalPaymentServiceField(PaymentService paypalPaymentServiceField) {
        this.paypalPaymentServiceField = paypalPaymentServiceField;
    }

    public void placeOrder(double amount) {
        System.out.println("Processing order...");
        creditCardPaymentService.processPayment(amount);   // Оплата через CreditCard
        paypalPaymentServiceSetter.processPayment(amount); // Оплата через PayPal (Setter)
        paypalPaymentServiceField.processPayment(amount);  // Оплата через PayPal (Field)
    }
}
