package com.example.demo.modelos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    private boolean completed;

    @ManyToMany
    @JoinTable(
        name = "task_user",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Userx> users = new HashSet<>();
    
	public Task() {
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Set<Userx> getUsers() {
		return users;
	}

	public void setUsers(Set<Userx> users) {
		this.users = users;
	}
    
    
}
