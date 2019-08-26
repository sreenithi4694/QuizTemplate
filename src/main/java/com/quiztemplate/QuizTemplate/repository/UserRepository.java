package com.quiztemplate.QuizTemplate.repository;

import org.springframework.data.repository.CrudRepository;

import com.quiztemplate.QuizTemplate.model.User;

public interface UserRepository extends  CrudRepository<User, Integer>{

}
