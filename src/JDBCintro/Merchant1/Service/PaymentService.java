package JDBCintro.Merchant1.Service;

import JDBCintro.Merchant1.Entities.Payment;
import JDBCintro.Merchant1.Repository.PaymentRepository;

public class PaymentService {
    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    public void showAll(){
       paymentRepository.getAll ();
       for(Payment i : paymentRepository.getAll ()){
           System.out.println (i );
       }

    }

//    public Double TotalSumPaidByMerchant (Merchant merchant){
//        double result=0;
//
//            try (Connection connection = getConnection ( );) {
//                Statement stmt = connection.createStatement ( );
//                ResultSet rs = stmt.executeQuery ("SELECT p.merchantId,m.name,p.sumPaid FROM payment p, merchant m where p.merchantId= m.id");
//                while (rs.next ( )) {
//                    int id = rs.getInt ("merchantId");
//                    String name = rs.getString ("name");
//                    Double sumPaid = rs.getDouble ("sumPaid");
//
//
//                    System.out.println ("Merchant id = " + id +   "  Title : " + name +  ", Sum Paid: " + sumPaid );
//                }
//            } catch (
//                    SQLException | IOException ex) {
//                System.out.println (ex.getMessage ( ));
//            }
//
//
//                //result = ()
//        return result;
//    }


}
