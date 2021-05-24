package br.com.zupacademy.mariel.casadocodigo.estado;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mariel.casadocodigo.common.validators.ExistsByAttribute;
import br.com.zupacademy.mariel.casadocodigo.estado.validation.UniqueInYourCountry;
import br.com.zupacademy.mariel.casadocodigo.pais.Pais;
import br.com.zupacademy.mariel.casadocodigo.pais.PaisesRepository;

@UniqueInYourCountry
public class EstadoRequestDto {

	@NotBlank
	private String nome;

	@NotNull
	@ExistsByAttribute(entity = Pais.class, attribute = "id")
	private Long pais;

	public Estado toEntity(PaisesRepository paisesRepository) {
		Optional<Pais> pais = paisesRepository.findById(this.pais);
		return new Estado(this.nome, pais.get());
	}

	public EstadoRequestDto(@NotBlank String nome, @NotBlank Long pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public Long getPais() {
		return pais;
	}

}
