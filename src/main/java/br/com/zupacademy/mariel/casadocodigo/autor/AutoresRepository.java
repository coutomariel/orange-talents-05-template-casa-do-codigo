package br.com.zupacademy.mariel.casadocodigo.autor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.mariel.casadocodigo.autor.entities.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);

}
