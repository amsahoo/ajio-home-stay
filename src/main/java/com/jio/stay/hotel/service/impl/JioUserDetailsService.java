package com.jio.stay.hotel.service.impl;

import com.jio.stay.hotel.domain.UserEntity;
import com.jio.stay.hotel.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JioUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> fetchedUser = userRepo.findById(userName);
        return new User(fetchedUser.get().getUserId(),fetchedUser.get().getPassword(), new ArrayList<>());
    }




}
