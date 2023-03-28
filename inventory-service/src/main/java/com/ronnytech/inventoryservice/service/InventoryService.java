package com.ronnytech.inventoryservice.service;

import com.ronnytech.inventoryservice.model.Inventory;
import com.ronnytech.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
//@Transactional
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Inventory> isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode);
    }
}
