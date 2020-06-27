package com.mohamed.spring.brwry.services;

import com.mohamed.spring.brwry.web.model.CustomerDTO;

import java.util.UUID;


public interface CustomerService {

   CustomerDTO getCustomer(UUID customerId);
}
