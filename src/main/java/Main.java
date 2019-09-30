import org.sqlite.SQLiteConfig;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public class Main {
    public static Connection db = null;

    private static void openDatabase(String dbFile) {
        try {
            Class.forName("ord.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            db = DriverManager.getConnection("jdbc:sqlite:recources/" + dbFile, config.toProperties());
            System.out.println("Database connection successfully established.");

        } catch (Exception exception) {
            System.out.println("Database connection error:" + exception.getMessage());

        }
    }

    private static void closeDatabase() {
        try {
            db.close();
            System.out.println("Disconnected from database.");
        } catch (Exception exception) {
            System.out.println("Database disconnection error: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        openDatabase("CourseworkDatabase.db");
        OrderController.insertOrder(000001, "12/9/2019", 12.99,true,"cash", "collection", "John");
        OrderController.insertOrder(000002, "12/9/2019", 15.99,true,"card", "collection","Claire");
        OrderController.insertOrder(000003, "13/9/2019", 20.00,true,"cash", "delivery","Ben");
        OrderController.listOrder(000002);
        closeDatabase();

    }


}
