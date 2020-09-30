package br.com.meutransporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meutransporte.model.Itinerario;

public interface ItinerarioRepository extends JpaRepository<Itinerario, Long>  {

	Itinerario findByLinhaAndNome(String linha, String nome);
	
}
