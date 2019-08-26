package com.quiztemplate.QuizTemplate.controller;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quiztemplate.QuizTemplate.service.UserService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/validateUser/{userId}",method=RequestMethod.GET)
	public String validateUser(@PathVariable("userId")String userId) {
		return userService.validateUser(userId);
	}
	
	@RequestMapping(value="/loadQuiz",method=RequestMethod.GET)
	public JSONObject loadQuiz() {
		return userService.loadQuiz();
	}
	
	
	@RequestMapping(value="/submitQuiz/{userId}",method=RequestMethod.POST)
	public void submitQuiz(@PathVariable("userId")String userId,@RequestBody JSONObject quizResponse) {
		userService.submitQuiz(userId,quizResponse);
	}
	
	@RequestMapping(value="/getResults")
	public String getResults() {
		return userService.getResults();
	}
}
