package br.com.meutransporte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

public class PontoTaxi {

	@NotNull @NotEmpty
	@ApiModelProperty(value = "Nome do ponto de táxi", required = true)
	private String nomePonto;

	@NotNull
	@ApiModelProperty(value = "Latitude do ponto de táxi", required = true)
	private BigDecimal latitude;

	@NotNull
	@ApiModelProperty(value = "Longitude do ponto de táxi", required = true)
	private BigDecimal longitude;

	@JsonProperty(access = Access.READ_ONLY)
	@ApiModelProperty(value = "Data e hora do cadastro", accessMode = AccessMode.READ_ONLY, hidden = true)
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
