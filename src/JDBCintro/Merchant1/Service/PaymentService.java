package JDBCintro.Merchant1.Service;

import JDBCintro.Merchant1.Entities.Merchant;
import JDBCintro.Merchant1.Entities.Payment;
import JDBCintro.Merchant1.Repository.PaymentRepository;

import java.util.List;

public class PaymentService {
    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void showAll(){
        for(Payment i : this.getAll ()){
            System.out.println (i );
        }
    }

    public List<Payment> getAll() {
        return paymentRepository.getAll ();
    }

    public Payment getById (int id){
        Payment payment1 = paymentRepository.getById (id);
        return payment1;
    }

    public double getTotalPaymentByMerchantId (Merchant merchant) {
        double sum=0;
        try {

            for (Payment i : merchant.getPayments ()) {
                sum = sum + i.getSumPaid ( );
            }
        } catch (NullPointerException e) {e.printStackTrace ();};
        return sum;
    }



}
