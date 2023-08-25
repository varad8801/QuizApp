package com.vss.Quizzer.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vss.Quizzer.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>
{
	List<Question> findByCategory(String category);
	@Query(value = "Select * from question q Where q.category=:category ORDER BY Random() LIMIT :numQ", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int  numQ);
	
	
}
