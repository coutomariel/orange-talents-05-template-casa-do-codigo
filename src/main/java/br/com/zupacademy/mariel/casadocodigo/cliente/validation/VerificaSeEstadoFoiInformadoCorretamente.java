package br.com.zupacademy.mariel.casadocodigo.cliente.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mariel.casadocodigo.cliente.ClienteRequestDto;

public class VerificaSeEstadoFoiInformadoCorretamente
		implements ConstraintValidator<ValidaSeEstadoFoiInformadoCorretamente, ClienteRequestDto> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void initialize(ValidaSeEstadoFoiInformadoCorretamente constraintAnnotation) {
	}

	@Override
	public boolean isValid(ClienteRequestDto cliente, ConstraintValidatorContext context) {
		boolean estadoFoiInformado = cliente.getEstadoId() != null;

		if (estadoFoiInformado) {
			return validaRegraDeEstadoEstasAssociadoAoPaisinformado(cliente);
		} else {
			return validaRegraDeInformarEstadoParaPaisesComEstadosCadastrados(cliente);
		}

	}

	private boolean validaRegraDeEstadoEstasAssociadoAoPaisinformado(ClienteRequestDto request) {
		String jpql = "select 1 from Estado where id = :pEstado and pais.id = :pPais";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pEstado", request.getEstadoId());
		query.setParameter("pPais", request.getPaisId());

		List<?> result = query.getResultList();
		return !result.isEmpty();
	}

	private boolean validaRegraDeInformarEstadoParaPaisesComEstadosCadastrados(ClienteRequestDto request) {
		String jpql = "select 1 from Estado where pais.id = :paisId ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("paisId", request.getPaisId());

		List<?> result = query.getResultList();
		boolean paisPossuiEstados = !result.isEmpty();

		boolean estadoNaoFoiInformado = request.getEstadoId() == null;

		if (paisPossuiEstados && estadoNaoFoiInformado) {
			return false;
		}

		return true;
	}

}
