package br.com.meutransporte.controller.form;

import java.math.BigDecimal;

import br.com.meutransporte.model.Itinerario;

public class ItinerarioForm {

	private String dataExtracao;

	private String linha;

	private String sentido;

	private Integer numero;

	private String tipo;

	private String nome;

	private String logradouro;

	private BigDecimal rank;

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

	public Itinerario criarItinerario() {
		Itinerario itinerario = new Itinerario();
		itinerario.setDataExtracao(dataExtracao);
		itinerario.setLinha(linha);
		itinerario.setSentido(sentido);
		itinerario.setNumero(numero);
		itinerario.setTipo(tipo);
		itinerario.setNome(nome);
		itinerario.setLogradouro(logradouro);
		itinerario.setRank(rank);
		return itinerario;
	}

}
