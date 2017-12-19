package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.service.DatabaseConnexion;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantQueriesTest {

    @Test
    public void testAllQueries () {
        //DatabaseConnexion.setIP("192.168.6.15");
        RestaurantQueries restaurantQueries = new RestaurantQueries();
        restaurantQueries.createRestaurant("RestaurantTest", "address", "0612345678", 1);
        //restaurantQueries.selectOneRestaurant(1);
        //restaurantQueries.updateRestaurant("RestaurantTest2", "address2", "658965", 2, 1);
        //restaurantQueries.selectRestaurant();
        //restaurantQueries.deleteRestaurant(1);
    }
}