package com.example.demo.modelos;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "skills")
    private Set<Userx> users = new HashSet<>();
    
	public Skill() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Userx> getUsers() {
		return users;
	}

	public void setUsers(Set<Userx> users) {
		this.users = users;
	}
    
}
