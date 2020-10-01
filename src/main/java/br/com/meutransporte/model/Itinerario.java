package br.com.meutransporte.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Itinerario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String dataExtracao;

	private String linha;

	private String sentido;

	private Integer numero;

	private String tipo;

	private String nome;

	private String logradouro;

	private BigDecimal rank;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public boolean isDiferencaInformacao(Itinerario itinerario) {
		return !dataExtracao.equals(itinerario.dataExtracao) || linha.equalsIgnoreCase(itinerario.linha)
				|| sentido.equalsIgnoreCase(itinerario.sentido) || numero.compareTo(itinerario.numero) != 0
				|| tipo.equalsIgnoreCase(itinerario.tipo) || nome.equalsIgnoreCase(itinerario.nome)
				|| logradouro.equalsIgnoreCase(itinerario.logradouro) || rank.compareTo(itinerario.rank) != 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itinerario other = (Itinerario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
