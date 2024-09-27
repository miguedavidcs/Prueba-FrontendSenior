package com.example.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.modelos.Task;

import com.example.demo.modelos.Userx;
import com.example.demo.dto.InDtoIngresarDatos;
import com.example.demo.dto.OutDtoIngresarDatos;
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

    public OutDtoIngresarDatos saveData(InDtoIngresarDatos input) {
    	Task task = input.getNuevotask();
        Userx user = input.getNuevousuario();
        Skill skill = input.getNuevoskill();
     
        task = saveOrUpdateTask(task);

        
        user = assignUserToTask(task, user);

        
        skill = assignSkillToUser(user, skill);
        
        return new OutDtoIngresarDatos(user, task, skill);
    }

	private Skill assignSkillToUser(Userx user, Skill skill) {
		
		return null;
	}

	private Userx assignUserToTask(Task task, Userx user) {
		Optional<Userx> existingUser = userRepository.findById(user.getId());
		if(existingUser.isPresent()) {
			user = existingUser.get();
		}else {
			user = userRepository.save(user);
		}
		if (!task.getUsers().contains(user)) {
			task.getUsers().add(user);
		}
		return null;
	}

	private Task saveOrUpdateTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}
}
