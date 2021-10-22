package com.kingstar.curso.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kingstar.curso.domain.entity.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

	List<Restaurante> findByTaxaFrenteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	@Query("from Restaurante whrere nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);

	List<Restaurante> findByNomeContainingAndId(String nome, Long id);
	
	Optional<Restaurante> findFirstByNomeContaining(String nome);
	
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	int coutByCozinhaId(Long cozinha);
}
