package com.application.springSecurity.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author mojib.haider
 * @since 5/6/25
 */
public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users;

    public InMemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return null;
    }
}
