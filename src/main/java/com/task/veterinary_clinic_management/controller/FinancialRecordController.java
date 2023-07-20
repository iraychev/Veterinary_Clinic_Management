package com.task.veterinary_clinic_management.controller;

import com.task.veterinary_clinic_management.model.FinancialRecord;
import com.task.veterinary_clinic_management.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financial-records")
public class FinancialRecordController {

    private final FinancialRecordService financialRecordService;

    @Autowired
    public FinancialRecordController(FinancialRecordService financialRecordService) {
        this.financialRecordService = financialRecordService;
    }

    @GetMapping
    public List<FinancialRecord> getAllFinancialRecords() {
        return financialRecordService.getAllFinancialRecords();
    }

    @GetMapping("/{id}")
    public FinancialRecord getFinancialRecordById(@PathVariable Long id) {
        return financialRecordService.getFinancialRecordById(id);
    }

    @PostMapping
    public FinancialRecord addFinancialRecord(@RequestBody FinancialRecord financialRecord) {
        return financialRecordService.addFinancialRecord(financialRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteFinancialRecord(@PathVariable Long id) {
        financialRecordService.deleteFinancialRecord(id);
    }
}
