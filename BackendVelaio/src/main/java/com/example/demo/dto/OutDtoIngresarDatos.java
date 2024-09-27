package com.example.demo.dto;

import com.example.demo.modelos.Skill;
import com.example.demo.modelos.Task;
import com.example.demo.modelos.Userx;

public class OutDtoIngresarDatos {
	private Userx usuario;
    private Task task;
    private Skill skill;
    public OutDtoIngresarDatos(Userx usuario, Task task, Skill skill) {
        this.usuario = usuario;
        this.task = task;
        this.skill = skill;
    }
    public OutDtoIngresarDatos() {
    	
    }
	public Userx getUsuario() {
		return usuario;
	}
	public void setUsuario(Userx usuario) {
		this.usuario = usuario;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
    
}
