package com.springboot.customer.customer.controler;

import com.springboot.customer.customer.dto.CustomerDto;
import com.springboot.customer.customer.model.Customer;
import com.springboot.customer.customer.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CustomerControler {

    CustomerService customerService;

    @Autowired
    public CustomerControler(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("Customer")
    public ResponseEntity<CustomerDto> getCustomer(@RequestParam Integer creditId) {

        return customerService.getCustomer(creditId);

    }

    @PostMapping("Customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto) {

        return customerService.createCustomer(customerDto);
    }

}
