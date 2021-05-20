package br.com.zupacademy.mariel.casadocodigo.autor.validations.email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.mariel.casadocodigo.autor.AutoresRepository;

public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {

	private String email;

	@Autowired
	private AutoresRepository autoresRepository;

	@Override
	public void initialize(EmailUnico constraintAnnotation) {
		this.email = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return !autoresRepository.findByEmail(email).isPresent();
	}

}
