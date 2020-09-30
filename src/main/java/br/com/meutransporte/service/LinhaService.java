package br.com.meutransporte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meutransporte.integration.LinhaDataPoaApi;
import br.com.meutransporte.repository.LinhaRepository;

@Service
public class LinhaService {

	@Autowired
	private LinhaRepository linhaRepository;
	
	@Autowired
	private LinhaDataPoaApi dataPoaApi;
	
}
