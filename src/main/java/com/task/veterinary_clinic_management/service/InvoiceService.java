package com.task.veterinary_clinic_management.service;

import com.task.veterinary_clinic_management.DTO.InvoiceDTO;
import com.task.veterinary_clinic_management.model.Invoice;
import com.task.veterinary_clinic_management.repository.InvoiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final ModelMapper modelMapper;

   @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, ModelMapper modelMapper) {
        this.invoiceRepository = invoiceRepository;
        this.modelMapper = modelMapper;
    }

    public InvoiceDTO getInvoiceById(Long id){
       Invoice invoice = invoiceRepository.getById(id);
       return modelMapper.map(invoice, InvoiceDTO.class);
    }
    public void createInvoice(InvoiceDTO invoiceDTO){
       Invoice invoice = modelMapper.map(invoiceDTO, Invoice.class);
       invoiceRepository.save(invoice);
    }


}
