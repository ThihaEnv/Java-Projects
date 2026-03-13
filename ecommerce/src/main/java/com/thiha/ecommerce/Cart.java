package com.thiha.ecommerce;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    //generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //database relationship and set the fetch type for data
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> items = new ArrayList<>();

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public List<Product> getItems()
    {
        return items;
    }
    public void setItems(List<Product> items)
    {
        this.items = items;
    }

    // total price calculations for cart products
    public double getTotal() {
        double total = 0;

        // total products calculations
        if (this.items != null) {
            for (Product p : items) {
                total += p.getPrice();
            }
        }
        return total;
    }
}
