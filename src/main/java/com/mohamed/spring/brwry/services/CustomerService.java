package com.mohamed.spring.brwry.services;

import com.mohamed.spring.brwry.web.model.CustomerDTO;

import java.util.UUID;


public interface CustomerService {

   CustomerDTO createCustomer(CustomerDTO customerToCreate);

   CustomerDTO getCustomer(UUID customerId);

   void updatedCustomer(CustomerDTO customerUpdate);

   void deleteCustomer(UUID uuid);
}
