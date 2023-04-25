package com.sga.cgfp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sga.cgfp.domain.model.ChamadaSenha;


@Repository
public interface ChamadaSenhaRepository extends JpaRepository<ChamadaSenha, Long>{}
