package com.kingstar.curso.domain.repository;

import java.util.List;

import com.kingstar.curso.domain.entity.Cidade;

public interface CidadeRepository {
	
	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade restaurante);
	void remover(Cidade restaurante);
}
