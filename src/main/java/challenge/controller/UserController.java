package challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import challenge.model.User;
import challenge.repository.UserRepository;
import challenge.security.IAuthenticationFacade;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
    IAuthenticationFacade authenticationFacade;
	
	@PostMapping("/users")
	public User newUser(@Valid @RequestBody User user) {
		return repository.save(user);
		
	}

	@GetMapping("/users/logged")
	public User loggedUser() {
		return authenticationFacade.getUser();
	
	}
}
