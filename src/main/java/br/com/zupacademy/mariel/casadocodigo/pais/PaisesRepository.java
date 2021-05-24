package br.com.zupacademy.mariel.casadocodigo.pais;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisesRepository extends JpaRepository<Pais, Long>{

	Optional<Pais> findByNome(@NotBlank String pais);

}
