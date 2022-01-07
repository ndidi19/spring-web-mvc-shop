package com.ndiaye.m2ishop.service.impl;

import com.ndiaye.m2ishop.model.Role;
import com.ndiaye.m2ishop.model.User;
import com.ndiaye.m2ishop.repository.RoleRepository;
import com.ndiaye.m2ishop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(email);

        if (u == null) {
            throw new UsernameNotFoundException("Invalid email or password");
        }
        List<GrantedAuthority> authorities = getUserAuthorities(u.getRoles());
        return buildUserForAuthentication(u, authorities);
    }

    private UserDetails buildUserForAuthentication(User u, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                u.getEmail(),
                u.getPassword(),
                authorities
        );
    }

    private List<GrantedAuthority> getUserAuthorities(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    public void saveUser(User user) {
        Role userRole = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
