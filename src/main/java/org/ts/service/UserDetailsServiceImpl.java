package org.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.ts.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userDao;


    /**
     * Spring security method
     * @param username
     * @return UserDetails object
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        org.ts.model.User user = userDao.findByEmail(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user);

        UserDetails ud = buildUserForAuthentication(user, authorities);;
        return ud;


    }


    /**
     * Create user for auth
     * @param user user entity
     * @param authorities user roles
     * @return User entity
     */
    private User buildUserForAuthentication(org.ts.model.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getEmail(),
                user.getPassword(), true,
                true, true, true, authorities);
    }

    /**
     * Buld special object contains user roles
     * @param user user Entity
     * @return
     */
    private List<GrantedAuthority> buildUserAuthority(org.ts.model.User user) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
            setAuths.add(new SimpleGrantedAuthority(user.getRole().toString()));
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
}
