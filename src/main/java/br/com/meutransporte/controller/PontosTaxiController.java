package br.com.meutransporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meutransporte.model.PontoTaxi;
import br.com.meutransporte.service.PontosTaxiService;

@RestController
public class PontosTaxiController {

	@Autowired
	private PontosTaxiService pontosTaxiService;

	@GetMapping("/pontos-taxi")
	public List<PontoTaxi> listar() {
		return pontosTaxiService.listar();
	}

	@PostMapping("/pontos-taxi")
	public void cadastrar(@RequestBody PontoTaxi pontoTaxi) {
		pontosTaxiService.cadastrar(pontoTaxi);
	}

}
