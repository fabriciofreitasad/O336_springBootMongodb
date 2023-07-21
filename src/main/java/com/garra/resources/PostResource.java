package com.garra.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.garra.domain.Post;
import com.garra.domain.User;
import com.garra.dto.UserDTO;
import com.garra.services.PostService;

@RestController
@RequestMapping(value = "/users")
public class PostResource {

	@Autowired
	private PostService service;

	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	


	
}
// A camada *Resource* (ou *Controller*) é responsável por expor
// os endpoints da API e lidar com as requisições HTTP. Ela é
// anotada com @RestController e injeta os serviços usando
// @Autowired. Os métodos desta camada geralmente mapeiam as rotas
// da API usando anotações como @RequestMapping ou @GetMapping.