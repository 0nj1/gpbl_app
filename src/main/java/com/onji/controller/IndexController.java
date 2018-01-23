package com.onji.controller;

import com.onji.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final SampleService sampleService;

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("sample", sampleService.sample());
        return "index";
    }
}
