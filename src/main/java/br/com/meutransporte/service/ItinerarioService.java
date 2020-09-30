package br.com.meutransporte.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutransporte.controller.form.ItinerarioForm;
import br.com.meutransporte.integration.ItinerarioDataPoaApi;
import br.com.meutransporte.integration.dto.ItinerarioDto;
import br.com.meutransporte.model.Itinerario;
import br.com.meutransporte.repository.ItinerarioRepository;

@Service
public class ItinerarioService {

	@Autowired
	private ItinerarioRepository itinerarioRepository;

	@Autowired
	private ItinerarioDataPoaApi dataPoaApi;

	public List<ItinerarioDto> listar() {
		return itinerarioRepository
				.findAll()
				.stream()
				.map(ItinerarioDto::new)
				.collect(Collectors.toList());
	}

	public void cadastrar(ItinerarioForm itinerario) {
		Itinerario resultado = itinerarioRepository.findByLinhaAndNome(itinerario.getLinha(), itinerario.getNome());
		Itinerario itinerarioNovo = itinerario.criarItinerario();
		if (resultado == null || isDiferencaInformacao(resultado, itinerarioNovo)) {
			itinerarioRepository.save(itinerarioNovo);
		}
	}

	private boolean isDiferencaInformacao(Itinerario resultado, Itinerario itinerarioNovo) {
		return false;
	}

}
