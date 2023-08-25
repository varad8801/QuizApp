package com.vss.Quizzer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vss.Quizzer.Dao.QuestionDao;
import com.vss.Quizzer.Dao.QuizDao;
import com.vss.Quizzer.model.Question;
import com.vss.Quizzer.model.QuestionWrapper;
import com.vss.Quizzer.model.Quiz;
import com.vss.Quizzer.model.Response;


@Service
public class QuizService {
	@Autowired
	QuizDao QuizD;
	@Autowired
	QuestionDao Qd;
	
	
	

	public ResponseEntity<String> craeteQuiz(String category, int numQ, String title) {
		
		List<Question> questions= Qd.findRandomQuestionsByCategory(category,numQ);
		Quiz quiz=new Quiz();
		
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		QuizD.save(quiz);
		return  new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}




	public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
		Optional <Quiz> quiz=QuizD.findById(id);
		List<Question> questionsFromDB=quiz.get().getQuestion();
		List<QuestionWrapper> questionsforUser=new ArrayList<>();
		for(Question q:questionsFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(),q.getOption4());
			questionsforUser.add(qw);
		}
		return new ResponseEntity<>(questionsforUser, HttpStatus.OK);
	}




	public ResponseEntity<Integer> calculateScore(Integer id, List<Response> responses) {
		Quiz quiz=QuizD.findById(id).get();
		int correct=0;
		int i=0;
		List<Question> questions=quiz.getQuestion();
		for(Response response:responses) {
			
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				correct++;
			
			
			i++;
		}
		return new ResponseEntity<>(correct, HttpStatus.OK);
	}
}
