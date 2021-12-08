package com.example.demojwt.service;

import com.example.demojwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        com.example.demojwt.models.User user = userRepository.findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found With email: "+ username));

        return UserDetailsImpl.build(user);
    }
}
