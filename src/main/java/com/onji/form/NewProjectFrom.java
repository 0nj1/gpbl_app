package com.onji.form;

import lombok.Data;

import java.util.List;

@Data
public class NewProjectFrom {
    private String projectName;
    private String startDate;
    private String endDate;
    private List<Integer> employees;
    private List<String> roles;
}
