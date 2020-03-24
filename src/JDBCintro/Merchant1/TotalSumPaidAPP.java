package JDBCintro.Merchant1;

import JDBCintro.Merchant1.Entities.Customer;
import JDBCintro.Merchant1.Entities.Merchant;
import JDBCintro.Merchant1.Entities.Payment;
import JDBCintro.Merchant1.Repository.CustomerRepository;
import JDBCintro.Merchant1.Repository.MerchantRepository;
import JDBCintro.Merchant1.Repository.PaymentRepository;
import JDBCintro.Merchant1.Service.CustomerService;
import JDBCintro.Merchant1.Service.MerchantService;
import JDBCintro.Merchant1.Service.PaymentService;

import java.util.List;

public class TotalSumPaidAPP {

    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository ( );
        MerchantRepository merchantRepository = new MerchantRepository ( );
        PaymentRepository paymentRepository = new PaymentRepository ( );
        var customerService = new CustomerService (customerRepository);
        MerchantService merchantService = new MerchantService (merchantRepository);
        var paymentService = new PaymentService (paymentRepository);


        //    2. Create a specific class and method that will show a total sum payed for a merchant with a given
//    id (argument). The report should also contain merchant id, title and lastSent info
        int n = 2;
        Merchant merchant1 = merchantService.getById (n); // creating merchant by id
        double totalSum1 = paymentService.getTotalPaymentByMerchantId (merchant1);
        System.out.println (" The total sum paid to Merchant ID #"+ n + " is : "   + totalSum1 );







    }
}
