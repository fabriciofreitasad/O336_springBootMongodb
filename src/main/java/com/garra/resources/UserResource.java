package com.garra.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garra.domain.User;
import com.garra.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
 	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
	//A camada *Resource* (ou *Controller*) é responsável por expor
	//os endpoints da API e lidar com as requisições HTTP. Ela é 
	//anotada com @RestController e injeta os serviços usando 
	//@Autowired. Os métodos desta camada geralmente mapeiam as rotas
	// da API usando anotações como  @RequestMapping ou @GetMapping.