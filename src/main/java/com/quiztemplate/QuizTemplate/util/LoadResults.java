package com.quiztemplate.QuizTemplate.util;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;

import com.quiztemplate.QuizTemplate.model.User;

public class LoadResults {
 @SuppressWarnings({ "rawtypes", "unchecked" })
public static String generateReport(List<User> userList ) {
	 Collections.sort(userList,new User());
	 String csvLoction = "result.csv";
	 CSVWriter csvWriter = null;
	 BeanToCsv bc = new BeanToCsv();
	 try {
	 // find the winner
	 getWinner(userList);
	 csvWriter = new CSVWriter(new FileWriter(csvLoction));
	 ColumnPositionMappingStrategy mappingStrategy= new ColumnPositionMappingStrategy(); 
     mappingStrategy.setType(User.class);
     String[] columns = new String[]  
             { "id", "userId", "totalMarks", "assessmentId" ,"isCompleted" ,"timeTaken"};
     mappingStrategy.setColumnMapping(columns); 
     bc.write(mappingStrategy, csvWriter, userList);
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return "Report Generated";
 }

private static void getWinner(List<User> userList) {
	// TODO Auto-generated method stub
	List<Integer> userIdList= new ArrayList<>();
    String highestTotalMarks= userList.get(0).getTotalMarks();
    try {
    	userList.forEach(list -> {
    		if(list.getTotalMarks().equals(highestTotalMarks))
    			userIdList.add(Integer.parseInt(list.getUserId()));
    	});
    	int index = ThreadLocalRandom.current().nextInt(userIdList.size());
    	System.out.println("Winner is "+userIdList.get(index));
    }catch(Exception e) {
		 e.printStackTrace();
	 }
}
}
