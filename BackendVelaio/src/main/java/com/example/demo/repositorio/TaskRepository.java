package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.modelos.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
	Page<Task> findAll(Pageable pageable);

	List<Task> findByCompleted(Boolean completed);
}
