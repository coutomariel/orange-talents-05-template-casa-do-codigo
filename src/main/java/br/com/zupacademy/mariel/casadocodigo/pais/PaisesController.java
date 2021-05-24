package br.com.zupacademy.mariel.casadocodigo.pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisesController {

	@Autowired
	private PaisesRepository paisesRepository;

	@PostMapping
	@Transactional
	public void criarPais(@RequestBody @Valid PaisRequestDto paisRequestDto) {
		paisesRepository.save(paisRequestDto.toEntity());
	}
	
}
