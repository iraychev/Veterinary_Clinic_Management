package com.task.veterinary_clinic_management.service;

import com.task.veterinary_clinic_management.DTO.PatientDTO;
import com.task.veterinary_clinic_management.model.Appointment;
import com.task.veterinary_clinic_management.model.Doctor;
import com.task.veterinary_clinic_management.model.Patient;
import com.task.veterinary_clinic_management.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PatientService(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }

    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.getById(id);
        return modelMapper.map(patient, PatientDTO.class);
    }

    public void createPatient(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
