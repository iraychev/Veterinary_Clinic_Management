package com.task.veterinary_clinic_management.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @Column(name = "amount")
    private double amount;

    @Column(name = "paid")
    private Boolean paid;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "inventory_item_id")
    private InventoryItem inventoryItem;

    @OneToMany(mappedBy = "invoice")
    private List<FinancialRecord> financialRecords;

    public Invoice() {
    }

    public Invoice(Appointment appointment, double amount, Boolean paid,
                   LocalDate paymentDate, InventoryItem inventoryItem, List<FinancialRecord> financialRecords) {
        this.appointment = appointment;
        this.amount = amount;
        this.paid = paid;
        this.paymentDate = paymentDate;
        this.inventoryItem = inventoryItem;
        this.financialRecords = financialRecords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
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

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public List<FinancialRecord> getFinancialRecords() {
        return financialRecords;
    }

    public void setFinancialRecords(List<FinancialRecord> financialRecords) {
        this.financialRecords = financialRecords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id && Double.compare(invoice.amount, amount) == 0 && Objects.equals(appointment, invoice.appointment) && Objects.equals(paid, invoice.paid) && Objects.equals(paymentDate, invoice.paymentDate) && Objects.equals(inventoryItem, invoice.inventoryItem) && Objects.equals(financialRecords, invoice.financialRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointment, amount, paid, paymentDate, inventoryItem, financialRecords);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", amount=" + amount +
                ", paid=" + paid +
                ", paymentDate=" + paymentDate +
                ", inventoryItem=" + inventoryItem +
                ", financialRecords=" + financialRecords +
                '}';
    }
}
