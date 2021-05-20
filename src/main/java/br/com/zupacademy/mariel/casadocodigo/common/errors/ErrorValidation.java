package br.com.zupacademy.mariel.casadocodigo.common.errors;

public class ErrorValidation {

	private String field;
	private String mesage;

	public ErrorValidation(String field, String message) {
		this.field = field;
		this.mesage = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return mesage;
	}

}
