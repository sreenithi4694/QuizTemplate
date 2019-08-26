package com.quiztemplate.QuizTemplate.model;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Comparator<User>{
    @Id
    @GeneratedValue
    private int id;
    private String userId="";
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String totalMarks="";
	private String assessmentId="";
	private boolean isCompleted=false;
	private int timeTaken;
	public int getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public String getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}
	@Override
	public int compare(User u1, User u2) {
		// TODO Auto-generated method stub
		int totalMarkCompate = u1.getTotalMarks().compareTo(u2.getTotalMarks()); 
        int timeCompare = u1.getTimeTaken() - u2.getTimeTaken(); 

        // 2-level comparison using if-else block 
        if (totalMarkCompate == 0) { 
            return ((totalMarkCompate == 0) ? totalMarkCompate : timeCompare); 
        } else { 
            return totalMarkCompate; 
        } 
	}
	
}
