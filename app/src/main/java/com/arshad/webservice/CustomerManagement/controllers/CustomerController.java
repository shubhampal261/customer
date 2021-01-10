package com.arshad.webservice.CustomerManagement.controllers;

import com.arshad.webservice.CustomerManagement.beans.Customer;
import com.arshad.webservice.CustomerManagement.beans.CustomerResponseModel;
import com.arshad.webservice.CustomerManagement.services.CustomerService;
import com.arshad.webservice.CustomerManagement.utils.CustomerConstants;
import com.arshad.webservice.CustomerManagement.utils.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
//    @Qualifier(value = "customerServiceImpl")
    @Qualifier(value = "customerServiceDbImpl")
    private CustomerService customerServiceImpl;

    @GetMapping
    public List<CustomerResponseModel> getAllCustomers(){
        return customerServiceImpl.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public CustomerResponseModel getCustomer(@PathVariable int id){
        CustomerResponseModel customer = customerServiceImpl.getCustomerByID(id);
        if(customer == null){
            throw new CustomerNotFoundException(String.format(CustomerConstants.NOT_FOUND_FOR_ID,id));
        }
        return customer;
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        customerServiceImpl.addCustomer(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id){
        CustomerResponseModel customer = customerServiceImpl.deleteCustomerById(id);
        if(customer == null){
            throw new CustomerNotFoundException(String.format(CustomerConstants.CANNOT_DELETE,id));
        }
        return ResponseEntity.noContent().build();
    }

}
