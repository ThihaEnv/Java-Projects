package com.thiha.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@GetMapping("/")
	public String helloWorld() {
		return "E Commerce Project by Thiha";
	}

	@Bean
	public CommandLineRunner ecommerceApp(ProductService productService,
								   CustomerRepository customerRepository,
								   CartController cartController,
								   OrderController orderController) {
		return args -> {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n--- WELCOME TO SPORT EQUIPMENT SHOP ---");

			while (true) {
				//error catch
				try {
					System.out.println("\n[MENU]");
					System.out.println("1. View Products");
					System.out.println("2. Register Customer");
					System.out.println("3. Add Product to Cart");
					System.out.println("4. Checkout (Cash)");
					System.out.println("5. Exit");
					System.out.print("Choose option: ");

					//input request for menu
					String input = scanner.nextLine();
					int choice = Integer.parseInt(input);

					switch (choice) {
						case 1:
							productService.getAllProducts().forEach(p ->
									System.out.println("ID: " + p.getId() + " | " + p.getName() + " | $" + p.getPrice()));
							break;
							//request input for customer name and email
						case 2:
							System.out.print("Enter Name: ");
							String name = scanner.nextLine();
							System.out.print("Enter Email: ");
							String email = scanner.nextLine();
							Customer customer = new Customer();
							customer.setName(name);
							customer.setEmail(email);
							customerRepository.save(customer);
							System.out.println("Registered! Your Cart ID is: " + customer.getCart().getId());
							break;
							//request input for product and cart id for order
						case 3:
							System.out.print("Enter Product ID: ");
							int pId = Integer.parseInt(scanner.nextLine());
							System.out.print("Enter Your Cart ID: ");
							int cId = Integer.parseInt(scanner.nextLine());
							System.out.println(cartController.addToCart(pId, cId));
							break;
							// input request for checkout cartID
						case 4:
							System.out.print("Enter Cart ID to Checkout: ");
							int checkoutId = Integer.parseInt(scanner.nextLine());
							System.out.println(orderController.pay(checkoutId));
							break;
						case 5:
							System.out.println("Goodbye!");
							System.exit(0);
					}
				}
				//error catching
				catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					System.out.println("Please try again.");
				}
			}
		};
	}
}