package com.questions.QuestionService.services;

import com.questions.QuestionService.entities.QuestionEntity;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;

public interface QuestionService {

    public QuestionEntity addQuestion(QuestionEntity question);

    public QuestionEntity getQuestion(Long id);

    public List getQuestion();

    public List<QuestionEntity> getAllQuestionsOfQuiz(Long id);
}
