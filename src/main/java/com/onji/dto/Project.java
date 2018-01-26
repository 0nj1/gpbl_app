package com.onji.dto;

import com.onji.enumration.EmployeeAssessment;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Project {
    private final String name;
    private final Integer totalTime;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final EmployeeAssessment employeeAssessment;
}
