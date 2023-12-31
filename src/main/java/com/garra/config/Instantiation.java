package com.garra.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.garra.domain.Post;
import com.garra.domain.User;
import com.garra.dto.AuthorDTO;
import com.garra.dto.CommentDTO;
import com.garra.repository.PostRepository;
import com.garra.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.save(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu viagem","Vou viajar para São Paulo abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2023"), "Bom dia","Acordei feliz hoje",new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2023"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2023"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um utimo dia!", sdf.parse("23/03/2023"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.save(Arrays.asList(post1,post2));
		
		maria.getPost().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
	
	}

}
