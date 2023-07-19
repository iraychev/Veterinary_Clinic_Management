package com.task.veterinary_clinic_management.service;


import com.task.veterinary_clinic_management.model.Appointment;
import com.task.veterinary_clinic_management.model.Patient;
import com.task.veterinary_clinic_management.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
     this.appointmentRepository = appointmentRepository;
    }

    public Appointment getAppointmentById(Long id){
        return appointmentRepository.getById(id);
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

     public void alertAppointment(Appointment appointment){
         Patient patient = appointment.getPatient();
         sendEmailNotification(patient,appointment);

     }
    private void sendEmailNotification(Patient patient, Appointment appointment) {


    }



}
