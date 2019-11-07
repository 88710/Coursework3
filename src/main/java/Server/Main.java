package Server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.sqlite.SQLiteConfig;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static Connection db = null;

    private static void openDatabase(String dbFile) {
        try {
            Class.forName("ord.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            db = DriverManager.getConnection("jdbc:sqlite:recources/" + dbFile, config.toProperties());
            System.out.println("Database connection successfully established.");

        } catch (Exception exception) {
            System.out.println("Database connection error:" + exception.getMessage());

        }
    }
//test
    private static void closeDatabase() {
        try {
            db.close();
            System.out.println("Disconnected from database.");
        } catch (Exception exception) {
            System.out.println("Database disconnection error: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        openDatabase("CourseworkDatabase.db");
        Controllers.OrderController.insertOrder(000001, "12/9/2019", 12.99,true,"cash", "Delivery", "John");
        Controllers.OrderController.insertOrder(000002, "12/9/2019", 15.99,true,"card", "collection","Claire");
        Controllers.PizzaController.insertPizza("Hawaiin", false, false,true);
        Controllers.PizzaController.insertPizza("VeggieDeluxe", true, true,false);
        Controllers.PizzaController.insertPizza("NewYorker", false, false,false);
        //Controllers.OrderController.listOrder(000002);
        //Controllers.PizzaController.listPizzas("NewYorker");
        Controllers.DeliveryController.insertDelivery(000001, 14, "New Bourne","Farnborough","GU14 5YT");
        //Controllers.DeliveryController.listDelivery(000001);

        closeDatabase();
        openDatabase("CourseworkDatabase.db");

        ResourceConfig config = new ResourceConfig();
        config.packages("Controllers");
        config.register(MultiPartFeature.class);
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        Server server = new Server(8081);
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(servlet, "/*");

        try {
            server.start();
            System.out.println("Server successfully started.");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
