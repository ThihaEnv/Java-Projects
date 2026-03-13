package com.thiha.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/carts")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    // add new products to cart
    @PostMapping("/add/{productId}/{cartId}")
    public String addToCart(@PathVariable Integer productId, @PathVariable Integer cartId) {

        //find products from database
        Product product = productRepository.findById(productId).orElse(null);

        //find existed cart
        Cart cart = cartRepository.findById(cartId).orElse(null);

        if (product == null) {
            return "Product not found!";
        }
        if (cart == null) {
            return "Cart not found!";
        }

        //save the products to cart
        cart.getItems().add(product);
        cartRepository.save(cart);

        return "Product [" + product.getName() + "] added to Cart ID: " + cart.getId();
    }
}