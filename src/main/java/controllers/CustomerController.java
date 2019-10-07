package controllers;

import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

import java.util.List;

public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity <List<Customer>> getCustomers() {
        List < Customer > customers = customerService.getCustomers();
        return new ResponseEntity< >(customers, HttpStatus.OK);
    }

    @PostMapping(value = "/customer")
    public ResponseEntity < Customer > createCustomer(@RequestBody Customer customer) {
        final Customer customerData = customerService.createCustomer(customer);
        return new ResponseEntity < >(customerData, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/customer/{id}")
    public ResponseEntity < String > deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity < >(HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity < Customer > getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity < >(customer, HttpStatus.OK);
    }
}
