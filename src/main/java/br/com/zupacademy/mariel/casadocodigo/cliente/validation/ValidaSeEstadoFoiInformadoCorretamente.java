package br.com.zupacademy.mariel.casadocodigo.cliente.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VerificaSeEstadoFoiInformadoCorretamente.class)
public @interface ValidaSeEstadoFoiInformadoCorretamente {
	String message() default "Informação do estado é obrigatória para países que possuem estados cadastrados e este estado precisa estar associado ao país informado";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
