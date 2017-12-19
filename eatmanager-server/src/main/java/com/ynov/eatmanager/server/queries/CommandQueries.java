package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.server.domain.Command;
import org.jdbi.v3.core.Handle;

import java.util.List;

public class CommandQueries extends Queries{

    //Retourne les commandes
    public List<Command> selectCommand() {
        try (Handle h = databaseConnexion.getConnexion().open()) {
            return h.createQuery(queriesProperties.getProperty("command.select")).mapToBean(Command.class).list();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Retourne une commande choisi
    public Command selectOwnCommand (int id) {
        String querie = String.format(queriesProperties.getProperty("command.ownSelect"), id);
        try (Handle h = databaseConnexion.getConnexion().open()) {
            return h.createQuery(querie).mapToBean(Command.class).findOnly();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Cre une commande
    public void createCommand (int idRestaurant, int idProduct, int quantity) {
        String querie = String.format(queriesProperties.getProperty("command.create"), idRestaurant, idProduct, quantity);
        executeQuerie(querie);
    }

    //Annule une commande
    public void cancelCommand (int idCommand) {
        String querie = String.format(queriesProperties.getProperty("command.cancelCommand"), idCommand);
        executeQuerie(querie);
    }

    public CommandQueries() {
        super();
    }
}
