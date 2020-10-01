package br.com.meutransporte.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meutransporte.model.Linha;
import br.com.meutransporte.service.LinhaService;

@RestController("/linhas")
public class LinhasController {

	@Autowired
	private LinhaService linhaService;

	@GetMapping
	public List<Linha> listar(String nome) {
		if (nome == null) {
			return linhaService.listar();
		}
		return Arrays.asList(linhaService.listar(nome));
	}

	@PostMapping
	public ResponseEntity<Linha> cadastrar(@RequestBody @Valid Linha linha, UriComponentsBuilder uriBuilder) {
		Linha linhaCadastrada = linhaService.cadastrar(linha);
		if (linhaCadastrada.getId() == null) {
			return ResponseEntity.noContent().build();
		}
		URI uri = uriBuilder.path("/linhas/{id}").buildAndExpand(linha.getId()).toUri();
		return ResponseEntity.created(uri).body(linhaCadastrada);
	}

}
