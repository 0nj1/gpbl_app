package com.onji.controller;

import com.onji.repository.UserRepository;
import com.onji.repository.ActivityRepository;
import com.onji.repository.ProjectRepository;
import com.onji.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final SampleService sampleService;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final ProjectRepository projectRepository;

    @RequestMapping("/")
    String index(Model model) {
        return "index";
    }

    @RequestMapping("/new-project")
    String newProject(Model model) {
        return "new-project";
    }

    @RequestMapping("/project-info")
    String projectInfo(Model model) {
        return "project-info";
    }
}
