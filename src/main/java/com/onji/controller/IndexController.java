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
        model.addAttribute("sample", sampleService.sample());
        userRepository.findAll().forEach(usersEntity -> {
            System.out.println(usersEntity.getId());
        });
        //projectRepository.findAll().forEach(e -> System.out.println(e.getId()));
        System.out.println(projectRepository.findOne(90).getUser().getMemberCode());

        return "index";
    }
}
