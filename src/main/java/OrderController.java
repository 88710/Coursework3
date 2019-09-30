import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderController {
    public static void insertOrder(int ReferenceNo, String DateOrder, double OrderPrice, boolean PaymentSuccessful, String PaymentType, String DeliveryOrCollection, String CustomerName) {
        try {
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Orders(ReferenceNO, DateOrder, OrderPrice, PaymentSuccessful, PaymentType, DeliveryOrCollection, CustomerName) Values (?,?,?,?,?,?,?)");
            ps.setInt(1, ReferenceNo);
            ps.setString(2, DateOrder);
            ps.setDouble(3, OrderPrice);
            ps.setBoolean(4, PaymentSuccessful);
            ps.setString(5, PaymentType);
            ps.setString(6, DeliveryOrCollection);
            ps.setString(7, CustomerName);

            ps.executeUpdate();//test

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }

    }

    public static void listOrder(int RefNo) {
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT ReferenceNo, DateOrder, OrderPrice, PaymentSuccessful, PaymentType, DeliveryOrCollection, CustomerName FROM Orders WHERE ReferenceNO = RefNo ");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                String ReferenceNo = results.getString(1);
                String DateOrder = results.getString(2);
                String OrderPrice = results.getString(3);
                String PaymentSuccessful = results.getString(4);
                String PaymentType = results.getString(5);
                String DeliveryOrCollection = results.getString(6);
                String CustomerName = results.getString(7);
                System.out.println("ReferenceNumber: " + ReferenceNo + ",  ");
                System.out.println("DateOrder: " + DateOrder + ",  ");
                System.out.println("OrderPrice: " + OrderPrice + ",  ");
                System.out.println("PaymentSuccessful: " + PaymentSuccessful + ",  ");
                System.out.println("PaymentType: " + PaymentType + ",  ");
                System.out.println("DeliveryOrCollection: " + DeliveryOrCollection + ",  ");
                System.out.println("CustomerName: " + CustomerName + ",  ");


            }
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
    }

    public static void OrderUpdate(int ReferenceNo, String DateOrder, Double OrderPrice, Boolean PaymentSuccessful, String PaymentType, String DeliveryOrCollection, String CustomerName) {
        try {
            PreparedStatement ps = Main.db.prepareStatement("UPDATE Orders SET ReferenceNo = ?, DateOrder = ?, OrderPrice = ?, PaymentSuccessful = ?, PaymentType = ?, DeliveryOrCollection = ?, CustomerName = ?");
            ps.setInt(1, ReferenceNo);
            ps.setString(2, DateOrder);
            ps.setDouble(3, OrderPrice);
            ps.setBoolean(4, PaymentSuccessful);
            ps.setString(5, PaymentType);
            ps.setString(6, DeliveryOrCollection);
            ps.setString(7, CustomerName);

            ps.execute();
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
        public static void OrdersDelete(int RefNo){
            try {
                PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Orders WHERE RefNo = ?");
                ps.setInt(1, RefNo);
                ps.execute();

            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
            }
        }
    }
}