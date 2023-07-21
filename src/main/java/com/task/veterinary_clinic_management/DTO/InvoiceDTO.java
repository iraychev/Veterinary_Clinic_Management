package com.task.veterinary_clinic_management.DTO;

import java.time.LocalDate;
import java.util.List;

public class InvoiceDTO {
    private Long id;
    private AppointmentDTO appointment;
    private double amount;
    private Boolean paid;
    private LocalDate paymentDate;
    private ProductDTO product;
    private List<FinancialRecordDTO> financialRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppointmentDTO getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentDTO appointment) {
        this.appointment = appointment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public List<FinancialRecordDTO> getFinancialRecords() {
        return financialRecords;
    }

    public void setFinancialRecords(List<FinancialRecordDTO> financialRecords) {
        this.financialRecords = financialRecords;
    }
}
