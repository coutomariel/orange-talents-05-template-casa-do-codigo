package br.com.zupacademy.mariel.casadocodigo.autor;

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

import br.com.zupacademy.mariel.casadocodigo.common.validators.Unique;

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
	@Unique(entity = Autor.class, attribute = "email")
	private String email;

	@Size(max = 400)
	@NotNull
	@NotEmpty
	@Column(nullable = false, length = 400)
	private String descricao;

	@Column(nullable = false)
	@NotNull
	private LocalDateTime dataCriacao = LocalDateTime.now();

	/**
	 * @deprecated contrutor usado apenas pelo hibernate
	 */
	@Deprecated
	public Autor() {
	}

	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
