package br.com.meutransporte.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItinerarioDetalheDto {

	@JsonProperty("records")
	private List<ItinerarioDto> itinerarios;

	public List<ItinerarioDto> getItinerarios() {
		return itinerarios;
	}

	public void setItinerarios(List<ItinerarioDto> itinerarios) {
		this.itinerarios = itinerarios;
	}

}
