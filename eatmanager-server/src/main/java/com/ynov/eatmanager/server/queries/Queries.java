package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.server.properties.QueriesProperties;
import com.ynov.eatmanager.service.DatabaseConnexion;
import org.jdbi.v3.core.Handle;

abstract class Queries
{
    protected QueriesProperties queriesProperties;
    protected DatabaseConnexion databaseConnexion;

    protected Queries()
    {
        databaseConnexion = DatabaseConnexion.getInstance();
        this.queriesProperties = new QueriesProperties();
    }

    //Execute la requete passe en parametre
    protected void executeQuery (String querie)
    {
        System.out.println(querie);
        try (Handle h = databaseConnexion.getInstance().getConnexion().open()) {
            h.execute(querie);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
