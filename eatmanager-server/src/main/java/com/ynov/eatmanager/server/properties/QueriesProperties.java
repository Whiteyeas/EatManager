package com.ynov.eatmanager.server.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class QueriesProperties extends Properties {
    //contient toutes les requêtes sql
    public QueriesProperties () {
        try
        {
            InputStream input = getClass().getResourceAsStream("/queries/queries.properties");
            this.load(input);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
