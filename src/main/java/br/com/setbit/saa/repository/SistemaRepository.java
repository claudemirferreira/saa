package br.com.setbit.saa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.setbit.saa.model.Sistema;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Integer> {

}