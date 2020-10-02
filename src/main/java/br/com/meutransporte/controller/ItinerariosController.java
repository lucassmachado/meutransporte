package br.com.meutransporte.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meutransporte.controller.dto.ItinerarioDto;
import br.com.meutransporte.controller.form.ItinerarioForm;
import br.com.meutransporte.model.Itinerario;
import br.com.meutransporte.service.ItinerarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/itinerarios")
@Api(tags = "API de itinerários.")
public class ItinerariosController {

	@Autowired
//	@Qualifier("itinerarioServiceApi")
	@Qualifier("itinerarioServiceDatabase")
	private ItinerarioService itinerarioService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Lista todos os itinerários")
	public List<ItinerarioDto> listar() {
		return itinerarioService.listar();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cadastra um itinerário ou atualiza caso ele exista")
	public ResponseEntity<ItinerarioDto> cadastrar(@RequestBody @Valid ItinerarioForm itinerarioForm,
			UriComponentsBuilder uriBuilder) {
		Itinerario itinerario = itinerarioService.cadastrar(itinerarioForm);
		if (itinerario.getId() == null) {
			return ResponseEntity.noContent().build();
		}
		URI uri = uriBuilder.path("/itinerarios/{id}").buildAndExpand(itinerario.getId()).toUri();
		return ResponseEntity.created(uri).body(new ItinerarioDto(itinerario));
	}

}
