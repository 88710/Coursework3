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


public class DeliveryController {
    @POST
    @Path("new")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertDelivery(@FormDataParam("ReferenceNo") Integer ReferenceNo, @FormDataParam("HouseNumber") Integer HouseNumber, @FormDataParam("StreetName") String StreetName, @FormDataParam("Town") String Town, @FormDataParam("Postcode") String Postcode) {
        try {
            if (ReferenceNo == null || HouseNumber == null || StreetName == null || Town == null || Postcode == null) {
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("thing/new ReferenceNo=" + ReferenceNo);
            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Delivery(ReferenceNO, HouseNumber, StreetName, Town, Postcode) Values (?,?,?,?,?)");
            ps.setInt(1, ReferenceNo);
            ps.setInt(2, HouseNumber);
            ps.setString(3, StreetName);
            ps.setString(4, Town);
            ps.setString(5, Postcode);
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
    public String listDelivery(int RefNo) {
        System.out.println("Delivery/list");
        JSONArray list = new JSONArray();
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT ReferenceNo, HouseNumber, StreetName, Town, Postcode, FROM Delivery WHERE ReferenceNo = RefNo ");
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
    @POST
    @Path("update")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateDelivery(@FormDataParam("ReferenceNo") Integer ReferenceNo, @FormDataParam("HouseNumber") Integer HouseNumber, @FormDataParam("StreetName") String StreetName, @FormDataParam("Town") String Town, @FormDataParam("Postcode") String Postcode) {
        try {
            if (ReferenceNo == null || HouseNumber == null || StreetName == null || Town == null || Postcode == null) {
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("thing/update id=" + ReferenceNo);

            PreparedStatement ps = Main.db.prepareStatement("UPDATE Delivery SET HouseNumber = ?, StreetName = ?, Town = ?, Postcode = ? WHERE ReferenceNo = ?");
            ps.setInt(1, ReferenceNo);
            ps.setInt(2, HouseNumber);
            ps.setString(3, StreetName);
            ps.setString(4, Town);
            ps.setString(5, Postcode);
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
    public String deleteDelivery(@FormDataParam("ReferenceNo") Integer ReferenceNo) {

        try {
            if (ReferenceNo == null) {
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("thing/delete id=" + ReferenceNo);

            PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Delivery WHERE Referenceno = ?");

            ps.setInt(1, ReferenceNo);

            ps.execute();

            return "{\"status\": \"OK\"}";

        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
            return "{\"error\": \"Unable to delete item, please see server console for more info.\"}";
        }
    }
}

