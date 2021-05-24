package br.com.zupacademy.mariel.casadocodigo.estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mariel.casadocodigo.pais.Pais;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	private String nome;

	@NotNull
	@ManyToOne
	private Pais pais;

	public Estado(@NotNull @NotBlank String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
}
