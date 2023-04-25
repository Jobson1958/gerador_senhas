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
@Entity
public class Senha {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String senha;
	
	@CreationTimestamp
	private OffsetDateTime dataHoraEmissao;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipoSenha;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void gerarStringSenhaConvecional(int cont_senha) {
		
		if(cont_senha == 0) {
			String sid = String.valueOf(this.id);
			String letra = "C";
			this.senha = letra.concat(sid);
		}else {
			String sid = String.valueOf(cont_senha);
			String letra = "C";
			this.senha = letra.concat(sid);			
		}
		
	}
	
	public void gerarStringSenhaPrioritaria() {
		String sid = String.valueOf(this.id);
		String letra = "P";
		this.senha = letra.concat(sid);
	}

}
