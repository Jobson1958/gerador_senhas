package com.sga.cgfp.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sga.cgfp.domain.exception.EntidadeNaoEncontradaException;
import com.sga.cgfp.domain.model.Atendimento;
import com.sga.cgfp.domain.model.StatusAtendimento;
import com.sga.cgfp.domain.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Transactional
	public Atendimento iniciarAtendimento(Atendimento atendimento) {
		atendimento.setStatusAtendimento(StatusAtendimento.EM_ATENDIMENTO);
		return atendimentoRepository.save(atendimento);
	}
	
	@Transactional
	public void finalizarAtendimento(Long atendimentoId) {
		
		Atendimento atendimentoBuscado = buscarOuFalhar(atendimentoId);
		
		atendimentoBuscado.setStatusAtendimento(StatusAtendimento.FINALIZADO);
		atendimentoBuscado.setFinalAtendimento(OffsetDateTime.now());
		atendimentoRepository.save(atendimentoBuscado);	
	}
	
	public Atendimento buscarOuFalhar(Long atendimentoId) {
		return atendimentoRepository.findById(atendimentoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entidade não encontrada"));
		
	}
	
	

}
