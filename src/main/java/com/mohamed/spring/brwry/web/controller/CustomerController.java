package com.mohamed.spring.brwry.web.controller;

import com.mohamed.spring.brwry.services.CustomerService;
import com.mohamed.spring.brwry.web.model.CustomerDTO;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }


    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDTO customerToCreate){
        CustomerDTO customer = customerService.createCustomer(customerToCreate);
        return new ResponseEntity(customer , HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerByID(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomer(customerId) , HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void customerToUpdate(@PathVariable("customerId") UUID uuid , @RequestBody CustomerDTO customerUpdate){
        customerService.updatedCustomer(customerUpdate);

    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID uuid){
        customerService.deleteCustomer(uuid);
    }


}
