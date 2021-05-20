package br.com.zupacademy.mariel.casadocodigo.categoria.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.mariel.casadocodigo.categoria.CategoriaRepository;

public class CategoriaUnicaValidator implements ConstraintValidator<CategoriaUnica, String>{

	private String nome;
	
	@Autowired
	private CategoriaRepository categoriarepository;
	
	@Override
	public void initialize(CategoriaUnica constraintAnnotation) {
		this.nome = constraintAnnotation.value();
	}
	
	public boolean isValid(String nome, ConstraintValidatorContext context) {
		return !categoriarepository.findByNome(nome).isPresent();
	}

}
