package com.example.pos_api.Interface;



import com.example.pos_api.entity.SupplierEntity;

import java.util.List;

public interface SupplierServiceInterface {

    SupplierEntity saveSupplier(SupplierEntity supplierDTO);

    List<SupplierEntity> getAllSuppliers();

    SupplierEntity updateSupplier(Long id, SupplierEntity supplier);
}
