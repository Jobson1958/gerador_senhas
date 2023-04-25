package com.sga.cgfp.domain.service;


import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sga.cgfp.domain.exception.EntidadeNaoEncontradaException;
import com.sga.cgfp.domain.model.ChamadaSenha;
import com.sga.cgfp.domain.model.Senha;
import com.sga.cgfp.domain.model.Tipo;
import com.sga.cgfp.domain.repository.ChamadaSenhaRepository;
import com.sga.cgfp.domain.repository.SenhaRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class SenhaService {
	
	int cont_senha = 0;
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	@Autowired
	private ChamadaSenhaRepository chamadaSenhaRepository;
	
	@Transactional
	public Senha emissaoSenha(Senha senha) {
		
		Senha senhaGerada = senhaRepository.save(senha);
		
//		ChamadaSenha chamadaSenha = chamadaSenhaService.chamarSenha(1L);
		
		Optional<ChamadaSenha> chamadaSenha = chamadaSenhaRepository.findById(1L);
		
		if(senhaGerada.getTipoSenha().equals(Tipo.CONVENCIONAL)) {
			if(chamadaSenha.isPresent()) {
				if(senhaGerada.getDataHoraEmissao() != chamadaSenha.get().getDataHoraEmissao()){
					cont_senha++;
					senhaGerada.gerarStringSenhaConvecional(cont_senha);
					//return senhaGerada;				
				}				
			}else {
				senhaGerada.gerarStringSenhaConvecional(cont_senha);
			}
		}
		
		return senhaGerada;
	}
	
	@Transactional
	public void excluir(Long idSenha) {
		senhaRepository.deleteById(idSenha);
	}
	
	@Transactional
	public byte[] emissaoSenhapPdf(Senha senha) throws Exception {
		
		Senha senhaGerada = senhaRepository.save(senha);
		
		Optional<ChamadaSenha> chamadaSenha = chamadaSenhaRepository.findById(1L);
		
		if(senhaGerada.getTipoSenha().equals(Tipo.CONVENCIONAL)) {
			if(chamadaSenha.isPresent()) {
				if(senhaGerada.getDataHoraEmissao() != chamadaSenha.get().getDataHoraEmissao()){
					cont_senha++;
					senhaGerada.gerarStringSenhaConvecional(cont_senha);			
				}				
			}else {
				senhaGerada.gerarStringSenhaConvecional(cont_senha);
			}
		}
		
//		Senha senhaGerada = senhaRepository.save(senha);
//		
//		if(senhaGerada.getTipoSenha().equals(Tipo.CONVENCIONAL)) {
//			//senhaGerada.gerarStringSenhaConvecional();
//		}else {
//			senhaGerada.gerarStringSenhaPrioritaria();
//		}
		
		List<Senha> listaSenhas = Arrays.asList(senhaGerada);
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/senhas/sga-senha.jasper");
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		var dataSource = new JRBeanCollectionDataSource(listaSenhas);
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros, dataSource);
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
		
		
	}
	
	/*
	 * TODO
	 * no front end, esse endpoint é chamado, porém na fila ele é removido 
	 */
	public Senha chamarSenha(Long senhaId) {
		Senha senha = senhaRepository.findById(senhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de senha com o este código")));
		
		return senha;
		
	}
	
	public Senha buscarOuFalhar(Long senhaId) {
		Senha senha = senhaRepository.findById(senhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de senha com o este código %d", senhaId)));
		
		return senha;
		
	}
	
	@Transactional
	public void removerSenha(Long senhaId) {
		senhaRepository.deleteById(senhaId);
	}

}
