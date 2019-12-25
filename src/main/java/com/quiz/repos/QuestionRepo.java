package com.quiz.repos;

import com.quiz.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<Question, Integer> {
}
