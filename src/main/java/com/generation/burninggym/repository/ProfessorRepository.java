package com.generation.burninggym.repository;

import com.generation.burninggym.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    public List<Professor> findAllByNomeContainingIgnoreCase (@Param("nome") String nome);
}
