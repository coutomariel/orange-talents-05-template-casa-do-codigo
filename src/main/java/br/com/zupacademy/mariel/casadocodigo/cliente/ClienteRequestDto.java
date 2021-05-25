package br.com.zupacademy.mariel.casadocodigo.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.zupacademy.mariel.casadocodigo.cliente.validation.ValidaSeEstadoFoiInformadoCorretamente;
import br.com.zupacademy.mariel.casadocodigo.cliente.validation.groups.ClienteGroupSequenceProvider;
import br.com.zupacademy.mariel.casadocodigo.cliente.validation.groups.PessoaFisica;
import br.com.zupacademy.mariel.casadocodigo.cliente.validation.groups.PessoaJuridica;
import br.com.zupacademy.mariel.casadocodigo.common.validators.ExistsByAttribute;
import br.com.zupacademy.mariel.casadocodigo.common.validators.Unique;
import br.com.zupacademy.mariel.casadocodigo.estado.Estado;
import br.com.zupacademy.mariel.casadocodigo.pais.Pais;

@ValidaSeEstadoFoiInformadoCorretamente
@GroupSequenceProvider(value = ClienteGroupSequenceProvider.class)
public class ClienteRequestDto {

	@NotBlank
	@Email
	@Unique(entity = Cliente.class, attribute = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@CPF(groups = PessoaFisica.class)
	@CNPJ(groups = PessoaJuridica.class)
	@Unique(entity = Cliente.class, attribute = "documento")
	private String documento;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ExistsByAttribute(entity = Pais.class, attribute = "id")
	private Long paisId;

	private Long estadoId;

	public Cliente toEntity(Pais pais ,Estado estado) {
		return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.telefone, this.cep,
				this.endereco, this.complemento, this.cidade, pais, estado);
	}
	
	public String getTipo() {
		return documento.length() == 11 ? "PF" : "PJ";
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

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}
	
}
