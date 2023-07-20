package com.task.veterinary_clinic_management.controller;

import com.task.veterinary_clinic_management.model.Appointment;
import com.task.veterinary_clinic_management.model.Product;
import com.task.veterinary_clinic_management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public String getAppointmentById(@PathVariable Long id, Model model){
       Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment",appointment);
        return "Appointment";
    }

    @PostMapping
    public void createAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.createAppointment(appointment);
    }

    @PostMapping("/alert")
    public void alertAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.alertAppointment(appointment);
    }
}
