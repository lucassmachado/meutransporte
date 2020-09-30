package br.com.meutransporte.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DataPoaUrlBuilder {

	@Autowired
	private Environment env;

	@Value("${datapoa.url}")
	private String url;
	private String action;
	private String resourceId;

	public DataPoaUrlBuilder cria() {
		this.action = env.getProperty("datapoa.action.create");
		return this;
	}

	public DataPoaUrlBuilder atualizaOuInsere() {
		this.action = env.getProperty("datapoa.action.upsert");
		return this;
	}

	public DataPoaUrlBuilder busca() {
		this.action = env.getProperty("datapoa.action.search");
		return this;
	}
	
	public DataPoaUrlBuilder itinerarios() {
		this.action = env.getProperty("datapoa.resource.id.itinerarios");
		return this;
	}
	
	public DataPoaUrlBuilder linhas() {
		this.action = env.getProperty("datapoa.resource.id.linhas");
		return this;
	}

	public String contruir() {
		return String.format("%s%s%s", url, action, resourceId);
	}

}
