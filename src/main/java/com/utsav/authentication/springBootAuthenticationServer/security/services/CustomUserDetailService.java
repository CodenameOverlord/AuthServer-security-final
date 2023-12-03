package com.utsav.authentication.springBootAuthenticationServer.security.services;

import com.utsav.authentication.springBootAuthenticationServer.models.User;
import com.utsav.authentication.springBootAuthenticationServer.repositories.UserRepository;
import com.utsav.authentication.springBootAuthenticationServer.security.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional  = userRepository.findByEmail(username);
        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException("user with entered email is not found");
        }
        return new CustomUserDetails(userOptional.get()) ;
    }
}
