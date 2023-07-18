package com.task.veterinary_clinic_management.repository;

import com.task.veterinary_clinic_management.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
