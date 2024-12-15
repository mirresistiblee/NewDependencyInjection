package com.example.dependency_injection.payment;

import org.springframework.stereotype.Service;

@Service("creditCardPaymentService")
public class CreditCardPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата в размере " + amount + " выполнена с использованием кредитной карты.");
    }
}