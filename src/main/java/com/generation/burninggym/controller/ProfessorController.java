package com.generation.burninggym.controller;

import com.generation.burninggym.model.Professor;
import com.generation.burninggym.repository.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public ResponseEntity<List<Professor>> getAll() {
        return ResponseEntity.ok(professorRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getById(@PathVariable Long id) {
        return professorRepository.findById(id)
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado"));
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Professor>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(professorRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Professor> post(@Valid @RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorRepository.save(professor));
    }

    @PutMapping
    public ResponseEntity<Professor> put(@Valid @RequestBody Professor professor) {
        return professorRepository.findById(professor.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(professorRepository.save(professor)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado"));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        if (professor.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Esse professor não existe");
        professorRepository.deleteById(id);
    }



}
