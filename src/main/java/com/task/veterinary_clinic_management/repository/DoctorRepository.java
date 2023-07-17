package com.task.veterinary_clinic_management.repository;

import com.task.veterinary_clinic_management.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
