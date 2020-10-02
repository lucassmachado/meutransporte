package br.com.meutransporte.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import br.com.meutransporte.model.PontoTaxi;

@Service
public class PontosTaxiService {

	private static final String CAMINHO_ARQUIVO = "classpath:data/pontos-taxi.dat";

	private static final String DELIMITADOR_ARQUIVO = "#|\r\n";

	@Value(CAMINHO_ARQUIVO)
	private Resource arquivoPontosTaxi;

	private List<PontoTaxi> pontosTaxi;

	@PostConstruct
	public void lerArquivoPontosTaxi() {
		pontosTaxi = new ArrayList<>();
		try (Scanner leitor = new Scanner(arquivoPontosTaxi.getInputStream()).useDelimiter(DELIMITADOR_ARQUIVO)) {
			while (leitor.hasNext()) {
				pontosTaxi.add(criarPontoTaxi(leitor));
			}
		} catch (IOException e) {
			// TODO: colocar log
			System.out.println("Arquivo não encontrado");
		}
	}

	private PontoTaxi criarPontoTaxi(Scanner leitor) {
		PontoTaxi ponto = new PontoTaxi();
		ponto.setNomePonto(leitor.next());
		ponto.setLatitude(new BigDecimal(leitor.next()));
		ponto.setLongitude(new BigDecimal(leitor.next()));
		ponto.setDataHoraCadastro(
				LocalDateTime.parse(leitor.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")));
		return ponto;
	}

	public List<PontoTaxi> listar() {
		return pontosTaxi;
	}

	public PontoTaxi cadastrar(PontoTaxi pontoTaxi) {
		PontoTaxi ponto = pontoTaxi;
		ponto.setDataHoraCadastro(LocalDateTime.now());

		atualizarLista(ponto);
		atualizarArquivo(ponto);
		return ponto;
	}

	private void atualizarLista(PontoTaxi pontoTaxi) {
		if (pontosTaxi == null) {
			pontosTaxi = new ArrayList<PontoTaxi>();
		}
		pontosTaxi.add(pontoTaxi);
	}

	private void atualizarArquivo(PontoTaxi pontoTaxi) {
		try {
			List<String> novaLinha = Arrays.asList(pontoTaxi.getLinhaArquivo());
			Files.write(arquivoPontosTaxi.getFile().toPath(), novaLinha, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO: lançar exceção
			System.out.println("Não foi possível atualizar o arquivo");
		}
	}

}
