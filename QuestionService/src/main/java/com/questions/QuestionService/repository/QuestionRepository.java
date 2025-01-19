package com.questions.QuestionService.repository;

import com.questions.QuestionService.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

    public List<QuestionEntity> findByQuizId(Long quizId);

}
