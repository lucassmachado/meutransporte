package br.com.meutransporte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PontoTaxi {

	@NotNull @NotEmpty
	private String nomePonto;

	@NotNull
	private BigDecimal latitude;

	@NotNull
	private BigDecimal longitude;

	@NotNull
	private LocalDateTime dataHoraCadastro;

	public String getNomePonto() {
		return nomePonto;
	}

	public void setNomePonto(String nomePonto) {
		this.nomePonto = nomePonto;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	@JsonIgnore
	public String getLinhaArquivo() {
		return String.format("%s%s#%s#%s#%s", System.lineSeparator(), nomePonto, latitude, longitude, dataHoraCadastro);
	}

}
