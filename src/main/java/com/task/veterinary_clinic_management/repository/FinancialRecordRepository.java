package com.task.veterinary_clinic_management.repository;

import com.task.veterinary_clinic_management.model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
}
