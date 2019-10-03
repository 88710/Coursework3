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


public class DeliveryController {
    public static void insertDelivery(int ReferenceNo, int HouseNumber, String StreetName, String Town, String Postcode) {
        try {
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Delivery(ReferenceNO, HouseNumber, StreetName, Town, Postcode) Values (?,?,?,?,?)");
            ps.setInt(1, ReferenceNo);
            ps.setInt(2, HouseNumber);
            ps.setString(3, StreetName);
            ps.setString(4, Town);
            ps.setString(5, Postcode);

            ps.executeUpdate();//test

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }

    }
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listDelivery(int RefNo) {
        System.out.println("Delivery/list");
        JSONArray list = new JSONArray();
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT ReferenceNo, HouseNumber, StreetName, Town, Postcode, FROM Delivery WHERE ReferenceNO = RefNo ");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                JSONObject item = new JSONObject();
                item.put("ReferenceNo",results.getInt(1));
                item.put("HouseNumber",results.getInt(2));
                item.put("StreetName",results.getString(3));
                item.put("Town",results.getString(4));
                item.put("Postcode",results.getString(5));
                list.add(item);
            }
            return list.toString();
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
            return "{\"error\": \"Unable to list items, please see server console for more info.\"}";
        }
    }

    public static void DeliveryUpdate(int ReferenceNo, int HouseNumber, String StreetName, String Town, String Postcode) {
        try {
            PreparedStatement ps = Main.db.prepareStatement("UPDATE Delivery SET ReferenceNo = ?, HouseNumber = ?, StreetName = ?, Town = ?, Postcode = ?");
            ps.setInt(1, ReferenceNo);
            ps.setInt(2, HouseNumber);
            ps.setString(3, StreetName);
            ps.setString(4, Town);
            ps.setString(5, Postcode);


            ps.execute();
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
        }
        /*public static void DeliveryDelete(int RefNo){
            try {
                PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Delivery WHERE ReferenceNo = ?");
                ps.setInt(1, RefNo);
                ps.execute();

            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
            }
        }*/
    }
}

