package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.service.DatabaseConnexion;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductQueriesTest {

    @Test
    public void testAllQueries () {
        DatabaseConnexion.setIP("192.168.6.15");
        ProductQueries productQueries = new ProductQueries();
        productQueries.createProduct("labelProdcut", 1, 1);
        productQueries.selectProduct();
        productQueries.updateProduct(3,1,1);
        productQueries.selectOneProduct(1);
        productQueries.commandProduct(1,1);
    }
}