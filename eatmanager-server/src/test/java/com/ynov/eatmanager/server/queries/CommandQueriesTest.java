package com.ynov.eatmanager.server.queries;

import com.ynov.eatmanager.service.DatabaseConnexion;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandQueriesTest
{
    @Test
    public void testAllQueries () {
        //DatabaseConnexion.setIP("10.31.1.248");
        CommandQueries commandQueries = new CommandQueries();
        commandQueries.createCommand(1,1,1);
        commandQueries.selectCommand();
        commandQueries.selectOwnCommand(1);
        commandQueries.cancelCommand(1);
    }
}