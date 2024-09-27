package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.modelos.Task;
import com.example.demo.modelos.Userx;
import com.example.demo.modelos.Skill;
import com.example.demo.repositorio.TaskRepository;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.repositorio.SkillRepository;


@RestController
@RequestMapping("/api/Ingresar")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillRepository skillRepository;
    
    

    
}
