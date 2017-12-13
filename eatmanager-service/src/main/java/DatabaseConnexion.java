import org.jdbi.v3.core.Jdbi;

public class DatabaseConnexion extends LoadInfoDatabase
{
    private volatile static DatabaseConnexion instanceDB;
    private Jdbi connexionDB;

    private DatabaseConnexion(String ipServerChild)
    {
        super(ipServerChild); //Constructeur parent
        connexionDB = Jdbi.create(getUrl(), getUser(), getPassword());
        System.out.println("Instance OK");
    }

    //Singleton pour objet 'DatabaseConnexion'
    public static DatabaseConnexion getInstance(String ipServer4Singleton)
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
