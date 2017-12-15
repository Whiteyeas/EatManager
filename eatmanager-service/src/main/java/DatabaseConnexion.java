import org.jdbi.v3.core.Jdbi;

public class DatabaseConnexion extends LoadInfoDatabase
{
    private volatile static DatabaseConnexion instanceDB;
    private Jdbi connexionDB;
    private static String ipServer4Singleton;

    private DatabaseConnexion(String ipServerChild)
    {
        super(ipServerChild); //Constructeur parent
        System.out.println("Instance pas encore Ok");
        connexionDB = Jdbi.create(getUrl(), getUser(), getPassword());
        System.out.println("Instance OK");
    }

    //On set l'IP pour l'utiliser dans le singleton
    public static void setIP(String ipDatabase)
    {
        ipServer4Singleton = ipDatabase;
    }

    //Singleton pour objet 'DatabaseConnexion'
    public static DatabaseConnexion getInstance()
    {
        if(instanceDB == null)
        {
            //Permet de gérer les cas de threading
            synchronized (DatabaseConnexion.class)
            {
                if(instanceDB == null)
                    instanceDB = new DatabaseConnexion(ipServer4Singleton);
            }
        }

        return instanceDB;
    }

    //Retourner la connexion JDBI de l'objet instancié
    public Jdbi getConnexion()
    {
        return this.connexionDB;
    }
}
