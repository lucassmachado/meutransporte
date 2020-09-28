package br.com.meutransporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meutransporte.integracao.MobilidadePoaApi;
import br.com.meutransporte.integracao.dto.ItinerarioDto;

@RestController
public class ItinerariosController {

	@Autowired	
	private MobilidadePoaApi mobilidadePoaApi;
	
	@GetMapping("/itinerarios")
	public List<ItinerarioDto> listar() {
		return mobilidadePoaApi.listarItinerarios();
	}
	
	
	
}
