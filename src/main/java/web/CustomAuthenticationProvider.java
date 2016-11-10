package web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import web.repositories.UserRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;
	
    public CustomAuthenticationProvider() {
        super();
    }
   
    // API

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        web.models.User u =userRepository.findUserByPhoneNumber(name);
        if (u==null) return null;
        String p=u.getPassword();
        if (password.equals(p)) {
            final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            if (u.getPhoneNumber().equals("admin")) grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            final UserDetails principal = new User(name, password, grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
            return auth;
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        //return authentication.equals(UsernamePasswordAuthenticationToken.class);
    	return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}