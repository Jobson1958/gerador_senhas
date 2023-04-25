package com.sga.cgfp.domain.model;

import java.time.OffsetDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Atendimento {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@CreationTimestamp
	//@JsonFormat(pattern =  "dd/MM/yyyy HH:mm")
	private OffsetDateTime inicioAtendimento;
	
	//@JsonFormat(pattern =  "dd/MM/yyyy HH:mm")
	private OffsetDateTime finalAtendimento;
	
	@Enumerated(EnumType.STRING)
	private StatusAtendimento statusAtendimento;
	
	private String senha;

}
