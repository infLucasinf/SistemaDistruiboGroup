package com.trabalhosistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhosistemas.models.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {
	Membro findById(long id);
}
