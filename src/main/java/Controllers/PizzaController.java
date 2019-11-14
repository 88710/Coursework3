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

    public class PizzaController {
        @POST
        @Path("new")
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        @Produces(MediaType.APPLICATION_JSON)
        public static String insertPizza(@FormDataParam("PizzaName") String PizzaName, @FormDataParam("Vegetarian") Boolean Vegetarian, @FormDataParam("Vegan") Boolean Vegan, @FormDataParam("GlutenFree") Boolean GlutenFree) {
            try {
                if (PizzaName == null || Vegetarian == null || Vegan == null || GlutenFree == null) {
                    throw new Exception("One or more form data parameters are missing in the HTTP request.");
                }
                System.out.println("thing/new PizzaName=" + PizzaName);
                PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Pizzas(PizzaName, Vegetarian, Vegan, GlutenFree) Values (?,?,?,?)");
                ps.setString(1, PizzaName);
                ps.setBoolean(2, Vegetarian);
                ps.setBoolean(3, Vegan);
                ps.setBoolean(4, GlutenFree);
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
        public static String listPizza(String PizzaNameX) {
            System.out.println("Pizzas/list");
            JSONArray list = new JSONArray();
            try {
                PreparedStatement ps = Main.db.prepareStatement("SELECT PizzaName, Vegetarian, Vegan, GlutenFree, FROM Pizzas WHERE PizzaName = PizzaNameX ");
                ResultSet results = ps.executeQuery();
                while (results.next()) {
                    JSONObject item = new JSONObject();
                    item.put("PizzaName",results.getString(1));
                    item.put("Vegetarian",results.getBoolean(2));
                    item.put("Vegan",results.getBoolean(3));
                    item.put("GlutenFree",results.getBoolean(4));
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
        public static String updatePizza(@FormDataParam("PizzaName") String PizzaName, @FormDataParam("Vegetarian") Boolean Vegetarian, @FormDataParam("Vegan") Boolean Vegan, @FormDataParam("GlutenFree") Boolean GlutenFree) {
            try {
                if (PizzaName == null || Vegetarian == null || Vegan == null || GlutenFree == null ) {
                    throw new Exception("One or more form data parameters are missing in the HTTP request.");
                }
                System.out.println("thing/update id=" + PizzaName);

                PreparedStatement ps = Main.db.prepareStatement("UPDATE Pizzas SET  Vegetarian= ?, Vegan = ?, GlutenFree = ? WHERE PizzaName = ?");
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
        public static String deletePizza(@FormDataParam("PizzaName") String PizzaName) {

            try {
                if (PizzaName == null) {
                    throw new Exception("One or more form data parameters are missing in the HTTP request.");
                }
                System.out.println("thing/delete id=" + PizzaName);

                PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Pizzas WHERE PizzaName = ?");

                ps.setString(1, PizzaName);

                ps.execute();

                return "{\"status\": \"OK\"}";

            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
                return "{\"error\": \"Unable to delete item, please see server console for more info.\"}";
            }
        }
    }
