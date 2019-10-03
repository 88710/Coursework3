package Controllers;

import Server.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listDelivery(int RefNo) {
        System.out.println("Orders/list");
        JSONArray list = new JSONArray();
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT ReferenceNo, Dateorder, OrderPrice, PaymentSuccessful, PaymentType, DeliveryOrCollection,CustomerName,  FROM Orders WHERE ReferenceNO = RefNo ");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                JSONObject item = new JSONObject();
                item.put("ReferenceNo",results.getInt(1));
                item.put("Dateorder",results.getString(2));
                item.put("OrderPrice",results.getDouble(3));
                item.put("PaymentSuccessful",results.getBoolean(4));
                item.put("PaymentType",results.getString(5));
                item.put("DeliveryOrCollection",results.getString(4));
                item.put("CustomerName",results.getString(5));
                list.add(item);
            }
            return list.toString();
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
            return "{\"error\": \"Unable to list items, please see server console for more info.\"}";
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
        /*public static void OrdersDelete(ReferenceNo){
            try {
                PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Orders WHERE RefNo = ?");
                ps.setInt(1, ReferenceNo);
                ps.execute();

            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
            }
        }*/
    }
}