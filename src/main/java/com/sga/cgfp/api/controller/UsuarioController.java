package com.sga.cgfp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sga.cgfp.domain.model.Senha;
import com.sga.cgfp.domain.service.SenhaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class UsuarioController {
	
	@Autowired
	private SenhaService emissaoSenhaService;
	
//	@PostMapping(path = "/solicitar-senha", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Senha gerarSenha(@RequestBody Senha senha) {
//		return emissaoSenhaService.emissaoSenha(senha);
//	}
	
	@PostMapping(path = "/solicitar-senha", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> gerarSenhaPdf(@RequestBody Senha senha) throws Exception {
		
		byte[] bytesPdf = emissaoSenhaService.emissaoSenhapPdf(senha);
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_PDF)
				.header(HttpHeaders.CONTENT_TYPE)
				.body(bytesPdf);
		
	}
	
	

}
