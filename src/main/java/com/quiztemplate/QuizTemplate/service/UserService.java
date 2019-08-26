package com.quiztemplate.QuizTemplate.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiztemplate.QuizTemplate.model.User;
import com.quiztemplate.QuizTemplate.repository.UserRepository;
import com.quiztemplate.QuizTemplate.util.LoadResults;
import com.quiztemplate.QuizTemplate.util.Utils;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	private String response="";
	public String validateUser(String userId) {
		List<User> userData=null;
		User user=new User();
		try {
			userData=(List<User>) userRepository.findAll();
			if(userData.size() > 0) {
				userData.forEach(list  ->{
					String tempId=list.getUserId()==null?"":list.getUserId();
					if(tempId.equals(userId)) {
						callMethod(list);
					}	
				});
			}
			else if (userData.isEmpty()) {
				user.setAssessmentId("123");
				user.setCompleted(false);
				user.setUserId(userId);
				userRepository.save(user);
				response = "Please proceed";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	
	public JSONObject loadQuiz() {
		return Utils.getJSONObject(new File("quizQuestion.json"));
	}
	
	
	
	public void submitQuiz(String userId,JSONObject quizResponse) {
		Optional<User> userData=null;
		User user=new User();
		try {
			userData=userRepository.findById(Integer.parseInt(userId));
			if(userData.isPresent()) {
				user=userData.get();
				user.setCompleted(true);
				user.setTotalMarks(quizResponse.get("totalMarks")==null?"":quizResponse.get("totalMarks").toString());
				userRepository.save(user);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getResults")
	public String getResults() {
		String response="";
		List<User> userList = (List<User>) userRepository.findAll();
		LoadResults.generateReport(userList);
		return response;
	}
	
	private void callMethod(User list) {
		if(list.isCompleted())
			response = "User Doesnot Exists";
		else if (!list.isCompleted())
			response = "Please proceed";
			
	}
}
