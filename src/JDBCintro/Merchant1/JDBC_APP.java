package JDBCintro.Merchant1;

import JDBCintro.Merchant1.Entities.Customer;
import JDBCintro.Merchant1.Repository.CustomerRepository;
import JDBCintro.Merchant1.Repository.MerchantRepository;
import JDBCintro.Merchant1.Repository.PaymentRepository;
import JDBCintro.Merchant1.Service.CustomerService;
import JDBCintro.Merchant1.Service.MerchantService;
import JDBCintro.Merchant1.Service.PaymentService;

import java.io.IOException;
import java.sql.SQLException;

public class JDBC_APP {
    public static void main(String[] args) throws IOException, SQLException {

        CustomerRepository customerRepository = new CustomerRepository ( );
        MerchantRepository merchantRepository = new MerchantRepository ( );
        PaymentRepository paymentRepository = new PaymentRepository ( );

//    1. Create a Java representation of SQL tables created in CASH_MANAGEMENT database.
        var customerService = new CustomerService (customerRepository);

        //customerService.showAll ();
        //System.out.println (customerService.getById (3).getAddress ());


        MerchantService merchantService = new MerchantService (merchantRepository);
        //merchantService.showAll ();
        System.out.println (merchantService.getById (3) );

        var paymentService = new PaymentService (paymentRepository);
        //paymentService.showAll ();
//        System.out.println (paymentService.getById (1).getSumPaid () ); // sum by payment id
//        System.out.println (paymentService.getById (2).getSumPaid () );



    }



}
