package com.quiz.controllers;

import com.quiz.models.Question;
import com.quiz.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private QuestionRepo questionRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("questions", questionRepo.findAll());

        return "home";
    }

    @PostMapping("/")
    public String add(@RequestParam String name, @RequestParam String text, @RequestParam String step, @RequestParam int score, Map<String, Object> model) {
        Question question = new Question(name, text, step, score);

        questionRepo.save(question);

        // Чтобы после отправки формы сразу в листе был добавленный вопрос
        model.put("questions", questionRepo.findAll());

        return "home";
    }
}
