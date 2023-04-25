package com.sga.cgfp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sga.cgfp.domain.model.Atendimento;
import com.sga.cgfp.domain.repository.AtendimentoRepository;
import com.sga.cgfp.domain.service.AtendimentoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService atendimentoService;
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@GetMapping
	public List<Atendimento> listarAtentimentos() {
		return atendimentoRepository.findAll();
	}
	
	@PostMapping("/iniciar-atendimento")
	public Atendimento iniciarAtendimento(@RequestBody Atendimento atendimento) {
		return atendimentoService.iniciarAtendimento(atendimento);
		
	}
	
	@PutMapping("/finalizar-atendimento/{atendimentoId}")
	public void finalizarAtendimento(@PathVariable Long atendimentoId, @RequestBody Atendimento atendimento) {
		atendimentoService.finalizarAtendimento(atendimentoId);
	}

}
