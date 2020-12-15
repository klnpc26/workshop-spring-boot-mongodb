package com.kaiqueLTDA.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kaiqueLTDA.workshopmongo.domain.Post;
import com.kaiqueLTDA.workshopmongo.domain.User;
import com.kaiqueLTDA.workshopmongo.repository.PostRepository;
import com.kaiqueLTDA.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
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
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar paara São Paulo, Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz hoje", maria);
		
		userRepository.save(Arrays.asList(maria, alex, bob));
		postRepository.save(Arrays.asList(post1, post2));
	}

}
