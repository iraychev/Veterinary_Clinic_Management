package com.task.veterinary_clinic_management.controller;

import com.task.veterinary_clinic_management.model.FinancialRecord;
import com.task.veterinary_clinic_management.model.Invoice;
import com.task.veterinary_clinic_management.service.FinancialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public String getAllFinancialRecords(Model model) {
        List<FinancialRecord> financialRecords = financialRecordService.getAllFinancialRecords();
        model.addAttribute("allFinancialRecords", financialRecords);
        return "allFinancialRecords";
    }

    @GetMapping("/{id}")
    public String getFinancialRecordById(@PathVariable Long id, Model model) {
        FinancialRecord financialRecord = financialRecordService.getFinancialRecordById(id);
        model.addAttribute("financialRecord", financialRecord);
        return "FinancialRecord";
    }

    @PostMapping
    public FinancialRecord addFinancialRecord(@ModelAttribute FinancialRecord financialRecord) {
        return financialRecordService.addFinancialRecord(financialRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteFinancialRecord(@PathVariable Long id) {
        financialRecordService.deleteFinancialRecord(id);
    }
}
