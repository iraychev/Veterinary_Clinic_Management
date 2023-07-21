package com.task.veterinary_clinic_management.service;

import com.task.veterinary_clinic_management.DTO.DoctorDTO;
import com.task.veterinary_clinic_management.model.Doctor;
import com.task.veterinary_clinic_management.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }

    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.getById(id);
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor, DoctorDTO.class);
    }

    public DoctorDTO updateDoctor(Long id, DoctorDTO updatedDoctorDTO) {
        Doctor existingDoctor = doctorRepository.getById(id);
        if (existingDoctor != null) {
            modelMapper.map(updatedDoctorDTO, existingDoctor);
            Doctor updatedDoctor = doctorRepository.save(existingDoctor);
            return modelMapper.map(updatedDoctor, DoctorDTO.class);
        }
        return null;
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
