package br.com.meutransporte.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.meutransporte.integration.dto.ItinerarioDetalheDto;
import br.com.meutransporte.integration.dto.ItinerarioDto;
import br.com.meutransporte.integration.dto.ResultadoDto;

@Component
public class ItinerarioDataPoaApi {

	@Autowired
	private DataPoaUrlBuilder urlBuilder;

	@Autowired
	private RestTemplate restTemplate;

	public List<ItinerarioDto> listarItinerarios() {
		String url = urlBuilder.busca().itinerarios().contruir();

		ResponseEntity<ResultadoDto<ItinerarioDetalheDto>> data = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<ResultadoDto<ItinerarioDetalheDto>>() {});
		return data.getBody().getResultado().getItinerarios();
	}

}
