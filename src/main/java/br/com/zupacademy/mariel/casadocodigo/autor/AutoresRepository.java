package br.com.zupacademy.mariel.casadocodigo.autor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);

}
