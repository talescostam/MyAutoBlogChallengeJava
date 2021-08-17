package challenge.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import challenge.model.User;


@Component
public class AuthenticationFacade implements IAuthenticationFacade {
	
	@Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
	
	@Override
	public User getUser() {
		SecUserDetails secUerDetails = (SecUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return secUerDetails.getUser();
	}
	
}
