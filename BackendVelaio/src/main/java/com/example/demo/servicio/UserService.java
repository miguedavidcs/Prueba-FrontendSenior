package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.modelos.Userx;
import com.example.demo.repositorio.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Userx saveUser(Userx user) {
        return userRepository.save(user);
    }

    public List<Userx> getAllUsers() {
        return userRepository.findAll();
    }
}