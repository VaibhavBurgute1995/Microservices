package com.microservice.services;

import com.microservice.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz> findAll();

    Quiz getQuiz(Long id);
}
