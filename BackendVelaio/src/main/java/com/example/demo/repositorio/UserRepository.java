package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
