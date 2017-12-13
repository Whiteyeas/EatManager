import org.flywaydb.core.Flyway;

public class DatabaseConception extends LoadInfoDatabase
{
    public DatabaseConception(String ipServerChild)
    {
        super(ipServerChild); //Constructeur parent
    }

    //Exécution de la migration avec FlyWay
    public void executeMigration ()
    {
        Flyway flyway = new Flyway();

        try
        {
            //Paramétrage de la source de données
            flyway.setDataSource(getUrl(), getUser(), getPassword());
            //Migration
            flyway.migrate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
