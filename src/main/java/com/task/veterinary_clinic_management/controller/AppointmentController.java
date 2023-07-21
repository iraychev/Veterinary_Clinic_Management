package com.task.veterinary_clinic_management.controller;

import com.task.veterinary_clinic_management.DTO.AppointmentDTO;
import com.task.veterinary_clinic_management.model.Appointment;
import com.task.veterinary_clinic_management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
        AppointmentDTO appointmentDTO = appointmentService.getAppointmentById(id);
        if (appointmentDTO != null) {
            return ResponseEntity.ok(appointmentDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDTO);
    }

    @PostMapping("/alert")
    public void alertAppointment(@RequestBody Appointment appointment) {
        appointmentService.alertAppointment(appointment);
    }
}
