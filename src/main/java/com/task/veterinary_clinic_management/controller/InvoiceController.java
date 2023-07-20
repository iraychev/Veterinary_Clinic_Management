package com.task.veterinary_clinic_management.controller;

import com.task.veterinary_clinic_management.model.Invoice;
import com.task.veterinary_clinic_management.model.Patient;
import com.task.veterinary_clinic_management.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public void createInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.createInvoice(invoice);
    }
    @GetMapping
    public String getAllPayment(Model model) {
        List<Invoice> invoices = invoiceService.getAllPayment();
        model.addAttribute("payment", invoices);
        return "Payments";
    }

    @GetMapping("/{id}")
    public String getPayment(@PathVariable Long id, Model model) {
        Invoice invoice = invoiceService.getPayment(id);
        model.addAttribute("payment", invoice);
        return "Payment";
    }
}
