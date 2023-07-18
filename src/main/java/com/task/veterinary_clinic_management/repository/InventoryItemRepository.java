package com.task.veterinary_clinic_management.repository;

import com.task.veterinary_clinic_management.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
}
