package com.task.veterinary_clinic_management.service;


import com.task.veterinary_clinic_management.DTO.AppointmentDTO;
import com.task.veterinary_clinic_management.model.Appointment;
import com.task.veterinary_clinic_management.model.Patient;
import com.task.veterinary_clinic_management.repository.AppointmentRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, ModelMapper modelMapper) {
        this.appointmentRepository = appointmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.getById(id);
        return modelMapper.map(appointment, AppointmentDTO.class);
    }

    public void createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
    }

     public void alertAppointment(Appointment appointment){
         Patient patient = appointment.getPatient();
         sendEmailNotification(patient,appointment);

     }
    private void sendEmailNotification(Patient patient, Appointment appointment) {


    }



}
