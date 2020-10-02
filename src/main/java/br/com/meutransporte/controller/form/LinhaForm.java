package br.com.meutransporte.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.meutransporte.model.Linha;
import io.swagger.annotations.ApiModelProperty;

public class LinhaForm {

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "Código da linha", required = true)
	private String codigo;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "Nome da linha", required = true)
	private String nome;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Linha criarLinha() {
		Linha linha = new Linha();
		linha.setCodigo(codigo);
		linha.setNome(nome);
		return linha;
	}

}
