package JDBCintro.Merchant1.Repository;

import JDBCintro.Merchant1.Entities.Customer;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static JDBCintro.Merchant1.DBUtils.Connection.getConnection;

public class CustomerRepository {

    public void addCustomerAutoId(Customer customer) throws IOException, SQLException {
        Connection connection = getConnection ( );
        String query = "INSERT INTO customer (name,address,eMail,ccNo,ccType,maturity) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement (query);
        statement.setString (1, customer.getName ( ));
        statement.setString (2, customer.getAddress ( ));
        statement.setString (3, customer.geteMail ( ));
        statement.setString (4, customer.getCcNo ( ));
        statement.setString (5, customer.getCcType ( ));
        statement.setDate (6, customer.getMaturity ( ));
        statement.executeUpdate ( );
        statement.close ( );
    }

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

    public Customer getById(int requestedId) {
        Customer newCustomer = new Customer ( );
        ResultSet rs = null;
        String query = "SELECT id, name, address, email, ccNo, ccType, maturity FROM customer where id = ?";// JAVA statement objection from Connection object
        try (Connection connection = getConnection ( ); PreparedStatement ps = connection.prepareStatement (query)) { //ResultSet rs = ps.executeQuery ("SELECT id, name, address, email, ccNo, ccType, maturity FROM customer "); // Execute query and get ResultSet  object
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
