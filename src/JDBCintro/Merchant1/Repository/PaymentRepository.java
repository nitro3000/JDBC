package JDBCintro.Merchant1.Repository;

import JDBCintro.Merchant1.Entities.Payment;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static JDBCintro.Merchant1.DBUtils.Connection.getConnection;

public class PaymentRepository {
//    public  void addPayment(int id, java.sql.Timestamp dt, int merchantId, int customerId, String goods, double sum, double charge) throws IOException, SQLException {
//        Connection connection = getConnection ( );
//        String sql = "INSERT INTO payment (id, dt, merchantId, customerId, goods, sumPaid, chargePaid) VALUES(?,?,?,?,?,?,?)";
//        PreparedStatement statement = connection.prepareStatement (sql);
//        statement.setInt (1, id);
//        statement.setTimestamp (2, dt);
//        statement.setInt (3, merchantId);
//        statement.setInt (4, customerId);
//        statement.setString (5, goods);
//        statement.setDouble (6, sum);
//        statement.setDouble (7, charge);
//        statement.executeUpdate ( );
//        statement.close ( );
//    }
//    public void addPayment(Payment payment) throws IOException, SQLException {
//        Connection connection = getConnection ( );
//        String sql = "INSERT INTO payment (dt, merchantId, customerId, goods, sumPaid, chargePaid) VALUES(?,?,?,?,?,?)";
//        PreparedStatement statement = connection.prepareStatement (sql);
//        //statement.setInt (1, id);
//        statement.setTimestamp ( 1, payment.getDt ());
//        statement.setInt (2, 4);
//        statement.setInt (3, 4);
//        statement.setString (4,payment.getGoods ());
//        statement.setDouble (5, payment.getSumPaid ());
//        statement.setDouble (6,23);
//        statement.executeUpdate ( );
//        statement.close ( );
//    }
//    public void paymentDisplay() {
//        try (Connection connection = getConnection ( );) {
//            Statement stmt = connection.createStatement ( );
//            ResultSet rs = stmt.executeQuery ("SELECT id, dt, merchantId, customerId, goods, sumPaid, chargePaid FROM payment ");
//            while (rs.next ( )) {
//                String id = rs.getString (1);
//                Timestamp dt = rs.getTimestamp (2);
//                String merchantId = rs.getString (3);
//                String customerId = rs.getString (4);
//                String goods = rs.getString (5);
//                String sumPaid = rs.getString (6);
//                String chargePaid = rs.getString (7);
//
//                System.out.println ("Payment id: " + id + " { " + "Time : " + dt + ", Merchant ID " + merchantId + ", Customer ID: " + customerId +
//                        ", Goods : " + goods + ", Sum Paid: " + sumPaid + ",  Charge Paid: " + chargePaid + "}");
//            }
//        } catch (
//                SQLException | IOException ex) {
//            System.out.println (ex.getMessage ( ));
//        }
//    }

    public List<Payment> getAll() {
        List<Payment>listOfPayments= new ArrayList<> ();

        try (Connection connection = getConnection ( );) {
            Statement stmt = connection.createStatement ( );
            ResultSet rs = stmt.executeQuery ("SELECT id, dt, merchantId, customerId, goods, sumPaid, chargePaid FROM payment ");
            while (rs.next ( )) {
                int id = rs.getInt (1);
                Timestamp dt = rs.getTimestamp (2);
                String merchantId = rs.getString (3);
                String customerId = rs.getString (4);
                String goods = rs.getString (5);
                Double sumPaid = rs.getDouble (6);
                Double chargePaid = rs.getDouble (7);

                Payment payment=new Payment (id, dt, merchantId, customerId, goods, sumPaid, chargePaid);
                listOfPayments.add (payment);


            }
        } catch (
                SQLException | IOException ex) {
            System.out.println (ex.getMessage ( ));
        }return listOfPayments;
    }

}
