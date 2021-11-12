package com.kingstar.curso.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@Id
	private Long Id;

	@Column(nullable = false)
	private String nome;

	@Column(name = "taxa_frente", nullable = false)
	private BigDecimal taxaFrente;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cozinha cozinha;
	
	@Embedded
	private Endereco endereco;
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "dateTime")
	private LocalDateTime dataCadastro;
	
	@UpdateTimestamp
	@Column(nullable = false, columnDefinition = "dateTime")
	private LocalDateTime dataAtualizacao;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name =  "restaurante_forma_pagamento", 
	joinColumns = @JoinColumn(name = "restaurante_id"),
	inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
	private List<FormaPagamento> formasPagamento = new ArrayList<>();
 }
