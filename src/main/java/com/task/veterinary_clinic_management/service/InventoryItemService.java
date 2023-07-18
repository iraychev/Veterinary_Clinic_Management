package com.task.veterinary_clinic_management.service;

import com.task.veterinary_clinic_management.model.InventoryItem;
import com.task.veterinary_clinic_management.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryItemService {
    private  final InventoryItemRepository inventoryItemRepository;

    @Autowired
    public InventoryItemService(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }
    public List<InventoryItem> getAllProducts(){
        return inventoryItemRepository.findAll();
    }
    public InventoryItem getProductById(Long id){
        return inventoryItemRepository.getById(id);
    }
    public void createProduct(InventoryItem inventoryItem){

         inventoryItemRepository.save(inventoryItem);
    }

}
