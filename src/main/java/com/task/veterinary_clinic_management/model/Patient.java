package com.task.veterinary_clinic_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    private String breed;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "owner_contact")
    private String ownerContact;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "medical_history", columnDefinition = "TEXT")
    private String medicalHistory;

    @Column(columnDefinition = "TEXT")
    private String allergies;

    @Column(columnDefinition = "TEXT")
    private String vaccinations;

    public Patient() {}

    public Patient(String name, String species, String breed, LocalDate dateOfBirth,
                   String ownerName, String ownerContact, String medicalHistory,
                   String allergies, String vaccinations) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.ownerName = ownerName;
        this.ownerContact = ownerContact;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.vaccinations = vaccinations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(name, patient.name) && Objects.equals(species, patient.species) && Objects.equals(breed, patient.breed) && Objects.equals(ownerName, patient.ownerName) && Objects.equals(ownerContact, patient.ownerContact) && Objects.equals(dateOfBirth, patient.dateOfBirth) && Objects.equals(medicalHistory, patient.medicalHistory) && Objects.equals(allergies, patient.allergies) && Objects.equals(vaccinations, patient.vaccinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species, breed, ownerName, ownerContact, dateOfBirth, medicalHistory, allergies, vaccinations);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerContact='" + ownerContact + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", allergies='" + allergies + '\'' +
                ", vaccinations='" + vaccinations + '\'' +
                '}';
    }
}
