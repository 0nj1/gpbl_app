package com.onji.dto;

import lombok.Value;

import java.util.List;

@Value
public class Employee {
    private final String name;
    private final Integer age;
    private final Integer totalTime;
    private final String location;
    private final List<Project> projects;
}
