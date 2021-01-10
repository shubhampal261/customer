package com.arshad.webservice.CustomerManagement.serviceImpl;

import com.arshad.webservice.CustomerManagement.beans.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("customerServiceImpl")
public class CustomerServiceImpl {
    private static int customerCount = 2;
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Arshad", new Date(), new Date(), new Date()));
        customerList.add(new Customer(2, "Shubham", new Date(), new Date(), new Date()));
    }

    public List<Customer> getAllCustomers() {
        return customerList;
    }

    public Customer getCustomerByID(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public Customer addCustomer(Customer customer) {
        customer.setId(++customerCount);
        customerList.add(customer);
        return customer;
    }

//    @Override
    public Customer deleteCustomerById(int id) {
        Iterator<Customer> itr = customerList.iterator();
        while (itr.hasNext()) {
            Customer customer = itr.next();
            if (customer.getId() == id) {
                customerList.remove(customer);
                return customer;
            }
        }
        return null;
    }

}
