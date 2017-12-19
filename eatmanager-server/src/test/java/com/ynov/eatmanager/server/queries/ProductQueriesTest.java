package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.service.DatabaseConnexion;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductQueriesTest {

    @Test
    public void testAllQueries () {
        DatabaseConnexion.setIP("10.31.1.248");
        ProductQueries productQueries = new ProductQueries();
        productQueries.createProduct("Tomate", 100, 2);
        productQueries.selectProduct();
        productQueries.updateProduct(3,1,1);
        productQueries.selectOneProduct(1);
        productQueries.commandProduct(1,1);
    }
}