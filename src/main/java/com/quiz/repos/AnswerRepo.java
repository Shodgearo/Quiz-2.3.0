package com.quiz.repos;

import com.quiz.models.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepo extends CrudRepository<Answer, Integer> {
}
