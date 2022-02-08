package com.sample.repository;

import com.sample.entity.QuestionQuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionQuizRepository extends JpaRepository<QuestionQuizEntity,Long> {
    Optional<List<QuestionQuizEntity>> findAllByQuizId(Long quizId);
}
