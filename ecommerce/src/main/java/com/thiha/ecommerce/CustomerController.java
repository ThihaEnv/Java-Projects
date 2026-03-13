package com.thiha.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public String registerCustomer(@RequestBody Customer customer) {
        // create new customer with new cart
        customerRepository.save(customer);
        return "Customer " + customer.getName() + " registered successfully with Cart ID: " + customer.getCart().getId();
    }
}
