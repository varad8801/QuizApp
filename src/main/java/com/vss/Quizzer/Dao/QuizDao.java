package com.vss.Quizzer.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vss.Quizzer.model.Quiz;
@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
