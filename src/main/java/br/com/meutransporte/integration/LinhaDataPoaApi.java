package br.com.meutransporte.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.meutransporte.integration.dto.ResultadoDto;
import br.com.meutransporte.model.Linha;

@Component
public class LinhaDataPoaApi {

	@Value("${datapoa.url.linhas}")
	private String url;

	@Autowired
	private RestTemplate restTemplate;

	public List<Linha> listarLinhas() {
		ResponseEntity<ResultadoDto<List<Linha>>> data = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<ResultadoDto<List<Linha>>>() {});
		return data.getBody().getResultado();
	}

	
}
