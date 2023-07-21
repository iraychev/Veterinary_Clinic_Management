package com.task.veterinary_clinic_management.controller;

import com.task.veterinary_clinic_management.DTO.FinancialRecordDTO;
import com.task.veterinary_clinic_management.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<FinancialRecordDTO> getAllFinancialRecords() {
        return financialRecordService.getAllFinancialRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialRecordDTO> getFinancialRecordById(@PathVariable Long id) {
        FinancialRecordDTO financialRecordDTO = financialRecordService.getFinancialRecordById(id);
        if (financialRecordDTO != null) {
            return ResponseEntity.ok(financialRecordDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FinancialRecordDTO> createFinancialRecord(@RequestBody FinancialRecordDTO financialRecordDTO) {
        FinancialRecordDTO createdFinancialRecordDTO = financialRecordService.createFinancialRecord(financialRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFinancialRecordDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinancialRecord(@PathVariable Long id) {
        financialRecordService.deleteFinancialRecord(id);
        return ResponseEntity.noContent().build();
    }
}
