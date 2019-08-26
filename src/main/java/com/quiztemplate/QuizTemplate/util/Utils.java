package com.quiztemplate.QuizTemplate.util;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Utils {

	public static JSONObject getJSONObject(File file) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		try {
			 Object obj = parser.parse(new FileReader("quiz.json"));
			 jsonObj = (JSONObject) obj;
		}catch(Exception e) {
			
		}
		return jsonObj;
	}
}
