package com.task.veterinary_clinic_management.controller;

import com.task.veterinary_clinic_management.DTO.InvoiceDTO;
import com.task.veterinary_clinic_management.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        invoiceService.createInvoice(invoiceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Long id) {
        InvoiceDTO invoiceDTO = invoiceService.getInvoiceById(id);
        if(invoiceDTO != null){
            return ResponseEntity.ok(invoiceDTO);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
