package br.com.meutransporte.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Raíz da Aplicação")
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "Bem-vindo ao Meu Transporte";
	}

}
