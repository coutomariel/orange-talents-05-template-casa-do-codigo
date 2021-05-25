package br.com.zupacademy.mariel.casadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.zupacademy.mariel.casadocodigo.estado.Estado;
import br.com.zupacademy.mariel.casadocodigo.pais.Pais;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@NotBlank
	@Column(nullable = false)
	private String sobrenome;

	@NotBlank
	@Column(nullable = false)
	private String documento;

	@NotBlank
	@Column(nullable = false)
	private String telefone;

	@NotBlank
	@Column(nullable = false)
	private String cep;

	@NotBlank
	@Column(nullable = false)
	private String endereco;

	@NotBlank
	@Column(nullable = false)
	private String complemento;

	@NotBlank
	@Column(nullable = false)
	private String cidade;

	@NotNull
	@ManyToOne
	private Pais pais;

	@ManyToOne
	private Estado estado;

	/**
	 * @deprecated exclusivo para uso do hibernate
	 */
	@Deprecated
	public Cliente() {
	}

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@CPF @CNPJ @NotBlank String documento, @NotBlank String telefone, @NotBlank String cep,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais,
			@NotNull Estado estado) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.telefone = telefone;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}
	
	
	
}
