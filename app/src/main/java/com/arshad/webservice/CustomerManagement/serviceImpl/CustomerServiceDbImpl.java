package com.arshad.webservice.CustomerManagement.serviceImpl;

import com.arshad.webservice.CustomerManagement.beans.Customer;
import com.arshad.webservice.CustomerManagement.beans.CustomerResponseModel;
import com.arshad.webservice.CustomerManagement.mapper.CustomerMapper;
import com.arshad.webservice.CustomerManagement.repo.CustomerJPARepository;
import com.arshad.webservice.CustomerManagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("CustomerServiceDbImpl")
public class CustomerServiceDbImpl implements CustomerService {

    @Autowired
    private CustomerJPARepository CustomerRepository;

    public List<CustomerResponseModel> getAllCustomers() {
        List<CustomerResponseModel> CustomerList = com.arshad.webservice.CustomerManagement.mapper.CustomerMapper.INSTANCE.mapToCustomerResponseModelList(CustomerRepository.findAll());
        return CustomerList;
    }

    public CustomerResponseModel getCustomerByID(int id) {
        Optional<Customer> CustomerOptional = CustomerRepository.findById(id);
        if (CustomerOptional.isPresent()) {
            return com.arshad.webservice.CustomerManagement.mapper.CustomerMapper.INSTANCE.mapToCustomerResponseModel(CustomerOptional.get());
        }
        return null;
    }

    public CustomerResponseModel addCustomer(Customer customer) {
        customer = CustomerRepository.save(customer);
        return com.arshad.webservice.CustomerManagement.mapper.CustomerMapper.INSTANCE.mapToCustomerResponseModel(customer);
    }

    @Override
    public CustomerResponseModel deleteCustomerById(int id) {
        Optional<Customer> CustomerOptional = CustomerRepository.findById(id);
        if (CustomerOptional.isPresent()) {
            Customer customer = CustomerOptional.get();
            CustomerRepository.delete(customer);
            return CustomerMapper.INSTANCE.mapToCustomerResponseModel(customer);
        }
        return null;
    }

}

