package com.sga.cgfp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sga.cgfp.domain.model.Senha;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {

}
