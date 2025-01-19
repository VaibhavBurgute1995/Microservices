package com.microservice.impl;

import com.microservice.entities.Question;
import com.microservice.entities.Quiz;
import com.microservice.repository.QuizRepository;
import com.microservice.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    RestTemplate restTemplate;

    private final String questionServiceUrl = "http://localhost:8082/question/quiz/";


    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> updatedQuizzes = quizzes.stream().map(quiz -> {
            List<Question> questions = getQuestionsForQuiz(quiz.getId());
            quiz.setQuestionList(questions);  // Set the questions to the quiz
            return quiz;
        }).collect(Collectors.toList());
        return updatedQuizzes;
    }

    @Override
    public Quiz getQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
        List<Question> questions = getQuestionsForQuiz(quiz.getId());
        quiz.setQuestionList(questions);  // Set the questions to the quiz
        return quiz;
    }

    private List<Question> getQuestionsForQuiz(Long quizId) {
        String url = UriComponentsBuilder.fromHttpUrl(questionServiceUrl)
                .pathSegment(quizId.toString())
                .toUriString();
        Question[] questionsArray = restTemplate.getForObject(url, Question[].class);
        return questionsArray != null ? List.of(questionsArray) : List.of();
    }
}
