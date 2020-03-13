package JDBCintro.Merchant1.Repository;

import JDBCintro.Merchant1.Entities.Merchant;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static JDBCintro.Merchant1.DBUtils.Connection.getConnection;

public class MerchantRepository {
    public void addMerchant(int id, String name, String bankName, String swift, String account, double charge, int period, double minSum, double needToSend, double sent, Date lastSent) throws IOException, SQLException {
        Connection connection = getConnection ( );
        String sql = "INSERT INTO merchant(name, bankName, swift, account, charge, period1, minSum, needToSend, sent, lastSent) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement (sql);

        //statement.setInt (1, id);
        statement.setString (1, name);
        statement.setString (2, bankName);
        statement.setString (3, swift);
        statement.setString (4, account);
        statement.setDouble (5, charge);
        statement.setInt (6, period);
        statement.setDouble (7, minSum);
        statement.setDouble (8, needToSend);
        statement.setDouble (9, sent);
        statement.setDate (10, lastSent);
        statement.executeUpdate ( );
        statement.close ( );
    }
    public void addMerchant(Merchant merchant) throws IOException, SQLException {
        Connection connection = getConnection ( );
        String query = "INSERT INTO merchant(name, bankName, swift, account, charge, period1, minSum, needToSend, sent, lastSent) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement (query);

        statement.setString (1, merchant.getTitle ());
        statement.setString (2, merchant.getBankName ());
        statement.setString (3, merchant.getSwift ());
        statement.setString (4, merchant.getAccount ());
        statement.setDouble (5, merchant.getCharge ());
        statement.setInt (6, merchant.getPeriod ());
        statement.setDouble (7, merchant.getMinSum ());
        statement.setDouble (8, merchant.getNeedToSend ());
        statement.setDouble (9, merchant.getSent ());
        statement.setDate (10,merchant.getLastSent ());
        statement.executeUpdate ( );
        statement.close ( );
    }
    public void merchantDisplay() {
        try (Connection connection = getConnection ( );) {
            Statement stmt = connection.createStatement ( );
            ResultSet rs = stmt.executeQuery ("SELECT id, name, bankName, swift, account, charge, period1, minSum, needToSend, sent, lastSent FROM merchant ");
            while (rs.next ( )) {
                String id = rs.getString ("id");
                String name = rs.getString (2);
                String bankName = rs.getString ("bankName");
                String swift = rs.getString ("swift");
                String acc = rs.getString ("account");
                double charge = rs.getDouble (6);
                int period = rs.getInt ("period1");
                double minSum = rs.getDouble ("minSum");
                double needToSend = rs.getDouble ("needToSend");
                double sent = rs.getDouble ("period1");
                Date lastSent = rs.getDate ("lastSent");
                System.out.println ("Merchant id: " + id + " { " + " Name: " + name + ", Bank Name: " + bankName + ", Swift: " + swift + ", Account# : " + acc + ", Charge: " + charge + ", " +
                        "Period" + period + ", Minimum Sum: " + minSum + ", Need to Send: " + needToSend + ", sent " + sent + ",last sent: " + lastSent + "}");
            }
        } catch (SQLException | IOException ex) {
            System.out.println (ex.getMessage ( ));
        }
    }

    public List<Merchant> getAll(){
        List<Merchant>result = new ArrayList<>();
        try (Connection connection = getConnection ( );) {
            Statement stmt = connection.createStatement ( );
            ResultSet rs = stmt.executeQuery ("SELECT id, name, bankName, swift, account, charge, period1, minSum, needToSend, sent, lastSent FROM merchant ");
            while (rs.next ( )) {
                int id = rs.getInt ("id");
                String name = rs.getString (2);
                String bankName = rs.getString ("bankName");
                String swift = rs.getString ("swift");
                String acc = rs.getString ("account");
                double charge = rs.getDouble (6);
                int period = rs.getInt ("period1");
                double minSum = rs.getDouble ("minSum");
                double needToSend = rs.getDouble ("needToSend");
                double sent = rs.getDouble ("period1");
                Date lastSent = rs.getDate ("lastSent");
                Merchant merchant = new Merchant (id, name, bankName, swift, acc, charge, period, minSum, needToSend, sent, lastSent);
                result.add(merchant);
//                System.out.println ("Merchant id: " + id + " { " + " Name: " + name + ", Bank Name: " + bankName + ", Swift: " + swift + ", Account# : " + acc + ", Charge: " + charge + ", " +
//                        "Period" + period + ", Minimum Sum: " + minSum + ", Need to Send: " + needToSend + ", sent " + sent + ",last sent: " + lastSent + "}");
            }
        } catch (SQLException | IOException ex) {
            System.out.println (ex.getMessage ( ));
        }

       return result;
    }

}
