package com.ynov.eatmanager.server.domain;

import java.beans.ConstructorProperties;



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

    @ConstructorProperties({
            "id_user",
            "last_name",
            "first_name",
            "email",
            "password",
            "id_rank"})

    public User() {

    }

    public User (int id, String lastName, String firstName, String email, String password, int idRank) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.idRank = idRank;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdRank(int idRank) {
        this.idRank = idRank;
    }
}
