package challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import challenge.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;
	
	// ...
}
