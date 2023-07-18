package com.task.veterinary_clinic_management.repository;

import com.task.veterinary_clinic_management.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
