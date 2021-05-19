package br.com.zupacademy.mariel.casadocodigo.autor.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.mariel.casadocodigo.autor.entities.Autor;

public class AutorRequestDto {

	@NotNull
	@NotEmpty
	private String nome;

	@Email
	@NotNull
	@NotEmpty
	private String email;

	@Size(max = 400)
	@NotNull
	@NotEmpty
	private String descricao;

	public AutorRequestDto(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toEntity() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		return email;
	}

}
