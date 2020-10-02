package br.com.meutransporte.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.meutransporte.model.Itinerario;
import io.swagger.annotations.ApiModelProperty;

public class ItinerarioForm {

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "Código da linha", required = true)
	private String linha;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "Sentido da linha (centro/bairro, etc)", required = true)
	private String sentido;

	@NotNull
	@ApiModelProperty(value = "Ordenação dos logradouros dentro do Itinerário", required = true)
	private Integer numero;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "Tipificação do item do itinerário (Logradouro, Terminal ou Ponto de Referência)", required = true)
	private String tipo;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "Nome do itinerário", required = true)
	private String nome;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "Endereço", required = true)
	private String logradouro;

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

	public Itinerario criarItinerario() {
		Itinerario itinerario = new Itinerario();
		itinerario.setLinha(linha);
		itinerario.setSentido(sentido);
		itinerario.setNumero(numero);
		itinerario.setTipo(tipo);
		itinerario.setNome(nome);
		itinerario.setLogradouro(logradouro);
		return itinerario;
	}

}
