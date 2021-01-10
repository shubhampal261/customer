package com.arshad.webservice.CustomerManagement.mapper;

import com.arshad.webservice.CustomerManagement.beans.Customer;
import com.arshad.webservice.CustomerManagement.beans.CustomerResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerResponseModel mapToCustomerResponseModel(final Customer customer);

    List<CustomerResponseModel> mapToCustomerResponseModelList(final List<Customer> customerList);
}
