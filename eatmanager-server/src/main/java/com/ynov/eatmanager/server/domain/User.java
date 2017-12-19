package com.ynov.eatmanager.server.domain;

public class User {

    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private int idRank;

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getIdRank() {
        return idRank;
    }

    public User (int id,String lastName, String firstName, String email, String password, int idRank) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.idRank = idRank;
    }
}
