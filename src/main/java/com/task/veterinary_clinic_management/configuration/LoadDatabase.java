package com.task.veterinary_clinic_management.configuration;

import com.task.veterinary_clinic_management.model.*;
import com.task.veterinary_clinic_management.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(DoctorRepository doctorRepository, PatientRepository patientRepository,
                                   ProductRepository productRepository) {

        return args -> {
            // Preload data for DoctorRepository
            doctorRepository.save(new Doctor("Dr. Smith", "Internal Medicine"));
            doctorRepository.save(new Doctor("Dr. Johnson", "Surgery"));
            doctorRepository.save(new Doctor("Dr. Lee", "Dermatology"));
            doctorRepository.save(new Doctor("Dr. Anderson", "Radiology"));

            // Preload data for PatientRepository
            patientRepository.save(new Patient("Fluffy", "Cat", "Persian", LocalDate.of(2019, 5, 15), "John Doe", "555-1234", "No major medical issues", "None", "Rabies, FVRCP"));
            patientRepository.save(new Patient("Buddy", "Dog", "Golden Retriever", LocalDate.of(2018, 10, 10), "Jane Smith", "555-5678", "Hip dysplasia", "Peanuts", "Rabies, DHPP"));
            patientRepository.save(new Patient("Max", "Dog", "Labrador Retriever", LocalDate.of(2017, 8, 20), "Sarah Johnson", "555-9876", "No major medical issues", "None", "Rabies, DHPP"));
            patientRepository.save(new Patient("Whiskers", "Cat", "Siamese", LocalDate.of(2020, 02, 12), "Michael Davis", "555-4321", "Asthma", "Fish", "Rabies, FVRCP"));

            // Preload data for ProductRepository
            productRepository.save(new Product("Medicine A", "For pain relief", 50, 10));
            productRepository.save(new Product("Medicine B", "Antibiotic", 30, 5));
            productRepository.save(new Product("Medicine C", "Antifungal", 20, 5));
            productRepository.save(new Product("Medicine D", "Anti-inflammatory", 15, 3));
        };
    }
}