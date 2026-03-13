package com.thiha.ecommerce;

import jakarta.persistence.*;

@Entity
public class Customer {

    //generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //declare variables
    private Integer id;

    private String name;
    private String email;

    //state cart for each customer
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    //create new cart for new customer
    public Customer() {
        this.cart = new Cart();
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Cart getCart()
    {
        return cart;
    }
    public void setCart(Cart cart)
    {
        this.cart = cart;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
    }
}
