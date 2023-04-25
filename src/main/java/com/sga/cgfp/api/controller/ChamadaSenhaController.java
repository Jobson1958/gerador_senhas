package com.sga.cgfp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sga.cgfp.domain.model.ChamadaSenha;
import com.sga.cgfp.domain.service.ChamadaSenhaService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ChamadaSenhaController {
	
	@Autowired
	private ChamadaSenhaService chamadaSenhaService;
	
	@GetMapping
	public ChamadaSenha Adicionar(@RequestBody ChamadaSenha chamadaSenha) {
		return chamadaSenhaService.salvar(chamadaSenha);
	}

	
	
	
}
