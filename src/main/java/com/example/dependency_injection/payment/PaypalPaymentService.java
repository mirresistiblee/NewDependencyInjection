package com.example.dependency_injection.payment;

import org.springframework.stereotype.Service;

@Service("paypalPaymentService")
public class PaypalPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата в размере " + amount + " выполнена через PayPal.");
    }
}