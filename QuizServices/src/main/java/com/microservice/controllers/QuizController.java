package com.microservice.controllers;

import com.microservice.entities.Quiz;
import com.microservice.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz requestBody){
        System.out.println(requestBody);
        return quizService.add(requestBody);
    }

    @GetMapping
    public List get(){
        return quizService.findAll();
    }

    @GetMapping("/{id}")
    public Quiz findAll(@PathVariable Long id){
        return quizService.getQuiz(id);
    }

}
