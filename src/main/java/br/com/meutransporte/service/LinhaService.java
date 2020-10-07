package br.com.meutransporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutransporte.controller.form.LinhaForm;
import br.com.meutransporte.model.Linha;
import br.com.meutransporte.repository.LinhaRepository;
import br.com.meutransporte.service.components.FiltradorLocalizacao;
import br.com.meutransporte.service.components.FiltroLocalizacao;

@Service
public class LinhaService {

	@Autowired
	private LinhaRepository linhaRepository;

	@Autowired 
	private FiltradorLocalizacao filtrador;
	
	public List<Linha> listar() {
		return linhaRepository.findAll();
	}

	public Linha listar(String nome) {
		return linhaRepository.findByNome(nome);
	}

	public Linha cadastrar(LinhaForm linha) {
		Linha resultado = linhaRepository.findByCodigoAndNome(linha.getCodigo(), linha.getNome());
		Linha linhaNova = linha.criarLinha();
		if (resultado == null || resultado.isDiferencaInformacao(linhaNova)) {
			return linhaRepository.save(linhaNova);
		}
		return linhaNova;
	}

	public List<Linha> listarLinhasDentroRaioKm(FiltroLocalizacao filtro) {
		return filtrador.filtrar(listar(), filtro);
	}

}
