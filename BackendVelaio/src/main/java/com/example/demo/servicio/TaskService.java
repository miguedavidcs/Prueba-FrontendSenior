package com.example.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.modelos.Task;
import com.example.demo.modelos.User;
import com.example.demo.modelos.Skill;
import com.example.demo.repositorio.TaskRepository;
import com.example.demo.repositorio.UserRepository;
import com.example.demo.repositorio.SkillRepository;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillRepository skillRepository;

    // Método para crear una tarea
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Método para listar tareas con paginación
    public Page<Task> listTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    // Método para obtener una tarea por ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

 // Método para asignar un usuario a una tarea
    public Task assignUserToTask(Long taskId, Long userId, User newUser) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));

        User user;
        
        
        Optional<User> existingUser = userRepository.findById(userId);
        
        if (existingUser.isPresent()) {
            
            user = existingUser.get();
        } else {
           
            user = newUser;
            userRepository.save(user); 
        }
        
        
        task.getUsers().add(user);
        return taskRepository.save(task);
    }

 // Método para asignar una habilidad a un usuario en una tarea
    public Task assignSkillToUserInTask(Long taskId, Long userId, Long skillId, User newUser) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found"));

        User user;

        // Intentar encontrar el usuario existente
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            // Si el usuario existe, lo asignamos
            user = existingUser.get();
        } else {
            // Si el usuario no existe, lo creamos
            user = newUser;
            userRepository.save(user); // Guardamos el nuevo usuario
        }

        // Buscamos la habilidad
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
        return taskRepository.save(task);
    }


    // Método para eliminar un usuario de una tarea
    public Task removeUserFromTask(Long taskId, Long userId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        task.getUsers().remove(user);
        return taskRepository.save(task);
    }

    // Método para eliminar una habilidad de un usuario en una tarea
    public Task removeSkillFromUserInTask(Long taskId, Long userId, Long skillId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found"));

        user.getSkills().remove(skill);
        task.getUsers().remove(user);
        return taskRepository.save(task);
    }

    // Otros métodos según sea necesario...
}
