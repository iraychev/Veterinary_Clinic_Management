package com.task.veterinary_clinic_management.service;

import com.task.veterinary_clinic_management.model.Appointment;
import com.task.veterinary_clinic_management.model.Patient;
import com.task.veterinary_clinic_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public Patient getPatientById(Long id){
        return patientRepository.getById(id);
    }
      public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }
    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }
}
