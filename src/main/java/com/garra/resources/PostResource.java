package com.garra.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garra.domain.Post;
import com.garra.resources.util.URL;
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
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findBytitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text =URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}

	
}
// A camada *Resource* (ou *Controller*) é responsável por expor
// os endpoints da API e lidar com as requisições HTTP. Ela é
// anotada com @RestController e injeta os serviços usando
// @Autowired. Os métodos desta camada geralmente mapeiam as rotas
// da API usando anotações como @RequestMapping ou @GetMapping.