package com.arshad.webservice.CustomerManagement.repo;

import com.arshad.webservice.CustomerManagement.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJPARepository extends JpaRepository<Customer, Integer>  {
}

