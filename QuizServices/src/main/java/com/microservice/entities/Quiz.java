package com.microservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    transient private List<Question> questionList;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Quiz(long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return id == quiz.id && Objects.equals(title, quiz.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    public Quiz() {
    }
}
