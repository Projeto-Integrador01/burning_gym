package com.generation.burninggym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.burninggym.model.Aluno;
import com.generation.burninggym.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired 
	private AlunoRepository alunoRepository;
	
	public Aluno criarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno calculoImc(Aluno aluno) {
		if (alunoRepository.existsById(aluno.getId())) {
			var peso = aluno.getPeso();
			var altura = aluno.getAltura();
			var imc = (peso.divide(altura.multiply(altura)));
			aluno.setImc(imc); 
			alunoRepository.save(aluno);
		}
		return null;
	}
	
}
