package Controllers;

import Server.Main;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderController {
    @POST
    @Path("new")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public static String insertOrder(@FormDataParam("ReferenceNo") Integer ReferenceNo, @FormDataParam("DateOrder") String DateOrder, @FormDataParam("OrderPrice") double OrderPrice, @FormDataParam("PaymentSuccessful") boolean PaymentSuccessful, @FormDataParam("PaymentType") String PaymentType, @FormDataParam("DeliveryOrCollection") String DeliveryOrCollection, @FormDataParam("CustomerName") String CustomerName) {
        try {
            if (ReferenceNo == null || DateOrder == null || PaymentType == null || DeliveryOrCollection == null || CustomerName == null) {
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("thing/new ReferenceNo=" + ReferenceNo);
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Orders(ReferenceNO, DateOrder, OrderPrice, PaymentSuccessful, PaymentType, DeliveryOrCollection, CustomerName) Values (?,?,?,?,?,?,?)");
            ps.setInt(1, ReferenceNo);
            ps.setString(2, DateOrder);
            ps.setDouble(3, OrderPrice);
            ps.setBoolean(4, PaymentSuccessful);
            ps.setString(5, PaymentType);
            ps.setString(6, DeliveryOrCollection);
            ps.setString(7, CustomerName);

            ps.executeUpdate();//test
            return "{\"status\": \"OK\"}";

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
            return "{\"error\": \"Unable to create new item, please see server console for more info.\"}";
        }

    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public static String listOrder(int RefNo) {
        System.out.println("Orders/list");
        JSONArray list = new JSONArray();
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT ReferenceNo, Dateorder, OrderPrice, PaymentSuccessful, PaymentType, DeliveryOrCollection,CustomerName,  FROM Orders WHERE ReferenceNO = RefNo ");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                JSONObject item = new JSONObject();
                item.put("ReferenceNo", results.getInt(1));
                item.put("DateOrder", results.getString(2));
                item.put("OrderPrice", results.getDouble(3));
                item.put("PaymentSuccessful", results.getBoolean(4));
                item.put("PaymentType", results.getString(5));
                item.put("DeliveryOrCollection", results.getString(6));
                item.put("CustomerName", results.getString(7));
                list.add(item);
            }
            return list.toString();
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
            return "{\"error\": \"Unable to list items, please see server console for more info.\"}";
        }
    }

    @POST
    @Path("update")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public static String updateOrder(
            @FormDataParam("ReferenceNo") Integer ReferenceNo, @FormDataParam("DateOrder") String DateOrder, @FormDataParam("OrderPrice") Double OrderPrice, @FormDataParam("PaymentSuccessful") Boolean PaymentSuccessful, @FormDataParam("DeliveryOrCollection") String DeliveryOrCollection, @FormDataParam("PaymentType") String PaymentType, @FormDataParam("CustomerName") String CustomerName) {
        try {
            if (ReferenceNo == null || DateOrder == null || PaymentType == null || DeliveryOrCollection == null || CustomerName == null) {
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("thing/update id=" + ReferenceNo);

            PreparedStatement ps = Main.db.prepareStatement("UPDATE Orders SET DateOrder = ?, OrderPrice = ?, PaymentType = ?, PaymentSuccessful = ?, DeliveryOrCollection = ?, CustomerName = ? WHERE ReferenceNo = ?");
            ps.setString(1, DateOrder);
            ps.setDouble(2, OrderPrice);
            ps.setBoolean(3, PaymentSuccessful);
            ps.setString(4, PaymentType);
            ps.setString(5, DeliveryOrCollection);
            ps.setString(6, CustomerName);
            ps.execute();
            return "{\"status\": \"OK\"}";

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
            return "{\"error\": \"Unable to update item, please see server console for more info.\"}";
        }
    }
    @POST
    @Path("delete")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public static String deleteOrder(@FormDataParam("ReferenceNo") Integer ReferenceNo) {

        try {
            if (ReferenceNo == null) {
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("thing/delete id=" + ReferenceNo);

            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Orders WHERE Referenceno = ?");

            ps.setInt(1, ReferenceNo);

            ps.execute();

            return "{\"status\": \"OK\"}";

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
            return "{\"error\": \"Unable to delete item, please see server console for more info.\"}";
        }
    }

}