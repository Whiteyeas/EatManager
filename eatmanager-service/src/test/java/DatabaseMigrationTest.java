import org.junit.Test;

public class DatabaseMigrationTest {

    @Test
    public void testMigration()
    {
        String IPServer = "jdbc:mysql://10.31.0.138/EatManagerDB";

        DatabaseMigration properties = new DatabaseMigration(IPServer);
        properties.executeMigration();
    }

}