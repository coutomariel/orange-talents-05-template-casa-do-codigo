package br.com.zupacademy.mariel.casadocodigo.cliente.validation.groups;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.zupacademy.mariel.casadocodigo.cliente.ClienteRequestDto;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<ClienteRequestDto> {

	public List<Class<?>> getValidationGroups(ClienteRequestDto dto) {
	    List<Class<?>> groups = new ArrayList<>();
	    
	    groups.add(ClienteRequestDto.class);
	    
	    if (dto != null) {
	      if ("PF".equalsIgnoreCase(dto.getTipo())) {
	        groups.add(PessoaFisica.class);
	      } else if ("PJ".equalsIgnoreCase(dto.getTipo())) {
	        groups.add(PessoaJuridica.class);
	      }
	    }
	    
	    return groups;
	  }

}
