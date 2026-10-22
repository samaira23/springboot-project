package com.example.ecommerce;

public class Product {

    private Long id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String emoji;

    public Product(Long id, String name, double price,
                   String description, String category,
                   String emoji) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.emoji = emoji;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getEmoji() {
        return emoji;
    }
}