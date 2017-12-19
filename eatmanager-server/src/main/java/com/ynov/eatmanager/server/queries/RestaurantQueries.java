package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.server.domain.Restaurant;
import org.jdbi.v3.core.Handle;

import java.util.List;

public class RestaurantQueries extends Queries {

    //Retourne tous les restaurants
    public List<Restaurant> selectRestaurant () {
        try (Handle h = databaseConnexion.getConnexion().open()) {
            return h.createQuery(queriesProperties.getProperty("restaurant.select")).mapToBean(Restaurant.class).list();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Retourne un restaurant choisi
    public Restaurant seletOneRestaurant (int id) {
        String querie = String.format(queriesProperties.getProperty("restaurant.selectOwn"), id);
        try (Handle h = databaseConnexion.getConnexion().open()) {
            return h.createQuery(querie).mapToBean(Restaurant.class).findOnly();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Cre un restaurant
    public void createRestaurant (String labelRestaurant, String address, String phoneNumber, int idManager) {
        String querie = String.format(queriesProperties.getProperty("restaurant.create"), labelRestaurant, address, phoneNumber, idManager);
        executeQuerie(querie);
    }

    //Modifie un restraurant
    public void updateRestaurant (String labelRestaurant, String address, String phoneNumber, int idManager, int idRestaurant) {
        String querie = String.format(queriesProperties.getProperty("restaurant.update"), labelRestaurant, address, phoneNumber, idManager, idRestaurant);
        executeQuerie(querie);
    }

    //Supprimer un restaurant
    public void deleteRestaurant (int idRestaurant) {
        String querie = String.format(queriesProperties.getProperty("restaurant.delete"), idRestaurant);
        executeQuerie(querie);
    }

    public RestaurantQueries () {
        super();
    }
}
