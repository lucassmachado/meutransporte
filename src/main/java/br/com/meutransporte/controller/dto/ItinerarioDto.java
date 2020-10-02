package br.com.meutransporte.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.meutransporte.model.Itinerario;
import io.swagger.annotations.ApiModelProperty;

public class ItinerarioDto {

	@JsonProperty("_id")
	@ApiModelProperty(value = "ID do itinerário", required = true)
	private Long id;

	@JsonProperty("data_extracao")
	@ApiModelProperty(value = "Data e hora de realização da extração de dados do sistema", required = true)
	private LocalDateTime dataExtracao;

	@ApiModelProperty(value = "Código da linha", required = true)
	private String linha;

	@ApiModelProperty(value = "Sentido da linha (centro/bairro, etc)", required = true)
	private String sentido;

	@JsonProperty("numero_sequencia")
	@ApiModelProperty(value = "Ordenação dos logradouros dentro do Itinerário", required = true)
	private Integer numero;

	@ApiModelProperty(value = "Tipificação do item do itinerário (Logradouro, Terminal ou Ponto de Referência)", required = true)
	private String tipo;

	@ApiModelProperty(value = "Nome do itinerário", required = true)
	private String nome;

	@JsonProperty("endereco_logradouro")
	@ApiModelProperty(value = "Endereço", required = true)
	private String logradouro;

	public ItinerarioDto(Itinerario itinerario) {
		super();
		this.id = itinerario.getId();
		this.dataExtracao = LocalDateTime.now();
		this.linha = itinerario.getLinha();
		this.sentido = itinerario.getSentido();
		this.numero = itinerario.getNumero();
		this.tipo = itinerario.getTipo();
		this.nome = itinerario.getNome();
		this.logradouro = itinerario.getLogradouro();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataExtracao() {
		return dataExtracao;
	}

	public void setDataExtracao(LocalDateTime dataExtracao) {
		this.dataExtracao = dataExtracao;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getSentido() {
		return sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
