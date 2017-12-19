package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.service.DatabaseConnexion;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserQueriesTest {

    private final String IPServer = "192.168.6.15";

    @Test
    public void connexion() throws Exception {
        DatabaseConnexion.setIP(IPServer);
        UserQueries userQueries = new UserQueries();
        userQueries.connexion("email", "password");
    }

    @Test
    public void createUser() throws Exception {
        DatabaseConnexion.setIP(IPServer);
        UserQueries userQueries = new UserQueries();
        userQueries.createUser("lastname", "firstname", "email", "password", 1);
    }

    @Test
    public void updateUser() throws Exception {
        DatabaseConnexion.setIP(IPServer);
        UserQueries userQueries = new UserQueries();
        userQueries.updateUser("lastname", "firstname", "email", "password", 1, 1);
    }

    @Test
    public void selectUser() throws Exception {
        DatabaseConnexion.setIP(IPServer);
        UserQueries userQueries = new UserQueries();
        userQueries.selectUser();
        userQueries.selectOneUser(1);
    }

    @Test
    public void updateOwnProfile() throws Exception {
        DatabaseConnexion.setIP(IPServer);
        UserQueries userQueries = new UserQueries();
        userQueries.updateOwnProfile("lastname", "firstname", "email", "password", 1);
    }

    @Test
    public void deleteUser() throws Exception {
        DatabaseConnexion.setIP(IPServer);
        UserQueries userQueries = new UserQueries();
        userQueries.deleteUser(1);
    }

}