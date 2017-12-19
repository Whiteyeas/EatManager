package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.server.domain.Restaurant;
import org.jdbi.v3.core.Handle;

import java.util.List;

public class RestaurantQueries extends Queries {

    //Retourne tous les restaurants
    public List<Restaurant> selectRestaurant ()
    {
        try (Handle h = databaseConnexion.getConnexion().open()) {
            return h.createQuery(queriesProperties.getProperty("restaurant.select")).mapToBean(Restaurant.class).list();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Retourne un restaurant choisi
    public Restaurant selectOneRestaurant (int id)
    {
        String query = String.format(queriesProperties.getProperty("restaurant.selectOwn"), id);
        try (Handle h = databaseConnexion.getConnexion().open())
        {
            return h.createQuery(query).mapToBean(Restaurant.class).findOnly();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Cre un restaurant
    public void createRestaurant (String labelRestaurant, String address, String phoneNumber, int idManager)
    {
        String query = String.format(queriesProperties.getProperty("restaurant.create"), labelRestaurant, address, phoneNumber, idManager);
        executeQuery(query);
    }

    //Modifie un restaurant
    public void updateRestaurant (String labelRestaurant, String address, String phoneNumber, int idManager, int idRestaurant) {
        String query = String.format(queriesProperties.getProperty("restaurant.update"), labelRestaurant, address, phoneNumber, idManager, idRestaurant);
        executeQuery(query);
    }

    //Supprimer un restaurant
    public void deleteRestaurant (int idRestaurant) {
        String query = String.format(queriesProperties.getProperty("restaurant.delete"), idRestaurant);
        executeQuery(query);
    }

    public RestaurantQueries () {
        super();
    }
}
