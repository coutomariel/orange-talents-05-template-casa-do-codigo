package br.com.zupacademy.mariel.casadocodigo.autor.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	@Column(nullable = false)
	private String nome;

	@Email
	@NotNull
	@NotEmpty
	@Column(nullable = false, unique = true)
	private String email;

	@Size(max = 400)
	@NotNull
	@NotEmpty
	@Column(nullable = false, length = 400)
	private String descricao;

	@Column(nullable = false)
	@NotNull
	private LocalDateTime dataCriacao = LocalDateTime.now();

	
	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
}
