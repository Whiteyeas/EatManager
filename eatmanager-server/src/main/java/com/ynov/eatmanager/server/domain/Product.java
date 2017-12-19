package com.ynov.eatmanager.server.domain;

public class Product {

    private int id;
    private String label;
    private int quantity;
    private int price;

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public Product (int id, String label, int quantity, int price) {
        this.id = id;
        this.label = label;
        this.quantity = quantity;
        this.price = price;
    }
}
