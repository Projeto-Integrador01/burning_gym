package com.generation.burninggym.repository;

import com.generation.burninggym.model.Aula;
import com.generation.burninggym.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    public List<Aula> findAllByTipoAulaContainingIgnoreCase (@Param("tipoAula") String tipoAula);
}
