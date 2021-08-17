package challenge.security;

import org.springframework.security.core.Authentication;

import challenge.model.User;

public interface IAuthenticationFacade {
	
	Authentication getAuthentication();
	
	User getUser();
	
}
