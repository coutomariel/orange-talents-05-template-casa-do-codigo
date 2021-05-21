package br.com.zupacademy.mariel.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public List<LivroResponseDto> listarLivros(){
		return livroRepository.findAll()
				.stream().map((livro) -> new LivroResponseDto(livro))
				.collect(Collectors.toList());
	}

}
