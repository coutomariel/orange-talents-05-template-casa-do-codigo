package br.com.zupacademy.mariel.casadocodigo.common.validators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BuscaPorAtributoExisteValidator implements ConstraintValidator<ExistsByAttribute, Object> {

	@PersistenceContext
	private EntityManager em;

	private Class<?> entity;
	private String attribute;

	@Override
	public void initialize(ExistsByAttribute annotation) {
		this.entity = annotation.entity();
		this.attribute = annotation.attribute();

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Query query = em.createQuery("select 1 from " + this.entity.getName() + " where " + this.attribute + " = :id");
		query.setParameter("id", value);
		List<?> result = query.getResultList();

		return !result.isEmpty();
	}

}
