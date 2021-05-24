package br.com.zupacademy.mariel.casadocodigo.estado.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mariel.casadocodigo.estado.EstadoRequestDto;

public class VericaSeEstadoJaExisteNoPais implements ConstraintValidator<UniqueInYourCountry, EstadoRequestDto> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void initialize(UniqueInYourCountry constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(EstadoRequestDto estadoRequestDto, ConstraintValidatorContext context) {
		System.out.println(estadoRequestDto.getPais());

		if (!(estadoRequestDto instanceof EstadoRequestDto)) {
			throw new IllegalArgumentException("@UniqueInYourCountry deve ser usado apenas para classe Estado");
		}

		String jpql ="select 1 from Estado where nome = :pNome and pais.id = :pPais"; 
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pNome", estadoRequestDto.getNome());
		query.setParameter("pPais", estadoRequestDto.getPais());
		
		List<?> result = query.getResultList();
		return result.isEmpty();
	}

}
