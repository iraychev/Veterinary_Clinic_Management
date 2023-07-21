package com.task.veterinary_clinic_management.service;

import com.task.veterinary_clinic_management.DTO.FinancialRecordDTO;
import com.task.veterinary_clinic_management.model.FinancialRecord;
import com.task.veterinary_clinic_management.repository.FinancialRecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinancialRecordService {
    private final FinancialRecordRepository financialRecordRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FinancialRecordService(FinancialRecordRepository financialRecordRepository, ModelMapper modelMapper) {
        this.financialRecordRepository = financialRecordRepository;
        this.modelMapper = modelMapper;
    }

    public List<FinancialRecordDTO> getAllFinancialRecords() {
        List<FinancialRecord> financialRecords = financialRecordRepository.findAll();
        return financialRecords.stream()
                .map(financialRecord -> modelMapper.map(financialRecord, FinancialRecordDTO.class))
                .collect(Collectors.toList());
    }

    public FinancialRecordDTO getFinancialRecordById(Long id) {
        FinancialRecord financialRecord = financialRecordRepository.getById(id);
        return modelMapper.map(financialRecord, FinancialRecordDTO.class);
    }

    public FinancialRecordDTO createFinancialRecord(FinancialRecordDTO financialRecordDTO) {
        FinancialRecord financialRecord = modelMapper.map(financialRecordDTO, FinancialRecord.class);
        financialRecord = financialRecordRepository.save(financialRecord);
        return modelMapper.map(financialRecord, FinancialRecordDTO.class);
    }

    public void deleteFinancialRecord(Long id) {
        financialRecordRepository.deleteById(id);
    }
}
