package br.com.zupacademy.mariel.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mariel.casadocodigo.autor.dtos.AutorRequestDto;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	@Autowired
	private AutoresRepository autoresRepository;
	
	@PostMapping
	public void criarAutor(@RequestBody @Valid AutorRequestDto autorRequestDto) {
		autoresRepository.save(autorRequestDto.toEntity());
	}
	
}
