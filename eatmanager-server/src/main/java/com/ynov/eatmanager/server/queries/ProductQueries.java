package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.server.domain.Product;
import org.jdbi.v3.core.Handle;

import java.util.List;

public class ProductQueries extends Queries {

    //Retourne tous les produits
    public List<Product> selectProduct () {
        try (Handle h = databaseConnexion.getConnexion().open()) {
            return h.createQuery(queriesProperties.getProperty("product.select")).mapToBean(Product.class).list();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Retourne un produit choisi
    public Product selectOneProduct (int id) {
        String querie = String.format(queriesProperties.getProperty("Product.ownSelect"), id);
        try (Handle h = databaseConnexion.getConnexion().open()) {
            return h.createQuery(querie).mapToBean(Product.class).findOnly();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Cre un produit
    public void createProduct (String labelProduct, int quantity, int unityPrice) {
        String querie = String.format(queriesProperties.getProperty("product.create"), labelProduct, quantity, unityPrice);
        executeQuerie(querie);
    }

    //Modifie un produit
    public void updateProduct (int quantity, int unityPrice, int idProduct) {
        String querie = String.format(queriesProperties.getProperty("product.update"), quantity, unityPrice, idProduct);
        executeQuerie(querie);
    }

    //Retire du stock les produits commandes
    public void commandProduct (int quantity, int idProduct) {
        String querie = String.format(queriesProperties.getProperty("product.command"), quantity, idProduct);
        executeQuerie(querie);
    }

    public ProductQueries() {
        super();
    }
}
