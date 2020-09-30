package br.com.meutransporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meutransporte.controller.form.ItinerarioForm;
import br.com.meutransporte.integration.dto.ItinerarioDto;
import br.com.meutransporte.service.ItinerarioService;

@RestController("/itinerarios")
public class ItinerariosController {

	@Autowired
	private ItinerarioService itinerarioService;

	@GetMapping
	public List<ItinerarioDto> listar() {
		return itinerarioService.listar();
	}

	@PostMapping
	public void cadastrar(@RequestBody ItinerarioForm itinerario) {
		itinerarioService.cadastrar(itinerario);
	}

}
