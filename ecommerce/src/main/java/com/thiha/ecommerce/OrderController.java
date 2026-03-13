package com.thiha.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/orders")
    public class OrderController {

        // auto connect with payment
        @Autowired
        private PaymentService paymentService;

        @PostMapping("/pay-cash/{cartId}")
        public String pay(@PathVariable Integer cartId) {
            return paymentService.processCashPayment(cartId);
        }
    }