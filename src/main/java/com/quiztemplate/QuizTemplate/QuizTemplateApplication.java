package com.quiztemplate.QuizTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.quiztemplate.QuizTemplate")
@EntityScan("com.quiztemplate.QuizTemplate")
public class QuizTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizTemplateApplication.class, args);
	}

}
