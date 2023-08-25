package com.vss.Quizzer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vss.Quizzer.Service.QuizService;
import com.vss.Quizzer.model.QuestionWrapper;
import com.vss.Quizzer.model.Response;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService Quizs;
	
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, int numQ,String title){
		return Quizs.craeteQuiz(category,numQ,title);
	}
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>>getQuiz(@PathVariable int id){
		return Quizs.getQuiz(id);
		
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
		return Quizs.calculateScore(id,responses);
	}
}
