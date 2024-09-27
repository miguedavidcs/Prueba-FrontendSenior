package com.example.demo.dto;

import com.example.demo.modelos.Skill;
import com.example.demo.modelos.Task;
import com.example.demo.modelos.Userx;

public class InDtoIngresarDatos {

    private Userx nuevousuario;
    private Task nuevotask;
    private Skill nuevoskill;

    
    public InDtoIngresarDatos(Userx nuevousuario, Task nuevotask, Skill nuevoskill) {
        this.nuevousuario = nuevousuario;
        this.nuevotask = nuevotask;
        this.nuevoskill = nuevoskill;
    }

    
    public InDtoIngresarDatos() {
		super();
	}


	public Userx getNuevousuario() {
        return nuevousuario;
    }

    public void setNuevousuario(Userx nuevousuario) {
        this.nuevousuario = nuevousuario;
    }

    public Task getNuevotask() {
        return nuevotask;
    }

    public void setNuevotask(Task nuevotask) {
        this.nuevotask = nuevotask;
    }

    public Skill getNuevoskill() {
        return nuevoskill;
    }

    public void setNuevoskill(Skill nuevoskill) {
        this.nuevoskill = nuevoskill;
    }
}
