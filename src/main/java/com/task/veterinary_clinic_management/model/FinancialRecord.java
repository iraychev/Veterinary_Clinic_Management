package com.task.veterinary_clinic_management.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "financial_record")
public class FinancialRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "amount")
    private double amount;

    public FinancialRecord() { }

    public FinancialRecord(Invoice invoice, LocalDate transactionDate, String description, double amount) {
        this.invoice = invoice;
        this.transactionDate = transactionDate;
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialRecord that = (FinancialRecord) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && Objects.equals(invoice, that.invoice) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoice, transactionDate, description, amount);
    }

    @Override
    public String toString() {
        return "FinancialRecord{" +
                "id=" + id +
                ", invoice=" + invoice +
                ", transactionDate=" + transactionDate +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
