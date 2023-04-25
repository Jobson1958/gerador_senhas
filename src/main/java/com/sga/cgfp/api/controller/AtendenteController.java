package com.sga.cgfp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sga.cgfp.domain.model.ChamadaSenha;
import com.sga.cgfp.domain.model.Senha;
import com.sga.cgfp.domain.repository.SenhaRepository;
import com.sga.cgfp.domain.service.ChamadaSenhaService;
import com.sga.cgfp.domain.service.SenhaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/senhas")
public class AtendenteController {
	
	@Autowired
	private SenhaService senhaService;
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	@Autowired
	private ChamadaSenhaService chamadaSenhaService;
	
	@GetMapping("/listar-senhas")
	public List<Senha> listarSenha() {
		return senhaRepository.findAll();
	}
	
	@GetMapping("/chamar-senha/{senhaId}")
	public Senha chamarSenha(@PathVariable Long senhaId) {
		return senhaService.chamarSenha(senhaId);
	}
	
	@GetMapping("/chamar-novamente/{senhaId}")
	public ChamadaSenha buscar(@PathVariable Long senhaId) {
		return chamadaSenhaService.chamarSenha(senhaId);
	}
	
	@PostMapping("/chamada/senha")
	public ChamadaSenha senhaChamada(@RequestBody ChamadaSenha chamadaSenha) {
		return chamadaSenhaService.salvar(chamadaSenha);
	} 
	
	@DeleteMapping("/remover-senha/{idSenha}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long idSenha) {
		senhaService.removerSenha(idSenha);
	}
	
	
	
	

}
