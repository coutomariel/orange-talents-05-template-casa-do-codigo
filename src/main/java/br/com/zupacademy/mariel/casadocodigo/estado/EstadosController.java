package br.com.zupacademy.mariel.casadocodigo.estado;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mariel.casadocodigo.pais.PaisesRepository;

@RestController
@RequestMapping("/estados")
public class EstadosController {

	@Autowired
	private EstadosRepository estadosRepository;

	@Autowired
	private PaisesRepository paisesRepository;

	@PostMapping
	@Transactional
	public void criarEstado(@RequestBody @Valid EstadoRequestDto estadoRequestDto) {
		Estado estado = estadoRequestDto.toEntity(paisesRepository);
		estadosRepository.save(estado);
	}

}
