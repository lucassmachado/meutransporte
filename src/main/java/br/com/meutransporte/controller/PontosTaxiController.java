package br.com.meutransporte.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meutransporte.model.PontoTaxi;
import br.com.meutransporte.service.PontosTaxiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/pontos-taxi")
@Api(tags = "API de pontos de táxi.")
public class PontosTaxiController {

	@Autowired
	private PontosTaxiService pontosTaxiService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Lista todos os pontos de táxi")
	public List<PontoTaxi> listar() {
		return pontosTaxiService.listar();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cadastra um novo ponto de táxi")
	public ResponseEntity<PontoTaxi> cadastrar(@RequestBody PontoTaxi pontoTaxi, UriComponentsBuilder uriBuilder) {
		PontoTaxi resultado = pontosTaxiService.cadastrar(pontoTaxi);
		URI uri = uriBuilder.path("/pontos-taxi/{nome}").buildAndExpand(resultado.getNomePonto()).toUri();
		return ResponseEntity.created(uri).body(resultado);
	}

}
