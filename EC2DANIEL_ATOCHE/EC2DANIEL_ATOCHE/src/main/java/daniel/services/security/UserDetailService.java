package daniel.services.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if( "usuario1".equals(username)) {
			return new User("usuario1", "123", new ArrayList<>());
		}else if( "usuario2".equals(username)){
			return new User("usuario2", "1904", new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("Usuario no existe " + username);
		}
	}

}
