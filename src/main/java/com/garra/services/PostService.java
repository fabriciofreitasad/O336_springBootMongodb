package com.garra.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garra.domain.Post;
import com.garra.repository.PostRepository;
import com.garra.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

	public List<Post> fullSearch(String tex, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(tex, minDate, maxDate);
	}

}

// A camada *Service* contém a lógica de negócios da aplicação e
// faz uso dos repositórios para acessar e manipular os dados.
// Ela é anotada com @Service e geralmente injeta os repositórios
// usando @Autowired