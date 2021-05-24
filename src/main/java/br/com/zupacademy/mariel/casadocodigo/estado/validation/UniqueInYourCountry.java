package br.com.zupacademy.mariel.casadocodigo.estado.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VericaSeEstadoJaExisteNoPais.class)
public @interface UniqueInYourCountry {
	String message() default "Já existe um estado com este nome associado ao país informado.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
