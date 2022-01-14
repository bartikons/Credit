package com.springboot.customer.customer.service;

import java.util.Optional;

import com.springboot.customer.customer.dto.CustomerDto;
import com.springboot.customer.customer.model.Customer;
import com.springboot.customer.customer.repository.CustomerRepository;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    CustomerRepository customerRepository;
    ModelMapper modelMapper = new ModelMapper();

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<CustomerDto> getCustomer(Integer creditId) {

        Optional<Customer> optionalCustomer = customerRepository.findById(creditId);
        if (!optionalCustomer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CustomerDto customerDto = modelMapper.map(optionalCustomer.get(), CustomerDto.class);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    public ResponseEntity<Customer> createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer = customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
