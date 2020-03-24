package JDBCintro.Merchant1.Repository;

import JDBCintro.Merchant1.Entities.Customer;
import JDBCintro.Merchant1.Entities.Merchant;
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
    MerchantRepository merchantRepository;
    CustomerRepository customerRepository;

    public PaymentRepository() {
        this.merchantRepository = new MerchantRepository ( );
        this.customerRepository = new CustomerRepository ( );
    }

    public List<Payment> getAll() {
        // ResultSet rs = null;
        List<Payment> listOfPayments = new ArrayList<> ( ); // creating List "listOfPayments"
        String query = "SELECT id, dt, merchantId, customerId, goods, sumPaid, chargePaid FROM payment "; // create query

        try (Connection connection = getConnection ( );  // connection to DB
             Statement stmt = connection.createStatement ( );) // create statement
        // insert query into the resultSet and execute query
        {
            ResultSet rs = stmt.executeQuery (query);
            while (rs.next ( )) { // iteration on resultSet
                // constructor for new payment obj
                int id = rs.getInt ("id");
                Timestamp dt = rs.getTimestamp ("dt");
                //Merchant merchantId = new MerchantRepository().getById(rs.getInt("merchantId"));  - add to constructor  of class PaymentRepository
                Merchant merchantId = merchantRepository.getById (rs.getInt ("merchantId")); // "rs.getInt" read from DB at "merchantId" column and will give an "id" of merchant for "getById" method
                Customer customerId = customerRepository.getById (rs.getInt ("customerId"));
                String goods = rs.getString ("goods");
                Double sumPaid = rs.getDouble ("sumPaid");
                Double chargePaid = rs.getDouble ("chargePaid");
                Payment payment = new Payment (id, dt, merchantId, customerId, goods, sumPaid, chargePaid); // create obj"payment" of Payment with args
                listOfPayments.add (payment); //adding obj "payment" to list "listOfPayments"
            }
        } catch (
                SQLException | IOException ex) {
            System.out.println (ex.getMessage ( ));
        }
        return listOfPayments;
    }

    public Payment getById(int requestedId) {
        Payment newPayment = new Payment ( );
        ResultSet rs = null;
        String query = "SELECT id, dt, merchantId, customerId, goods, sumPaid, chargePaid FROM payment where id = ? ";
        try (Connection connection = getConnection ( ); PreparedStatement ps = connection.prepareStatement (query)) {
            ps.setInt (1, requestedId);
            rs = ps.executeQuery ( );
            if (rs.next ( ) == false) {
                return newPayment;
            }
            Timestamp dt = rs.getTimestamp ("dt");
            Merchant merchantId = new MerchantRepository ( ).getById (rs.getInt ("merchantId"));
            Customer customerId = new CustomerRepository ( ).getById (rs.getInt ("customerId"));
            String goods = rs.getString ("goods");
            Double sumPaid = rs.getDouble ("sumPaid");
            Double chargePaid = rs.getDouble ("chargePaid");
            newPayment = new Payment (requestedId, dt, merchantId, customerId, goods, sumPaid, chargePaid);

        } catch (
                SQLException | IOException ex) {
            System.out.println (ex.getMessage ( ));
        }
        return newPayment;
    }
    public List<Payment> getPaymentsByMerchantId(Merchant requestedMerchantId) {

        Payment newPayment = new Payment ();
        ResultSet rs = null;
        List<Payment> payments = new ArrayList<> ( );
        String query = "select id, dt, merchantId, customerId, goods, sumPaid, chargePaid from payment where merchantId=?";
        try (Connection connection = getConnection ( ); PreparedStatement ps = connection.prepareStatement (query );) {
            rs = ps.executeQuery ();
            if (rs.next ( ) == false) {
                return payments;
            }
            while (rs.next ( )) {
                Integer id = rs.getInt ("id");
                Timestamp dt = rs.getTimestamp ("dt");
                //Merchant merchantId = merchantRepository.getById (rs.getInt ("merchantId"));
                Customer customerId = customerRepository.getById (rs.getInt ("customerId"));
                String goods = rs.getString ("goods");
                Double sumPaid = rs.getDouble ("sumPaid");
                Double chargePaid = rs.getDouble ("chargePaid");

                newPayment = new Payment (id, dt, requestedMerchantId, customerId, goods, sumPaid, chargePaid);
                payments.add (newPayment);
            }
        } catch (
                SQLException | IOException e) {
            e.printStackTrace ( );
        }
        return payments;
    }




}