package com.ynov.eatmanager.service.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class LoadInfoDatabase
{
    private static String ipServer;
    private static Properties prop = new Properties();
    private static InputStream input = null;

    protected LoadInfoDatabase(String IpServer)
    {
        ipServer = IpServer;
    }

    //Chargement du fichier contenant les informations de connexion
    private void loadInput()
    {
        try
        {
            input = getClass().getResourceAsStream("/db/login/db.properties");
            prop.load(input);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //Récupération du nom de la base
    private String getDatabaseName()
    {
        loadInput();
        //System.out.println(prop.getProperty("database.name"));
        return prop.getProperty("database.name");
    }

    //Constitution de l'URL du serveur
    public String getUrl()
    {
        //System.out.println("jdbc:mysql://" + ipServer + "/" + getDatabaseName());
        return String.format("jdbc:mysql://%s/%s?useSSL=false", ipServer, getDatabaseName());
    }

    //Récupération du username
    protected String getUser()
    {
        loadInput();
        //System.out.println(prop.getProperty("database.username"));
        return prop.getProperty("database.username");
    }

    //Récupération du password
    protected String getPassword()
    {
        loadInput();
        //System.out.println(prop.getProperty("database.password"));
        return prop.getProperty("database.password");
    }
}

