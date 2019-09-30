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

        public static void listPizzas(String PizzaQuery) {
            try {
                PreparedStatement ps = Main.db.prepareStatement("SELECT PizzaName,Vegetarian,Vegan,GlutenFree FROM Pizzas WHERE PizzaName = PizzaQuery ");
                ResultSet results = ps.executeQuery();
                while (results.next()) {
                    String PizzaName = results.getString(1);
                    String Vegetarian = results.getString(2);
                    String Vegan = results.getString(3);
                    String GlutenFree = results.getString(4);
                    System.out.println("PizzaName: " + PizzaName + ",  ");
                    System.out.println("Vegetarian: " + Vegetarian + ",  ");
                    System.out.println("Vegan: " + Vegan + ",  ");
                    System.out.println("GlutenFree: " + GlutenFree + ",  ");


                }
            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
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
            public static void PizzaDelete(String PizzaName){
                try {
                    PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Pizzas WHERE PizzaName = ?");
                    ps.setString(1, PizzaName);
                    ps.execute();

                } catch (Exception exception) {
                    System.out.println("Database error: " + exception.getMessage());
                }
            }
        }
    }
