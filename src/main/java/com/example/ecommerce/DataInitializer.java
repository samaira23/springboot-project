package com.example.ecommerce;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        if (productRepository.count() > 0) {
            return;
        }

        List<Product> products = List.of(
            new Product("Wireless Headphones", 1999,
                "Immersive sound and all-day comfort.", "Electronics", "🎧"),
            new Product("Smart Watch", 2499,
                "Track your activity and stay connected.", "Electronics", "⌚"),
            new Product("Bluetooth Speaker", 1799,
                "Portable sound for your favorite music.", "Electronics", "🔊"),
            new Product("Mechanical Keyboard", 3299,
                "A satisfying typing experience.", "Electronics", "⌨️"),
            new Product("Wireless Mouse", 799,
                "Comfortable and precise everyday control.", "Electronics", "🖱️"),
            new Product("Digital Camera", 12999,
                "Capture your favorite moments.", "Electronics", "📷"),
            new Product("Running Shoes", 2999,
                "Lightweight shoes for everyday adventures.", "Fashion", "👟"),
            new Product("Classic T-Shirt", 599,
                "A soft, versatile wardrobe essential.", "Fashion", "👕"),
            new Product("Denim Jacket", 2199,
                "A timeless layer for casual outfits.", "Fashion", "🧥"),
            new Product("Everyday Sneakers", 1899,
                "Simple style with a comfortable fit.", "Fashion", "👞"),
            new Product("Travel Backpack", 1499,
                "A practical companion for daily travel.", "Accessories", "🎒"),
            new Product("Classic Sunglasses", 999,
                "An effortless finishing touch.", "Accessories", "🕶️"),
            new Product("Wrist Watch", 1799,
                "A clean design for every occasion.", "Accessories", "⌚"),
            new Product("Leather Wallet", 699,
                "Keep your essentials neatly organized.", "Accessories", "👛"),
            new Product("Coffee Mug", 399,
                "Make your morning coffee special.", "Home", "☕"),
            new Product("Desk Lamp", 1299,
                "Warm lighting for focused work.", "Home", "💡")
        );

        productRepository.saveAll(products);
    }
}
