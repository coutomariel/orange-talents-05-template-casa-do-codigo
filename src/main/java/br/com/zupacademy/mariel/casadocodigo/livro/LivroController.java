package br.com.zupacademy.mariel.casadocodigo.livro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mariel.casadocodigo.autor.AutoresRepository;
import br.com.zupacademy.mariel.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutoresRepository autoresRepository;
	@Autowired
	private CategoriaRepository categoriasRepository;

	@PostMapping
	public void criarlivro(@RequestBody @Valid LivroRequestDto dto) {
		Livro livro = dto.toEntity(autoresRepository, categoriasRepository);
		livroRepository.save(livro);
	}

}
