package com.microservice.entities;

public class Question {


    private Long questionId;
    private String question;
    private Long quizId;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long id) {
        this.questionId = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Question(Long id, String question,Long quizId) {
        this.questionId = id;
        this.question = question;
        this.quizId = quizId;
    }

    public Question() {
    }
}
