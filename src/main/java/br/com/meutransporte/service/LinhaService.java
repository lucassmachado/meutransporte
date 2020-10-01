package br.com.meutransporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutransporte.model.Linha;
import br.com.meutransporte.repository.LinhaRepository;

@Service
public class LinhaService {

	@Autowired
	private LinhaRepository linhaRepository;

	public List<Linha> listar() {
		return linhaRepository.findAll();
	}

	public Linha listar(String nome) {
		return linhaRepository.findByNome(nome);
	}

	public Linha cadastrar(Linha linha) {
		Linha resultado = linhaRepository.findByCodigoAndNome(linha.getCodigo(), linha.getNome());
		if (resultado == null || linha.isDiferencaInformacao(resultado)) {
			return linhaRepository.save(linha);
		}
		return linha;
	}

}
