package com.garra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garra.domain.User;
import com.garra.dto.UserDTO;
import com.garra.repository.UserRepository;
import com.garra.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getId());
	}
}
	//A camada *Service* contém a lógica de negócios da aplicação e 
	//faz uso dos repositórios para acessar e manipular os dados.
	//Ela é anotada com @Service e geralmente injeta os repositórios
	//usando @Autowired