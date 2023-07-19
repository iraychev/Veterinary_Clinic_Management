package com.task.veterinary_clinic_management.repository;

import com.task.veterinary_clinic_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
