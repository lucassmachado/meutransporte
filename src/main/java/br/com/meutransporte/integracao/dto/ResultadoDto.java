package br.com.meutransporte.integracao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultadoDto<T> {
	
	@JsonProperty("result")
	private T resultado;

	public T getResultado() {
		return resultado;
	}

	public void setResultado(T resultado) {
		this.resultado = resultado;
	}

}
