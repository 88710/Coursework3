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
        openDatabase("Test.db");
        insertOrder(000001, "12/9/2019", 12.99,true,"cash", "collection", "John");
        insertOrder(000002, "12/9/2019", 15.99,true,"card", "collection","Claire");
        insertOrder(000003, "13/9/2019", 20.00,true,"cash", "delivery","Ben");
        listOrder();
        closeDatabase();

    }

    public static void insertOrder(int ReferenceNo, String DateOrder, double OrderPrice, boolean PaymentSuccessful, String PaymentType, String DeliveryOrCollection, String CustomerName) {
        try {
            PreparedStatement ps = db.prepareStatement("INSERT INTO Orders(ReferenceNO, DateOrder, OrderPrice, PaymentSuccessful, PaymentType, DeliveryOrCollection, CustomerName) Values (?,?,?,?,?,?)");
            ps.setInt(1, ReferenceNo);
            ps.setString(2, DateOrder);
            ps.setDouble(3, OrderPrice );
            ps.setBoolean(4, PaymentSuccessful);
            ps.setString(5, PaymentType);
            ps.setString(6, DeliveryOrCollection);
            ps.setString(7, CustomerName);

            ps.executeUpdate();//test

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }

    }

    public static void listOrder(int RefNo){
        try {
            PreparedStatement ps = db.prepareStatement("SELECT ReferenceNo, DateOrder, OrderPrice, PaymentSuccessful, PaymentType, DeliveryOrCollection, CustomerName FROM Orders WHERE ReferenceNO = RefNo ");
            ResultSet results = ps.executeQuery();
            while(results.next()){
                String ReferenceNo = results.getString(1);
                String DateOrder = results.getString(2);
                String OrderPrice = results.getString(3);
                String PaymentSuccessful = results.getString(4);
                String PaymentType = results.getString(5);
                String DeliveryOrCollection = results.getString(6);
                String CustomerName = results.getString(7);
                System.out.println("DateOrder: "+ DateOrder + ",  ");
                System.out.println("OrderPrice: "+ OrderPrice + ",  ");
                System.out.println("PaymentSuccessful: "+PaymentSuccessful + ",  ");
                System.out.println("PaymentType: "+ PaymentType + ",  ");
                System.out.println("DeliveryOrCollection: "+ DeliveryOrCollection + ",  ");
                System.out.println("CustomerName: "+ CustomerName + ",  ");


            }
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }
}
