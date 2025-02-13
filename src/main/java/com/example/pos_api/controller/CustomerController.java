package com.example.pos_api.controller;


import com.example.pos_api.entity.CustomerEntity;
import com.example.pos_api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.pos_api.config.jwtUtils;


@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private CustomerService customerService;


    @PostMapping("/create")
    public ResponseEntity <CustomerEntity> create(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity customer = customerService.saveCustomer(customerEntity);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CustomerEntity>> getAllSuppliers() {
        List<CustomerEntity> customer = customerService.getAllCustomer();
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerEntity> updateSupplier(@PathVariable Long id, @RequestBody CustomerEntity updatedCustomer) {
        // Update the supplier using the service
        CustomerEntity updated = customerService.updateCustomer(id, updatedCustomer);
        // Return the updated supplier as the response
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/validate-token")
    public ResponseEntity<Void> validateToken() {
        return ResponseEntity.ok().build(); // If it reaches here, token is valid
    }

}
