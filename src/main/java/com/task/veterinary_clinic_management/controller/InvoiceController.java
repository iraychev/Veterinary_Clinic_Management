package com.task.veterinary_clinic_management.controller;

import com.task.veterinary_clinic_management.model.Invoice;
import com.task.veterinary_clinic_management.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void createInvoice(@RequestBody Invoice invoice) {
        invoiceService.createInvoice(invoice);
    }

    @GetMapping("/{id}")
    public Invoice getPayment(@PathVariable Long id) {
        return invoiceService.getPayment(id);
    }
}
