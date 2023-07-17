package com.task.veterinary_clinic_management.repository;

import com.task.veterinary_clinic_management.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
