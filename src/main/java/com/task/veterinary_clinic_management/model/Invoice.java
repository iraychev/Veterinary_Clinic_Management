package com.task.veterinary_clinic_management.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "invoice")
    private List<FinancialRecord> financialRecords;

    public Invoice() {
    }

    public Invoice(Appointment appointment, double amount, Boolean paid,
                   LocalDate paymentDate, Product product, List<FinancialRecord> financialRecords) {
        this.appointment = appointment;
        this.amount = amount;
        this.paid = paid;
        this.paymentDate = paymentDate;
        this.product = product;
        this.financialRecords = financialRecords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        return Objects.equals(id, invoice.id) && Double.compare(invoice.amount, amount) == 0 && Objects.equals(appointment, invoice.appointment) && Objects.equals(paid, invoice.paid) && Objects.equals(paymentDate, invoice.paymentDate) && Objects.equals(product, invoice.product) && Objects.equals(financialRecords, invoice.financialRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointment, amount, paid, paymentDate, product, financialRecords);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", amount=" + amount +
                ", paid=" + paid +
                ", paymentDate=" + paymentDate +
                ", inventoryItem=" + product +
                ", financialRecords=" + financialRecords +
                '}';
    }
}
