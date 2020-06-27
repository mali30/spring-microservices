package com.mohamed.spring.brwry.services;

import com.mohamed.spring.brwry.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerSerivceImpl implements CustomerService {


    @Override
    public CustomerDTO getCustomer(UUID customerId) {
        return CustomerDTO
                .builder()
                .customerId(customerId)
                .customerName("")
                .build();
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerToCreate) {
        return CustomerDTO.builder().customerName(customerToCreate.getCustomerName())
                .customerId(customerToCreate.getCustomerId()).build();
    }

    @Override
    public void updatedCustomer(CustomerDTO customerUpdate) {
        CustomerDTO.builder().customerId(customerUpdate.getCustomerId()).customerName(customerUpdate.getCustomerName());
    }

    @Override
    public void deleteCustomer(UUID uuid) {
        CustomerDTO.builder().customerId(uuid).customerName("");
    }
}
