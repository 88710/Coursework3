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
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            db = DriverManager.getConnection("jdbc:sqlite:resources/" + dbFile, config.toProperties());
            System.out.println("Database connection successfully established.");

        } catch (Exception exception) {
            System.out.println("Database connection error:" + exception.getMessage());

        }
    }

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

  /*      try {
   Controllers.DeliveryController.insertDelivery(5,13, "Short Street", "London", "GU140XU");
} catch(Exception exception) {
   System.out.println("Database insert error: " + exception.getMessage());
}
System.out.println("Insertion successful" + Controllers.DeliveryController.listDelivery(5));
*/
/*try {
   Controllers.OrderController.insertOrder(8,"23/10/2019", 12.99, true, "cash","Collection", "John");
} catch(Exception exception) {
   System.out.println("Database insert error: " + exception.getMessage());
}
System.out.println("Insertion successful" + Controllers.OrderController.listOrder(8));*/

/*try {
   Controllers.OrderController.insertOrder(000002,"13/09/2019", 15.99, true, "cash","Collection", "Steve");
} catch(Exception exception) {
   System.out.println("Database insert error: " + exception.getMessage());
}
System.out.println("Insertion successful" + Controllers.OrderController.listOrder(000002));*/

/*try {
   Controllers.PizzaController.listPizza("Tropical");
} catch(Exception exception) {
   System.out.println("Database list error: " + exception.getMessage());
}
System.out.println("Insertion successful" + Controllers.PizzaController.listPizza("Tropical"));

closeDatabase();
openDatabase("CourseworkDatabase.db");*/

/*try {
   Controllers.PizzaController.listPizza("Tropical");
} catch(Exception exception) {
   System.out.println("Database list error: " + exception.getMessage());
}
System.out.println("Insertion successful" + Controllers.PizzaController.listPizza("Tropical"));*/
/*
try {
   Controllers.PizzaController.updatePizza(1, "Meaty", false, false, false);
} catch(Exception exception) {
   System.out.println("Database list error: " + exception.getMessage());
}
System.out.println("Insertion successful" + Controllers.PizzaController.listPizza(1));
*/
/*try {
   Controllers.OrderController.deleteOrder(2);
} catch(Exception exception) {
   System.out.println("Database list error: " + exception.getMessage());
}*/


        closeDatabase();
        openDatabase("CourseworkDatabase.db");

       /* ResourceConfig config = new ResourceConfig();
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
        }*/


    }


}
