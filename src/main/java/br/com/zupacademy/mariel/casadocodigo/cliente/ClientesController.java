package br.com.zupacademy.mariel.casadocodigo.cliente;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mariel.casadocodigo.estado.Estado;
import br.com.zupacademy.mariel.casadocodigo.estado.EstadosRepository;
import br.com.zupacademy.mariel.casadocodigo.pais.Pais;
import br.com.zupacademy.mariel.casadocodigo.pais.PaisesRepository;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClientesRepository clientesRepository;

	@Autowired
	private EstadosRepository estadosRepository;

	@Autowired
	private PaisesRepository paisesRepository;

	@PostMapping
	@Transactional
	public Long criarCliente(@RequestBody @Valid ClienteRequestDto request) {
		Pais pais = paisesRepository.findById(request.getPaisId()).get();
		Estado estado = estadosRepository.findById(request.getEstadoId()).get();
		Cliente clienteSalvo = clientesRepository.save(request.toEntity(pais, estado));
		return clienteSalvo.getId();
	}
}
