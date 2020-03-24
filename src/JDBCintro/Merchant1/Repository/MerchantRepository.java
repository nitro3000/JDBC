package JDBCintro.Merchant1.Repository;

import JDBCintro.Merchant1.Entities.Merchant;
import JDBCintro.Merchant1.Entities.Payment;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static JDBCintro.Merchant1.DBUtils.Connection.getConnection;

public class MerchantRepository {

    public void addMerchant(Merchant merchant) throws IOException, SQLException {
        Connection connection = getConnection ( );
        String query = "INSERT INTO merchant(name, bankName, swift, account, charge, period1, minSum, needToSend, sent, lastSent) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement (query);

        statement.setString (1, merchant.getTitle ( ));
        statement.setString (2, merchant.getBankName ( ));
        statement.setString (3, merchant.getSwift ( ));
        statement.setString (4, merchant.getAccount ( ));
        statement.setDouble (5, merchant.getCharge ( ));
        statement.setInt (6, merchant.getPeriod ( ));
        statement.setDouble (7, merchant.getMinSum ( ));
        statement.setDouble (8, merchant.getNeedToSend ( ));
        statement.setDouble (9, merchant.getSent ( ));
        statement.setDate (10, merchant.getLastSent ( ));
        statement.executeUpdate ( );
        statement.close ( );
    }

    public List<Merchant> getAll() {
        List<Merchant> result = new ArrayList<> ( );
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
                result.add (merchant);
            }
        } catch (SQLException | IOException ex) {
            System.out.println (ex.getMessage ( ));
        }
        return result;
    }

    public Merchant getById(int requestedId) {
        Merchant newMerchant = new Merchant ( );
        ResultSet rs = null;
        String query = "SELECT id, name, bankName, swift, account, charge, period1, minSum, needToSend, sent, lastSent FROM merchant where id =?";
        try (Connection connection = getConnection ( ); PreparedStatement ps = connection.prepareStatement (query);) {
            ps.setInt (1, requestedId);
            rs = ps.executeQuery ( );
            if (rs.next ( ) == false) {
                return newMerchant;
            }
            String name = rs.getString ("name");
            String bankName = rs.getString ("bankName");
            String swift = rs.getString ("swift");
            String acc = rs.getString ("account");
            double charge = rs.getDouble (6);
            int period = rs.getInt ("period1");
            double minSum = rs.getDouble ("minSum");
            double needToSend = rs.getDouble ("needToSend");
            double sent = rs.getDouble ("period1");
            Date lastSent = rs.getDate ("lastSent");
            newMerchant = new Merchant (requestedId, name, bankName, swift, acc, charge, period, minSum, needToSend, sent, lastSent);
        } catch (SQLException | IOException ex) {
            System.out.println (ex.getMessage ( ));
        }
        return newMerchant;
    }
//SELECT SUM(sumPaid)Total_SumPaid, m.name TITLE,p.merchantId, m.lastSent FROM merchant m, payment p where m.id=p.merchantId and m.id =1
//    public double getTotalSumPaidByMerchantId2(int requestedId) {
//        double result=0;
//        ResultSet rs = null;
//        String query = "SELECT SUM(sumPaid)Total_SumPaid, m.name TITLE,p.merchantId, m.lastSent FROM merchant m, payment p where m.id=p.merchantId and m.id =?";
//        try (Connection connection = getConnection ( ); PreparedStatement ps = connection.prepareStatement (query);) {
//            ps.setInt (1, requestedId);
//            rs = ps.executeQuery ( );
//            if (rs.next ( ) == false) {
//                return result;
//            }
//            Double totalSumPaid  = rs.getDouble (1);
//            String title = rs.getString (2);
//            //Integer requestedId = rs.getInt (3);
//            Date lastSent = rs.getDate (4);
//            Merchant totalPayment=new Merchant (totalSumPaid,title,requestedId, lastSent);
//        } catch (SQLException | IOException ex) {
//            System.out.println (ex.getMessage ( ));
//        }
//        return result;
//    }


}
