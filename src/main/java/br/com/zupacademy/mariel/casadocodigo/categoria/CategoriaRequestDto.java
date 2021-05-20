package br.com.zupacademy.mariel.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mariel.casadocodigo.common.validators.Unique;

public class CategoriaRequestDto {

	@NotBlank
	@Unique(entity = Categoria.class, attribute = "nome")
	private String nome;

	public Categoria toEntity() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return nome;
	}

}
