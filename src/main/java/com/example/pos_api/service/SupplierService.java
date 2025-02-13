package com.example.pos_api.service;

import com.example.pos_api.Interface.SupplierServiceInterface;
import com.example.pos_api.Repository.SupplierRepository;

import com.example.pos_api.entity.SupplierEntity;
import com.example.pos_api.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService implements SupplierServiceInterface {

    private final SupplierRepository supplierRepository;

    @Override
    @Transactional
    public SupplierEntity saveSupplier(SupplierEntity supplier) {
        // Save the Supplier entity to the database
        return supplierRepository.save(supplier);  // Return the saved Supplier entity
    }

    @Override
    public List<SupplierEntity> getAllSuppliers() {
        return supplierRepository.findAll();  // Return all Supplier entities
    }


    @Override
    public SupplierEntity updateSupplier(Long id, SupplierEntity updatedSupplier) {
        SupplierEntity existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Supplier not found with id " + id);
                });

        // Update fields (make sure these are fields that can be updated)
        existingSupplier.setName(updatedSupplier.getName());
        existingSupplier.setEmail(updatedSupplier.getEmail());
        existingSupplier.setPhone(updatedSupplier.getPhone());
        existingSupplier.setCompanyName(updatedSupplier.getCompanyName());
        existingSupplier.setVATNUMBER(updatedSupplier.getVATNUMBER());

        existingSupplier.setAddressLine1(updatedSupplier.getPostcode());
        existingSupplier.setAddressLine1(updatedSupplier.getAddressLine1());
        existingSupplier.setAddressLine1(updatedSupplier.getAddressLine2());

        return supplierRepository.save(existingSupplier);
    }
}
