package JDBCintro.Merchant1;

import java.io.IOException;
import java.sql.SQLException;
import JDBCintro.Merchant1.Entities.Customer;
import JDBCintro.Merchant1.Repository.CustomerRepository;
import JDBCintro.Merchant1.Repository.MerchantRepository;
import JDBCintro.Merchant1.Repository.PaymentRepository;
import JDBCintro.Merchant1.Service.CustomerService;
import JDBCintro.Merchant1.Service.MerchantService;
import JDBCintro.Merchant1.Service.PaymentService;

public class JDBC_APP {
    public static void main(String[] args) throws IOException, SQLException {
        CustomerRepository customerRepository = new CustomerRepository ( );
        MerchantRepository merchantRepository = new MerchantRepository ();
        PaymentRepository paymentRepository = new PaymentRepository ();


         // +++++++++++++++++++++ show all customers
        var customerService = new CustomerService (customerRepository);
        //customerService.showAll ();

        Customer customer = customerService.getById (1);
        System.out.println (customer.getAddress () );


        // +++++++++++++++++++++ show all merchants
        MerchantService merchantService = new MerchantService (merchantRepository);
//        merchantService.showAll ();
          // +++++++++++++++++++++ show all payments ??????????????????????????????????????????????????????????
        PaymentService paymentService = new PaymentService (paymentRepository);
//        paymentService.showAll ();




    }





}
