import com.ynov.eatmanager.service.DatabaseConception;
import com.ynov.eatmanager.service.DatabaseConnexion;
import org.jdbi.v3.core.Jdbi;
import org.junit.Test;

public class TestServicesDatabase
{
    private static String IPServer = "10.31.1.248";

    @Test
    //Test de la migration avec Flyway
    public void testMigration()
    {
        try {
            DatabaseConception properties = new DatabaseConception(IPServer);
            properties.executeMigration();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    //Test de la connexion via le singleton
    public void testSingleton()
    {
        //Boucle pour Test de conservation de l'instance
        for (int cpt=0; cpt<10; cpt++) {
            try {
                DatabaseConnexion.setIP(IPServer);
                Jdbi connexion = DatabaseConnexion.getInstance().getConnexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(DatabaseConnexion.getInstance().getUrl());
            System.out.println("Compteur : " + cpt);
        }
    }

    @Test
    //Test de la connexion avec jdbi
    public void testConnection () {
        DatabaseConnexion.setIP(IPServer);
        try {
            DatabaseConnexion.getInstance().getConnexion().open();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}