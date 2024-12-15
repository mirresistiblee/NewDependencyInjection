package com.example.dependency_injection;

import com.example.dependency_injection.payment.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.dependency_injection"); // Укажите ваш пакет

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder(150.0);
    }
}