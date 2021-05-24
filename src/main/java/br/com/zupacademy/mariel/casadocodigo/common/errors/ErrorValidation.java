package br.com.zupacademy.mariel.casadocodigo.common.errors;

public abstract class ErrorValidation {

	private String mesage;

	public ErrorValidation(String field, String message) {
		this.mesage = message;
	}

	public String getMessage() {
		return mesage;
	}

}
