package com.ynov.eatmanager.server.domain;

public class Command {

    private int id;
    private String restaurant;
    private String product;
    private int quantity;
    private int unityPrice;

    public int getId() {
        return id;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnityPrice() {
        return unityPrice;
    }

    public Command(int id, String restaurant, String product, int quantity, int unityPrice){
        this.id = id;
        this.restaurant = restaurant;
        this.product = product;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
    }
}
