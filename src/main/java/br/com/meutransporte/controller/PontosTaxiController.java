package br.com.meutransporte.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meutransporte.model.PontoTaxi;
import br.com.meutransporte.service.PontosTaxiService;

@RestController("/pontos-taxi")
public class PontosTaxiController {

	@Autowired
	private PontosTaxiService pontosTaxiService;

	@GetMapping
	public List<PontoTaxi> listar() {
		return pontosTaxiService.listar();
	}

	@PostMapping
	public ResponseEntity<PontoTaxi> cadastrar(@RequestBody PontoTaxi pontoTaxi, UriComponentsBuilder uriBuilder) {
		PontoTaxi resultado = pontosTaxiService.cadastrar(pontoTaxi);
		URI uri = uriBuilder.path("/pontos-taxi/{nome}").buildAndExpand(resultado.getNomePonto()).toUri();
		return ResponseEntity.created(uri).body(resultado);
	}

}
