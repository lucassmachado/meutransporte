package br.com.meutransporte.integracao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.meutransporte.integracao.dto.ItinerarioDetalheDto;
import br.com.meutransporte.integracao.dto.ItinerarioDto;
import br.com.meutransporte.integracao.dto.ResultadoDto;

@Component
public class MobilidadePoaApi {

	@Value("${datapoa.url.itinerarios}")
	private String url;

	@Autowired
	private RestTemplate restTemplate;

	public List<ItinerarioDto> listarItinerarios() {
		ResponseEntity<ResultadoDto<ItinerarioDetalheDto>> forObject = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<ResultadoDto<ItinerarioDetalheDto>>() {});
		return forObject.getBody().getResultado().getItinerarios();
	}

}
