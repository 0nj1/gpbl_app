package com.onji.controller;

import com.onji.dto.Employee;
import com.onji.dto.Project;
import com.onji.entity.User;
import com.onji.form.NewProjectFrom;
import com.onji.form.ProjectMemberForm;
import com.onji.repository.RoleRepository;
import com.onji.repository.UserRepository;
import com.onji.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProjectMemberService projectMemberService;
    private final UserRepository userRepository;

    @GetMapping("/")
    String newProject(Model model) {
        return "new-project";
    }

    @PostMapping("/index")
    String index(@Validated ProjectMemberForm memberForm, Model model) {
        List<Employee> employees = projectMemberService.searchEmployees(memberForm.getRole());
        model.addAttribute("employees", employees);
        model.addAttribute("roles", memberForm.getRoles());
        model.addAttribute("numbers", memberForm.getNumbers());
        model.addAttribute("role", memberForm.getRole());

        Employee employee;
        if (memberForm.getEmployeeId().equals(0)) {
            employee = new Employee(0, "None", 0, 0, "None", Collections.emptyList());
        } else {
            List<Employee> emp = employees.stream()
                    .filter(e -> Objects.equals(e.getId(), memberForm.getEmployeeId()))
                    .collect(Collectors.toList());
            if (emp.size() == 1) {
                employee = emp.get(0);
            } else {
                employee = new Employee(0, "None", 0, 0, "None", Collections.emptyList());
            }
        }
        model.addAttribute("employee", employee);
        if (memberForm.getSelectedEmployees() != null) {
            ArrayList<Employee> employees1 = new ArrayList();
            for (int i=0; i< memberForm.getSelectedEmployees().size(); i++) {
                Integer employeeId = memberForm.getSelectedEmployees().get(i);
                String role = memberForm.getSelectedEmployeeRoles().get(i);
                User user = userRepository.findOne(employeeId);
                if (user == null) {
                    continue;
                }
                employees1.add(new Employee(employeeId, user.getUserName(), 0,0, role, Collections.emptyList()));
            }
            model.addAttribute("selectedEmployees", employees1);
        } else {
            model.addAttribute("selectedEmployees", Collections.emptyList());
        }
        return "index";
    }

    @PostMapping("/project-info")
    String projectInfo(@Validated NewProjectFrom newProjectFrom, Model model) {
        ArrayList<Employee> employees =  new ArrayList<>();
        for (int i=0; i<newProjectFrom.getEmployees().size(); i++) {
            User user =  userRepository.findOne(newProjectFrom.getEmployees().get(i));
            employees.add(new Employee(user.getId(), user.getUserName(), 0, 0, newProjectFrom.getRoles().get(i), Collections.emptyList()));
        }

        model.addAttribute("project", newProjectFrom);
        model.addAttribute("employees", employees);
        return "project-info";
    }
}
