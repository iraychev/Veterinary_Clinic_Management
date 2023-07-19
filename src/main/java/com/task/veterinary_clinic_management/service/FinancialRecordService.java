package com.task.veterinary_clinic_management.service;

import com.task.veterinary_clinic_management.model.FinancialRecord;
import com.task.veterinary_clinic_management.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialRecordService {
    private final FinancialRecordRepository financialRecordRepository;

    @Autowired
    public FinancialRecordService(FinancialRecordRepository financialRecordRepository) {
        this.financialRecordRepository = financialRecordRepository;
    }

    public List<FinancialRecord> getAllFinancialRecords() {
        return financialRecordRepository.findAll();
    }

    public FinancialRecord getFinancialRecordById(Long id) {
        return financialRecordRepository.getById(id);
    }

    public FinancialRecord addFinancialRecord(FinancialRecord financialRecord) {
        return financialRecordRepository.save(financialRecord);
    }

    public void deleteFinancialRecord(Long id) {
        financialRecordRepository.deleteById(id);
    }
}
