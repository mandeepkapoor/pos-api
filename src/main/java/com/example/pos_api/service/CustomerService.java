package com.example.pos_api.service;

import com.example.pos_api.Repository.CustomerRepository;
import com.example.pos_api.entity.CustomerEntity;
import com.example.pos_api.entity.SupplierEntity;
import com.example.pos_api.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerEntity saveCustomer(CustomerEntity customer){
        return customerRepository.save(customer);
    }

    public List<CustomerEntity> getAllCustomer(){
        return customerRepository.findAll();
    }

    public  CustomerEntity updateCustomer(Long id, CustomerEntity customer){
        CustomerEntity existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Supplier not found with id " + id);
                });

        existingCustomer.setTitle(customer.getTitle());
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        return customerRepository.save(customer);
    }
}
