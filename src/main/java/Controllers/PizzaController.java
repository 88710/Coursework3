package Controllers;

import Server.Main;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

    @Path("pizzas/")
    public class PizzaController {
        @POST
        @Path("new")
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        @Produces(MediaType.APPLICATION_JSON)
        public static String insertPizza(@FormDataParam("PizzaId") Integer PizzaId, @FormDataParam("PizzaName") String PizzaName, @FormDataParam("Vegetarian") Boolean Vegetarian, @FormDataParam("Vegan") Boolean Vegan, @FormDataParam("GlutenFree") Boolean GlutenFree) {
            try {
                if (PizzaId == null || PizzaName == null || Vegetarian == null || Vegan == null || GlutenFree == null) {
                    throw new Exception("One or more form data parameters are missing in the HTTP request.");
                }
                System.out.println("thing/new PizzaId=" + PizzaId);
                PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Pizzas(PizzaId, PizzaName, Vegetarian, Vegan, GlutenFree) Values (?,?,?,?,?)");
                ps.setInt(1, PizzaId);
                ps.setBoolean(2, Vegetarian);
                ps.setBoolean(3, Vegan);
                ps.setBoolean(4, GlutenFree);
                ps.setString(5, PizzaName);
                ps.executeUpdate();//test
                return "{\"status\": \"OK\"}";

            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
                return "{\"error\": \"Unable to create new item, please see server console for more info.\"}";
            }

        }

        @GET
        @Path("list/{PizzaId}")
        @Produces(MediaType.APPLICATION_JSON)
        public static String listPizza(@PathParam("PizzaId") Integer PizzaId) {
            System.out.println("Pizzas/list");
            JSONArray list = new JSONArray();
            try {
                System.out.println("Pizzas/list");
                PreparedStatement ps = Main.db.prepareStatement("SELECT PizzaId, PizzaName, Vegetarian, Vegan, GlutenFree FROM Pizzas WHERE PizzaId = ? ");
                ps.setInt(1,PizzaId);
                ResultSet results = ps.executeQuery();
                while (results.next()) {
                    JSONObject item = new JSONObject();
                    item.put("PizzaId",results.getInt(1));
                    item.put("Vegetarian",results.getBoolean(2));
                    item.put("Vegan",results.getBoolean(3));
                    item.put("GlutenFree",results.getBoolean(4));
                    item.put("PizzaName",results.getString(5));
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
        public static String updatePizza(@FormDataParam("PizzaId") Integer PizzaId, @FormDataParam("PizzaName") String PizzaName, @FormDataParam("Vegetarian") Boolean Vegetarian, @FormDataParam("Vegan") Boolean Vegan, @FormDataParam("GlutenFree") Boolean GlutenFree) {
            try {
                if (PizzaId == null || PizzaName == null || Vegetarian == null || Vegan == null || GlutenFree == null ) {
                    throw new Exception("One or more form data parameters are missing in the HTTP request.");
                }
                System.out.println("thing/update id=" + PizzaId);

                PreparedStatement ps = Main.db.prepareStatement("UPDATE Pizzas SET  Vegetarian= ?, Vegan = ?, GlutenFree = ? WHERE PizzaId = ?");
                ps.setInt(1, PizzaId);
                ps.setString(1, PizzaName);
                ps.setBoolean(2, Vegetarian);
                ps.setBoolean(3, Vegan);
                ps.setBoolean(4, GlutenFree);
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
        public static String deletePizza(@FormDataParam("PizzaId") String PizzaId) {

            try {
                if (PizzaId == null) {
                    throw new Exception("One or more form data parameters are missing in the HTTP request.");
                }
                System.out.println("thing/delete id=" + PizzaId);

                PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Pizzas WHERE PizzaId = ?");

                ps.setString(1, PizzaId);

                ps.execute();

                return "{\"status\": \"OK\"}";

            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
                return "{\"error\": \"Unable to delete item, please see server console for more info.\"}";
            }
        }
    }
