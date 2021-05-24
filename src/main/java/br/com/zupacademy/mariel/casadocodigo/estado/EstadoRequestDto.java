package br.com.zupacademy.mariel.casadocodigo.estado;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mariel.casadocodigo.common.validators.ExistsByAttribute;
import br.com.zupacademy.mariel.casadocodigo.common.validators.Unique;
import br.com.zupacademy.mariel.casadocodigo.pais.Pais;
import br.com.zupacademy.mariel.casadocodigo.pais.PaisesRepository;

public class EstadoRequestDto {

	@NotBlank
	@Unique(entity = Estado.class, attribute = "nome")
	private String nome;

	@NotBlank
	@ExistsByAttribute(entity = Pais.class, attribute = "nome")
	private String pais;

	public Estado toEntity(PaisesRepository paisesRepository) {
		Optional<Pais> pais = paisesRepository.findByNome(this.pais);
		return new Estado(this.nome, pais.get());
	}

	public EstadoRequestDto(@NotBlank String nome, @NotBlank String pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}

}
