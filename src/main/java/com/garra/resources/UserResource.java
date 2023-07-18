package com.garra.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garra.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "maria", "maria@gmail.com");
		User fabricio = new User("1", "fabricio", "fabricio@Gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, fabricio));
		return ResponseEntity.ok().body(list);
	}

}
