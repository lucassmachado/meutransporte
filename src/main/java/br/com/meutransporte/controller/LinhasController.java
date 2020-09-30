package br.com.meutransporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meutransporte.service.LinhaService;

@RestController
public class LinhasController {

	@Autowired
	private LinhaService linhaService;
	
	@GetMapping("/linhas")
	public void listar(String nome) {
	}
	
}
