package br.com.zupacademy.mariel.casadocodigo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String nome;

	/**
	 * @deprecated Construtor para uso exclusivo do hibernate
	 */
	@Deprecated
	public Categoria() {
	}

	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}

}
