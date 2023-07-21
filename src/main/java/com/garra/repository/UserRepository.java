package com.garra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.garra.domain.User;


public interface UserRepository extends MongoRepository<User, String> {


		
		//A camada *Repository* é responsável por acessar os dados e 
		//realizar operações de persistência. Ela é implementada usando 
		//interfaces que estendem JpaRepository ou outro repositório do 
		//Spring Data
		
		

	
}
