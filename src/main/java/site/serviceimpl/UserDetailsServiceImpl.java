package site.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import site.dao.UserDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 14.9.23.
 */
@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("UserDAO")
    private UserDAO userDAO;


    @Override
    public UserDetails loadUserByUsername(String s) {
        UserDetails userDetails = null;
        site.entity.User user = null;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        try {
            user = userDAO.getUser(s);
            authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
            userDetails = new User(s, user.getPassword(), true, true, true, true, authorities);
        } catch (SQLException e) {
        }
        return userDetails;
    }
}
