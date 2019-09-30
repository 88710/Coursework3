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

    public static void listDelivery(int RefNo) {
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT ReferenceNo, HouseNumber, StreetName, Town, Postcode, FROM Delivery WHERE ReferenceNO = RefNo ");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                int ReferenceNo = results.getInt(1);
                int HouseNumber = results.getInt(2);
                String StreetName = results.getString(3);
                String Town = results.getString(4);
                String Postcode = results.getString(5);
                System.out.println("ReferenceNo: " + ReferenceNo + ",  ");
                System.out.println("HouseNumber: " + HouseNumber + ",  ");
                System.out.println("StreetName: " + StreetName + ",  ");
                System.out.println("Town: " + Town + ",  ");
                System.out.println("Postcode: " + Postcode + ",  ");



            }
        } catch (Exception exception) {
            System.out.println("Database error: " + exception.getMessage());
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
        public static void DeliveryDelete(int RefNo){
            try {
                PreparedStatement ps = Main.db.prepareStatement("DELETE FROM Delivery WHERE ReferenceNo = ?");
                ps.setInt(1, RefNo);
                ps.execute();

            } catch (Exception exception) {
                System.out.println("Database error: " + exception.getMessage());
            }
        }
    }
}

