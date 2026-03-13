package com.thiha.ecommerce;
import jakarta.persistence.*;

@Entity
@Table(name = "customer_orders")
public class Order {

    // generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // declare variables
    private Integer id;
    private String customerName;
    private double totalAmount;

    public Order() {

    }
    // Getters and Setters
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }
    public double getTotalAmount()
    {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }
}