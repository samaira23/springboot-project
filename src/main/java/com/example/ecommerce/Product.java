package com.example.ecommerce;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, length = 60)
    private String category;

    @Column(length = 20)
    private String emoji;

    // Required by JPA
    public Product() {
    }

    public Product(String name, double price, String description,
                   String category, String emoji) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
