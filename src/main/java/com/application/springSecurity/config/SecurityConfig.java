package com.application.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

/**
 * @author mojib.haider
 * @since 5/4/25
 */
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = new com.application.springSecurity.config.User("haider", "pass", "read");

        return new InMemoryUserDetailsService(List.of(user));
    }

//    No need for this bean as CustomAuthenticationProvider have been used
//    @Bean
//    public UserDetailsService userDetailsService(){
//        var user = User.withUsername("haider")
//                .password("pass")
//                .authorities("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
            return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.httpBasic(Customizer.withDefaults());
//
//        httpSecurity.authenticationProvider(customAuthenticationProvider);
//
//        httpSecurity.authorizeHttpRequests(req -> req.anyRequest().authenticated());
//
//        return httpSecurity.build();
//    }


}
