package taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taxi.dao.OperatorDao;
import taxi.domain.Operator;
import taxi.exception.AuthenticationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private OperatorDao operatorDao;

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    public void setOperatorDao(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public AuthenticationServiceImpl() {
    }

    public AuthenticationServiceImpl(OperatorDao operatorDao) {
        this.operatorDao = operatorDao;
    }

    public Operator authenticate(String login, String pass) throws AuthenticationException, IllegalArgumentException {
        if (login == null || login.length() == 0 || pass == null || pass.length() == 0) {
            throw new IllegalArgumentException();
        }
        Operator operator = operatorDao.findByName(login);
        if (operator != null && operator.getPassword().equals(pass)) {
            return operator;
        } else {
            throw new AuthenticationException();
        }
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        try {
            Operator operator = operatorDao.findByName(userName);

            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = !operator.checkRequisites();
            boolean accountNonLocked = !operator.checkRequisites();

            return new User(
                    operator.getLogin(),
                    operator.getPassword().toLowerCase(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(operator.getStatus().toString()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    private List<String> getRoles(String role) {
        List<String> roles = new ArrayList<String>();
        if (role.equals("ADMIN")) {
            roles.add("USER");
            roles.add("ADMIN");
        } else if (role.equals("USER")) {
            roles.add("USER");
        }
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
