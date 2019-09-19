import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static Connection db = null;

    private static void openDatabase(String dbFile) {
        try {
            Class.forName("ord.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            db = DriveManager.getConnection("jdbc:sqlite:recources/" + dbFile, config.toProperties());
            System.out.println("Database connection successfully established.");

        } catch (Exception exception) {
            System.out.println("Database connection error:" + exception.getMessage());

        }
    }
    private static void closeDatabase()
    {
        try{
            db.close();
            System.out.println("Disconnected from database.");
        } catch (Exception exception){
            System.out.println("Database disconnection error: " + exception.getMessage());
        }
    }

    public static void main(String[] args){
        openDatabase("Test.db");
        //code using the database goes here
        closeDatabase();

    }
    public static void insertUser(){
        try {
            PreparedStatement ps = db.prepareStatement("INSERT INTO orders(ReferenceNo, Date, OrderPrice, PaymentSuccessful, PaymentType, EndofCardNo, DeliveryOrCollection, CustomerName) Values (?, ?, ? ,? ,? ,? ,?,?)");
            ps.setString(1, 00000001);
            ps.setString(2, 19 / 09 / 2019);
            ps.setString(3, 12.99);
            //continue phase 1, lesson 7
            ps.executeUpdate();
        }catch (Exception exception){
            System.out.println("Database error: "exception.getMessage());


        }
    }
}
