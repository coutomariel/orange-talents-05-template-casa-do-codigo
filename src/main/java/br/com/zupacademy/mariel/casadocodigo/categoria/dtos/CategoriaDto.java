package br.com.zupacademy.mariel.casadocodigo.categoria.dtos;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mariel.casadocodigo.categoria.entities.Categoria;
import br.com.zupacademy.mariel.casadocodigo.categoria.validation.CategoriaUnica;

public class CategoriaDto {
	
	@NotBlank
	@CategoriaUnica
	private String nome;

	public Categoria toEntity() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return nome;
	}

}
