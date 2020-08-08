package com.shika.ecomerce.service;

import com.shika.ecomerce.model.Role;
import com.shika.ecomerce.model.User;
import com.shika.ecomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("USER NOT FOUND!");
        } else {
//            List<GrantedAuthority> authorities = this.getAuthorities(user.getRoles());
            return buildUserForAuthentication(user);
        }
    }

//    private List<GrantedAuthority> getAuthorities(Set<Role> userRoles) {
//        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//        for(Role role : userRoles) {
//            roles.add(new SimpleGrantedAuthority(role.getRole()));
//        }
//        List <GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        return grantedAuthorities;
//    }

    private UserDetails buildUserForAuthentication(User user) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities2("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities2(String role_user) {
        return Collections.singleton(new SimpleGrantedAuthority(role_user));
    }
}
