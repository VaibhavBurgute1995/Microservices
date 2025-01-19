package com.questions.QuestionService.impl;

import com.questions.QuestionService.entities.QuestionEntity;
import com.questions.QuestionService.repository.QuestionRepository;
import com.questions.QuestionService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public QuestionEntity addQuestion(QuestionEntity question) {
        return questionRepository.save(question);
    }

    @Override
    public QuestionEntity getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List getQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<QuestionEntity> getAllQuestionsOfQuiz(Long id)
    {
        return questionRepository.findByQuizId(id);
    }
}
