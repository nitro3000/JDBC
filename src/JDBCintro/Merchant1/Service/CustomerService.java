package JDBCintro.Merchant1.Service;

import JDBCintro.Merchant1.Entities.Customer;
import JDBCintro.Merchant1.Repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void showAll() {
        for (Customer i : this.getAll ( )) {
            System.out.println (i);
        }
    }
    public List<Customer> getAll() {
        return customerRepository.getAll ( );
    }


    public Customer getById(int id) {
        Customer cust1 = customerRepository.getById (id);
        return cust1;
    }


    public List<Customer> filterBYCreteria() {
        return this.getAll ( ).stream ( ).filter (item -> item.getName ( ).length ( ) > 10).collect (Collectors.toList ( ));
    }
}
