package br.com.meutransporte.service.components;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class FiltradorLocalizacao {

	private static final int RAIO_TERRA = 6371;

	public <T extends Localizacao> List<T> filtrar(List<T> localizacoes, FiltroLocalizacao filtro) {
		return localizacoes.stream()
				.filter(localizacao -> isDentroRaio(localizacao, filtro))
				.collect(Collectors.toList());
	}

	private boolean isDentroRaio(Localizacao localizacao, FiltroLocalizacao filtro) {
		return verificarDistancia(localizacao.getLatitude(), localizacao.getLongitude(),
				filtro.getLocalizacao().getLatitude(), filtro.getLocalizacao().getLongitude()) <= filtro.getRaio();
	}

	private double verificarDistancia(double startLat, double startLong, double endLat, double endLong) {
		double dLat = Math.toRadians((endLat - startLat));
		double dLong = Math.toRadians((endLong - startLong));

		startLat = Math.toRadians(startLat);
		endLat = Math.toRadians(endLat);

		double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return RAIO_TERRA * c;
	}

	private double haversin(double val) {
		return Math.pow(Math.sin(val / 2), 2);
	}

}
