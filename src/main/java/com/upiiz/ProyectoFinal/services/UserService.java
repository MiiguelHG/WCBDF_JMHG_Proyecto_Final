package com.upiiz.ProyectoFinal.services;

import com.upiiz.ProyectoFinal.entities.UserEntity;
import com.upiiz.ProyectoFinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
