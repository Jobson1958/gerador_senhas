package com.sga.cgfp.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sga.cgfp.domain.exception.EntidadeNaoEncontradaException;
import com.sga.cgfp.domain.model.ChamadaSenha;
import com.sga.cgfp.domain.repository.ChamadaSenhaRepository;


@Service
public class ChamadaSenhaService {
	
	@Autowired
	private ChamadaSenhaRepository chamadaSenhaRepository;
	
	@Transactional
	public ChamadaSenha salvar(ChamadaSenha chamadaSenha) {
		return chamadaSenhaRepository.save(chamadaSenha);
	}
	
	public ChamadaSenha chamarSenha(Long senhaId) {
		ChamadaSenha chamadaSenha = chamadaSenhaRepository.findById(senhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de senha com o este código")));
		
		
		return chamadaSenha;
		
	}
	
	

}
