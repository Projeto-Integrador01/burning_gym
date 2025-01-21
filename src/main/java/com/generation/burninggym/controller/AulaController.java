package com.generation.burninggym.controller;

import com.generation.burninggym.model.Aluno;
import com.generation.burninggym.model.Aula;
import com.generation.burninggym.repository.AlunoRepository;
import com.generation.burninggym.repository.AulaRepository;
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
@RequestMapping ("/aula")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class AulaController {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public ResponseEntity<List<Aula>> getAll() {
        return ResponseEntity.ok(aulaRepository.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Aula> getById(@PathVariable Long id) {
        return aulaRepository.findById(id)
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @GetMapping("/tipo/{tipoAula}")
    public ResponseEntity <List<Aula>> findAllByTipoContainingIgnoreCase(@PathVariable String tipoAula) {
        return ResponseEntity.ok(aulaRepository.findAllByTipoAulaContainingIgnoreCase(tipoAula));
    }

    @PostMapping
    public ResponseEntity<Aula> post (@Valid @RequestBody Aula aula) {
        if (professorRepository.existsById(aula.getProfessor().getId()))
            return ResponseEntity.status(HttpStatus.CREATED).body(aulaRepository.save(aula));
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professor não existe", null);
    }

    @PutMapping
    public ResponseEntity<Aula> put (@Valid @RequestBody Aula aula) {
        if (aulaRepository.existsById(aula.getId())){

            if(professorRepository.existsById(aula.getProfessor().getId()))
                return ResponseEntity.status(HttpStatus.OK).body(aulaRepository.save(aula));
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professor não existe", null);
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        Optional<Aula> aula = aulaRepository.findById(id);
        if (aula.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum aluno");
        }
        aulaRepository.deleteById(id);
    }
}
