package br.com.meutransporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meutransporte.model.Linha;

public interface LinhaRepository extends JpaRepository<Linha, Long> {

	Linha findByNome(String nome);

	Linha findByCodigoAndNome(String codigo, String nome);

}
