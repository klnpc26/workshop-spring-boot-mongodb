package com.kaiqueLTDA.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiqueLTDA.workshopmongo.domain.Post;
import com.kaiqueLTDA.workshopmongo.repository.PostRepository;
import com.kaiqueLTDA.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll() {
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Post user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
}