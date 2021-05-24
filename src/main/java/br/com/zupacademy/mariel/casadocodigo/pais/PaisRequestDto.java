package br.com.zupacademy.mariel.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mariel.casadocodigo.common.validators.Unique;

public class PaisRequestDto {
	
	@NotBlank
	@Unique(entity = Pais.class, attribute = "nome")
	private String nome;
	
	public Pais toEntity() {
		return new Pais(this.nome);
	}

	public String getNome() {
		return nome;
	}
	
}
