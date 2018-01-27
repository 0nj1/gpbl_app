package com.onji.controller;

import com.onji.dto.Employee;
import com.onji.form.ProjectMemberForm;
import com.onji.repository.RoleRepository;
import com.onji.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProjectMemberService projectMemberService;
    private final RoleRepository roleRepository;

    @GetMapping("/")
    String newProject(Model model) {
        return "new-project";
    }

    @PostMapping("/index")
    String index(@Validated ProjectMemberForm memberForm, Model model) {
        List<Employee> employees = projectMemberService.searchEmployees(memberForm);
        model.addAttribute("employees", employees);
        model.addAttribute("roles", roleRepository.findAll());

        return "index";
    }

    @GetMapping("/project-info")
    String projectInfo(Model model) {
        return "project-info";
    }
}
