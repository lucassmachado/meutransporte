package br.com.meutransporte.service;

import java.util.List;

import br.com.meutransporte.controller.dto.ItinerarioDto;
import br.com.meutransporte.controller.form.ItinerarioForm;
import br.com.meutransporte.model.Itinerario;

public interface ItinerarioService {

	public List<ItinerarioDto> listar();

	public Itinerario cadastrar(ItinerarioForm itinerario);

}
