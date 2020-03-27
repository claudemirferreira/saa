package br.com.setbit.saa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.setbit.saa.model.Perfil;
import br.com.setbit.saa.repository.PerfilRepository;
import br.com.setbit.saa.service.PerfilService;

@Service
public class PerfilServiceImpl extends AbstractService<Perfil, Integer> implements PerfilService {

	private PerfilRepository repository;

	@Autowired
	public PerfilServiceImpl(PerfilRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Perfil, Integer> getRepository() {
		return repository;
	}

}