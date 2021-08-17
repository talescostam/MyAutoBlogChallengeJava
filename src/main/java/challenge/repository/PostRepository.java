package challenge.repository;

import org.springframework.data.repository.CrudRepository;

import challenge.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
	
}
