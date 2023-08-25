package com.vss.Quizzer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vss.Quizzer.model.Question;
import com.vss.Quizzer.Dao.QuestionDao;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao Qd;
	
	public List<Question> getAllQuestions() {
		
		// TODO Auto-generated method stub
		return Qd.findAll();
	}

	public List<Question> getQuestionsByCategory(String category) {
		return Qd.findByCategory(category);
		
	}

	public String addQuestion(Question question) {
		Qd.save(question);
		return "Added";
	}

	public String updateQuestion(Question question) {
		Qd.save(question);
		return "Updated";
	}

	public String deleteQuestion(Question question) {
		Qd.delete(question);
		return "Deleted";
	}

}
