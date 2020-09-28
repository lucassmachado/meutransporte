package br.com.meutransporte.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import br.com.meutransporte.model.PontoTaxi;

@Service
public class PontosTaxiService {

	private static final String CAMINHO_ARQUIVO = "classpath:data/pontos-taxi.dat";

	private static final String DELIMITADOR_ARQUIVO = "#|\r\n";

	@Value(CAMINHO_ARQUIVO)
	private String arquivoPontosTaxi;

	private List<PontoTaxi> pontosTaxi;

	@PostConstruct
	public void iniciar() {
		lerArquivoPontosTaxi();
	}

	private void lerArquivoPontosTaxi() {
		pontosTaxi = new ArrayList<>();
		try (Scanner leitor = new Scanner(ResourceUtils.getFile(arquivoPontosTaxi)).useDelimiter(DELIMITADOR_ARQUIVO)) {
			leitor.nextLine();
			while (leitor.hasNext()) {
				pontosTaxi.add(criarPontoTaxi(leitor));
			}
		} catch (FileNotFoundException e) {
			// TODO: colocar log
			System.out.println(e);
		}
	}

	private PontoTaxi criarPontoTaxi(Scanner leitor) {
		PontoTaxi ponto = new PontoTaxi();
		ponto.setNomePonto(leitor.next());
		ponto.setLatitude(new BigDecimal(leitor.next()));
		ponto.setLongitude(new BigDecimal(leitor.next()));
		ponto.setDataHoraCadastro(converterData(leitor.next()));
		return ponto;
	}

	private LocalDateTime converterData(String data) {
		return LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
	}

	public List<PontoTaxi> listar() {
		return pontosTaxi;
	}

	public void cadastrar(PontoTaxi pontoTaxi) {
		atualizarLista(pontoTaxi);
		atualizarArquivo(pontoTaxi);
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
			Files.write(Paths.get(arquivoPontosTaxi), novaLinha, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO: lançar exceção
			System.out.println(e);
		}
	}

}
