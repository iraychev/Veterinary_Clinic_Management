package com.task.veterinary_clinic_management.DTO;

import java.time.LocalDate;

public class FinancialRecordDTO {
    private int id;
    private InvoiceDTO invoice;
    private LocalDate transactionDate;
    private String description;
    private double amount;

    // Constructors, getters, and setters
}