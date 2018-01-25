package com.onji.controller;

import com.onji.form.ProjectMemberForm;
import com.onji.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProjectMemberService projectMemberService;

    @GetMapping("/")
    String newProject(Model model) {
        return "new-project";
    }

    @PostMapping("/index")
    String index(@ModelAttribute ProjectMemberForm memberForm, Model model) {
        return "index";
    }

    @GetMapping("/project-info")
    String projectInfo(Model model) {
        return "project-info";
    }
}
