package com.garra.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.garra.domain.Post;
import com.garra.domain.User;


public interface PostRepository extends MongoRepository<User, String> {

	void save(List<Post> asList);


		
		//A camada *Repository* é responsável por acessar os dados e 
		//realizar operações de persistência. Ela é implementada usando 
		//interfaces que estendem JpaRepository ou outro repositório do 
		//Spring Data
		
		

	
}