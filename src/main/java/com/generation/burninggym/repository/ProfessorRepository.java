package com.generation.burninggym.repository;

import com.generation.burninggym.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
