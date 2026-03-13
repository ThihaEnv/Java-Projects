package com.thiha.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(String customerName, double total) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setTotalAmount(total);

        // save the order
        return orderRepository.save(order);
    }
}
