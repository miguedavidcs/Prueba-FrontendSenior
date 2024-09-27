package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.modelos.Task;
import com.example.demo.modelos.User;
import com.example.demo.modelos.Skill;
import com.example.demo.repositorio.TaskRepository;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.repositorio.SkillRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillRepository skillRepository;

    // Crear nueva tarea
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(savedTask);
    }

    // Listar tareas
    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        List<Task> tasks = taskRepository.findAll();
        return ResponseEntity.ok(tasks);
    }

    // Asignar usuario a una tarea
    @PostMapping("/{taskId}/users")
    public ResponseEntity<Task> assignUserToTask(@PathVariable Long taskId, @RequestParam Long userId, @RequestBody User newUser) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));

        User user;

        // Intentar encontrar el usuario existente
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            user = existingUser.get();
        } else {
            user = newUser;
            userRepository.save(user); // Guardamos el nuevo usuario
        }

        task.getUsers().add(user);
        Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    // Asignar habilidad a un usuario en una tarea
    @PostMapping("/{taskId}/users/{userId}/skills")
    public ResponseEntity<Task> assignSkillToUserInTask(@PathVariable Long taskId, @PathVariable Long userId, @PathVariable Long skillId, @RequestBody User newUser) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));

        User user;

        // Intentar encontrar el usuario existente
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            user = existingUser.get();
        } else {
            user = newUser;
            userRepository.save(user); // Guardamos el nuevo usuario
        }

        Skill skill = skillRepository.findById(skillId)
            .orElseThrow(() -> new RuntimeException("Skill not found"));

        // Agregamos la habilidad al usuario si no ya la tiene
        if (!user.getSkills().contains(skill)) {
            user.getSkills().add(skill);
        }

        // Aseguramos que el usuario esté en la tarea
        if (!task.getUsers().contains(user)) {
            task.getUsers().add(user);
        }

        // Guardamos la tarea
        Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    // Marcar tarea como completada
    @PutMapping("/{taskId}/complete")
    public ResponseEntity<Task> completeTask(@PathVariable Long taskId) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(true); // Suponiendo que hay un atributo 'completed' en Task
        Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    // Filtrar tareas por estado
    @GetMapping("/filter")
    public ResponseEntity<List<Task>> filterTasks(@RequestParam Boolean completed) {
        List<Task> tasks = taskRepository.findByCompleted(completed); // Método que debes definir en el repositorio
        return ResponseEntity.ok(tasks);
    }
}
