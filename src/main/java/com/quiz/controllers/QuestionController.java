package com.quiz.controllers;


import com.quiz.repos.AnswerRepo;
import com.quiz.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/question")
public class QuestionController {
    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AnswerRepo answerRepo;

    @GetMapping(value = "/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("answers", answerRepo.findAll());
        model.addAttribute("question", questionRepo.findById(Integer.valueOf(id)));

        return "edit";
    }
}
