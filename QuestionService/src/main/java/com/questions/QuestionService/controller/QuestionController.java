package com.questions.QuestionService.controller;

import com.questions.QuestionService.entities.QuestionEntity;
import com.questions.QuestionService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public QuestionEntity createQuestion(@RequestBody QuestionEntity question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/{id}")
    public QuestionEntity getQuestionById(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping
    public List<QuestionEntity> getAllQuestions() {
        return questionService.getQuestion();
    }

    @GetMapping("/quiz/{quizId}")
    public List<QuestionEntity> getQuestionsOfQuiz(@PathVariable Long quizId) {
        return questionService.getAllQuestionsOfQuiz(quizId);
    }
}
