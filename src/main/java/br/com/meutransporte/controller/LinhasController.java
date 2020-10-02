package br.com.meutransporte.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meutransporte.controller.form.LinhaForm;
import br.com.meutransporte.model.Linha;
import br.com.meutransporte.service.LinhaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/linhas")
@Api(tags = "API de linhas de ônibus.")
public class LinhasController {

	@Autowired
	private LinhaService linhaService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Lista todos as linhas de ônibus ou uma linha espefica dado um nome da linha.")
	public List<Linha> listar(String nome) {
		if (nome == null) {
			return linhaService.listar();
		}
		return Arrays.asList(linhaService.listar(nome));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cadastra uma linha de ônibus ou atualiza caso ela exista")
	public ResponseEntity<Linha> cadastrar(@RequestBody @Valid LinhaForm linha, UriComponentsBuilder uriBuilder) {
		Linha linhaCadastrada = linhaService.cadastrar(linha);
		if (linhaCadastrada.getId() == null) {
			return ResponseEntity.noContent().build();
		}
		URI uri = uriBuilder.path("/linhas/{id}").buildAndExpand(linhaCadastrada.getId()).toUri();
		return ResponseEntity.created(uri).body(linhaCadastrada);
	}

}
