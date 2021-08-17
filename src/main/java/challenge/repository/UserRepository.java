package challenge.repository;

import org.springframework.data.repository.CrudRepository;

import challenge.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
	boolean existsByEmail(String email);
	
}
