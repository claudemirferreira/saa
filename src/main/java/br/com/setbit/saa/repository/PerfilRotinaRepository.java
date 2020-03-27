package br.com.setbit.saa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.setbit.saa.model.PerfilRotina;

@Repository
public interface PerfilRotinaRepository extends JpaRepository<PerfilRotina, Integer> {

}