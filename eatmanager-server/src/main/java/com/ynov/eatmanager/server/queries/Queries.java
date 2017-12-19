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
        this.queriesProperties = new QueriesProperties();
    }

    //Execute la requete passe en parametre
    protected void executeQuery (String query)
    {
        System.out.println(query);
        try (Handle h = databaseConnexion.get().open())
        {
            System.out.println("Execution de la requete");
            h.execute(query);
            System.out.println("Fin de l'execution de la requete");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
