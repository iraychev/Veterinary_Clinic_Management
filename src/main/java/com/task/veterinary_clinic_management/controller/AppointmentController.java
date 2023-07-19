package com.task.veterinary_clinic_management.controller;

import com.task.veterinary_clinic_management.model.Appointment;
import com.task.veterinary_clinic_management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public void createAppointment(@RequestBody Appointment appointment) {
        appointmentService.createAppointment(appointment);
    }

    @PostMapping("/alert")
    public void alertAppointment(@RequestBody Appointment appointment) {
        appointmentService.alertAppointment(appointment);
    }
}
