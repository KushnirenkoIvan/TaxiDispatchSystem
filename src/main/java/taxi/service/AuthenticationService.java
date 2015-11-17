package taxi.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import taxi.domain.Operator;
import taxi.exception.AuthenticationException;

public interface AuthenticationService extends UserDetailsService {
    Operator authenticate(String login, String pass) throws AuthenticationException, IllegalArgumentException;
}
