package com.generation.burninggym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table (name="tb_professor")
public class Professor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "O atributo nome é obrigatório")
    @Size (min = 3, max = 100)
    private String nome;

    @NotBlank (message = "O atributo especialidade é obrigatório")
    @Size(min = 3 , max=200)
    private String especialidade;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "professor", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("professor")
    private List<Aula> aula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Aula> getAula() {
        return aula;
    }

    public void setAula(List<Aula> aula) {
        this.aula = aula;
    }
}
