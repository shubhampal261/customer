package com.arshad.webservice.CustomerManagement.services;

import com.arshad.webservice.CustomerManagement.beans.Customer;
import com.arshad.webservice.CustomerManagement.beans.CustomerResponseModel;

import java.util.List;

public interface CustomerService {

    public List<CustomerResponseModel> getAllCustomers();

    public CustomerResponseModel getCustomerByID(int id);

    public CustomerResponseModel addCustomer(Customer customer);

    public CustomerResponseModel deleteCustomerById(int id);
}
