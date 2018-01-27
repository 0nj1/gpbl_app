package com.onji.service;

import com.onji.enumration.EmployeeAssessment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeAssessmentService {
    EmployeeAssessment calculate() {
        return EmployeeAssessment.A;
    }
}
