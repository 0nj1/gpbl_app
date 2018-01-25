package com.onji.controller;

import com.onji.repository.SampleRepository;
import com.onji.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final SampleService sampleService;
    private final SampleRepository sampleRepository;

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("sample", sampleService.sample());
        sampleRepository.findAll().forEach(usersEntity -> {
            System.out.println(usersEntity.getId());
        });
        return "index";
    }
}
