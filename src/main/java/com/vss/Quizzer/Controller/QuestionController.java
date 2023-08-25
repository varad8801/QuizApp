package com.vss.Quizzer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vss.Quizzer.Service.QuestionService;
import com.vss.Quizzer.model.Question;

@RestController
@RequestMapping("question")
public class QuestionController 
{	
	@Autowired
	QuestionService Qs;
	
	

	@GetMapping("allQuestions")
	@ResponseBody
	public List<Question> getAllQuestions(){
		return Qs.getAllQuestions();
	}
	
	@GetMapping("category/{category}") 
	@ResponseBody
	public List<Question> getQuestionsByCategory(@PathVariable String category){
		return Qs.getQuestionsByCategory(category);
		
	}
	@PostMapping("add")
	public String addQuestion(@RequestBody Question question) {
		
		return Qs.addQuestion(question);
	}
	@PutMapping("update")
	public String updateQuestion(@RequestBody Question question) {
		return Qs.updateQuestion(question);
	}
	@PutMapping("delete")
	public String deleteQuestion(@RequestBody Question question) {
		return Qs.deleteQuestion(question);
	}
}
