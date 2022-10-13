package challenge.controller;

import challenge.model.Post;
import challenge.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;

	@PostMapping("/posts")
	public ResponseEntity<Post> newPost(@Valid @RequestBody Post post) {

		Post posts = repository.save(post);

		return ResponseEntity.ok(posts);
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPost(@PathVariable long id){
		Optional<Post> postOptional = repository.findById(id);

		if(postOptional.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "post.not_found_error", null);
		}

		return ResponseEntity.ok(postOptional.get());

	}

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPosts(){

		List<Post> postList = (List<Post>) repository.findAll();

		if (postList.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "post.not_found_error", null);
		}

		return ResponseEntity.ok(postList);

	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> editPost(@RequestBody Post newPost, @PathVariable Long id){

		Optional<Post> postOptional = repository.findById(id);

		if(postOptional.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "post.not_found_error", null);
		}

		Post post = postOptional.get();
		post.setTitle(newPost.getTitle());
		post.setText(newPost.getText());
		Post save = repository.save(post);

		return ResponseEntity.ok(save);

	}

	@DeleteMapping("/posts")
	public ResponseEntity<Void> deletePost(@PathVariable long id){
		Optional<Post> postOptional = repository.findById(id);

		if(postOptional.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "post.not_found_error", null);
		}

		repository.deleteById(id);
		return ResponseEntity.noContent().build();

	}

}
