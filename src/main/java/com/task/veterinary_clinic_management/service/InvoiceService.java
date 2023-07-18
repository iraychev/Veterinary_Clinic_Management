package com.task.veterinary_clinic_management.service;

import com.task.veterinary_clinic_management.model.Invoice;
import com.task.veterinary_clinic_management.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

   @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Invoice invoice){
       invoiceRepository.save(invoice);
    }
    public Invoice getPayment(Long id){
       return invoiceRepository.getById(id);
    }

}
