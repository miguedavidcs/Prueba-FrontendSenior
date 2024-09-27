package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.Userx;

public interface UserRepository extends JpaRepository<Userx, Long> {

}
