package com.generation.burninggym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="tb_aula")
public class Aula {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O tipo da Aula é obrigatório")
    @Size(min = 3, max = 100)
    private String tipoAula;

    @NotNull
    private LocalDate data;
    @NotNull
    private LocalTime duracaoAula;

    @ManyToOne
    @JsonIgnoreProperties("aula")
    private Professor professor;

    @ManyToOne
    @JsonIgnoreProperties("aula")
    private Aluno aluno;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getDuracaoAula() {
        return duracaoAula;
    }

    public void setDuracaoAula(LocalTime duracaoAula) {
        this.duracaoAula = duracaoAula;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
