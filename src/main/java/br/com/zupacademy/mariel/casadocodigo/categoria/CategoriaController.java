package br.com.zupacademy.mariel.casadocodigo.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mariel.casadocodigo.categoria.dtos.CategoriaDto;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public void criarCategoria(@RequestBody @Valid CategoriaDto categoriaDto) {
		categoriaRepository.save(categoriaDto.toEntity());
	}

}
