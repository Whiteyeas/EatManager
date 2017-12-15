import org.jdbi.v3.core.Jdbi;
import org.junit.Test;

public class TestServicesDatabase
{
    private static String IPServer = "192.168.1.50";

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

}