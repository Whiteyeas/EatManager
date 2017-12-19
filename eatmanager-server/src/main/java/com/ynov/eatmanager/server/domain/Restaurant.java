package com.ynov.eatmanager.server.domain;

public class Restaurant {

    private int id;
    private String labelRestaurant;
    private String address;
    private String phoneNumber;
    private int idManager;

    public int getId() {
        return id;
    }

    public String getLabelRestaurant() {
        return labelRestaurant;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getIdManager() {
        return idManager;
    }

    public Restaurant (int id, String labelRestaurant, String address, String phoneNumber, int idManager) {
        this.id = id;
        this.labelRestaurant = labelRestaurant;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idManager = idManager;
    }
}
