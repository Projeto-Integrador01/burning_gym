package com.generation.burninggym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
    @Column(name = "tipo_aula")
    private String tipoAula;

    @NotBlank (message = "A descrição da aula é obrigatória")
    @Size(min = 3, max = 100)
    private String descricao;

    @NotNull (message = "A data da aula é obrigatória")
    private String data;

    @NotNull (message = "A duração da aula é obrigatória")
    @Column(name = "duracao_aula") // funciona como se fosse um alter table no banco de dados 
    private String duracaoAula;

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
    
    public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDuracaoAula() {
		return duracaoAula;
	}

	public void setDuracaoAula(String duracaoAula) {
		this.duracaoAula = duracaoAula;
	}

	public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
