package br.com.zupacademy.mariel.casadocodigo.common.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValorUnicoValidator.class)
public @interface Unique {

	String message() default "Atributo permite apenas valores únicos";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String value() default "";

	Class<?> entity();

	String attribute();

}
