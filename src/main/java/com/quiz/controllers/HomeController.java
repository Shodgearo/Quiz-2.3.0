package com.quiz.controllers;

import com.quiz.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private QuestionRepo questionRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("questions", questionRepo.findAll());

        return "home";
    }



}
