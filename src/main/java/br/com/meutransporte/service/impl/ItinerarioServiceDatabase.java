package br.com.meutransporte.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutransporte.controller.dto.ItinerarioDto;
import br.com.meutransporte.controller.form.ItinerarioForm;
import br.com.meutransporte.model.Itinerario;
import br.com.meutransporte.repository.ItinerarioRepository;
import br.com.meutransporte.service.ItinerarioService;

@Service("itinerarioServiceDatabase")
public class ItinerarioServiceDatabase implements ItinerarioService {

	@Autowired
	private ItinerarioRepository itinerarioRepository;

	@Override
	public List<ItinerarioDto> listar() {
		return itinerarioRepository.findAll().stream().map(ItinerarioDto::new).collect(Collectors.toList());
	}

	@Override
	public Itinerario cadastrar(ItinerarioForm itinerario) {
		Itinerario resultado = itinerarioRepository.findByLinhaAndNome(itinerario.getLinha(), itinerario.getNome());
		Itinerario itinerarioNovo = itinerario.criarItinerario();
		if (resultado == null || resultado.isDiferencaInformacao(itinerarioNovo)) {
			return itinerarioRepository.save(itinerarioNovo);
		}
		return itinerarioNovo;
	}

}
