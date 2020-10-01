package br.com.meutransporte.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutransporte.controller.dto.ItinerarioDto;
import br.com.meutransporte.controller.form.ItinerarioForm;
import br.com.meutransporte.integration.ItinerarioDataPoaApi;
import br.com.meutransporte.model.Itinerario;
import br.com.meutransporte.service.ItinerarioService;

@Service("itinerarioServiceApi")
public class ItinerarioServiceApi implements ItinerarioService {

	@Autowired
	private ItinerarioDataPoaApi dataPoaApi;

	@Override
	public List<ItinerarioDto> listar() {
		return dataPoaApi.listar();
	}

	@Override
	public Itinerario cadastrar(ItinerarioForm itinerario) {
		Optional<ItinerarioDto> resultado = listar().stream()
				.filter(i -> i.getLinha().equalsIgnoreCase(itinerario.getLinha())
						&& i.getNome().equalsIgnoreCase(itinerario.getNome()))
				.findFirst();
		
		

		return null;
	}

}
