package com.onji.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProjectMemberForm {
    @NotNull
    @Size(min = 1)
    private List<String> roles;

    @NotNull
    @Size(min = 1)
    private List<Integer> numbers;

    @NotNull
    private String role;

    @NotNull
    private Integer employeeId;

    private List<Integer> selectedEmployees;
    private List<String> selectedEmployeeRoles;
}
