package com.garra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garra.domain.User;
import com.garra.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
	//A camada *Service* contém a lógica de negócios da aplicação e 
	//faz uso dos repositórios para acessar e manipular os dados.
	//Ela é anotada com @Service e geralmente injeta os repositórios
	//usando @Autowired