package br.com.meutransporte.integracao.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItinerarioDto {

	@JsonProperty("_id")
	private Integer id;

	@JsonProperty("data_extracao")
	private String dataExtracao;

	private String linha;

	private String sentido;

	@JsonProperty("numero_sequencia")
	private Integer numero;

	private String tipo;

	private String nome;

	@JsonProperty("endereco_logradouro")
	private String logradouro;

	private BigDecimal rank;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataExtracao() {
		return dataExtracao;
	}

	public void setDataExtracao(String dataExtracao) {
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

	public BigDecimal getRank() {
		return rank;
	}

	public void setRank(BigDecimal rank) {
		this.rank = rank;
	}

}
