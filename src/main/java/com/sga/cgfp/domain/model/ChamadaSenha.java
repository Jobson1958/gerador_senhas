package com.sga.cgfp.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ChamadaSenha {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String senha;
	
	private String nivelPrioridade;
	
	private OffsetDateTime dataHoraEmissao;
	
	
}
