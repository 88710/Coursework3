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

    public class PizzaController {
        public static void insertPizza(String PizzaName, boolean Vegetarian, boolean Vegan, boolean GlutenFree) {
            try {
                PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Pizzas(PizzaName,Vegetarian,Vegan,GlutenFree) Values (?,?,?,?)");
                ps.setString(1, PizzaName);
                ps.setBoolean(2, Vegetarian);
                ps.setBoolean(3, Vegan);
                ps.setBoolean(4, GlutenFree);

                ps.executeUpdate();//test

            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
            }

        }

        @GET
        @Path("list")
        @Produces(MediaType.APPLICATION_JSON)
        public String listDelivery(int RefNo) {
            System.out.println("Pizzas/list");
            JSONArray list = new JSONArray();
            try {
                PreparedStatement ps = Main.db.prepareStatement("SELECT ReferenceNo, Vegetarian, Vegan, GlutenFree, FROM Pizzas WHERE ReferenceNO = RefNo ");
                ResultSet results = ps.executeQuery();
                while (results.next()) {
                    JSONObject item = new JSONObject();
                    item.put("ReferenceNo",results.getInt(1));
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

        public static void PizzaUpdate(String PizzaName, boolean Vegetarian, boolean Vegan, boolean GlutenFree) {
            try {
                PreparedStatement ps = Main.db.prepareStatement("UPDATE Pizzas SET PizzaName = ?, Vegetarian = ?, Vegan = ?, GlutenFree = ?");
                ps.setString(1, PizzaName);
                ps.setBoolean(2, Vegetarian);
                ps.setBoolean(3, Vegan);
                ps.setBoolean(4, GlutenFree);

                ps.execute();
            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
            }
            /*public static void PizzaDelete(String PizzaName){
                try {
                    PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Pizzas WHERE PizzaName = ?");
                    ps.setString(1, PizzaName);
                    ps.execute();

                } catch (Exception exception) {
                    System.out.println("Database error: " + exception.getMessage());
                }
            }*/
        }
    }
