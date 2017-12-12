import org.flywaydb.core.Flyway;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class DatabaseMigration
{
    private String url;
    private String user;
    private String password;

    private Properties prop = new Properties();
    private InputStream input = null;

    DatabaseMigration(String Url)
    {
       url = Url;
    }

    private void takingProperties()
    {
        try
        {
            input = getClass().getResourceAsStream("db/login/db.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.user = prop.getProperty("database.username");
            this.password = prop.getProperty("database.password");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void executeMigration ()
    {
        Flyway flyway = new Flyway();
        this.takingProperties();
        try
        {
            flyway.setDataSource(url, user, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        flyway.migrate();
    }

}
