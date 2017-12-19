package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.server.domain.User;
import com.ynov.eatmanager.server.properties.QueriesProperties;
import com.ynov.eatmanager.service.DatabaseConnexion;
import org.jdbi.v3.core.Handle;

import java.util.List;

public class UserQueries extends Queries
{
    //verifie que l'utilisateur existe et retourne son rang d'utilisateur
    public int connexion (String email, String password)
    {
        String query = String.format(queriesProperties.getProperty("user.connexion"), email, password);
        System.out.println(query);

        try (Handle h = databaseConnexion.getConnexion().open())
        {
            return h.createQuery(query).mapTo(int.class).findOnly();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Retourne les users présents dans la table t_users
    public List<User> selectUser ()
    {
        try (Handle h = databaseConnexion.getConnexion().open())
        {
           return h.createQuery(queriesProperties.getProperty("user.select")).mapToBean(User.class).list();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Retourne un user choisi
    public User selectOneUser (int id)
    {
        String query = String.format(queriesProperties.getProperty("user.selectOne"), id);
        System.out.println(query);
        try (Handle h = databaseConnexion.getConnexion().open()) {
            return h.createQuery(query).mapToBean(User.class).findOnly();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Cre un nouveau user
    public void createUser(String lastName, String firstName, String email, String password, int idRank)
    {
        String query = String.format(queriesProperties.getProperty("user.create"), lastName, firstName, email, password, idRank);
        executeQuery(query);
    }

    //Modifie un user
    public void updateUser(String lastName, String firstName, String email, String password, int idRank, int id)
    {
        String query = String.format(queriesProperties.getProperty("user.update"), lastName, firstName, email, password, idRank, id);
        executeQuery(query);
    }

    //Modifie son propre profil user
    public void updateOwnProfile(String lastName, String firstName, String email, String password, int id)
    {
        String query = String.format(queriesProperties.getProperty("user.updateOwnProfile"), lastName, firstName, email, password, id);
        executeQuery(query);
    }

    //Supprime un user
    public void deleteUser(int id)
    {
        String query = String.format(queriesProperties.getProperty("user.delete"),id);
        executeQuery(query);
    }

    public UserQueries () {
        super();
    }
}
