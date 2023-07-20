package com.task.veterinary_clinic_management.controller;


import com.task.veterinary_clinic_management.model.Doctor;
import com.task.veterinary_clinic_management.model.Patient;
import com.task.veterinary_clinic_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public String getPatientById(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "Patient";
    }
    @GetMapping
    public String getAllPatient(Model model) {
        List<Patient> patients = patientService.getAllPatient();
        model.addAttribute("patients", patients);
        return "Patients";
    }


    @PostMapping
    public void createPatient(@ModelAttribute Patient patient) {
        patientService.createPatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
