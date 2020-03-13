package JDBCintro.Merchant1.Repository;

import JDBCintro.Merchant1.Entities.Customer;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static JDBCintro.Merchant1.DBUtils.Connection.getConnection;

public class CustomerRepository {

    //    public void addCustomerAutoId(String name,String address,String eMail,String ccNo,String ccType,Date maturity) throws IOException, SQLException {
//        Connection connection = getConnection ( );
//        String sql = "INSERT INTO customer (name,address,eMail,ccNo,ccType,maturity) VALUES(?,?,?,?,?,?)";
//        PreparedStatement statement = connection.prepareStatement (sql);
//        //statement.setInt (1,4);
//        statement.setString (1,"Ded-Moroz");
//        statement.setString (2,"Norh Pole");
//        statement.setString (3, "Dmoroz@noviygod");
//        statement.setString (4, "4580 0000 1234 9999");
//        statement.setString (5, "Visa");
//        statement.setDate (6, null);
//        statement.executeUpdate ( );
//        statement.close ( );
//    }
//    public void addCustomerAutoId(Customer customer) throws IOException, SQLException {
//        Connection connection = getConnection ( );
//        String query = "INSERT INTO customer (name,address,eMail,ccNo,ccType,maturity) VALUES(?,?,?,?,?,?)";
//        PreparedStatement statement = connection.prepareStatement (query);
//
////        LocalDate maturity = null;
////        Date maturityFromDB = statement.setDate (6, Date.valueOf ("2025-10-10"));
////        if (maturityFromDB != null) {
////            maturity = maturityFromDB.toLocalDate();
////        }
//        statement.setString (1,customer.getName () );
//        statement.setString (2,customer.getAddress ());
//        statement.setString (3, customer.geteMail ());
//        statement.setString (4, customer.getCcNo ());
//        statement.setString (5, customer.getCcType ());
//        statement.setDate (6, customer.getMaturity ());
//        statement.executeUpdate ( );
//        statement.close ( );
//    }
//    public void customerDisplay() {
//        try (Connection connection = getConnection ( );) {
//            Statement stmt = connection.createStatement ( );
//            ResultSet rs = stmt.executeQuery ("SELECT id, name, address, email, ccNo, ccType, maturity FROM customer ");
//            while (rs.next ( )) {
//                String id = rs.getString ("id");
//                String name = rs.getString (2);
//                String address = rs.getString ("address");
//                String email = rs.getString ("email");
//                String ccNo = rs.getString ("ccNo");
//                String ccType = rs.getString (6);
//                Date maturity = rs.getDate ("maturity");
//                System.out.println ("Customer id: " + id + " { " + " Name: " + name + ", Address: " + address + ", email: " + email +
//                        ", Credit Card # : " + ccNo + ", Credit Card Type: " + ccType + ",  Maturity Date: " + maturity + "}");
//            }
//        } catch (
//                SQLException | IOException ex) {
//            System.out.println (ex.getMessage ( ));
//        }
//    }
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<> ( );
        try (Connection connection = getConnection ( );) {
            Statement stmt = connection.createStatement ( ); // JAVA statement objection from Connection object
            ResultSet rs = stmt.executeQuery ("SELECT id, name, address, email, ccNo, ccType, maturity FROM customer "); // Execute query and get ResultSet  object
            while (rs.next ( )) {
                int id = rs.getInt ("id");
                String name = rs.getString ("name");
                String address = rs.getString ("address");
                String email = rs.getString ("email");
                String ccNo = rs.getString ("ccNo");
                String ccType = rs.getString (6);
                Date maturity = rs.getDate ("maturity");
                Customer customer = new Customer (id, name, address, email, ccNo, ccType, maturity);
                customers.add (customer);
            }
        } catch (
                SQLException | IOException ex) {
            System.out.println (ex.getMessage ( ));
        }
        return customers;
    }
//    Connection connection = getConnection ( );
//    String query = "INSERT INTO customer (name,address,eMail,ccNo,ccType,maturity) VALUES(?,?,?,?,?,?)";
//    PreparedStatement statement = connection.prepareStatement (query);


    public Customer getById(int requestedId) {
        Customer newCustomer = new Customer ( );
        ResultSet rs = null;
        String query = "SELECT id, name, address, email, ccNo, ccType, maturity FROM customer where id = ?";// JAVA statement objection from Connection object
        try (Connection connection = getConnection ( ); PreparedStatement ps = connection.prepareStatement (query);) { //ResultSet rs = ps.executeQuery ("SELECT id, name, address, email, ccNo, ccType, maturity FROM customer "); // Execute query and get ResultSet  object
            ps.setInt (1, requestedId);
            rs = ps.executeQuery ( );
            if (rs.next ( ) == false) {
                return newCustomer;
            }
            String name = rs.getString ("name");
            String address = rs.getString ("address");
            String email = rs.getString ("email");
            String ccNo = rs.getString ("ccNo");
            String ccType = rs.getString (6);
            Date maturity = rs.getDate ("maturity");
            newCustomer = new Customer (requestedId, name, address, email, ccNo, ccType, maturity);

        } catch (
                SQLException | IOException ex) {
            System.out.println (ex.getMessage ( ));
        }
        return newCustomer;
    }


}
//To retrieve rows from a table using a SELECT statement with no parameter markers, you need to perform these steps:
//
//Invoke the Connection.createStatement method to create a Statement object.
//Invoke the Statement.executeQuery method to obtain the result table from the SELECT statement in a ResultSet object.
//In a loop, position the cursor using the next method, and retrieve data from each column of the current row of the ResultSet object using getXXX methods. XXX represents a data type.
//Invoke the ResultSet.close method to close the ResultSet object.
//Invoke the Statement.close method to close the Statement object when you have finished using that object.