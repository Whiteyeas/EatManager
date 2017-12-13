import org.jdbi.v3.core.Jdbi;
import org.junit.Test;

public class TestServicesDatabase
{
    private static String IPServer = "172.20.10.9";

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
                Jdbi connexion = DatabaseConnexion.getInstance(IPServer).getConnexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Compteur : " + cpt);
        }
    }

}