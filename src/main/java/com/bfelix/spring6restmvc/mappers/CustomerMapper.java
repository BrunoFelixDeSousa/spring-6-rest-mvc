package com.bfelix.spring6restmvc.mappers;

import com.bfelix.spring6restmvc.entities.Customer;
import com.bfelix.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerTdoToCustumer(CustomerDTO dto);
    CustomerDTO customerToCustumerDto(Customer customer);

}
