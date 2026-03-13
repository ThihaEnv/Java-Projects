package com.thiha.ecommerce;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    // processing for payment
    @Transactional
    public String processCashPayment(Integer cartId) {
        //find the cart from database
        Cart cart = cartRepository.findById(cartId).orElse(null);

        if (cart == null || cart.getItems().isEmpty()) {
            return "Error: No Product found.";
        }


        //total products price calculation
        double totalAmount = cart.getTotal();

        //insert data to order
        Order order = new Order();
        order.setTotalAmount(totalAmount);

        String itemNames = cart.getItems().stream()
                .map(Product::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("No items");

        order.setCustomerName("Customer for Cart #" + cartId + " (Items: " + itemNames + ")");

        //save the order
        orderRepository.save(order);

        return "Order is Successful. $" + totalAmount + " (Numbers of Items " + cart.getItems().size()+")";
    }
}
