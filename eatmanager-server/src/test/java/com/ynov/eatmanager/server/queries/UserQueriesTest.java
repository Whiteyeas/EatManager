package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.server.domain.User;
import com.ynov.eatmanager.service.DatabaseConnexion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserQueriesTest {

    //IP a modifier pour les tests unitaires
    private final String IPServer = "10.31.1.248";

    @Test
    //Test de la requête pour se connecter
    public void connexion() throws Exception
    {
        //Paramètres de test
        String email = "root@root.com";
        String password= "Passw0rd";
        DatabaseConnexion.setIP(IPServer);

        //Execute des fonctions que l'on veut tester
        UserQueries userQueries = new UserQueries();
        int resultTest = userQueries.connexion(email, password);

        //Affichage du résultat
        System.out.println("Rank de l'utilisateur sélectionné : " + resultTest);
    }

    @Test
    public void createUser() throws Exception {

        //Paramètres de test
        String lastname = "lastnameTest";
        String firstname= "firstnameTest";
        String email = "email@testc.com";
        String password = "passwordTest";
        int idRank = 1;
        DatabaseConnexion.setIP(IPServer);

        //Execution des fonctions que l'on veut tester
        UserQueries userQueries = new UserQueries();
        userQueries.createUser(lastname, firstname, email, password, idRank);

        //Affichage du résultat
        System.out.printf("L'utilisateur " + lastname + "." + firstname + " a été créé.");
    }

    @Test
    public void updateUser() throws Exception
    {
        //Paramètres de test
        String lastname = "lastnameTestModif";
        String firstname= "firstnameTestModif";
        String email = "email@Modif.com";
        String password = "passwordTestModif";
        int idRank = 1;
        int idUser = 7;
        DatabaseConnexion.setIP(IPServer);

        //Exécution des fonctions que l'on veut tester
        UserQueries userQueries = new UserQueries();
        userQueries.updateUser(lastname, firstname, email, password, idRank, idUser);

        //Affichage du résultat
        System.out.printf("L'utilisateur " + lastname + "." + firstname + " a été modifié.");
    }

    @Test
    public void selectUser() throws Exception
    {
        //Paramètres de test
        int idUserForSelect = 1;
        DatabaseConnexion.setIP(IPServer);

        //Exécution des fonctions que l'on veut tester
        UserQueries userQueries = new UserQueries();
        List<User> listResult= userQueries.selectUser();
        User oneUser = userQueries.selectOneUser(idUserForSelect);

        //Affichage du résultat
        for (User user : listResult)
        {
            System.out.println(user);
        }
        System.out.println(oneUser);
    }

    @Test
    public void updateOwnProfile() throws Exception
    {
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